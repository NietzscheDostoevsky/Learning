//jDownloader - Downloadmanager
//Copyright (C) 2017  JD-Team support@jdownloader.org
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.appwork.storage.TypeRef;
import org.appwork.utils.StringUtils;
import org.appwork.utils.formatter.TimeFormatter;
import org.jdownloader.captcha.v2.challenge.recaptcha.v2.CaptchaHelperHostPluginRecaptchaV2;
import org.jdownloader.gui.translate._GUI;
import org.jdownloader.plugins.controller.LazyPlugin;

import jd.PluginWrapper;
import jd.controlling.AccountController;
import jd.http.Browser;
import jd.http.Cookie;
import jd.http.Cookies;
import jd.http.Request;
import jd.nutils.encoding.Encoding;
import jd.parser.Regex;
import jd.parser.html.Form;
import jd.parser.html.InputField;
import jd.plugins.Account;
import jd.plugins.Account.AccountType;
import jd.plugins.AccountInfo;
import jd.plugins.AccountInvalidException;
import jd.plugins.AccountRequiredException;
import jd.plugins.DownloadLink;
import jd.plugins.DownloadLink.AvailableStatus;
import jd.plugins.HostPlugin;
import jd.plugins.LinkStatus;
import jd.plugins.PluginException;
import jd.plugins.PluginForHost;

@HostPlugin(revision = "$Revision: 49757 $", interfaceVersion = 3, names = { "kink.com" }, urls = { "https?://(?:www\\.)?kink.com/shoot/(\\d+)" })
public class KinkCom extends PluginForHost {
    public KinkCom(PluginWrapper wrapper) {
        super(wrapper);
        this.enablePremium("https://www." + getHost() + "/join/kink");
    }

    @Override
    public Browser createNewBrowserInstance() {
        final Browser br = super.createNewBrowserInstance();
        br.setFollowRedirects(true);
        br.getHeaders().put("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:88.0) Gecko/20100101 Firefox/88.0");
        return br;
    }

    @Override
    public LazyPlugin.FEATURE[] getFeatures() {
        return new LazyPlugin.FEATURE[] { LazyPlugin.FEATURE.XXX, LazyPlugin.FEATURE.COOKIE_LOGIN_OPTIONAL };
    }
    /* DEV NOTES */
    // Tags: Porn plugin
    // protocol: no https
    // other:

    @Override
    public String getAGBLink() {
        return "https://kink.zendesk.com/hc/en-us/articles/360004660854-Kink-com-Terms-of-Use";
    }

    @Override
    public boolean isResumeable(final DownloadLink link, final Account account) {
        return true;
    }

    public int getMaxChunks(final DownloadLink link, final Account account) {
        return 0;
    }

    @Override
    public String getLinkID(final DownloadLink link) {
        final String fid = getFID(link);
        if (fid != null) {
            return this.getHost() + "://" + fid;
        } else {
            return super.getLinkID(link);
        }
    }

    private String getFID(final DownloadLink link) {
        return new Regex(link.getPluginPatternMatcher(), this.getSupportedLinks()).getMatch(0);
    }

    @Override
    public AvailableStatus requestFileInformation(final DownloadLink link) throws IOException, PluginException, InterruptedException {
        final Account acc = AccountController.getInstance().getValidAccount(this.getHost());
        return requestFileInformation(link, acc, false);
    }

    private String getDirectlinkProperty(final DownloadLink link, final Account account) {
        if (account != null) {
            return "directlink_account";
        } else {
            return "directlink";
        }
    }

