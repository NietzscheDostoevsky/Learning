package jd.plugins.decrypter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import jd.PluginWrapper;
import jd.controlling.ProgressController;
import jd.http.Browser;
import jd.http.URLConnectionAdapter;
import jd.http.requests.GetRequest;
import jd.nutils.encoding.Encoding;
import jd.parser.Regex;
import jd.parser.html.HTMLParser;
import jd.plugins.CryptedLink;
import jd.plugins.DecrypterPlugin;
import jd.plugins.DownloadLink;
import jd.plugins.LinkStatus;
import jd.plugins.PluginException;
import jd.plugins.PluginForDecrypt;
import jd.plugins.hoster.DirectHTTP;

import org.appwork.storage.config.annotations.AboutConfig;
import org.appwork.storage.config.annotations.DefaultBooleanValue;
import org.appwork.storage.config.annotations.DescriptionForConfigEntry;
import org.jdownloader.plugins.config.Order;
import org.jdownloader.plugins.config.PluginConfigInterface;
import org.jdownloader.plugins.config.PluginHost;
import org.jdownloader.plugins.config.PluginJsonConfig;
import org.jdownloader.plugins.config.Type;

@DecrypterPlugin(revision = "$Revision: 49914 $", interfaceVersion = 3, names = {}, urls = {})
public class WebArchiveOrg extends PluginForDecrypt {
    private static final Pattern PATTERN_DIRECT = Pattern.compile("https?://web\\.archive\\.org/web/(\\d+)(if|im|oe)_/(https?.+)", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_OTHER  = Pattern.compile("https?://web\\.archive\\.org/web/(\\d+)/(https?.+)", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_FILE   = Pattern.compile("^https?://[^/]+/web/(\\d+)[^/]*/(.+)", Pattern.CASE_INSENSITIVE);

    public WebArchiveOrg(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public Browser createNewBrowserInstance() {
        final Browser br = super.createNewBrowserInstance();
        br.setFollowRedirects(true);
        return br;
    }

    public static List<String[]> getPluginDomains() {
        final List<String[]> ret = new ArrayList<String[]>();
        // each entry in List<String[]> will result in one PluginForDecrypt, Plugin.getHost() will return String[0]->main domain
        ret.add(new String[] { "web.archive.org" });
        return ret;
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
            ret.add("https?://" + buildHostsPatternPart(domains) + "/web/[0-9]+((if|im|oe)_|\\*)?/.+");
        }
        return ret.toArray(new String[0]);
    }

    @Override
    public ArrayList<DownloadLink> decryptIt(final CryptedLink param, ProgressController progress) throws Exception {
        final ArrayList<DownloadLink> ret = new ArrayList<DownloadLink>();
        final Regex regexDirect = new Regex(param.getCryptedUrl(), PATTERN_DIRECT);
        final Regex regexFile = new Regex(param.getCryptedUrl(), PATTERN_FILE);
        final String originalURL = new Regex(param.getCryptedUrl(), PATTERN_OTHER).getMatch(1);
        final PluginForDecrypt yt = getNewPluginForDecryptInstance("youtube.com");
        final String youtubeVideoID = yt != null && yt.canHandle(originalURL) ? TbCmV2.getVideoIDFromUrl(param.getCryptedUrl()) : null;
        boolean looksLikeOfflineContent = false;
        if (youtubeVideoID != null) {
            /* Look for direct-URLs */
            final Browser brc = br.cloneBrowser();
            brc.setFollowRedirects(false);
            brc.getPage("https://web.archive.org/web/2oe_/http://wayback-fakeurl.archive.org/yt/" + Encoding.urlEncode(youtubeVideoID));
            final String directurl = brc.getRedirectLocation();
            if (directurl == null) {
                throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
            }
            ret.add(createDownloadlink(DirectHTTP.createURLForThisPlugin(directurl)));
            return ret;
        } else if (regexDirect.patternFind()) {
            /* Sure that we got a direct-URL */
            ret.add(createDownloadlink(DirectHTTP.createURLForThisPlugin(param.getCryptedUrl())));
        } else if (regexFile.patternFind()) {
            /* Unsure if we got a direct-URL -> Check it */
            final String fileID = regexFile.getMatch(0);
            final String linkpart = regexFile.getMatch(1);
            final String url = "https://web.archive.org/web/" + fileID + "if_" + "/" + linkpart;
            /* First check if maybe the user has added a directURL. */
            final GetRequest getRequest = br.createGetRequest(url);
            final URLConnectionAdapter con = this.br.openRequestConnection(getRequest);
            try {
                if (this.looksLikeDownloadableContent(con)) {
                    final DownloadLink direct = getCrawler().createDirectHTTPDownloadLink(getRequest, con);
                    ret.add(direct);
                } else {
                    br.followConnection();
                    if (br.getHttpConnection().getResponseCode() == 404) {
                        looksLikeOfflineContent = true;
                    } else if (!br.getURL().contains(fileID)) {
                        /* E.g. redirect to main page */
                        looksLikeOfflineContent = true;
                    } else {
                        if (PluginJsonConfig.get(getConfigInterface()).isCrawlEmbeddedFilesEnabled()) {
                            final String links[] = HTMLParser.getHttpLinks(br.getRequest().getHtmlCode(), br.getURL());
                            if (links != null) {
                                final Set<String> dupes = new HashSet<String>();
                                for (final String link : links) {
                                    if (canHandle(link) && dupes.add(link) && PATTERN_DIRECT.matcher(link).matches()) {
                                        ret.add(this.createDownloadlink(link));
                                    }
                                }
                            }
                        }
                        /* E.g. embedded PDF */
                        final String directurl = br.getRegex("<iframe id=\"playback\"[^>]*src=\"(https?://[^\"]+)").getMatch(0);
                        if (ret.size() == 0 && directurl == null) {
                            logger.info("URL is not supported or content is offline");
                            looksLikeOfflineContent = true;
                        } else {
                            ret.add(this.createDownloadlink(DirectHTTP.createURLForThisPlugin(directurl)));
                        }
                    }
                }
            } finally {
                con.disconnect();
            }
        } else {
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND, "Unsupported URL");
        }
        if (ret.isEmpty()) {
            if (looksLikeOfflineContent) {
                throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
            } else {
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
            }
        } else {
            return ret;
        }
    }

    @PluginHost(host = "web.archive.org", type = Type.CRAWLER)
    public static interface WebArchiveOrgConfig extends PluginConfigInterface {
        @AboutConfig
        @DefaultBooleanValue(false)
        @DescriptionForConfigEntry("Crawl embedded files from web.archive.org link?")
        @Order(10)
        boolean isCrawlEmbeddedFilesEnabled();

        void setCrawlEmbeddedFilesEnabled(boolean b);
    }

    @Override
    public Class<WebArchiveOrgConfig> getConfigInterface() {
        return WebArchiveOrgConfig.class;
    }
}
