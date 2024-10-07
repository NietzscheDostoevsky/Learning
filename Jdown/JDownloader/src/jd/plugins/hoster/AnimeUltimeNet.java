//jDownloader - Downloadmanager
//Copyright (C) 2010  JD-Team support@jdownloader.org
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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.appwork.storage.TypeRef;
import org.appwork.utils.StringUtils;
import org.appwork.utils.formatter.SizeFormatter;
import org.appwork.utils.formatter.TimeFormatter;
import org.appwork.utils.parser.UrlQuery;
import org.jdownloader.plugins.controller.LazyPlugin;

import jd.PluginWrapper;
import jd.http.Browser;
import jd.http.Cookies;
import jd.nutils.encoding.Encoding;
import jd.parser.Regex;
import jd.parser.html.Form;
import jd.plugins.Account;
import jd.plugins.Account.AccountType;
import jd.plugins.AccountInfo;
import jd.plugins.AccountInvalidException;
import jd.plugins.DownloadLink;
import jd.plugins.DownloadLink.AvailableStatus;
import jd.plugins.HostPlugin;
import jd.plugins.LinkStatus;
import jd.plugins.PluginException;
import jd.plugins.PluginForHost;

@HostPlugin(revision = "$Revision: 48620 $", interfaceVersion = 2, names = {}, urls = {})
public class AnimeUltimeNet extends PluginForHost {
    public AnimeUltimeNet(PluginWrapper wrapper) {
        super(wrapper);
        this.enablePremium("https://www." + getHost() + "/premium-0-1");
    }