    private AvailableStatus requestFileInformation(final DownloadLink link, final Account account, final boolean isDownload) throws IOException, PluginException, InterruptedException {
        final String extDefault = ".mp4";
        final String fid = this.getFID(link);
        if (!link.isNameSet()) {
            link.setName(fid + extDefault);
        }
        if (account != null) {
            this.login(account, false);
        }
        br.getPage(link.getPluginPatternMatcher());
        if (br.getHttpConnection().getResponseCode() == 404) {
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
        }
        String title = br.getRegex("<title>\\s*([^<>\"]+)\\s*</title>").getMatch(0);
        String directurl = null;
        String json = br.getRegex("data-setup=\"([^\"]+)").getMatch(0);
        int heightMaxTrailer = -1;
        String directurlTrailerBest = null;
        if (json != null) {
            json = Encoding.htmlOnlyDecode(json);
            final Map<String, Object> entries = restoreFromString(json, TypeRef.MAP);
            title = entries.get("title").toString();
            final Map<String, Object> trailer = (Map<String, Object>) entries.get("trailer");
            final List<Map<String, Object>> sources = (List<Map<String, Object>>) trailer.get("sources");
            for (final Map<String, Object> source : sources) {
                final int height = ((Number) source.get("resolution")).intValue();
                if (directurlTrailerBest == null || height > heightMaxTrailer) {
                    directurlTrailerBest = source.get("url").toString();
                    heightMaxTrailer = height;
                }
            }
        }
        if (account != null) {
            /* Look for "official" downloadlinks --> Find highest quality */
            int qualityMax = -1;
            final String[][] dlinfos = br.getRegex("download\\s*=\\s*\"(https?://[^\"]+)\"[^>]*quality=\"(\\d+)\"").getMatches();
            if (dlinfos == null || dlinfos.length == 0) {
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
            }
            for (final String[] dlinfo : dlinfos) {
                final int qualityTmp = Integer.parseInt(dlinfo[1]);
                if (qualityTmp > qualityMax) {
                    qualityMax = qualityTmp;
                    String url = dlinfo[0];
                    url = Encoding.htmlOnlyDecode(url);
                    directurl = url;
                }
            }
            logger.info("Chosen premium download quality: " + qualityMax + " -> " + directurl);
        } else {
            /* Download trailer */
            directurl = directurlTrailerBest;
            logger.info("Chosen trailer: " + directurl);
        }
        String filetitle;
        if (!StringUtils.isEmpty(title)) {
            filetitle = fid + "_" + title;
        } else {
            filetitle = fid;
        }
        filetitle = Encoding.htmlDecode(filetitle);
        filetitle = filetitle.trim();
        link.setFinalFileName(this.applyFilenameExtension(filetitle, extDefault));
        if (!StringUtils.isEmpty(directurl)) {
            link.setProperty(this.getDirectlinkProperty(link, account), directurl);
            if (!isDownload) {
                basicLinkCheck(br.cloneBrowser(), br.createHeadRequest(directurl), link, link.getFinalFileName(), extDefault);
            }
        }
        return AvailableStatus.TRUE;
    }

    @Override
    public void handleFree(final DownloadLink link) throws Exception {
        handleDownload(link, null);
    }

    private void handleDownload(final DownloadLink link, final Account account) throws Exception {
        final String directlinkproperty = this.getDirectlinkProperty(link, account);
        final String storedDirecturl = link.getStringProperty(directlinkproperty);
        String dllink = null;
        if (storedDirecturl != null) {
            logger.info("Re-using stored directurl: " + storedDirecturl);
            dllink = storedDirecturl;
        } else {
            requestFileInformation(link, account, true);
            dllink = link.getStringProperty(directlinkproperty);
            if (StringUtils.isEmpty(dllink)) {
                if (account != null && AccountType.PREMIUM.equals(account.getType())) {
                    /* This should never happen. */
                    throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
                } else {
                    /* This should never happen but maybe not all videos have a trailer available. */
                    throw new AccountRequiredException("Failed to download trailer -> Add a premium account and try again");
                }
            }
        }
        try {
            dl = jd.plugins.BrowserAdapter.openDownload(br, link, dllink, this.isResumeable(link, account), this.getMaxChunks(link, account));
            handleConnectionErrors(br, dl.getConnection());
        } catch (final Exception e) {
            if (storedDirecturl != null) {
                link.removeProperty(directlinkproperty);
                throw new PluginException(LinkStatus.ERROR_RETRY, "Stored directurl expired", e);
            } else {
                throw e;
            }
        }
        dl.startDownload();
    }

