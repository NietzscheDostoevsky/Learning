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
package jd.plugins.decrypter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import jd.PluginWrapper;
import jd.controlling.ProgressController;
import jd.parser.Regex;
import jd.plugins.CryptedLink;
import jd.plugins.DecrypterPlugin;
import jd.plugins.DownloadLink;
import jd.plugins.FilePackage;
import jd.plugins.LinkStatus;
import jd.plugins.PluginException;
import jd.plugins.PluginForDecrypt;
import jd.utils.JDUtilities;

@DecrypterPlugin(revision = "$Revision: 49089 $", interfaceVersion = 2, names = {}, urls = {})
public class ModDbComDecrypter extends PluginForDecrypt {
    public ModDbComDecrypter(PluginWrapper wrapper) {
        super(wrapper);
    }

    private volatile boolean loaded = false;
    private static Object    LOCK   = new Object();

    public static List<String[]> getPluginDomains() {
        final List<String[]> ret = new ArrayList<String[]>();
        // each entry in List<String[]> will result in one PluginForDecrypt, Plugin.getHost() will return String[0]->main domain
        ret.add(new String[] { "moddb.com" });
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
            ret.add("https?://(?:www\\.)?" + buildHostsPatternPart(domains) + "/(games|mods|engines|groups)/([\\w+\\-]+)(/(addons|downloads)(/page/\\d+|/[\\w\\-]+)?)?");
        }
        return ret.toArray(new String[0]);
    }

    public ArrayList<DownloadLink> decryptIt(CryptedLink param, ProgressController progress) throws Exception {
        ArrayList<DownloadLink> ret = new ArrayList<DownloadLink>();
        String contenturl = param.getCryptedUrl();
        final Regex urlinforegex = new Regex(contenturl, this.getSupportedLinks());
        final HashSet<String> invalidfileitems = new HashSet<String>();
        invalidfileitems.add("add");
        invalidfileitems.add("feed");
        invalidfileitems.add("page");
        final String singlefileitemregexStr = "(?i).+/(addons|downloads)/([\\w\\-]+)$";
        final Regex singleitemregex = new Regex(contenturl, singlefileitemregexStr);
        final String titleSlug = urlinforegex.getMatch(1);
        br.setFollowRedirects(true);
        if (singleitemregex.patternFind()) {
            /* Single file */
            final String singlefileitemSlug = singleitemregex.getMatch(1);
            if (invalidfileitems.contains(singlefileitemSlug)) {
                throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
            }
            br.getPage(contenturl);
            if (br.getHttpConnection().getResponseCode() == 404) {
                throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
            }
            if (loaded == false) {
                synchronized (LOCK) {
                    if (loaded == false) {
                        /*
                         * we only have to load this once, to make sure its loaded
                         */
                        JDUtilities.getPluginForHost(this.getHost());
                    }
                    loaded = true;
                }
            }
            // Get pages with the mirrors
            jd.plugins.hoster.ModDbCom.getSinglemirrorpage(br);
            ret.add(createDownloadlink(contenturl.replace("moddb.com/", "moddbdecrypted.com/")));
            return ret;
        } else {
            /* Multiple items */
            if (!contenturl.contains("/addons") && !contenturl.contains("/downloads")) {
                /* Correct URL added by user */
                contenturl += "/downloads";
            }
            br.getPage(contenturl);
            if (br.getHttpConnection().getResponseCode() == 404) {
                throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
            }
            final String[] downloadlinks = br.getRegex("(/[\\w\\-]+/" + titleSlug + "/(addons|downloads)/(?!feed|page)[\\w\\-]+)").getColumn(0);
            if (downloadlinks == null || downloadlinks.length == 0) {
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
            }
            final FilePackage fp = FilePackage.getInstance();
            fp.setName(titleSlug.replace("-", " ").trim());
            fp.setPackageKey("moddb://slug/" + titleSlug);
            for (final String downloadlink : downloadlinks) {
                final Regex thisSingleitemregex = new Regex(downloadlink, singlefileitemregexStr);
                final String thisTitleSlug = thisSingleitemregex.getMatch(1);
                /* Skip invalid results here already in order to prevent getting ugly offline-items later on. */
                if (invalidfileitems.contains(thisTitleSlug)) {
                    /* Skip invalid items */
                    logger.info("Skipping invalid URL: " + downloadlink);
                    continue;
                }
                final String fullurl = br.getURL(downloadlink).toExternalForm();
                final DownloadLink link = this.createDownloadlink(fullurl);
                link._setFilePackage(fp);
                ret.add(link);
            }
        }
        return ret;
    }

    @Override
    public boolean hasCaptcha(CryptedLink link, jd.plugins.Account acc) {
        return false;
    }
}