    @Override
    public LazyPlugin.FEATURE[] getFeatures() {
        return new LazyPlugin.FEATURE[] { LazyPlugin.FEATURE.VIDEO_STREAMING };
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
        ret.add(new String[] { "anime-ultime.net" });
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

    private static final String PATTERN_FILE_FREE    = "/info\\-0\\-1/((\\d+)(/([^/#]+))?)";
    private static final String PATTERN_FILE_PREMIUM = "/ddl/(\\d+)/orig/([^/#]+)";

    public static String[] buildAnnotationUrls(final List<String[]> pluginDomains) {
        final List<String> ret = new ArrayList<String>();
        for (final String[] domains : pluginDomains) {
            ret.add("https?://(?:www\\.)?" + buildHostsPatternPart(domains) + "(" + PATTERN_FILE_FREE + "|" + PATTERN_FILE_PREMIUM + ")");
        }
        return ret.toArray(new String[0]);
    }

    @Override
    public String getAGBLink() {
        return "https://www." + getHost() + "/index-0-1#principal";
    }

    @Override
    public String getLinkID(final DownloadLink link) {
        final String fileid = getFID(link);
        if (fileid != null) {
            return "alimeultimenet://file/" + fileid;
        } else {
            return super.getLinkID(link);
        }
    }

    private String getFID(final DownloadLink link) {
        String fileid = new Regex(link.getPluginPatternMatcher(), PATTERN_FILE_FREE).getMatch(1);
        if (fileid == null) {
            fileid = new Regex(link.getPluginPatternMatcher(), PATTERN_FILE_PREMIUM).getMatch(0);
        }
        return fileid;
    }

    private String getDirecturlProperty(final Account account) {
        if (account == null) {
            return "directlink";
        } else {
            return "directlink_account_ " + account.getType().getLabel();
        }
    }

    @Override
    public boolean isResumeable(final DownloadLink link, final Account account) {
        return true;
    }

    public int getMaxChunks(final Account account) {
        return 1;
    }

    @Override
    public AvailableStatus requestFileInformation(final DownloadLink link) throws Exception {
        return requestFileInformation(link, null);
    }

    private AvailableStatus requestFileInformation(final DownloadLink link, final Account account) throws Exception {
        this.setBrowserExclusive();
        if (account != null) {
            this.login(account, false);
        }
        final String fileid = this.getFID(link);
        final String extDefault = "mp4";
        if (!link.isNameSet()) {
            link.setName(fileid + "." + extDefault);
        }
        br.getPage("https://www." + this.getHost() + "/info-0-1/" + fileid);
        if (this.br.getHttpConnection().getResponseCode() == 404) {
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
        } else if (br.containsHTML("(?i)>\\s*0 vostfr streaming\\s*<")) {
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
        }
        final String titleFromURL = new Regex(br.getURL(), PATTERN_FILE_FREE).getMatch(3);
        String filetitle = br.getRegex("<h1>([^<>\"]*?)</h1>").getMatch(0);
        if (filetitle == null && titleFromURL != null) {
            filetitle = titleFromURL.replace("-", " ");
        }
        String filesize = br.getRegex("Taille\\s*:\\s*([^<>\"]*?)<br />").getMatch(0);
        if (filesize != null) {
            if (filesize.equals("")) {
                /* Probably offline as filesize is not given and downloadlink is not available/dead(404) */
                throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
            }
            /* Convert French to English */
            filesize = filesize.replaceAll("(?i)Ko", "Kb").replaceAll("(?i)Mo", "Mb").replaceAll("(?i)Go", "Gb");
            link.setDownloadSize(SizeFormatter.getSize(filesize));
        } else {
            logger.warning("Failed to find filesize");
        }
        if (filetitle != null) {
            filetitle = Encoding.htmlDecode(filetitle).trim();
            String fileextension = br.getRegex("Conteneur\\s*:\\s*([A-Za-z0-9]+)").getMatch(0);
            if (fileextension != null) {
                fileextension = fileextension.trim();
            } else {
                /* Fallback: We know that most of all of their files are video files. */
                fileextension = extDefault;
            }
            link.setName(filetitle + "." + fileextension);
        } else {
            logger.warning("Failed to find filetitle");
        }
        return AvailableStatus.TRUE;
    }

    @Override
    public void handleFree(final DownloadLink link) throws Exception, PluginException {
        handleDownload(link, null);
    }

    private void handleDownload(final DownloadLink link, final Account account) throws Exception, PluginException {
        final String directlinkproperty = getDirecturlProperty(account);
        final String storedDirectlink = link.getStringProperty(directlinkproperty);
        String dllink = null;
        if (storedDirectlink != null) {
            logger.info("Re-using stored directlink: " + storedDirectlink);
            dllink = storedDirectlink;
        } else {
            requestFileInformation(link, account);
            final String fileid = getFID(link);
            /*
             * 2023-01-09: It is possible to download as premium user in free mode but let's not be evil and hope that they will patch this
             * possibility soon!
             */
            final String premiumDirecturl = br.getRegex("(/ddl/" + fileid + "/orig/[^/#\"]+)\"").getMatch(0);
            if (premiumDirecturl != null) {
                /* Premium user -> We can skip the other steps (we could also do the other steps and it would work fine too). */
                dllink = premiumDirecturl;
            } else {
                final boolean enforcePremiumLinkAlsoInFreeMode = false;
                if ((account == null || account.getType() == AccountType.FREE) && enforcePremiumLinkAlsoInFreeMode) {
                    /**
                     * 2023-01-11: With this trick we can theoretically download in premium mode for free lol </br>
                     * Free connection limits still apply but this could be used to skip pre download wait time.
                     */
                    dllink = "https://www." + this.getHost() + "/ddl/" + fileid + "/orig/";
                } else {
                    final Browser brc = br.cloneBrowser();
                    brc.getHeaders().put("Accept", "application/json, text/javascript, */*; q=0.01");
                    brc.getHeaders().put("X-Requested-With", "XMLHttpRequest");
                    final UrlQuery dlquery = new UrlQuery();
                    dlquery.add("idfile", fileid);
                    dlquery.add("type", "orig");
                    brc.postPage("/ddl/authorized_download.php", dlquery);
                    final Map<String, Object> entries = restoreFromString(brc.getRequest().getHtmlCode(), TypeRef.MAP);
                    dllink = (String) entries.get("link");
                    if (dllink == null) {
                        /* 2nd step is not always needed */
                        final boolean skipPreDownloadWaittime = false;
                        if (!skipPreDownloadWaittime) {
                            final int waittimeSeconds = ((Number) entries.get("wait")).intValue();
                            logger.info("Pre download wait in seconds: " + waittimeSeconds);
                            this.sleep(waittimeSeconds * 1001l, link);
                        }
                        brc.postPage(brc.getURL(), dlquery);
                        final Map<String, Object> entries2 = restoreFromString(brc.getRequest().getHtmlCode(), TypeRef.MAP);
                        dllink = (String) entries2.get("link");
                        if (StringUtils.isEmpty(dllink)) {
                            /* Very very rare problem */
                            throw new PluginException(LinkStatus.ERROR_TEMPORARILY_UNAVAILABLE, "Wait error: Server thinks we haven't waited long enough", 1 * 60 * 1000l);
                        }
                    }
                }
            }
        }
        try {
            dl = jd.plugins.BrowserAdapter.openDownload(br, link, dllink, isResumeable(link, account), this.getMaxChunks(account));
            if (!this.looksLikeDownloadableContent(dl.getConnection())) {
                br.followConnection(true);
                if (dl.getConnection().getResponseCode() == 403) {
                    throw new PluginException(LinkStatus.ERROR_TEMPORARILY_UNAVAILABLE, "Server error 403", 15 * 60 * 1000l);
                } else if (dl.getConnection().getResponseCode() == 404) {
                    throw new PluginException(LinkStatus.ERROR_TEMPORARILY_UNAVAILABLE, "Server error 404 - file offline?", 60 * 60 * 1000l);
                } else if (dl.getConnection().getResponseCode() == 503) {
                    throw new PluginException(LinkStatus.ERROR_HOSTER_TEMPORARILY_UNAVAILABLE, "Server error 503 - too many concurrent connections", 1 * 60 * 1000l);
                } else {
                    throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
                }
            }
        } catch (final Exception e) {
            if (storedDirectlink != null) {
                link.removeProperty(directlinkproperty);
                throw new PluginException(LinkStatus.ERROR_RETRY, "Stored directurl expired", e);
            } else {
                throw e;
            }
        }
        link.setProperty(directlinkproperty, dl.getConnection().getURL().toExternalForm());
        dl.startDownload();
    }

    private boolean login(final Account account, final boolean force) throws Exception {
        synchronized (account) {
            br.setCookiesExclusive(true);
            final Cookies cookies = account.loadCookies("");
            if (cookies != null) {
                logger.info("Attempting cookie login");
                this.br.setCookies(this.getHost(), cookies);
                if (!force) {
                    /* Don't validate cookies */
                    return false;
                }
                br.getPage("https://www." + this.getHost() + "/");
                if (this.isLoggedin(br)) {
                    logger.info("Cookie login successful");
                    /* Refresh cookie timestamp */
                    account.saveCookies(br.getCookies(getHost()), "");
                    return true;
                } else {
                    logger.info("Cookie login failed");
                    br.clearCookies(null);
                }
            }
            logger.info("Performing full login");
            br.getPage("https://www." + this.getHost() + "/");
            final Form loginform = br.getFormbyProperty("name", "identification");
            if (loginform == null) {
                logger.warning("Failed to find loginform");
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
            }
            loginform.put("Indexlogin", Encoding.urlEncode(account.getUser()));
            loginform.put("Indexpassword", Encoding.urlEncode(account.getPass()));
            br.submitForm(loginform);
            if (!isLoggedin(br)) {
                throw new AccountInvalidException();
            }
            account.saveCookies(br.getCookies(br.getHost()), "");
            return true;
        }
    }

    private boolean isLoggedin(final Browser br) {
        return br.containsHTML("/disconnect");
    }

    @Override
    public AccountInfo fetchAccountInfo(final Account account) throws Exception {
        final AccountInfo ai = new AccountInfo();
        login(account, true);
        ai.setUnlimitedTraffic();
        br.getPage("/premium-0-1");
        final String expire = br.getRegex("(\\d{2} [A-Za-z]+ 20\\d{2})").getMatch(0);
        if (expire == null) {
            account.setType(AccountType.FREE);
            account.setMaxSimultanDownloads(this.getMaxSimultanFreeDownloadNum());
        } else {
            ai.setValidUntil(TimeFormatter.getMilliSeconds(expire, "dd MMMM yyyy", Locale.FRANCE));
            account.setType(AccountType.PREMIUM);
            account.setMaxSimultanDownloads(getMaxSimultanPremiumDownloadNum()); // Checked 2024-01-11
        }
        return ai;
    }

    @Override
    public void handlePremium(final DownloadLink link, final Account account) throws Exception {
        this.handleDownload(link, account);
    }

    @Override
    public boolean hasCaptcha(DownloadLink link, jd.plugins.Account acc) {
        /* 2023-01-11: No captchas at all */
        return false;
    }

    @Override
    public int getMaxSimultanPremiumDownloadNum() {
        return 5;
    }

    @Override
    public void reset() {
    }

    @Override
    public int getMaxSimultanFreeDownloadNum() {
        // Untested -> Set to 1
        return 1;
    }

    @Override
    public void resetDownloadlink(final DownloadLink link) {
    }
}