    private void login(final Account account, final boolean force) throws IOException, InterruptedException, PluginException {
        synchronized (account) {
            br.setCookiesExclusive(true);
            br.setAllowedResponseCodes(new int[] { 401 });
            final Cookies userCookies = account.loadUserCookies();
            final Cookies cookies = account.loadCookies("");
            if (userCookies != null) {
                if (checkAndSaveCookies(br, userCookies, account)) {
                    /* Cookies are valid. */
                    return;
                } else {
                    if (account.hasEverBeenValid()) {
                        throw new AccountInvalidException(_GUI.T.accountdialog_check_cookies_expired());
                    } else {
                        throw new AccountInvalidException(_GUI.T.accountdialog_check_cookies_invalid());
                    }
                }
            } else if (cookies != null) {
                if (checkAndSaveCookies(br, cookies, account)) {
                    /* Cookies are valid. */
                    return;
                } else {
                    br.clearCookies(null);
                    account.clearCookies("");
                }
            }
            logger.info("Performing full login");
            br.setCookie(getHost(), "ktvc", "0");
            br.setCookie(getHost(), "privyOptIn", "false");
            br.getPage("https://www." + getHost() + "/login");
            final Form loginform = br.getFormbyProperty("name", "login");
            if (loginform == null) {
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT, "Failed to find loginform");
            }
            /* Add some browser fingerprinting magic */
            loginform.put("pf", Encoding.urlEncode(getPFValue(this.br, loginform)));
            loginform.put("username", Encoding.urlEncode(account.getUser()));
            loginform.put("password", Encoding.urlEncode(account.getPass()));
            if (loginform.containsHTML("phone") && !loginform.hasInputFieldByName("phone")) {
                loginform.put("phone", "");
            }
            /* Makes the cookies last for 30 days */
            loginform.put("remember", "on");
            final boolean captchaRequired = br.containsHTML("window\\.grecaptchaRequired\\s*=\\s*true");
            if (captchaRequired) {
                final Browser brc = br.cloneBrowser();
                brc.getPage("/assets/packs/global.1355.js");
                String reCaptchaKey = brc.getRegex("var c\\s*=\\s*\"([^\"]+)").getMatch(0);
                if (reCaptchaKey == null) {
                    logger.warning("Failed to find reCaptchaKey -> Fallback to hardcoded value");
                    reCaptchaKey = "6LfTIKIdAAAAAI56SZ-5XsX2yS2HpjTKyFwmz-C9"; // 2024-02-22
                }
                final String recaptchaV2Response = new CaptchaHelperHostPluginRecaptchaV2(this, br, reCaptchaKey) {
                    @Override
                    public TYPE getType() {
                        return TYPE.INVISIBLE;
                    }
                }.getToken();
                loginform.put("g-recaptcha-response", Encoding.urlEncode(recaptchaV2Response));
            }
            final Request post = br.createFormRequest(loginform);
            post.getHeaders().put("Origin", "https://www." + this.getHost());
            br.getPage(post);
            if (!isLoggedin(br)) {
                /* Recommend cookie login to user */
                showCookieLoginInfo();
                throw new AccountInvalidException();
            }
            account.saveCookies(br.getCookies(br.getHost()), "");
        }
    }

    private boolean checkAndSaveCookies(final Browser br, final Cookies cookies, final Account account) throws IOException {
        logger.info("Attempting cookie login");
        br.setCookies(this.getHost(), cookies);
        br.getPage("https://www." + this.getHost() + "/my/billing");
        if (this.isLoggedin(br)) {
            logger.info("Cookie login successful");
            /* Refresh cookie timestamp */
            account.saveCookies(br.getCookies(br.getHost()), "");
            return true;
        } else {
            logger.info("Cookie login failed");
            return false;
        }
    }

    /** Returns special browser fingerprinting value required for first login. */
    private String getPFValue(final Browser br, final Form loginform) throws PluginException {
        final InputField csrf = loginform.getInputField("_csrf");
        if (csrf == null || csrf.getValue() == null) {
            throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
        }
        final String pf = "%7B%22plugins%22%3A%5B%5D%2C%22mimeTypes%22%3A%5B%5D%2C%22userAgent%22%3A%22Mozilla%2F5.0%20(X11%3B%20Ubuntu%3B%20Linux%20x86_64%3B%20rv%3A88.0)%20Gecko%2F20100101%20Firefox%2F88.0%22%2C%22platform%22%3A%22Linux%20x86_64%22%2C%22languages%22%3A%5B%22de%22%2C%22de-DE%22%2C%22en%22%5D%2C%22screen%22%3A%7B%22wInnerHeight%22%3A1469%2C%22wOuterHeight%22%3A1571%2C%22wOuterWidth%22%3A2560%2C%22wInnerWidth%22%3A2560%2C%22wScreenX%22%3A0%2C%22wPageXOffset%22%3A0%2C%22wPageYOffset%22%3A0%2C%22cWidth%22%3A2560%2C%22cHeight%22%3A1389%2C%22sWidth%22%3A2560%2C%22sHeight%22%3A1600%2C%22sAvailWidth%22%3A2560%2C%22sAvailHeight%22%3A1600%2C%22sColorDepth%22%3A24%2C%22sPixelDepth%22%3A24%2C%22wDevicePixelRatio%22%3A1%7D%2C%22touchScreen%22%3A%5B0%2Cfalse%2Cfalse%5D%2C%22videoCard%22%3A%5B%22NVIDIA%20Corporation%22%2C%22GeForce%20GTX%20660%2FPCIe%2FSSE2%22%5D%2C%22multimediaDevices%22%3A%7B%22speakers%22%3A0%2C%22micros%22%3A3%2C%22webcams%22%3A0%7D%2C%22productSub%22%3A%2220100101%22%2C%22navigatorPrototype%22%3A%5B%22vibrate~~~function%20vibrate()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22javaEnabled~~~function%20javaEnabled()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22getGamepads~~~function%20getGamepads()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22mozGetUserMedia~~~function%20mozGetUserMedia()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22sendBeacon~~~function%20sendBeacon()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22requestMediaKeySystemAccess~~~function%20requestMediaKeySystemAccess()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22registerProtocolHandler~~~function%20registerProtocolHandler()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22taintEnabled~~~function%20taintEnabled()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22permissions~~~function%20permissions()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22mimeTypes~~~function%20mimeTypes()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22plugins~~~function%20plugins()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22doNotTrack~~~function%20doNotTrack()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22maxTouchPoints~~~function%20maxTouchPoints()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22mediaCapabilities~~~function%20mediaCapabilities()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22oscpu~~~function%20oscpu()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22vendor~~~function%20vendor()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22vendorSub~~~function%20vendorSub()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22productSub~~~function%20productSub()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22cookieEnabled~~~function%20cookieEnabled()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22buildID~~~function%20buildID()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22mediaDevices~~~function%20mediaDevices()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22credentials~~~function%20credentials()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22clipboard~~~function%20clipboard()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22mediaSession~~~function%20mediaSession()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22webdriver~~~function%20webdriver()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22hardwareConcurrency~~~function%20hardwareConcurrency()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22geolocation~~~function%20geolocation()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22appCodeName~~~function%20appCodeName()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22appName~~~function%20appName()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22appVersion~~~function%20appVersion()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22platform~~~function%20platform()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22userAgent~~~function%20userAgent()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22product~~~function%20product()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22language~~~function%20language()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22languages~~~function%20languages()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22onLine~~~function%20onLine()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22storage~~~function%20storage()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22constructor~~~function%20Navigator()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22toString~~~%22%2C%22toLocaleString~~~%22%2C%22valueOf~~~%22%2C%22hasOwnProperty~~~%22%2C%22isPrototypeOf~~~%22%2C%22propertyIsEnumerable~~~%22%2C%22__defineGetter__~~~%22%2C%22__defineSetter__~~~%22%2C%22__lookupGetter__~~~%22%2C%22__lookupSetter__~~~%22%2C%22__proto__~~~%22%2C%22constructor~~~function%20Navigator()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%5D%2C%22etsl%22%3A37%2C%22screenDesc%22%3A%22function%20width()%20%7B%5Cn%20%20%20%20%5Bnative%20code%5D%5Cn%7D%22%2C%22phantomJS%22%3A%5Bfalse%2Cfalse%2Cfalse%5D%2C%22nightmareJS%22%3Afalse%2C%22selenium%22%3A%5Bfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%2Cfalse%5D%2C%22webDriver%22%3Atrue%2C%22webDriverValue%22%3Afalse%2C%22errorsGenerated%22%3A%5B%22azeaze%20is%20not%20defined%22%2C%22https%3A%2F%2Fwww.kink.com%2Fjavascripts%2Fkink.min.1064.js%22%2C1%2Cnull%2Cnull%2C980632%2Cnull%2C%22An%20invalid%20or%20illegal%20string%20was%20specified%22%5D%2C%22resOverflow%22%3A%7B%22depth%22%3A24415%2C%22errorMessage%22%3A%22too%20much%20recursion%22%2C%22errorName%22%3A%22InternalError%22%2C%22errorStacklength%22%3A7808%7D%2C%22accelerometerUsed%22%3Afalse%2C%22screenMediaQuery%22%3Atrue%2C%22hasChrome%22%3Afalse%2C%22detailChrome%22%3A%22unknown%22%2C%22permissions%22%3A%7B%22state%22%3A%22prompt%22%2C%22permission%22%3A%22default%22%7D%2C%22iframeChrome%22%3A%22undefined%22%2C%22debugTool%22%3Afalse%2C%22battery%22%3Afalse%2C%22deviceMemory%22%3A0%2C%22tpCanvas%22%3A%7B%220%22%3A0%2C%221%22%3A0%2C%222%22%3A0%2C%223%22%3A0%7D%2C%22sequentum%22%3Afalse%2C%22audioCodecs%22%3A%7B%22ogg%22%3A%22probably%22%2C%22mp3%22%3A%22maybe%22%2C%22wav%22%3A%22probably%22%2C%22m4a%22%3A%22maybe%22%2C%22aac%22%3A%22maybe%22%7D%2C%22videoCodecs%22%3A%7B%22ogg%22%3A%22probably%22%2C%22h264%22%3A%22probably%22%2C%22webm%22%3A%22probably%22%7D%2C%22csrf%22%3A%22"
                + csrf.getValue() + "%22%7D";
        return Encoding.Base64Encode(pf);
    }

    private boolean isLoggedin(final Browser br) {
        return br.containsHTML("/logout\"");
    }

    @Override
    public AccountInfo fetchAccountInfo(final Account account) throws Exception {
        final AccountInfo ai = new AccountInfo();
        login(account, true);
        if (!br.getURL().contains("/my/billing")) {
            /* E.g. first full website login */
            br.getPage("/my/billing");
        }
        final Cookies userCookies = account.loadUserCookies();
        if (userCookies != null) {
            /*
             * When using cookie login users can enter whatever they want into username field --> We're trying to get unique values for that
             * field too!
             */
            String username = br.getRegex("account-name\"[^>]*>([^<]+)<").getMatch(0);
            if (username == null) {
                /* 2024-02-22 */
                username = br.getRegex("id=\"userDropdownMenu\"[^>]*>\\s*<li><p [^>]*>([^<]+)<").getMatch(0);
            }
            if (username != null) {
                account.setUser(Encoding.htmlDecode(username).trim());
            } else {
                logger.warning("Failed to find username");
            }
        }
        Boolean isAutoRebill = null;
        long highestExpireTimestamp = -1;
        /* User can own multiple premium packages --> Use the expire date that is farthest away to set in JD! */
        final String[] possibleExpireDates = br.getRegex("([A-Z][a-z]{2} \\d{2}, \\d{4} \\d{2}:\\d{2} [A-Z]{3})").getColumn(0);
        if (possibleExpireDates != null && possibleExpireDates.length > 0) {
            for (final String possibleExpireDate : possibleExpireDates) {
                final long expireTimestampTmp = TimeFormatter.getMilliSeconds(possibleExpireDate, "MMM dd, yyyy HH:mm ZZ", Locale.ENGLISH);
                if (expireTimestampTmp > highestExpireTimestamp) {
                    highestExpireTimestamp = expireTimestampTmp;
                }
            }
        } else {
            /* Maybe user only has permanent subscriptions "without" expire-date --> Use highest "rebill-date" as expire-date instead. */
            final String[] possibleRebillDates = br.getRegex("([A-Z][a-z]{2} \\d{1,2}, \\d{4})").getColumn(0);
            if (possibleRebillDates != null && possibleRebillDates.length > 0) {
                for (final String possibleExpireDate : possibleRebillDates) {
                    final long expireTimestampTmp = TimeFormatter.getMilliSeconds(possibleExpireDate, "MMM dd, yyyy", Locale.ENGLISH);
                    if (expireTimestampTmp > highestExpireTimestamp) {
                        highestExpireTimestamp = expireTimestampTmp;
                    }
                }
                isAutoRebill = true;
            }
        }
        /* 2024-09-11: Running subscriptions do not have an end date */
        boolean isRunningSubscription = br.containsHTML("id=\"cancelSub\"");
        if (!isRunningSubscription) {
            isRunningSubscription = br.containsHTML("class=\"subscription-status\"[^>]*>\\s*active");
        }
        if (highestExpireTimestamp == -1 && !isRunningSubscription) {
            ai.setExpired(true);
            logger.info("Failed to find any expiredate -> Account is expired or plugin is broken");
            return ai;
        }
        /*
         * Always set expire-date. Free/expired premium accounts are unsupported and will get displayed as expired automatically --> Do NOT
         * accept those!
         */
        if (highestExpireTimestamp != -1) {
            ai.setValidUntil(highestExpireTimestamp, br);
        }
        ai.setUnlimitedTraffic();
        account.setType(AccountType.PREMIUM);
        account.setConcurrentUsePossible(true);
        String statusText = account.getType().getLabel();
        if (isAutoRebill != null) {
            if (Boolean.TRUE.equals(isAutoRebill)) {
                statusText += " | Auto rebill: Yes";
            } else {
                statusText += " | Auto rebill: No";
            }
        }
        /* Try to let user know when login session will expire */
        final Cookies allCookies = br.getCookies(br.getHost());
        final Cookie cookie = allCookies.get("kinky.sess");
        if (cookie != null && userCookies != null) {
            final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            final String sessionExpireDateFormatted = formatter.format(new Date(cookie.getExpireDate()));
            statusText += " | Cookies valid until: " + sessionExpireDateFormatted;
        }
        ai.setStatus(statusText);
        return ai;
    }

    @Override
    public void handlePremium(final DownloadLink link, final Account account) throws Exception {
        handleDownload(link, account);
    }

    @Override
    public int getMaxSimultanPremiumDownloadNum() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean hasCaptcha(final DownloadLink link, final Account acc) {
        /* Only account login can have captchas */
        return false;
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
