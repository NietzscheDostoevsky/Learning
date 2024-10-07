//jDownloader - Downloadmanager
//Copyright (C) 2009  JD-Team support@jdownloader.org
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <http://www.gnu.org/licenses/>.
package jd.plugins.hoster;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.appwork.storage.TypeRef;
import org.appwork.utils.StringUtils;
import org.appwork.utils.formatter.TimeFormatter;
import org.jdownloader.downloader.hls.HLSDownloader;
import org.jdownloader.plugins.components.hls.HlsContainer;
import org.jdownloader.plugins.controller.LazyPlugin;
import org.jdownloader.scripting.JavaScriptEngineFactory;

import jd.PluginWrapper;
import jd.http.Browser;
import jd.nutils.encoding.Encoding;
import jd.parser.Regex;
import jd.plugins.DownloadLink;
import jd.plugins.DownloadLink.AvailableStatus;
import jd.plugins.HostPlugin;
import jd.plugins.LinkStatus;
import jd.plugins.PluginException;
import jd.plugins.PluginForHost;

@HostPlugin(revision = "$Revision: 49338 $", interfaceVersion = 3, names = { "welt.de" }, urls = { "https?://(?:www\\.)?welt\\.de/.*?/(?:video|sendung)\\d+/[A-Za-z0-9\\-]+\\.html" })
public class WeltDeMediathek extends PluginForHost {
    public WeltDeMediathek(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public LazyPlugin.FEATURE[] getFeatures() {
        return new LazyPlugin.FEATURE[] { LazyPlugin.FEATURE.VIDEO_STREAMING };
    }

    /* DEV NOTES */
    // Tags:
    // protocol: https
    // other:
    /* Extension which will be used if no correct extension is found */
    private static final String  default_extension = ".mp4";
    /* Connection stuff */
    private static final boolean free_resume       = true;
    private static final int     free_maxchunks    = 0;
    private String               dllink            = null;

    @Override
    public String getAGBLink() {
        return "https://www.welt.de/services/article122129231/Nutzungsbedingungen-DIE-WELT-Digital.html";
    }

    @SuppressWarnings("deprecation")
    @Override
    public AvailableStatus requestFileInformation(final DownloadLink link) throws Exception {
        dllink = null;
        this.setBrowserExclusive();
        br.setFollowRedirects(true);
        br.getPage(link.getDownloadURL());
        if (br.getHttpConnection().getResponseCode() == 404) {
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
        } else if (br.containsHTML("\"DreifaltigkeitLiveMarker\"")) {
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND, "Livestreams are not supported");
        }
        final String url_title = new Regex(link.getDownloadURL(), ".+/(.+)\\.html").getMatch(0);
        /* Tags: schema.org */
        final String json_source_videoinfo = this.br.getRegex("<script[^>]*?type=\"application/ld\\+json[^>]*?\">(.*?)</script>").getMatch(0);
        Map<String, Object> entries = restoreFromString(json_source_videoinfo, TypeRef.MAP);
        String filenameBase = "";
        String title = (String) entries.get("headline");
        final String description = (String) entries.get("description");
        final String date_formatted = formatDate((String) entries.get("datePublished"));
        String organization = (String) JavaScriptEngineFactory.walkJson(entries, "publisher/name");
        if (StringUtils.isEmpty(organization)) {
            organization = "DIE WELT";
        }
        if (title == null) {
            title = url_title;
        }
        if (date_formatted != null) {
            filenameBase = date_formatted + "_";
        }
        filenameBase += organization + "_" + title;
        filenameBase = Encoding.htmlDecode(filenameBase);
        filenameBase = filenameBase.trim();
        /* Find downloadlink */
        try {
            final String mp4[] = br.getRegex("(https?://[^\"]*?[A-Za-z0-9_]+_(\\d{3,4})\\.mp4)").getColumn(0);
            int best = -1;
            for (String url : mp4) {
                final String bitrateString = new Regex(url, "_(\\d{3,4})\\.mp4$").getMatch(0);
                final int bitrate = Integer.parseInt(bitrateString);
                if (best == -1 || bitrate > best) {
                    best = bitrate;
                    dllink = url;
                }
            }
            if (dllink == null) {
                dllink = br.getRegex("(https?://[^\"]*?[A-Za-z0-9_]+_(4800|2400|2000|1500|1000|700|200)\\.mp4)").getMatch(0);
            }
            if (dllink == null) {
                final String m3u8ToMp4 = br.getRegex("(https?://[^\"]*?([A-Za-z0-9_\\-]+_),([0-9,]+)\\.mp4\\.csmil/master\\.m3u8)").getMatch(0);
                if (m3u8ToMp4 != null) {
                    final Browser brc = br.cloneBrowser();
                    brc.getPage(m3u8ToMp4);
                    /* Convert hls --> http (sometimes required) */
                    final Regex hlsregex = new Regex(m3u8ToMp4, "https?://.*?/(?:i/)?(.*?)/([A-Za-z0-9_\\-]+_),([0-9,]+)\\.mp4\\.csmil/master\\.m3u8");
                    /* Usually both IDs are the same */
                    final String id1 = hlsregex.getMatch(0);
                    final String id2 = hlsregex.getMatch(1);
                    /* Bitrates from lowest to highest. */
                    final String[] bitrates = hlsregex.getMatch(2).split(",");
                    int highest = -1;
                    for (String bitrate : bitrates) {
                        if (highest == -1 || Integer.parseInt(bitrate) > highest) {
                            highest = Integer.parseInt(bitrate);
                        }
                    }
                    if (id1 != null && id2 != null && highest > 0) {
                        if (dllink != null) {
                            dllink = String.format("https://" + new URL(dllink).getHost() + "/%s/%s%s.mp4", id1, id2, highest);
                        } else {
                            dllink = String.format("https://weltn24sfthumb-a.akamaihd.net/%s/%s%s.mp4", id1, id2, highest);
                        }
                    }
                }
            }
            if (dllink == null) {
                dllink = br.getRegex("\"src\"\\s*:\\s*\"(https?://[^\"]*?master\\.m3u8)\"").getMatch(0);
            }
        } catch (final Throwable e) {
            getLogger().log(e);
        }
        final String ext;
        if (StringUtils.isNotEmpty(dllink) && !StringUtils.containsIgnoreCase(dllink, ".m3u8")) {
            ext = getFileNameExtensionFromString(dllink, default_extension);
        } else {
            ext = default_extension;
        }
        if (description != null && link.getComment() == null) {
            link.setComment(description);
        }
        link.setFinalFileName(this.applyFilenameExtension(filenameBase, ext));
        if (StringUtils.isNotEmpty(dllink) && !StringUtils.containsIgnoreCase(dllink, ".m3u8")) {
            dllink = Encoding.htmlOnlyDecode(dllink);
            basicLinkCheck(br.cloneBrowser(), br.createHeadRequest(dllink), link, filenameBase, ext);
        }
        return AvailableStatus.TRUE;
    }

