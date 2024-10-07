package org.jdownloader.plugins.components.config;

import org.appwork.storage.config.annotations.AboutConfig;
import org.appwork.storage.config.annotations.DefaultBooleanValue;
import org.appwork.storage.config.annotations.DefaultEnumValue;
import org.appwork.storage.config.annotations.DefaultIntValue;
import org.appwork.storage.config.annotations.DefaultOnNull;
import org.appwork.storage.config.annotations.DescriptionForConfigEntry;
import org.appwork.storage.config.annotations.LabelInterface;
import org.appwork.storage.config.annotations.SpinnerValidator;
import org.jdownloader.plugins.config.Order;
import org.jdownloader.plugins.config.PluginConfigInterface;
import org.jdownloader.plugins.config.PluginHost;
import org.jdownloader.plugins.config.TakeValueFromSubconfig;
import org.jdownloader.plugins.config.Type;

@PluginHost(host = "rapidgator.net", type = Type.HOSTER)
public interface RapidGatorConfig extends PluginConfigInterface {
    final String                    text_ActivateExperimentalWaittimeHandling             = "Activate experimental waittime handling to prevent 24-hours IP ban from rapidgator?";
    final String                    text_EnableAPIPremium                                 = "Enable API for premium downloads [recommended] (disabled = use website for premium downloads)?";
    final String                    text_EnableResumeFree                                 = "Attempt to resume stopped downloads in free (& free-account) mode? Rapidgator sometimes allows resume in free mode for some files and sometimes doesn't.";
    final String                    text_ExperimentalEnforceSSL                           = "Activate experimental forced SSL for downloads?";
    final String                    text_Referer                                          = "Define custom referer";
    final String                    text_ReadTimeout                                      = "Define custom browser read-timeout (seconds)";
    final String                    text_WaitSecondsOnErrorYouCantDownloadMoreThanOneFile = "Wait time on error 'You can't download more than one file at the same time' (seconds)";
    public static final TRANSLATION TRANSLATION                                           = new TRANSLATION();

    public static class TRANSLATION {
        public String getActivateExperimentalWaittimeHandling_label() {
            return text_ActivateExperimentalWaittimeHandling;
        }

        public String getEnableAPIPremium_label() {
            return text_EnableAPIPremium;
        }

        public String getEnableResumeFree_label() {
            return text_EnableResumeFree;
        }

        public String getEnableFreeDownloadModeCaptchaDuringPreDownloadWait_label() {
            return "Free downloads: Handle captcha during pre download wait time?";
        }

        public String getExperimentalEnforceSSL_label() {
            return text_ExperimentalEnforceSSL;
        }

        public String getReferer_label() {
            return text_Referer;
        }

        public String getReadTimeout_label() {
            return text_ReadTimeout;
        }

        public String getWaitSecondsOnErrorYouCantDownloadMoreThanOneFile_label() {
            return text_WaitSecondsOnErrorYouCantDownloadMoreThanOneFile;
        }

        public String getPremiumDownloadBehaviorForSubscriberOnlyFiles_label() {
            return "Premium account download: What to do when an additional subscription is required to download a file?";
        }
    }

    @AboutConfig
    @DefaultBooleanValue(false)
    @TakeValueFromSubconfig("EXPERIMENTALHANDLING")
    @DescriptionForConfigEntry(text_ActivateExperimentalWaittimeHandling)
    @DefaultOnNull()
    @Order(10)
    boolean isActivateExperimentalWaittimeHandling();

    void setActivateExperimentalWaittimeHandling(boolean b);

    /* Some users always get server error 500 via API thus website might work better for them. */
    @AboutConfig
    @DefaultBooleanValue(true)
    @DescriptionForConfigEntry(text_EnableAPIPremium)
    @DefaultOnNull()
    @Order(20)
    boolean isEnableAPIPremium();

    void setEnableAPIPremium(boolean b);

    /**
     * 2020-08-05: Resume in free mode is sometimes working, sometimes not. This setting allows users to disable resuming so they e.g.
     * always get the "non resumable downloads active" warning when stopping their downloads.
     */
    @AboutConfig
    @DefaultBooleanValue(true)
    @DescriptionForConfigEntry(text_EnableResumeFree)
    @DefaultOnNull()
    @Order(21)
    boolean isEnableResumeFree();

    void setEnableResumeFree(boolean b);

    @AboutConfig
    @DefaultBooleanValue(true)
    @DescriptionForConfigEntry("This may save some time for free- and free account downloads.")
    @DefaultOnNull()
    @Order(22)
    boolean isEnableFreeDownloadModeCaptchaDuringPreDownloadWait();

    void setEnableFreeDownloadModeCaptchaDuringPreDownloadWait(boolean b);

    @AboutConfig
    @DefaultBooleanValue(false)
    @TakeValueFromSubconfig("EXPERIMENTAL_ENFORCE_SSL")
    @DescriptionForConfigEntry(text_ExperimentalEnforceSSL)
    @DefaultOnNull()
    @Order(30)
    boolean isExperimentalEnforceSSL();

    void setExperimentalEnforceSSL(boolean b);

    @AboutConfig
    @TakeValueFromSubconfig("CUSTOM_REFERER")
    @DescriptionForConfigEntry(text_Referer)
    @DefaultOnNull()
    @Order(40)
    String getReferer();

    void setReferer(String str);

    @AboutConfig
    @DefaultIntValue(120)
    @SpinnerValidator(min = 1, max = 300, step = 1)
    @DefaultOnNull()
    @Order(50)
    @DescriptionForConfigEntry(text_ReadTimeout)
    int getReadTimeout();

    void setReadTimeout(int i);

    @AboutConfig
    @DefaultIntValue(300)
    @SpinnerValidator(min = 15, max = 900, step = 1)
    @DefaultOnNull()
    @Order(60)
    @DescriptionForConfigEntry(text_WaitSecondsOnErrorYouCantDownloadMoreThanOneFile)
    int getWaitSecondsOnErrorYouCantDownloadMoreThanOneFile();

    void setWaitSecondsOnErrorYouCantDownloadMoreThanOneFile(int i);

    public static enum PremiumDownloadBehaviorForSubscriberOnlyFiles implements LabelInterface {
        SKIP {
            @Override
            public String getLabel() {
                return "Skip file";
            }
        },
        DOWNLOAD_AS_FREE_USER {
            @Override
            public String getLabel() {
                return "Download file as free user";
            }
        };
    }

    @AboutConfig
    @DefaultEnumValue("SKIP")
    @DefaultOnNull()
    @Order(70)
    @DescriptionForConfigEntry("What to do when a file needs a separate (additional) subscription but is also downloadable for free users?")
    PremiumDownloadBehaviorForSubscriberOnlyFiles getPremiumDownloadBehaviorForSubscriberOnlyFiles();

    void setPremiumDownloadBehaviorForSubscriberOnlyFiles(final PremiumDownloadBehaviorForSubscriberOnlyFiles namingSchemeType);
}