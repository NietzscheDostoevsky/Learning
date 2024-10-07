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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import jd.PluginWrapper;
import jd.http.Browser;
import jd.nutils.encoding.Encoding;
import jd.parser.Regex;
import jd.plugins.Account.AccountType;
import jd.plugins.DownloadLink;
import jd.plugins.DownloadLink.AvailableStatus;
import jd.plugins.HostPlugin;
import jd.plugins.LinkStatus;
import jd.plugins.PluginException;
import jd.plugins.PluginForHost;
import jd.plugins.decrypter.EasyuploadIoFolder;

import org.appwork.utils.StringUtils;
import org.appwork.utils.formatter.SizeFormatter;
import org.appwork.utils.parser.UrlQuery;
import org.jdownloader.captcha.v2.challenge.recaptcha.v2.CaptchaHelperHostPluginRecaptchaV2;
import org.jdownloader.scripting.JavaScriptEngineFactory;

@HostPlugin(revision = "$Revision: 49430 $", interfaceVersion = 3, names = {}, urls = {})
public class EasyuploadIo extends PluginForHost {
    public EasyuploadIo(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public String getAGBLink() {
        return "https://easyupload.io/terms-of-use";
    }

    public static List<String[]> getPluginDomains() {
        final List<String[]> ret = new ArrayList<String[]>();
        // each entry in List<String[]> will result in one PluginForHost, Plugin.getHost() will return String[0]->main domain
        ret.add(new String[] { "easyupload.io" });
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
        final List<String> ret = new ArrayList<String>();
        for (final String[] domains : getPluginDomains()) {
            ret.add("https?://(?:www\\.)?" + buildHostsPatternPart(domains) + "/([A-Za-z0-9\\-_]+)");
        }
        return ret.toArray(new String[0]);
    }

    /* Connection stuff */
    private static final boolean FREE_RESUME       = true;
    private static final int     FREE_MAXCHUNKS    = 1;
    private static final int     FREE_MAXDOWNLOADS = -1;

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
    public AvailableStatus requestFileInformation(final DownloadLink link) throws Exception {
        if (!link.isNameSet()) {
            link.setName(this.getFID(link));
        }
        this.setBrowserExclusive();
        br.getPage(link.getPluginPatternMatcher());
        EasyuploadIoFolder.checkErrors(br);
        parseFileInfo(br, link);
        return AvailableStatus.TRUE;
    }

    public static void parseFileInfo(final Browser br, final DownloadLink link) throws PluginException {
        String filename = br.getRegex("<h4[^>]*>([^<>\"]+)</h4>").getMatch(0);
        String filesize = br.getRegex("(?i)\\s*Size:\\s*(\\d+(\\.\\d+)? [^ \"\\|]+)").getMatch(0);
        if (filename != null) {
            filename = Encoding.htmlDecode(filename).trim();
            /* Set final filename because they are truncating long filenames in Content-Disposition header. */
            link.setFinalFileName(filename);
        }
        if (filesize != null) {
            link.setDownloadSize(SizeFormatter.getSize(filesize));
        }
        if (filename == null && filesize == null && !br.containsHTML("class=\"upload\"")) {
            /* E.g. invalid URLs such as easyupload.io/login */
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
        }
    }

    @Override
    public void handleFree(final DownloadLink link) throws Exception, PluginException {
        requestFileInformation(link);
        doFree(link, FREE_RESUME, FREE_MAXCHUNKS, "free_directlink");
    }

    private void doFree(final DownloadLink link, final boolean resumable, final int maxchunks, final String directlinkproperty) throws Exception, PluginException {
        String dllink = checkDirectLink(link, directlinkproperty);
        if (dllink == null) {
            final String fid = this.getFID(link);
            final String action = br.getRegex("url\\s*:\\s*\"(https?://[^\"]+action\\.php)\"").getMatch(0);
            if (action == null) {
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
            }
            String passCode = null;
            if (br.containsHTML("(?i)\\| Password Protected")) {
                link.setPasswordProtected(true);
                passCode = link.getDownloadPassword();
                if (StringUtils.isEmpty(passCode)) {
                    /* No stored password available? Ask user! */
                    passCode = getUserInput("Password?", link);
                }
            } else {
                link.setPasswordProtected(false);
                passCode = "";
            }
            final UrlQuery query = new UrlQuery();
            query.add("type", "download-token");
            query.add("url", fid);
            final String passwordMaxLength = br.getRegex("<input id=\"password\"[^>]*maxlength=\"(\\d+)\"[^>]*>").getMatch(0);
            final int maxLength = passwordMaxLength != null ? Integer.parseInt(passwordMaxLength) : 20;
            if (passCode != null && passCode.length() > maxLength) {
                passCode = passCode.substring(0, maxLength);
            }
            query.add("value", Encoding.urlEncode(passCode));
            query.add("method", "regular");
            final boolean captchaIsAlwaysNeeded = true; // 2023-05-30
            if (CaptchaHelperHostPluginRecaptchaV2.containsRecaptchaV2Class(br) || captchaIsAlwaysNeeded) {
                final CaptchaHelperHostPluginRecaptchaV2 rc2 = new CaptchaHelperHostPluginRecaptchaV2(this, br);
                final String rckey = rc2.getSiteKey();
                final String captchatoken;
                if (rckey != null) {
                    final String recaptchaV2Response = new CaptchaHelperHostPluginRecaptchaV2(this, br, rckey).getToken();
                    captchatoken = recaptchaV2Response;
                } else {
                    /* 2023-01-05: No recaptcha but custom generated value */
                    final StringBuilder sb = new StringBuilder();
                    final String plainjs = "function generateCaptcha(length) {    let result = '';    const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';    const charactersLength = characters.length;    let counter = 0;    while (counter < length) {      result += characters.charAt(Math.floor(Math.random() * charactersLength));      counter += 1;    }    return result;}";
                    sb.append(plainjs.replace("let ", "var "));
                    sb.append("var res = generateCaptcha(32);");
                    final ScriptEngineManager manager = JavaScriptEngineFactory.getScriptEngineManager(this);
                    final ScriptEngine engine = manager.getEngineByName("javascript");
                    engine.eval(sb.toString());
                    captchatoken = engine.get("res").toString();
                }
                query.add("captchatoken", Encoding.urlEncode(captchatoken));
            }
            br.postPage(action, query);
            if (br.containsHTML("(?i)Invalid file password")) {
                /* {"status":false,"data":"Invalid file password"} */
                link.setDownloadPassword(null);
                throw new PluginException(LinkStatus.ERROR_RETRY, "Wrong password entered");
            }
            if (link.isPasswordProtected()) {
                link.setDownloadPassword(passCode);
            }
            final Map<String, Object> entries = JavaScriptEngineFactory.jsonToJavaMap(br.getRequest().getHtmlCode());
            /* 2023-07-12: This can be null. Should be a super rare case. */
            dllink = (String) entries.get("download_link");
            if (StringUtils.isEmpty(dllink)) {
                throw new PluginException(LinkStatus.ERROR_FATAL, "No downloadlink available -> Broken file?");
            }
        }
        dl = jd.plugins.BrowserAdapter.openDownload(br, link, dllink, resumable, maxchunks);
        handleConnectionErrors(br, dl.getConnection());
        link.setProperty(directlinkproperty, dl.getConnection().getURL().toString());
        dl.startDownload();
    }

    private String checkDirectLink(final DownloadLink link, final String property) {
        final String dllink = link.getStringProperty(property);
        if (dllink != null) {
            try {
                basicLinkCheck(br.cloneBrowser(), br.createHeadRequest(dllink), link, null, null, new FILENAME_SOURCE[0]);
                return dllink;
            } catch (final Exception e) {
                link.removeProperty(property);
                logger.log(e);
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean hasCaptcha(DownloadLink link, jd.plugins.Account acc) {
        if (acc == null) {
            /* no account, yes we can expect captcha */
            return true;
        } else if (acc.getType() == AccountType.FREE) {
            /* Free accounts can have captchas */
            return true;
        } else {
            /* Premium accounts do not have captchas */
            return false;
        }
    }

    @Override
    public int getMaxSimultanFreeDownloadNum() {
        return FREE_MAXDOWNLOADS;
    }

    @Override
    public void reset() {
    }

    @Override
    public void resetDownloadlink(DownloadLink link) {
    }
}