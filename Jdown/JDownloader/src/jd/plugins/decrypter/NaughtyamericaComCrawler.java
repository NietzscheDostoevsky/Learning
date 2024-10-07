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
package jd.plugins.decrypter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jd.PluginWrapper;
import jd.controlling.AccountController;
import jd.controlling.ProgressController;
import jd.http.Browser;
import jd.nutils.encoding.Encoding;
import jd.parser.Regex;
import jd.plugins.Account;
import jd.plugins.Account.AccountError;
import jd.plugins.AccountRequiredException;
import jd.plugins.CryptedLink;
import jd.plugins.DecrypterPlugin;
import jd.plugins.DecrypterRetryException;
import jd.plugins.DecrypterRetryException.RetryReason;
import jd.plugins.DownloadLink;
import jd.plugins.FilePackage;
import jd.plugins.LinkStatus;
import jd.plugins.PluginException;
import jd.plugins.PluginForDecrypt;
import jd.plugins.PluginForHost;
import jd.plugins.hoster.NaughtyamericaCom;

import org.appwork.utils.StringUtils;
import org.jdownloader.plugins.components.config.NaughtyamericaConfig;
import org.jdownloader.plugins.components.config.NaughtyamericaConfig.VideoImageGalleryCrawlMode;
import org.jdownloader.plugins.config.PluginJsonConfig;

