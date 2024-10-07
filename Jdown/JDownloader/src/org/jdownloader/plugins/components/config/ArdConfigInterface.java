package org.jdownloader.plugins.components.config;

import org.appwork.storage.config.annotations.AboutConfig;
import org.appwork.storage.config.annotations.DefaultBooleanValue;
import org.appwork.storage.config.annotations.DefaultEnumValue;
import org.appwork.storage.config.annotations.DefaultStringValue;
import org.appwork.storage.config.annotations.DescriptionForConfigEntry;
import org.appwork.storage.config.annotations.LabelInterface;
import org.jdownloader.plugins.config.Order;
import org.jdownloader.plugins.config.PluginConfigInterface;
import org.jdownloader.plugins.config.PluginHost;
import org.jdownloader.plugins.config.Type;
import org.jdownloader.translate._JDT;

@PluginHost(host = "ardmediathek.de", type = Type.CRAWLER)
public interface ArdConfigInterface extends PluginConfigInterface {
    final String text_PreferredSubtitleType = "Preferred subtitle type";

    public static class TRANSLATION {
        public String getFastLinkcheckEnabled_label() {
            return _JDT.T.lit_enable_fast_linkcheck();
        }

        public String getGrabSubtitleEnabled_label() {
            return _JDT.T.lit_add_subtitles();
        }

        public String getPreferredSubtitleType_label() {
            return text_PreferredSubtitleType;
        }

        public String getPreferAudioDescription_label() {
            return "Prefer audiodescription";
        }

        public String getGrabBESTEnabled_label() {
            return _JDT.T.lit_add_only_the_best_video_quality();
        }

        public String getOnlyBestVideoQualityOfSelectedQualitiesEnabled_label() {
            return _JDT.T.lit_add_only_the_best_video_quality_within_user_selected_formats();
        }
        // public String getAddUnknownQualitiesEnabled_label() {
        // return _JDT.T.lit_add_unknown_formats();
        // }

        public String getAudioLanguagePriorityString_label() {
            return "Audio language priority string";
        }

        public String getHlsCrawlMode_label() {
            return "HLS crawl mode";
        }
    }

    public static final ArdConfigInterface.TRANSLATION TRANSLATION = new TRANSLATION();

    @DefaultBooleanValue(true)
    @Order(9)
    boolean isFastLinkcheckEnabled();

    void setFastLinkcheckEnabled(boolean b);

    @DefaultBooleanValue(false)
    @Order(10)
    boolean isGrabSubtitleEnabled();

    void setGrabSubtitleEnabled(boolean b);

    public static enum SubtitleType implements LabelInterface {
        WEBVTT {
            @Override
            public String getLabel() {
                return "WEBVTT (.vtt)";
            }
        },
        XML {
            @Override
            public String getLabel() {
                return "EBU-TT XML (.xml)";
            }
        },
        SRT {
            @Override
            public String getLabel() {
                return "SRT [EBU-TT XML converted to srt (.srt)]";
            }
        };
    }

    @AboutConfig
    @DefaultEnumValue("WEBVTT")
    @Order(11)
    SubtitleType getPreferredSubtitleType();

    void setPreferredSubtitleType(final SubtitleType type);

    @DefaultBooleanValue(false)
    @Order(12)
    boolean isPreferAudioDescription();

    void setPreferAudioDescription(boolean b);

    @DefaultBooleanValue(false)
    @Order(20)
    boolean isGrabBESTEnabled();

    void setGrabBESTEnabled(boolean b);

    @AboutConfig
    @DefaultBooleanValue(false)
    @Order(21)
    boolean isOnlyBestVideoQualityOfSelectedQualitiesEnabled();

    void setOnlyBestVideoQualityOfSelectedQualitiesEnabled(boolean b);

    /* 2022-01-20: Grabbing unknown qualities is not supported anymore for now. */
    // @DefaultBooleanValue(true)
    // @Order(22)
    // boolean isAddUnknownQualitiesEnabled();
    //
    // void setAddUnknownQualitiesEnabled(boolean b);
    @DefaultBooleanValue(true)
    @Order(25)
    boolean isGrabHLS144pVideoEnabled();

    void setGrabHLS144pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(30)
    boolean isGrabHLS180pVideoEnabled();

    void setGrabHLS180pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(40)
    boolean isGrabHLS270pVideoEnabled();

    void setGrabHLS270pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(42)
    boolean isGrabHLS280pVideoEnabled();

    void setGrabHLS280pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(43)
    boolean isGrabHLS288pVideoEnabled();

    void setGrabHLS288pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(50)
    boolean isGrabHLS360pVideoEnabled();

    void setGrabHLS360pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(60)
    boolean isGrabHLS480pVideoEnabled();

    void setGrabHLS480pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(70)
    boolean isGrabHLS540pVideoEnabled();

    void setGrabHLS540pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(80)
    boolean isGrabHLS720pVideoEnabled();

    void setGrabHLS720pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(81)
    boolean isGrabHLS1080pVideoEnabled();

    void setGrabHLS1080pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(82)
    boolean isGrabHLS1440pVideoEnabled();

    void setGrabHLS1440pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(83)
    boolean isGrabHLS2160pVideoEnabled();

    void setGrabHLS2160pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(85)
    boolean isGrabHTTP144pVideoEnabled();

    void setGrabHTTP144pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(90)
    boolean isGrabHTTP180pVideoEnabled();

    void setGrabHTTP180pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(100)
    boolean isGrabHTTP270pVideoEnabled();

    void setGrabHTTP270pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(110)
    boolean isGrabHTTP280pVideoEnabled();

    void setGrabHTTP280pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(115)
    boolean isGrabHTTP288pVideoEnabled();

    void setGrabHTTP288pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(120)
    boolean isGrabHTTP360pVideoEnabled();

    void setGrabHTTP360pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(130)
    boolean isGrabHTTP480pVideoEnabled();

    void setGrabHTTP480pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(140)
    boolean isGrabHTTP540pVideoEnabled();

    void setGrabHTTP540pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(150)
    boolean isGrabHTTP720pVideoEnabled();

    void setGrabHTTP720pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(151)
    boolean isGrabHTTP1080pVideoEnabled();

    void setGrabHTTP1080pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(152)
    boolean isGrabHTTP1440pVideoEnabled();

    void setGrabHTTP1440pVideoEnabled(boolean b);

    @DefaultBooleanValue(true)
    @Order(153)
    boolean isGrabHTTP2160pVideoEnabled();

    void setGrabHTTP2160pVideoEnabled(boolean b);

    @AboutConfig
    @DescriptionForConfigEntry("Define priority of audio languages e.g. 'deu,ov' or 'de, en, original'. Only the first available source will be added. If none of the preferred languages are found, only the first found language will be added.")
    @DefaultStringValue("deu,ov")
    @Order(180)
    String getAudioLanguagePriorityString();

    void setAudioLanguagePriorityString(String str);

    public static enum HlsCrawlMode implements LabelInterface {
        AUTO {
            @Override
            public String getLabel() {
                return "Auto";
            }
        },
        ALWAYS_WHEN_HLS_IS_SELECTED {
            @Override
            public String getLabel() {
                return "Always return HLS streams if selected";
            }
        };
    }

    @AboutConfig
    @DefaultEnumValue("AUTO")
    @Order(200)
    HlsCrawlMode getHlsCrawlMode();

    void setHlsCrawlMode(final HlsCrawlMode mode);
}