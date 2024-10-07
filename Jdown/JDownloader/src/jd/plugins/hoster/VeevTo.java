//jDownloader - Downloadmanager
//Copyright (C) 2013  JD-Team support@jdownloader.org
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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.appwork.storage.TypeRef;
import org.appwork.utils.StringUtils;
import org.jdownloader.plugins.components.XFileSharingProBasic;

import jd.PluginWrapper;
import jd.http.Browser;
import jd.parser.Regex;
import jd.parser.html.Form;
import jd.parser.html.Form.MethodType;
import jd.plugins.Account;
import jd.plugins.Account.AccountType;
import jd.plugins.DownloadLink;
import jd.plugins.HostPlugin;
import jd.plugins.LinkStatus;
import jd.plugins.PluginException;

@HostPlugin(revision = "$Revision: 49420 $", interfaceVersion = 3, names = {}, urls = {})
public class VeevTo extends XFileSharingProBasic {
    public VeevTo(final PluginWrapper wrapper) {
        super(wrapper);
        this.enablePremium(super.getPurchasePremiumURL());
    }

    /**
     * DEV NOTES XfileSharingProBasic Version SEE SUPER-CLASS<br />
     * mods: See overridden functions<br />
     * limit-info:<br />
     * captchatype-info: 2024-04-10: reCaptchaV2 <br />
     * other:<br />
     */
    public static List<String[]> getPluginDomains() {
        final List<String[]> ret = new ArrayList<String[]>();
        // each entry in List<String[]> will result in one PluginForHost, Plugin.getHost() will return String[0]->main domain
        ret.add(new String[] { "veev.to" });
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
        return VeevTo.buildAnnotationUrlsVeevToSpecial(getPluginDomains());
    }

    private static final Pattern PATTERN_SPECIAL = Pattern.compile("/(d|e)/([A-Za-z0-9]+)", Pattern.CASE_INSENSITIVE);

    public static String[] buildAnnotationUrlsVeevToSpecial(final List<String[]> pluginDomains) {
        final List<String> ret = new ArrayList<String>();
        for (final String[] domains : pluginDomains) {
            ret.add("https?://(?:www\\.)?" + buildHostsPatternPart(domains) + "(?::\\d+)?" + PATTERN_SPECIAL.pattern());
        }
        return ret.toArray(new String[0]);
    }

    @Override
    public boolean isResumeable(final DownloadLink link, final Account account) {
        final AccountType type = account != null ? account.getType() : null;
        if (AccountType.FREE.equals(type)) {
            /* Free Account */
            return true;
        } else if (AccountType.PREMIUM.equals(type) || AccountType.LIFETIME.equals(type)) {
            /* Premium account */
            return true;
        } else {
            /* Free(anonymous) and unknown account type */
            return true;
        }
    }

    @Override
    public int getMaxChunks(final Account account) {
        final AccountType type = account != null ? account.getType() : null;
        if (AccountType.FREE.equals(type)) {
            /* Free Account */
            return 0;
        } else if (AccountType.PREMIUM.equals(type) || AccountType.LIFETIME.equals(type)) {
            /* Premium account */
            return 0;
        } else {
            /* Free(anonymous) and unknown account type */
            return 0;
        }
    }

    @Override
    public int getMaxSimultaneousFreeAnonymousDownloads() {
        return -1;
    }

    @Override
    public int getMaxSimultaneousFreeAccountDownloads() {
        return -1;
    }

    @Override
    public int getMaxSimultanPremiumDownloadNum() {
        return -1;
    }

    @Override
    protected String getDllinkViaOfficialVideoDownloadNew(final Browser br, final DownloadLink link, final Account account, final boolean returnFilesize) throws Exception {
        if (returnFilesize) {
            logger.info("[FilesizeMode] Trying to find official video downloads");
            return null;
        }
        final Form dlform = br.getFormbyActionRegex(".*/dl");
        if (dlform == null) {
            // throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
            /* 2024-07-08 */
            throw new PluginException(LinkStatus.ERROR_FATAL, "Uploader has disabled downloads for this file");
        }
        final Form preForm = new Form();
        preForm.setMethod(MethodType.POST);
        preForm.put("op", "ae");
        preForm.put("cmd", "aet");
        preForm.put("t", "1");
        preForm.put("e", "1");
        // preForm.put("kp38653", "");
        preForm.put("n", "propellerads");
        preForm.put("wc", "0");
        preForm.put("h", "");
        preForm.put("u", "25");
        final Browser br2 = br.cloneBrowser();
        submitForm(br2, preForm);
        final Map<String, Object> entries = restoreFromString(br2.getRequest().getHtmlCode(), TypeRef.MAP);
        if (!"success".equals(entries.get("status"))) {
            throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
        }
        // final CaptchaHelperHostPluginRecaptchaV2 rc2 = getCaptchaHelperHostPluginRecaptchaV2(this, br);
        // final String rctoken = rc2.getToken();
        // dlform.put("k", Encoding.urlEncode(rctoken));
        this.handleRecaptchaV2(link, br, dlform);
        br2.setFollowRedirects(false);
        // submitForm(br2, dlform);
        br2.submitForm(dlform);
        final String dllink = br2.getRedirectLocation();
        if (StringUtils.isEmpty(dllink)) {
            logger.warning("Failed to find dllink via official video download");
        } else {
            logger.info("Successfully found dllink via official video download");
        }
        return dllink;
    }

    @Override
    public String[] scanInfo(final String html, final String[] fileInfo) {
        super.scanInfo(html, fileInfo);
        final String betterFilename = new Regex(html, "<h4>([^<]+)</h4>").getMatch(0);
        if (betterFilename != null) {
            fileInfo[0] = betterFilename;
        }
        return fileInfo;
    }

    @Override
    protected boolean isOffline(final DownloadLink link, final Browser br) {
        if (br.containsHTML("<title>Watch video - Veev\\.to</title>")) {
            /* 2024-07-08: Offline embed item without further error message. */
            return true;
        } else {
            return super.isOffline(link, br);
        }
    }

    @Override
    protected URL_TYPE getURLType(final String url) {
        if (url == null) {
            return null;
        }
        final Regex regex_pattern_special = new Regex(url, PATTERN_SPECIAL);
        if (regex_pattern_special.patternFind()) {
            return super.getURLType(url);
        }
        final String typeString = regex_pattern_special.getMatch(0);
        if (typeString.equalsIgnoreCase("e")) {
            return URL_TYPE.EMBED_VIDEO_2;
        } else {
            return URL_TYPE.OFFICIAL_VIDEO_DOWNLOAD;
        }
    }

    @Override
    protected String getFUID(final String url, URL_TYPE type) {
        if (url == null || type == null) {
            return null;
        }
        try {
            if (type == URL_TYPE.EMBED_VIDEO_2) {
                return new Regex(new URL(url).getPath(), "(?i)/e/([A-Za-z0-9]+)").getMatch(0);
            } else if (type == URL_TYPE.EMBED_VIDEO_2) {
                return new Regex(new URL(url).getPath(), "(?i)/d/([A-Za-z0-9]+)").getMatch(0);
            }
        } catch (MalformedURLException e) {
            logger.log(e);
        }
        return super.getFUID(url, type);
    }
}