@DecrypterPlugin(revision = "$Revision: 49907 $", interfaceVersion = 2, names = { "naughtyamerica.com" }, urls = { "https?://(?:members|tour|www)\\.naughtyamerica\\.com/scene/[a-z0-9\\-]+\\-\\d+" })
public class NaughtyamericaComCrawler extends PluginForDecrypt {
    public NaughtyamericaComCrawler(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public Browser createNewBrowserInstance() {
        final Browser br = super.createNewBrowserInstance();
        br.setFollowRedirects(true);
        return br;
    }

    public static String DOMAIN_BASE           = "naughtyamerica.com";
    public static String DOMAIN_PREFIX_PREMIUM = "members.";

    @Override
    public ArrayList<DownloadLink> decryptIt(final CryptedLink param, ProgressController progress) throws Exception {
        return crawlContent(param, false);
    }

    public ArrayList<DownloadLink> crawlContent(final CryptedLink param, final boolean ignoreQualitySelection) throws Exception {
        final ArrayList<DownloadLink> ret = new ArrayList<DownloadLink>();
        /* 2016-12-12: Prefer current website instead of beta */
        final String contenturl = param.getCryptedUrl().replaceFirst("(?i)beta\\.", "");
        final String urlSlug = new Regex(contenturl, "/([a-z0-9\\-]+)$").getMatch(0);
        final String contentID = new Regex(contenturl, "(\\d+)$").getMatch(0);
        final Account acc = AccountController.getInstance().getValidAccount(this.getHost());
        if (acc != null) {
            final PluginForHost hostPlugin = this.getNewPluginForHostInstance(this.getHost());
            ((jd.plugins.hoster.NaughtyamericaCom) hostPlugin).login(acc, false);
            br.getPage(getVideoUrlPremium(urlSlug));
        } else {
            br.getPage(getVideoUrlFree(urlSlug));
        }
        final String redirect = br.getRegex("Redirecting to <a\\s*href\\s*=\\s*\"(https?://[^<>\"]+)\"\\s*>").getMatch(0);
        if (redirect != null) {
            br.getPage(redirect);
        }
        if (isOffline(br)) {
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
        }
        final String title = urlSlug;
        if (acc != null) {
            if (!NaughtyamericaCom.isLoggedIN(this.br)) {
                acc.setError(AccountError.TEMP_DISABLED, 30 * 1000l, "Session expired?");
                throw new DecrypterRetryException(RetryReason.PLUGIN_SETTINGS, "ACCOUNT_LOGIN_EXPIRED_" + urlSlug, "Refresh your account in settings and try again.");
            } else if (br.containsHTML(">\\s*Add 3D Videos to")) {
                throw new AccountRequiredException("Add 3D Videos to your Membership to unlock this video");
            }
            final ArrayList<Integer> selectedQualities = this.getSelectedQualities();
            if (selectedQualities.isEmpty() && !ignoreQualitySelection) {
                throw new DecrypterRetryException(RetryReason.PLUGIN_SETTINGS, "USER_DESELECTED_ALL_QUALITIES_" + urlSlug, "You've deselected all qualities in the settings of this plugin.");
            }
            final HashSet<String> alldirecturls = new HashSet<String>();
            String[] directurls = br.getRegex("playVideoStream\\([^\\)]*'(https?://[^<>\"\\']+)").getColumn(0);
            if (directurls.length == 0) {
                /*
                 * Fallback e.g. for vr content which is only available in one quality(?) e.g.
                 * https://members.naughtyamerica.com/scene/rpvr-rorysummeralex-30918
                 */
                // directurls = br.getRegex("<source src=\"(https?://[^\"]+)\"[^>]*type=\"video/mp4\"").getColumn(0);
                directurls = br.getRegex("var video_file = \"(https?://[^\"]+)\"").getColumn(0);
            }
            if (directurls != null && directurls.length > 0) {
                for (String directlink : directurls) {
                    directlink = Encoding.htmlOnlyDecode(directlink);
                    alldirecturls.add(directlink);
                }
            }
            /* 2023-01-05 */
            final String[] directurls2 = br.getRegex("<source[^<]*src=\"(https?://[^\"]+)\"[^<]*type=\"video/mp4\"").getColumn(0);
            if (directurls2 != null && directurls2.length > 0) {
                for (String directlink : directurls2) {
                    directlink = Encoding.htmlOnlyDecode(directlink);
                    alldirecturls.add(directlink);
                }
            }
            if (alldirecturls.isEmpty()) {
                /* This should never happen */
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT, "Failed to find any directurls");
            }
            // final String[] captchaDownloadurls =
            // br.getRegex("\"(https?://members\\.naughtyamerica\\.com/scene/\\d+/captcha\\?file_name=[^\"]+)").getColumn(0);
            final List<DownloadLink> unknownQualities = new ArrayList<DownloadLink>();
            final Map<Integer, List<DownloadLink>> foundQualities = new HashMap<Integer, List<DownloadLink>>();
            int qualityHeightMax = -1;
            final List<DownloadLink> best = new ArrayList<DownloadLink>();
            final NaughtyamericaConfig cfg = PluginJsonConfig.get(NaughtyamericaConfig.class);
            final boolean preferh265 = cfg.isPreferH265();
            for (final String directlink : alldirecturls) {
                /* Skip trailers */
                if (StringUtils.containsIgnoreCase(directlink, "/trailers/")) {
                    logger.info("Skipping trailer URL: " + directlink);
                    continue;
                }
                final String qualityStr = new Regex(directlink, "(?i)_([a-z0-9]+)\\.(?:wmv|mp4)").getMatch(0);
                if (qualityStr == null) {
                    logger.warning("Failed to find quality modifier for URL: " + directlink);
                    continue;
                }
                final int qualityHeight = getQualityHeight(qualityStr);
                String ext = getFileNameExtensionFromURL(directlink);
                if (ext == null) {
                    ext = ".mp4";
                }
                final String filename = title + "_" + qualityStr + ext;
                final DownloadLink dl = this.createDownloadlink(directlink.replaceFirst("https?://", "http://naughtyamericadecrypted"));
                dl.setLinkID(this.getHost() + "://" + contentID + "_" + qualityStr);
                dl.setName(filename);
                dl.setAvailable(true);
                dl.setProperty(NaughtyamericaCom.PROPERTY_CRAWLER_FILENAME, filename);
                dl.setProperty(NaughtyamericaCom.PROPERTY_CONTENT_ID, contentID);
                dl.setProperty(NaughtyamericaCom.PROPERTY_VIDEO_QUALITY, Integer.toString(qualityHeight));
                dl.setProperty(NaughtyamericaCom.PROPERTY_URL_SLUG, urlSlug);
                dl.setProperty(NaughtyamericaCom.PROPERTY_MAINLINK, contenturl);
                if (qualityHeight == -1) {
                    unknownQualities.add(dl);
                } else {
                    List<DownloadLink> list = foundQualities.get(qualityHeight);
                    if (list == null) {
                        list = new ArrayList<DownloadLink>();
                        foundQualities.put(qualityHeight, list);
                    }
                    list.add(dl);
                }
                if (best.size() == 0) {
                    qualityHeightMax = qualityHeight;
                    best.add(dl);
                } else if (qualityHeight > qualityHeightMax) {
                    qualityHeightMax = qualityHeight;
                    best.clear();
                    best.add(dl);
                } else if (qualityHeight == qualityHeightMax) {
                    best.add(dl);
                }
            }
            logger.info("Found qualities: Total: " + alldirecturls.size() + " | Known: " + foundQualities.keySet() + " | Unknown: " + unknownQualities.size());
            if (cfg.isGrabBestVideoQualityOnly()) {
                for (DownloadLink link : best) {
                    if (preferh265 && link.getPluginPatternMatcher().contains("265.")) {
                        ret.add(link);
                        break;
                    } else if (!preferh265 && !link.getPluginPatternMatcher().contains("265.")) {
                        ret.add(link);
                        break;
                    }
                }
            } else if (foundQualities.size() > 0) {
                /* Add user selected qualities */
                /* TODO: Add plugin setting for this */
                final boolean addUnknownQualitiesAsFallback = true;
                final Iterator<Entry<Integer, List<DownloadLink>>> iterator = foundQualities.entrySet().iterator();
                while (iterator.hasNext()) {
                    final Entry<Integer, List<DownloadLink>> entry = iterator.next();
                    final int quality = entry.getKey();
                    if (selectedQualities.contains(quality)) {
                        if (entry.getValue().size() == 1) {
                            ret.addAll(entry.getValue());
                        } else {
                            for (DownloadLink link : entry.getValue()) {
                                if (preferh265 && link.getPluginPatternMatcher().contains("265.")) {
                                    ret.add(link);
                                    break;
                                } else if (!preferh265 && !link.getPluginPatternMatcher().contains("265.")) {
                                    ret.add(link);
                                    break;
                                }
                            }
                        }

                    }
                }
                if (ret.isEmpty() && addUnknownQualitiesAsFallback) {
                    ret.addAll(unknownQualities);
                }
                if (ret.isEmpty()) {
                    throw new DecrypterRetryException(RetryReason.PLUGIN_SETTINGS, "FAILED_TO_FIND_ANY_SELECTED_QUALITY_" + urlSlug, "None of your selected qualities have been found. Select all to get results.");
                }
            } else {
                /* Fallback: Add all unknown qualities */
                /* Developer should update plugin-settings */
                logger.warning("Failed to find any known video-qualities -> Adding all found unknown qualities as fallback");
                ret.addAll(unknownQualities);
            }
            if (ignoreQualitySelection) {
                ret.clear();
                for (List<DownloadLink> quality : foundQualities.values()) {
                    ret.addAll(quality);
                }
                ret.addAll(unknownQualities);
            }
            final VideoImageGalleryCrawlMode mode = cfg.getVideoImageGalleryCrawlMode();
            if (mode == VideoImageGalleryCrawlMode.AS_SINGLE_IMAGES || ignoreQualitySelection) {
                /* Crawl picture gallery if user wants that. */
                final String galleryCount = br.getRegex("var galleryCount = (\\d+);").getMatch(0);
                final String imageBase = br.getRegex("href=\"[^\"]*(//content\\.naughtycdn\\.com/photosets/[^\"]+/large_)1\\.jpg").getMatch(0);
                if (galleryCount != null && imageBase != null) {
                    for (int imageNumber = 1; imageNumber <= Integer.parseInt(galleryCount); imageNumber++) {
                        final String finallink = "https:" + imageBase + imageNumber + ".jpg";
                        final DownloadLink dl = this.createDownloadlink(generateUrlForHostplugin(finallink));
                        dl.setLinkID(this.getHost() + "://" + contentID + "_" + imageNumber);
                        final String filename = title + "_" + imageNumber + ".jpg";
                        dl.setFinalFileName(filename);
                        dl.setAvailable(true);
                        dl.setProperty(NaughtyamericaCom.PROPERTY_CRAWLER_FILENAME, filename);
                        dl.setProperty(NaughtyamericaCom.PROPERTY_CONTENT_ID, contentID);
                        dl.setProperty(NaughtyamericaCom.PROPERTY_PICTURE_NUMBER, imageNumber);
                        dl.setProperty(NaughtyamericaCom.PROPERTY_URL_SLUG, urlSlug);
                        dl.setProperty(NaughtyamericaCom.PROPERTY_MAINLINK, contenturl);
                        ret.add(dl);
                    }
                } else {
                    logger.warning("Picture gallery handling failed");
                }
            }
            String allPicturesZipDownloadURL = br.getRegex("class=\"download-zip\"[^>]*href=\"[^\"]*(//[^\"]+\\.zip)\"").getMatch(0);
            if (allPicturesZipDownloadURL != null && (mode == VideoImageGalleryCrawlMode.AS_ZIP || ignoreQualitySelection)) {
                allPicturesZipDownloadURL = "https:" + allPicturesZipDownloadURL;
                final DownloadLink zip = this.createDownloadlink(generateUrlForHostplugin(allPicturesZipDownloadURL));
                zip.setLinkID(this.getHost() + "://" + contentID + "_zip");
                final String filename = title + ".zip";
                zip.setFinalFileName(title + ".zip");
                zip.setAvailable(true);
                zip.setProperty(NaughtyamericaCom.PROPERTY_CRAWLER_FILENAME, filename);
                zip.setProperty(NaughtyamericaCom.PROPERTY_CONTENT_ID, contentID);
                zip.setProperty(NaughtyamericaCom.PROPERTY_PICTURE_NUMBER, "ZIP");
                zip.setProperty(NaughtyamericaCom.PROPERTY_URL_SLUG, urlSlug);
                zip.setProperty(NaughtyamericaCom.PROPERTY_MAINLINK, contenturl);
                ret.add(zip);
            }
        } else {
            /* We're not logged in but maybe the user has an account to download later or a multihoster account --> Add one dummy url. */
            final String quality_dummy = "1080";
            final String type_dummy = "full";
            final String linkid = title + type_dummy + quality_dummy;
            final DownloadLink dl = this.createDownloadlink("http://naughtyamericadecryptedlvl3.secure.naughtycdn.com/mfhg/members/chanelvan/" + urlSlug + "_" + quality_dummy + ".mp4");
            dl.setLinkID(linkid);
            /*
             * Do not include quality in filename here as we do not kow which quality we'll get in the end - user might only download the
             * trailer which is often only available in 480p.
             */
            dl.setName(title + ".mp4");
            dl.setProperty(NaughtyamericaCom.PROPERTY_CONTENT_ID, contentID);
            dl.setProperty(NaughtyamericaCom.PROPERTY_VIDEO_QUALITY, quality_dummy);
            dl.setProperty(NaughtyamericaCom.PROPERTY_URL_SLUG, urlSlug);
            dl.setAvailable(true);
            ret.add(dl);
        }
        final FilePackage fp = FilePackage.getInstance();
        fp.setName(title);
        fp.addLinks(ret);
        return ret;
    }

