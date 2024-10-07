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

import java.io.IOException;

import jd.PluginWrapper;
import jd.nutils.encoding.Encoding;
import jd.parser.Regex;
import jd.plugins.DownloadLink;
import jd.plugins.DownloadLink.AvailableStatus;
import jd.plugins.HostPlugin;
import jd.plugins.LinkStatus;
import jd.plugins.PluginException;
import jd.plugins.PluginForHost;
import jd.plugins.components.SiteType.SiteTemplate;

import org.appwork.utils.StringUtils;
import org.jdownloader.plugins.controller.LazyPlugin;

@HostPlugin(revision = "$Revision: 49243 $", interfaceVersion = 3, names = { "pornhd.com" }, urls = { "https?://(?:www\\.)?pornhd\\.com/(videos/\\d+/[a-z0-9\\-]+|video/embed/\\d+)" })
public class PornhdCom extends PluginForHost {
    public PornhdCom(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public LazyPlugin.FEATURE[] getFeatures() {
        return new LazyPlugin.FEATURE[] { LazyPlugin.FEATURE.XXX };
    }

    /* DEV NOTES */
    /* Porn_plugin */
    // Tags:
    // other: 2016-04-15: Limited chunks to 1 as tester Guardao reported that anything over 5 chunks would cause issues --> 2019-10-28: Set
    // chunks to unlimited again
    /* Connection stuff */
    private static final boolean free_resume       = true;
    private static final int     free_maxchunks    = 0;
    private static final int     free_maxdownloads = -1;
    private String               dllink            = null;

    /* 2020-04-30: Do not modify added URLs anymore! This may corrupt them and lead to http response 404! */
    // public void correctDownloadLink(final DownloadLink link) {
    // final String fid = getFID(link);
    // link.setLinkID(this.getHost() + "://" + fid);
    // link.setPluginPatternMatcher("https://www.pornhd.com/videos/" + fid);
    // }
    private String getFallbackTitle(final DownloadLink link) {
        if (link.getPluginPatternMatcher() == null) {
            return null;
        } else if (link.getPluginPatternMatcher().matches(TYPE_EMBED)) {
            return new Regex(link.getPluginPatternMatcher(), TYPE_EMBED).getMatch(0);
        } else {
            String title = new Regex(link.getPluginPatternMatcher(), TYPE_NORMAL).getMatch(1);
            /* Cleanup that title */
            title = title.replace("-", " ").trim();
            title = title.replaceAll("(?i) on pornhd.*?$", "");
            return title;
        }
    }

    @Override
    public String getAGBLink() {
        return "https://www.pornhd.com/legal/terms";
    }

    private static final String TYPE_EMBED  = "(?i)https?://[^/]+/video/embed/(\\d+)";
    private static final String TYPE_NORMAL = "(?i)https?://[^/]+/videos/(\\d+)/([a-z0-9\\-]+)";

    @Override
    public String getLinkID(final DownloadLink link) {
        final String linkid = getFID(link);
        if (linkid != null) {
            return this.getHost() + "://" + linkid;
        } else {
            return super.getLinkID(link);
        }
    }

    private String getFID(final DownloadLink link) {
        if (link.getPluginPatternMatcher() == null) {
            return null;
        } else if (link.getPluginPatternMatcher().matches(TYPE_EMBED)) {
            return new Regex(link.getPluginPatternMatcher(), TYPE_EMBED).getMatch(0);
        } else {
            return new Regex(link.getPluginPatternMatcher(), TYPE_NORMAL).getMatch(0);
        }
    }

    @Override
    public AvailableStatus requestFileInformation(final DownloadLink link) throws IOException, PluginException {
        dllink = null;
        final String extDefault = ".mp4";
        if (!link.isNameSet()) {
            link.setName(getFallbackTitle(link) + extDefault);
        }
        this.setBrowserExclusive();
        br.setFollowRedirects(true);
        br.getPage(link.getPluginPatternMatcher());
        if (br.getHttpConnection().getResponseCode() == 404 || this.br.containsHTML("class=\"player-container no-video\"|class=\"no\\-video\"")) {
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
        } else if (!br.getURL().contains(this.getFID(link))) {
            /* E.g. redirect to mainpage */
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
        }
        String title = br.getRegex("name=\"og:title\" content=\"([^<>\"]+)\\s*- HD porn video \\| PornHD\"").getMatch(0);
        if (title == null) {
            title = br.getRegex("<title>([^\"]+)\\s*- HD porn video \\| PornHD</title>").getMatch(0);
        }
        final String[] qualities = { "1080p", "720p", "480p", "360p", "240p" };
        for (final String quality : qualities) {
            dllink = br.getRegex("(?:\\'|\")" + quality + "(?:\\'|\")\\s*:\\s*(?:\\'|\")((https?|.?/)[^<>\"]*?)(?:\\'|\")").getMatch(0);
            if (dllink == null) {
                /* 2020-04-30 */
                dllink = br.getRegex("<source[^>]*src=\"([^\"]+)\"[^>]*label='" + quality + "").getMatch(0);
            }
            if (dllink != null) {
                logger.info("Chosen quality: " + quality);
                break;
            }
        }
        if (dllink != null) {
            dllink = Encoding.htmlDecode(dllink);
        }
        if (title != null) {
            title = Encoding.htmlDecode(title);
            title = title.trim();
            title = title.replaceFirst("(?i) on pornhd", "");
            link.setFinalFileName(title + extDefault);
        }
        return AvailableStatus.TRUE;
    }

    @Override
    public void handleFree(final DownloadLink link) throws Exception {
        requestFileInformation(link);
        if (StringUtils.isEmpty(dllink)) {
            throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
        }
        dl = jd.plugins.BrowserAdapter.openDownload(br, link, dllink, free_resume, free_maxchunks);
        handleConnectionErrors(br, dl.getConnection());
        dl.startDownload();
    }

    @Override
    public int getMaxSimultanFreeDownloadNum() {
        return free_maxdownloads;
    }

    @Override
    public SiteTemplate siteTemplateType() {
        return SiteTemplate.UnknownPornScript5;
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
