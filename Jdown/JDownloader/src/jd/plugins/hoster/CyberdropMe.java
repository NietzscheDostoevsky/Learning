package jd.plugins.hoster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.appwork.storage.TypeRef;
import org.appwork.utils.StringUtils;

import jd.PluginWrapper;
import jd.http.Browser;
import jd.http.URLConnectionAdapter;
import jd.nutils.encoding.Encoding;
import jd.parser.Regex;
import jd.plugins.Account;
import jd.plugins.DownloadLink;
import jd.plugins.DownloadLink.AvailableStatus;
import jd.plugins.HostPlugin;
import jd.plugins.LinkStatus;
import jd.plugins.PluginDependencies;
import jd.plugins.PluginException;
import jd.plugins.PluginForHost;
import jd.plugins.decrypter.CyberdropMeAlbum;

@HostPlugin(revision = "$Revision: 49458 $", interfaceVersion = 3, names = {}, urls = {})
@PluginDependencies(dependencies = { CyberdropMeAlbum.class })
public class CyberdropMe extends PluginForHost {
    public CyberdropMe(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public String getAGBLink() {
        return "https://" + CyberdropMeAlbum.MAIN_CYBERDROP_DOMAIN + "/faq";
    }

    public static List<String[]> getPluginDomains() {
        return CyberdropMeAlbum.getPluginDomains();
    }

    public static String[] getAnnotationNames() {
        return buildAnnotationNames(getPluginDomains());
    }

    @Override
    public String[] siteSupportedNames() {
        return buildSupportedNames(getPluginDomains());
    }

    public static String[] getAnnotationUrls() {
        return buildAnnotationUrls(getPluginDomains());
    }

    public static String[] buildAnnotationUrls(final List<String[]> pluginDomains) {
        final List<String> ret = new ArrayList<String>();
        for (final String[] domains : pluginDomains) {
            ret.add("");
        }
        return ret.toArray(new String[0]);
    }

    @Override
    public String rewriteHost(final String host) {
        /* This host is frequently changing its' main domain. */
        return this.rewriteHost(getPluginDomains(), host);
    }

    private int getMaxChunks(final Account account) {
        return 1;
    }

    @Override
    public int getMaxSimultanFreeDownloadNum() {
        return -1;
    }

    private String getContentURL(final DownloadLink link) {
        final String url = link.getPluginPatternMatcher();
        /* Do some domain corrections */
        String newURL = url.replaceFirst("(?i)cyberdrop\\.[a-z]+/", CyberdropMeAlbum.MAIN_CYBERDROP_DOMAIN + "/");
        /* Some fileservers are permanently down -> Fix that by using random fs01 to fs05 */
        newURL = newURL.replaceFirst("fs-06\\.", "fs-0." + (1 + new Random().nextInt(5)));
        return newURL;
    }

    @Override
    public String getLinkID(final DownloadLink link) {
        final String fid = getFID(link);
        if (fid != null) {
            return "cyberdrop://" + fid;
        } else {
            return super.getLinkID(link);
        }
    }

    private String getFID(final DownloadLink link) {
        String filenameFromURL = new Regex(link.getPluginPatternMatcher(), "(?i)https?://[^/]+/(.+)").getMatch(0);
        if (filenameFromURL != null) {
            return Encoding.htmlDecode(filenameFromURL).trim();
        } else {
            return null;
        }
    }

    private final String PROPERTY_LAST_GRABBED_DIRECTURL = "last_grabbed_directurl";

    @Override
    public AvailableStatus requestFileInformation(final DownloadLink link) throws Exception {
        return requestFileInformation(link, false);
    }

    private AvailableStatus requestFileInformation(final DownloadLink link, final boolean isDownload) throws Exception {
        this.setBrowserExclusive();
        br.setFollowRedirects(true);
        final String contenturl = this.getContentURL(link);
        final String filenameFromURL = getFID(link);
        if (!link.isNameSet() && filenameFromURL != null) {
            link.setName(filenameFromURL);
        }
        String directurl;
        final Regex singlefle = new Regex(contenturl, CyberdropMeAlbum.PATTERN_SINGLE_FILE);
        if (singlefle.patternFind()) {
            final String fileID = singlefle.getMatch(0);
            final Browser brc = br.cloneBrowser();
            brc.getHeaders().put("Referer", contenturl);
            brc.getPage("https://api." + this.getHost() + "/api/file/info/" + fileID);
            if (brc.getHttpConnection().getResponseCode() == 403) {
                throw new PluginException(LinkStatus.ERROR_HOSTER_TEMPORARILY_UNAVAILABLE, "Invalid API response: Error 403 too many connections?", 1 * 60 * 1000l);
            } else if (brc.getHttpConnection().getResponseCode() == 404) {
                throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
            } else if (!brc.getRequest().getHtmlCode().startsWith("{")) {
                throw new PluginException(LinkStatus.ERROR_HOSTER_TEMPORARILY_UNAVAILABLE, "Invalid API response: No json response", 1 * 60 * 1000l);
            }
            final Map<String, Object> resp1 = restoreFromString(brc.getRequest().getHtmlCode(), TypeRef.MAP);
            link.setFinalFileName(resp1.get("name").toString());
            link.setVerifiedFileSize(((Number) resp1.get("size")).longValue());
            if (!isDownload) {
                return AvailableStatus.TRUE;
            }
            final String continuelink = resp1.get("auth_url").toString();
            brc.getPage(continuelink);
            final Map<String, Object> resp2 = restoreFromString(brc.getRequest().getHtmlCode(), TypeRef.MAP);
            directurl = resp2.get("url").toString();
            if (StringUtils.isEmpty(directurl)) {
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
            }
            link.setProperty(PROPERTY_LAST_GRABBED_DIRECTURL, directurl);
        } else {
            final String containerURL = link.getContainerUrl();
            if (containerURL != null) {
                br.getHeaders().put("Referer", containerURL);
            }
            /* Assume that contenturl == directurl */
            directurl = contenturl;
        }
        if (directurl == null) {
            throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
        }
        URLConnectionAdapter con = null;
        try {
            if (isDownload) {
                dl = jd.plugins.BrowserAdapter.openDownload(br, link, directurl, true, this.getMaxChunks(null));
                con = dl.getConnection();
                handleConnectionErrors(br, con);
            } else {
                basicLinkCheck(br.cloneBrowser(), br.createHeadRequest(directurl), link, link.getFinalFileName(), null);
            }
        } catch (final Exception e) {
            try {
                con.disconnect();
            } catch (final Throwable ignore) {
            }
            throw e;
        } finally {
            if (!isDownload) {
                try {
                    con.disconnect();
                } catch (final Throwable e) {
                }
            }
        }
        return AvailableStatus.TRUE;
    }

    @Override
    public void handleFree(final DownloadLink link) throws Exception {
        requestFileInformation(link, true);
        if (this.dl == null) {
            throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
        }
        dl.startDownload();
    }

    @Override
    protected void handleConnectionErrors(final Browser br, final URLConnectionAdapter con) throws PluginException, IOException {
        super.handleConnectionErrors(br, con);
        if (con.getURL().getPath().equalsIgnoreCase("/maintenance.webm")) {
            con.disconnect();
            /* https://cyberfile.me/maintenance.webm */
            throw new PluginException(LinkStatus.ERROR_TEMPORARILY_UNAVAILABLE, "Media temporarily not available due to ongoing server maintenance.", 2 * 60 * 60 * 1000l);
        }
    }

    @Override
    public void reset() {
    }

    @Override
    public void resetDownloadlink(DownloadLink link) {
    }
}