    private String generateUrlForHostplugin(final String url) {
        return url.replaceFirst("https?://", "http://naughtyamericadecrypted");
    }

    private int getQualityHeight(final String qualityStr) {
        if (qualityStr.matches("\\d+")) {
            return Integer.parseInt(qualityStr);
        } else if (qualityStr.equalsIgnoreCase("8k") || StringUtils.startsWithCaseInsensitive(qualityStr, "8k")) {
            return 4320;
        } else if (qualityStr.equalsIgnoreCase("6k") || StringUtils.startsWithCaseInsensitive(qualityStr, "6k")) {
            /* Quest2/Quest Pro 6K H265 */
            return 3466;
        } else if (qualityStr.equalsIgnoreCase("4k")) {
            return 2160;
        } else if (qualityStr.equalsIgnoreCase("vrdesktophd")) {
            /* Quest1/Oculus Rift 4K */
            return 2048;
        } else if (qualityStr.equalsIgnoreCase("3dh")) {
            return 1440;
        } else if (qualityStr.equalsIgnoreCase("1080p")) {
            return 1080;
        } else if (qualityStr.equalsIgnoreCase("sbs")) {
            /* Playstation VR -> Also 1080p */
            return 1080;
        } else if (qualityStr.equalsIgnoreCase("smartphonevr00")) {
            /* Smartphone (Legacy) */
            return 1024;
        } else if (qualityStr.equalsIgnoreCase("720p")) {
            return 720;
        } else if (qualityStr.equalsIgnoreCase("qt") || qualityStr.equalsIgnoreCase("480p")) {
            return 480;
        } else {
            /* Unknown quality */
            return -1;
        }
    }