    @Override
    public void handleFree(final DownloadLink link) throws Exception {
        requestFileInformation(link);
        if (dllink == null) {
            final String html_error = this.br.getRegex("<p[^>]*?class=\"o-text c-catch-up-error__text\">([^<\"]+)</p>").getMatch(0);
            if (html_error != null) {
                /* 2018-04-11: E.g. 'Diese Sendung ist zur Zeit aus lizenzrechtlichen Gründen nicht verfügbar.' */
                throw new PluginException(LinkStatus.ERROR_FATAL, Encoding.htmlDecode(html_error).trim());
            } else if (br.containsHTML(">\\s*Diese Sendung ist zur Zeit aus lizenzrechtlichen Gründen nicht verfügbar")) {
                throw new PluginException(LinkStatus.ERROR_FATAL, "Diese Sendung ist zur Zeit aus lizenzrechtlichen Gründen nicht verfügbar");
            } else {
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
            }
        }
        if (StringUtils.containsIgnoreCase(dllink, ".m3u8")) {
            final HlsContainer hlsbest = HlsContainer.findBestVideoByBandwidth(HlsContainer.getHlsQualities(br.cloneBrowser(), dllink));
            if (hlsbest == null) {
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
            }
            String dllink = hlsbest.getDownloadurl();
            checkFFmpeg(link, "Download a HLS Stream");
            dl = new HLSDownloader(link, br, dllink);
        } else {
            dl = jd.plugins.BrowserAdapter.openDownload(br, link, dllink, free_resume, free_maxchunks);
            this.handleConnectionErrors(br, dl.getConnection());
        }
        dl.startDownload();
    }

    private String formatDate(final String input) {
        /* 2016-07-25T15:29:07Z */
        final long date = TimeFormatter.getMilliSeconds(input, "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.GERMAN);
        String formattedDate = null;
        final String targetFormat = "yyyy-MM-dd";
        Date theDate = new Date(date);
        try {
            final SimpleDateFormat formatter = new SimpleDateFormat(targetFormat);
            formattedDate = formatter.format(theDate);
        } catch (Exception e) {
            /* prevent input error killing plugin */
            formattedDate = input;
        }
        return formattedDate;
    }

    @Override
    public int getMaxSimultanFreeDownloadNum() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void reset() {
    }

    @Override
    public void resetPluginGlobals() {
    }

    @Override
    public void resetDownloadlink(DownloadLink link) {
    }
}