    private ArrayList<Integer> getSelectedQualities() {
        final ArrayList<Integer> selectedQualities = new ArrayList<Integer>();
        final NaughtyamericaConfig cfg = PluginJsonConfig.get(NaughtyamericaConfig.class);
        if (cfg.isGrab8K()) {
            selectedQualities.add(4320);
        }
        if (cfg.isGrab6K()) {
            // Multiple different video-heights possible
            selectedQualities.add(3465);
            selectedQualities.add(3466);
        }
        if (cfg.isGrab4K()) {
            // Multiple different video-heights possible
            selectedQualities.add(2048);
            selectedQualities.add(2160);
        }
        if (cfg.isGrab1440p()) {
            selectedQualities.add(1440);
        }
        if (cfg.isGrab1080p()) {
            selectedQualities.add(1080);
        }
        if (cfg.isGrab720p()) {
            selectedQualities.add(720);
        }
        if (cfg.isGrab480p()) {
            selectedQualities.add(480);
        }
        return selectedQualities;
    }

    public static String getVideoUrlFree(final String filename_url) {
        return "https://www." + DOMAIN_BASE + "/scene/" + filename_url;
    }

    public static String getVideoUrlPremium(final String filename_url) {
        return "https://" + DOMAIN_PREFIX_PREMIUM + DOMAIN_BASE + "/scene/" + filename_url;
    }

    public static String getPicUrl(final String filename_url) {
        return getVideoUrlPremium(filename_url);
    }

    public static boolean isOffline(final Browser br) {
        if (br.getHttpConnection().getResponseCode() == 404) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isProxyRotationEnabledForLinkCrawler() {
        return false;
    }

    public boolean hasCaptcha(CryptedLink link, jd.plugins.Account acc) {
        return false;
    }
}