package org.jdownloader.gui.views.linkgrabber.contextmenu;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import jd.controlling.downloadcontroller.DownloadController;
import jd.controlling.linkcollector.LinkCollector;
import jd.controlling.linkcollector.LinkCollector.ConfirmLinksSettings;
import jd.controlling.linkcollector.LinkCollector.MoveLinksMode;
import jd.controlling.linkcrawler.CrawledLink;
import jd.controlling.linkcrawler.CrawledPackage;
import jd.gui.swing.jdgui.JDGui;
import jd.gui.swing.jdgui.interfaces.View;

import org.appwork.storage.config.annotations.LabelInterface;
import org.appwork.storage.config.annotations.SpinnerValidator;
import org.appwork.swing.MigPanel;
import org.appwork.uio.ComboBoxDialogInterface;
import org.appwork.uio.UIOManager;
import org.appwork.utils.Application;
import org.appwork.utils.ImageProvider.ImageProvider;
import org.appwork.utils.event.queue.QueueAction;
import org.appwork.utils.swing.EDTRunner;
import org.appwork.utils.swing.dialog.ComboBoxDialog;
import org.appwork.utils.swing.dialog.DefaultButtonPanel;
import org.appwork.utils.swing.dialog.Dialog;
import org.appwork.utils.swing.dialog.DialogCanceledException;
import org.appwork.utils.swing.dialog.DialogClosedException;
import org.appwork.utils.swing.dialog.DialogNoAnswerException;
import org.jdownloader.actions.AppAction;
import org.jdownloader.controlling.Priority;
import org.jdownloader.controlling.contextmenu.ActionContext;
import org.jdownloader.controlling.contextmenu.CustomizableTableContextAppAction;
import org.jdownloader.controlling.contextmenu.Customizer;
import org.jdownloader.extensions.extraction.Archive;
import org.jdownloader.extensions.extraction.ArchiveFile;
import org.jdownloader.extensions.extraction.DummyArchive;
import org.jdownloader.extensions.extraction.ExtractionExtension;
import org.jdownloader.extensions.extraction.bindings.crawledlink.CrawledLinkArchiveFile;
import org.jdownloader.extensions.extraction.contextmenu.downloadlist.ArchiveValidator;
import org.jdownloader.extensions.extraction.contextmenu.downloadlist.ArchiveValidator.ArchiveValidation;
import org.jdownloader.extensions.extraction.gui.DummyArchiveDialog;
import org.jdownloader.gui.IconKey;
import org.jdownloader.gui.KeyObserver;
import org.jdownloader.gui.event.GUIEventSender;
import org.jdownloader.gui.event.GUIListener;
import org.jdownloader.gui.translate._GUI;
import org.jdownloader.gui.views.SelectionInfo;
import org.jdownloader.gui.views.linkgrabber.LinkGrabberTable;
import org.jdownloader.gui.views.linkgrabber.LinkgrabberSearchField;
import org.jdownloader.images.AbstractIcon;
import org.jdownloader.images.NewTheme;
import org.jdownloader.plugins.config.Order;
import org.jdownloader.settings.GraphicalUserInterfaceSettings.ConfirmIncompleteArchiveAction;
import org.jdownloader.settings.staticreferences.CFG_GUI;
import org.jdownloader.settings.staticreferences.CFG_LINKGRABBER;
import org.jdownloader.translate._JDT;

public class ConfirmLinksContextAction extends CustomizableTableContextAppAction<CrawledPackage, CrawledLink> implements GUIListener, ActionContext {
    public static final String SELECTION_ONLY = "selectionOnly";

    public static enum OnOfflineLinksAction implements LabelInterface {
        INCLUDE_OFFLINE {
            @Override
            public String getLabel() {
                return _JDT.T.ConfirmLinksContextAction_HandleOfflineLinksOptions_INCLUDE_OFFLINE();
            }

            @Override
            public OnOfflineLinksAction getSelectedAction() {
                return this;
            }
        },
        EXCLUDE_OFFLINE {
            @Override
            public String getLabel() {
                return _JDT.T.ConfirmLinksContextAction_HandleOfflineLinksOptions_EXCLUDE_OFFLINE();
            }

            @Override
            public OnOfflineLinksAction getSelectedAction() {
                return this;
            }
        },
        EXCLUDE_OFFLINE_AND_REMOVE {
            @Override
            public String getLabel() {
                return _JDT.T.ConfirmLinksContextAction_HandleOfflineLinksOptions_EXCLUDE_OFFLINE_AND_REMOVE();
            }

            @Override
            public OnOfflineLinksAction getSelectedAction() {
                return this;
            }
        },
        ASK {
            @Override
            public String getLabel() {
                return _JDT.T.ConfirmLinksContextAction_HandleOfflineLinksOptions_ASK();
            }

            @Override
            public OnOfflineLinksAction getSelectedAction() {
                return this;
            }
        },
        GLOBAL {
            @Override
            public String getLabel() {
                return _JDT.T.ConfirmLinksContextAction_HandleOfflineLinksOptions_GLOBAL(getSelectedAction().getLabel());
            }

            @Override
            public OnOfflineLinksAction getSelectedAction() {
                final OnOfflineLinksAction dflt = CFG_LINKGRABBER.CFG.getDefaultOnAddedOfflineLinksAction();
                if (dflt == this || dflt == null) {
                    return OnOfflineLinksAction.ASK;
                }
                return dflt;
            }
        };

        public abstract OnOfflineLinksAction getSelectedAction();
    }

    public static enum OnDupesLinksAction implements LabelInterface {
        INCLUDE {
            @Override
            public String getLabel() {
                return _JDT.T.ConfirmLinksContextAction_HandleDupesLinksOptions_INCLUDE();
            }

            @Override
            public OnDupesLinksAction getSelectedAction() {
                return this;
            }
        },
        EXCLUDE {
            @Override
            public String getLabel() {
                return _JDT.T.ConfirmLinksContextAction_HandleDupesLinksOptions_EXCLUDE();
            }

            @Override
            public OnDupesLinksAction getSelectedAction() {
                return this;
            }
        },
        EXCLUDE_AND_REMOVE {
            @Override
            public String getLabel() {
                return _JDT.T.ConfirmLinksContextAction_HandleDupesLinksOptions_EXCLUDE_AND_REMOVE();
            }

            @Override
            public OnDupesLinksAction getSelectedAction() {
                return this;
            }
        },
        ASK {
            @Override
            public String getLabel() {
                return _JDT.T.ConfirmLinksContextAction_HandleDupesLinksOptions_ASK();
            }

            @Override
            public OnDupesLinksAction getSelectedAction() {
                return this;
            }
        },
        GLOBAL {
            @Override
            public String getLabel() {
                return _JDT.T.ConfirmLinksContextAction_HandleDupesLinksOptions_GLOBAL(getSelectedAction().getLabel());
            }

            @Override
            public OnDupesLinksAction getSelectedAction() {
                final OnDupesLinksAction dflt = CFG_LINKGRABBER.CFG.getDefaultOnAddedDupesLinksAction();
                if (dflt == this || dflt == null) {
                    return OnDupesLinksAction.ASK;
                } else {
                    return dflt;
                }
            }
        };

        public abstract OnDupesLinksAction getSelectedAction();
    }

    public static enum AutoStartOptions implements LabelInterface {
        AUTO {
            @Override
            public String getLabel() {
                return _JDT.T.AutoStartOptions_AUTO();
            }

            @Override
            public boolean isEnabled() {
                return CFG_LINKGRABBER.LINKGRABBER_AUTO_START_ENABLED.isEnabled();
            }
        },
        DISABLED {
            @Override
            public String getLabel() {
                return _JDT.T.AutoStartOptions_DISABLED();
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        },
        ENABLED {
            @Override
            public String getLabel() {
                return _JDT.T.AutoStartOptions_ENABLED();
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };

        public abstract boolean isEnabled();
    }

    public static enum PackageExpandBehavior implements LabelInterface {
        UNCHANGED {
            @Override
            public String getLabel() {
                return _JDT.T.PackageExpandBehavior_UNCHANGED();
            }
        },
        EXPANDED {
            @Override
            public String getLabel() {
                return _JDT.T.PackageExpandBehavior_EXPANDED();
            }
        },
        COLLAPSED {
            @Override
            public String getLabel() {
                return _JDT.T.PackageExpandBehavior_COLLAPSED();
            }
        };
    }

    public static enum ConfirmationDialogBehavior implements LabelInterface {
        DISABLED {
            @Override
            public String getLabel() {
                return "Disabled";
            }
        },
        ENABLED_THRESHOLD_AUTO {
            @Override
            public String getLabel() {
                return "Auto: Threshold & if no other dialogs were shown";
            }
        },
        ENABLED_THRESHOLD_SIMPLE {
            @Override
            public String getLabel() {
                return "Enabled: Threshold";
            }
        };
    }

    public static String getTranslationForCtrlToggle() {
        return _JDT.T.ConfirmLinksContextAction_getTranslationForCtrlToggle();
    }

    @Customizer(link = "#getTranslationForCtrlToggle")
    @Order(301)
    public boolean isCtrlToggle() {
        return ctrlToggle;
    }

    public void setCtrlToggle(boolean ctrlToggle) {
        this.ctrlToggle = ctrlToggle;
    }

    public static String getTranslationForForceDownloads() {
        return _JDT.T.ConfirmLinksContextAction_getTranslationForForceDownloads();
    }

    @Customizer(link = "#getTranslationForForceDownloads")
    public boolean isForceDownloads() {
        return forceDownloads;
    }

    public void setForceDownloads(boolean forceDownloads) {
        this.forceDownloads = forceDownloads;
    }

    private boolean                    ctrlToggle                                            = true;
    private boolean                    forceDownloads                                        = false;
    private Priority                   piority                                               = Priority.DEFAULT;
    private boolean                    assignPriorityEnabled                                 = false;
    private PackageExpandBehavior      packageExpandBehavior                                 = PackageExpandBehavior.UNCHANGED;
    private OnOfflineLinksAction       handleOffline                                         = OnOfflineLinksAction.GLOBAL;
    private OnDupesLinksAction         handleDupes                                           = OnDupesLinksAction.GLOBAL;
    private AutoStartOptions           autoStart                                             = AutoStartOptions.AUTO;
    private boolean                    clearListAfterConfirm                                 = false;
    private boolean                    metaCtrl                                              = false;
    private ConfirmationDialogBehavior confirmationDialogBehavior                            = ConfirmationDialogBehavior.DISABLED;
    private int                        minNumberofPackagesForConfirmMoveToDownloadlistDialog = 1;
    private int                        minNumberofLinksForConfirmMoveToDownloadlistDialog    = 1;

    public static String getTranslationForAssignPriorityEnabled() {
        return _JDT.T.ConfirmLinksContextAction_getTranslationForAssignPriorityEnabled();
    }

    @Customizer(link = "#getTranslationForAssignPriorityEnabled")
    @Order(20)
    public boolean isAssignPriorityEnabled() {
        return assignPriorityEnabled;
    }

    public void setAssignPriorityEnabled(boolean assignPriorityEnabled) {
        this.assignPriorityEnabled = assignPriorityEnabled;
    }

    public static String getTranslationForPriority() {
        return _JDT.T.ConfirmLinksContextAction_getTranslationForPriority();
    }

    @Customizer(link = "#getTranslationForPriority")
    @Order(21)
    public Priority getPriority() {
        return piority;
    }

    public void setPriority(Priority priority) {
        this.piority = priority;
    }

    public static String getTranslationForPackageExpandBehavior() {
        return _JDT.T.ConfirmLinksContextAction_getTranslationForPackageExpandBehavior();
    }

    @Customizer(link = "#getTranslationForPackageExpandBehavior")
    @Order(30)
    public PackageExpandBehavior getPackageExpandBehavior() {
        return packageExpandBehavior;
    }

    public void setPackageExpandBehavior(PackageExpandBehavior packageExpandBehavior) {
        this.packageExpandBehavior = packageExpandBehavior;
    }

    public static String getTranslationForConfirmationDialogBehavior() {
        return "Add links conformation dialog behavior";
    }

    @Customizer(link = "#getTranslationForConfirmationDialogBehavior")
    @Order(40)
    @SpinnerValidator(min = 1, max = Integer.MAX_VALUE, step = 1)
    public ConfirmationDialogBehavior getConfirmationDialogBehavior() {
        return this.confirmationDialogBehavior;
    }

    public void setConfirmationDialogBehavior(ConfirmationDialogBehavior behavior) {
        this.confirmationDialogBehavior = behavior;
    }

    public static String getTranslationForMinNumberofPackagesForMoveToDownloadlistConfirmDialog() {
        return "Min number of packages for confirm dialog";
    }

    @Customizer(link = "#getTranslationForMinNumberofPackagesForMoveToDownloadlistConfirmDialog")
    @Order(41)
    @SpinnerValidator(min = 1, max = Integer.MAX_VALUE, step = 1)
    public int getMinNumberofPackagesForMoveToDownloadlistConfirmDialog() {
        return this.minNumberofPackagesForConfirmMoveToDownloadlistDialog;
    }

    public void setMinNumberofPackagesForMoveToDownloadlistConfirmDialog(int num) {
        this.minNumberofPackagesForConfirmMoveToDownloadlistDialog = num;
    }

    public static String getTranslationForMinNumberofLinksForMoveToDownloadlistConfirmDialog() {
        return "Min number of links for confirm dialog";
    }

    @Customizer(link = "#getTranslationForMinNumberofLinksForMoveToDownloadlistConfirmDialog")
    @Order(42)
    public int getMinNumberofLinksForMoveToDownloadlistConfirmDialog() {
        return this.minNumberofLinksForConfirmMoveToDownloadlistDialog;
    }

    public void setMinNumberofLinksForMoveToDownloadlistConfirmDialog(int num) {
        this.minNumberofLinksForConfirmMoveToDownloadlistDialog = num;
    }

    public static final String FORCE_START      = "forceDownloads";
    public static final String AUTO_START       = "autoStart";
    /**
     *
     */
    private static final long  serialVersionUID = -3937346180905569896L;

    public static void confirmSelection(final SelectionInfo<CrawledPackage, CrawledLink> selection, final ConfirmLinksSettings settings) {
        final Thread thread = new Thread() {
            public void run() {
                OnOfflineLinksAction handleOfflineLoc = settings.getHandleOffline();
                OnDupesLinksAction handleDupesLoc = settings.getHandleDupes();
                boolean alreadyDisplayedOtherDialogToUser = false;
                final HashSet<CrawledLink> toDelete = new HashSet<CrawledLink>();
                final HashSet<CrawledLink> toKeepInLinkgrabber = new HashSet<CrawledLink>();
                final ExtractionExtension extractionExtension = ExtractionExtension.getInstance();
                ConfirmIncompleteArchiveAction doAction = CFG_GUI.CFG.getConfirmIncompleteArchiveAction();
                if (extractionExtension != null && !ConfirmIncompleteArchiveAction.MOVE_TO_DOWNLOADLIST.equals(doAction)) {
                    /* Collect incomplete archives */
                    try {
                        // this validation step also copies the passwords from the Crawledlinks in the archive settings
                        final ArchiveValidation result = ArchiveValidator.validate(selection, false);
                        for (final Archive a : result.getArchives()) {
                            ConfirmIncompleteArchiveAction doActionForTheCurrentArchive = doAction;
                            final DummyArchive da = extractionExtension.createDummyArchive(a);
                            if (da.isComplete()) {
                                continue;
                            }
                            if (doAction == ConfirmIncompleteArchiveAction.ASK) {
                                final ConfirmIncompleteArchiveAction[] options = new ConfirmIncompleteArchiveAction[] { ConfirmIncompleteArchiveAction.DELETE, ConfirmIncompleteArchiveAction.KEEP_IN_LINKGRABBER, ConfirmIncompleteArchiveAction.MOVE_TO_DOWNLOADLIST };
                                int def = 0;
                                final ConfirmIncompleteArchiveAction s = CFG_LINKGRABBER.CFG.getHandleIncompleteArchiveOnConfirmLatestSelection();
                                for (int i = 0; i < options.length; i++) {
                                    if (s == options[i]) {
                                        def = i;
                                        break;
                                    }
                                }
                                final ComboBoxDialog guiDialog = new ComboBoxDialog(Dialog.STYLE_SHOW_DO_NOT_DISPLAY_AGAIN, _GUI.T.ConfirmAction_run_incomplete_archive_title_(a.getName()), _GUI.T.ConfirmAction_run_incomplete_archive_msg(), options, def, new AbstractIcon(IconKey.ICON_STOP, 32), _GUI.T.lit_continue(), null, null) {
                                    public String getDontShowAgainKey() {
                                        return null;
                                    };

                                    protected MigPanel createBottomPanel() {
                                        return new MigPanel("ins 0", "[]20[grow,fill][]", "[]");
                                    }

                                    @Override
                                    protected DefaultButtonPanel createBottomButtonPanel() {
                                        DefaultButtonPanel ret = new DefaultButtonPanel("ins 0", "[][][]", "0[]0");
                                        ret.add(new JButton(new AppAction() {
                                            {
                                                setName(_GUI.T.ConfirmAction_run_incomplete_archive_details());
                                            }

                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                try {
                                                    Dialog.getInstance().showDialog(new DummyArchiveDialog(da));
                                                } catch (DialogClosedException e1) {
                                                    e1.printStackTrace();
                                                } catch (DialogCanceledException e1) {
                                                    e1.printStackTrace();
                                                }
                                            }
                                        }), "");
                                        return ret;
                                    }

                                    @Override
                                    protected String getDontShowAgainLabelText() {
                                        return _GUI.T.ConfirmLinksContextAction_getDontShowAgainLabelText_object_();
                                    }

                                    protected ListCellRenderer getRenderer(final ListCellRenderer orgRenderer) {
                                        return new ListCellRenderer() {
                                            @Override
                                            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                                                if (value == null) {
                                                    return orgRenderer.getListCellRendererComponent(list, _GUI.T.AddActionAction_getListCellRendererComponent_no_action_(), index, isSelected, cellHasFocus);
                                                }
                                                switch (((ConfirmIncompleteArchiveAction) value)) {
                                                // case EXCLUDE_OFFLINE:
                                                // return orgRenderer.getListCellRendererComponent(list,
                                                // _GUI.T.ConfirmLinksContextAction_getListCellRendererComponent_EXCLUDE_OFFLINE(),
                                                // index, isSelected, cellHasFocus);
                                                //
                                                // case EXCLUDE_OFFLINE_AND_REMOVE:
                                                // return orgRenderer.getListCellRendererComponent(list,
                                                // _GUI.T.ConfirmLinksContextAction_getListCellRendererComponent_EXCLUDE_OFFLINE_AND_REMOVE(),
                                                // index, isSelected, cellHasFocus);
                                                //
                                                // case INCLUDE_OFFLINE:
                                                // return orgRenderer.getListCellRendererComponent(list,
                                                // _GUI.T.ConfirmLinksContextAction_getListCellRendererComponent_INCLUDE_OFFLINE(),
                                                // index, isSelected, cellHasFocus);
                                                }
                                                JLabel ret = (JLabel) orgRenderer.getListCellRendererComponent(list, ((ConfirmIncompleteArchiveAction) value).getLabel(), index, isSelected, cellHasFocus);
                                                return ret;
                                            }
                                        };
                                    }
                                };
                                final ComboBoxDialogInterface response = UIOManager.I().show(ComboBoxDialogInterface.class, guiDialog);
                                response.throwCloseExceptions();
                                doActionForTheCurrentArchive = options[response.getSelectedIndex()];
                                CFG_LINKGRABBER.CFG.setHandleIncompleteArchiveOnConfirmLatestSelection(doActionForTheCurrentArchive);
                                if (response.isDontShowAgainSelected()) {
                                    /* Do not display dialog for subsequent items in current loop. */
                                    doAction = doActionForTheCurrentArchive;
                                }
                                alreadyDisplayedOtherDialogToUser = true;
                            }
                            switch (doActionForTheCurrentArchive) {
                            case DELETE:
                                for (ArchiveFile af : a.getArchiveFiles()) {
                                    if (af instanceof CrawledLinkArchiveFile) {
                                        toDelete.addAll(((CrawledLinkArchiveFile) af).getLinks());
                                    }
                                }
                                break;
                            case KEEP_IN_LINKGRABBER:
                                for (ArchiveFile af : a.getArchiveFiles()) {
                                    if (af instanceof CrawledLinkArchiveFile) {
                                        toKeepInLinkgrabber.addAll(((CrawledLinkArchiveFile) af).getLinks());
                                    }
                                }
                                break;
                            case MOVE_TO_DOWNLOADLIST:
                                // do nothing
                                break;
                            default:
                                break;
                            }
                        }
                    } catch (final DialogNoAnswerException e) {
                        /* User did not react -> Do nothing */
                        return;
                    } catch (final Throwable ignore) {
                        org.appwork.utils.logging2.extmanager.LoggerFactory.getDefaultLogger().log(ignore);
                    }
                }
                if (handleOfflineLoc != OnOfflineLinksAction.INCLUDE_OFFLINE) {
                    /* Collect- and handle offline items */
                    final ArrayList<CrawledLink> offline = new ArrayList<CrawledLink>();
                    for (final CrawledLink cl : selection.getChildren()) {
                        if (toKeepInLinkgrabber.contains(cl)) {
                            /* Item has already been processed. */
                            continue;
                        } else if (toDelete.contains(cl)) {
                            /* Item has already been processed. */
                            continue;
                        } else if (!cl.getDownloadLink().isAvailabilityStatusChecked() || cl.getDownloadLink().isAvailable()) {
                            /* Item has not been checked or item is online -> We are only collecting offline items here. */
                            continue;
                        }
                        offline.add(cl);
                        if (handleOfflineLoc == OnOfflineLinksAction.ASK) {
                            final OnOfflineLinksAction[] options = new OnOfflineLinksAction[] { OnOfflineLinksAction.INCLUDE_OFFLINE, OnOfflineLinksAction.EXCLUDE_OFFLINE, OnOfflineLinksAction.EXCLUDE_OFFLINE_AND_REMOVE };
                            final ComboBoxDialog combo = new ComboBoxDialog(0, _GUI.T.ConfirmLinksContextAction_run_offline_ask_title(), _GUI.T.ConfirmLinksContextAction_run_offline_ask_question(), options, 1, null, null, null, null) {
                                protected javax.swing.JComboBox getComboBox(Object[] options2) {
                                    OnOfflineLinksAction s = CFG_LINKGRABBER.CFG.getHandleOfflineOnConfirmLatestSelection();
                                    JComboBox ret = super.getComboBox(options2);
                                    if (s != null) {
                                        ret.setSelectedItem(s);
                                    }
                                    return ret;
                                };

                                protected ListCellRenderer getRenderer(final ListCellRenderer orgRenderer) {
                                    return new ListCellRenderer() {
                                        @Override
                                        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                                            if (value == null) {
                                                return orgRenderer.getListCellRendererComponent(list, _GUI.T.AddActionAction_getListCellRendererComponent_no_action_(), index, isSelected, cellHasFocus);
                                            }
                                            switch (((OnOfflineLinksAction) value)) {
                                            case EXCLUDE_OFFLINE:
                                                return orgRenderer.getListCellRendererComponent(list, _GUI.T.ConfirmLinksContextAction_getListCellRendererComponent_EXCLUDE_OFFLINE(), index, isSelected, cellHasFocus);
                                            case EXCLUDE_OFFLINE_AND_REMOVE:
                                                return orgRenderer.getListCellRendererComponent(list, _GUI.T.ConfirmLinksContextAction_getListCellRendererComponent_EXCLUDE_OFFLINE_AND_REMOVE(), index, isSelected, cellHasFocus);
                                            case INCLUDE_OFFLINE:
                                                return orgRenderer.getListCellRendererComponent(list, _GUI.T.ConfirmLinksContextAction_getListCellRendererComponent_INCLUDE_OFFLINE(), index, isSelected, cellHasFocus);
                                            }
                                            JLabel ret = (JLabel) orgRenderer.getListCellRendererComponent(list, ((OnOfflineLinksAction) value).getLabel(), index, isSelected, cellHasFocus);
                                            return ret;
                                        }
                                    };
                                }
                            };
                            final ComboBoxDialogInterface result = UIOManager.I().show(ComboBoxDialogInterface.class, combo);
                            try {
                                result.throwCloseExceptions();
                            } catch (final Exception e) {
                                return;
                            }
                            handleOfflineLoc = options[result.getSelectedIndex()];
                            /* Store last user selected option. */
                            CFG_LINKGRABBER.CFG.setHandleOfflineOnConfirmLatestSelection(handleOfflineLoc);
                            alreadyDisplayedOtherDialogToUser = true;
                        }
                        switch (handleOfflineLoc) {
                        case EXCLUDE_OFFLINE:
                            toKeepInLinkgrabber.add(cl);
                            break;
                        case EXCLUDE_OFFLINE_AND_REMOVE:
                            toDelete.add(cl);
                            break;
                        }
                    }
                }
                if (handleDupesLoc != OnDupesLinksAction.INCLUDE) {
                    /* Collect- and handle items which are already in downloadlist. */
                    final ArrayList<CrawledLink> dupes = new ArrayList<CrawledLink>();
                    for (final CrawledLink cl : selection.getChildren()) {
                        final String id = cl.getLinkID();
                        if (toKeepInLinkgrabber.contains(cl)) {
                            /* Item has already been processed and shall be kept in linkgrabber */
                            continue;
                        } else if (toDelete.contains(cl)) {
                            /* Item has already been processed and shall be deleted. */
                            continue;
                        } else if (!DownloadController.getInstance().hasDownloadLinkByID(id)) {
                            /* Item is not a dupe -> Not relevant for us here */
                            continue;
                        }
                        dupes.add(cl);
                        if (handleDupesLoc == OnDupesLinksAction.ASK) {
                            final OnDupesLinksAction[] options = new OnDupesLinksAction[] { OnDupesLinksAction.INCLUDE, OnDupesLinksAction.EXCLUDE, OnDupesLinksAction.EXCLUDE_AND_REMOVE };
                            final ComboBoxDialog combo = new ComboBoxDialog(0, _GUI.T.ConfirmLinksContextAction_run_dupes_ask_title(), _GUI.T.ConfirmLinksContextAction_run_dupes_ask_question(), options, 0, null, null, null, null) {
                                protected javax.swing.JComboBox getComboBox(Object[] options2) {
                                    OnDupesLinksAction s = CFG_LINKGRABBER.CFG.getHandleDupesOnConfirmLatestSelection();
                                    JComboBox ret = super.getComboBox(options2);
                                    if (s != null) {
                                        ret.setSelectedItem(s);
                                    }
                                    return ret;
                                };

                                protected ListCellRenderer getRenderer(final ListCellRenderer orgRenderer) {
                                    return new ListCellRenderer() {
                                        @Override
                                        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                                            if (value == null) {
                                                return orgRenderer.getListCellRendererComponent(list, _GUI.T.AddActionAction_getListCellRendererComponent_no_action_(), index, isSelected, cellHasFocus);
                                            }
                                            switch (((OnDupesLinksAction) value)) {
                                            case EXCLUDE:
                                                return orgRenderer.getListCellRendererComponent(list, _GUI.T.ConfirmLinksContextAction_getListCellRendererComponent_EXCLUDE_DUPES(), index, isSelected, cellHasFocus);
                                            case EXCLUDE_AND_REMOVE:
                                                return orgRenderer.getListCellRendererComponent(list, _GUI.T.ConfirmLinksContextAction_getListCellRendererComponent_EXCLUDE_DUPES_AND_REMOVE(), index, isSelected, cellHasFocus);
                                            case INCLUDE:
                                                return orgRenderer.getListCellRendererComponent(list, _GUI.T.ConfirmLinksContextAction_getListCellRendererComponent_INCLUDE_DUPES(), index, isSelected, cellHasFocus);
                                            }
                                            JLabel ret = (JLabel) orgRenderer.getListCellRendererComponent(list, ((OnDupesLinksAction) value).getLabel(), index, isSelected, cellHasFocus);
                                            return ret;
                                        }
                                    };
                                }
                            };
                            final ComboBoxDialogInterface result = UIOManager.I().show(ComboBoxDialogInterface.class, combo);
                            try {
                                result.throwCloseExceptions();
                            } catch (Exception e) {
                                return;
                            }
                            handleDupesLoc = options[result.getSelectedIndex()];
                            CFG_LINKGRABBER.CFG.setHandleDupesOnConfirmLatestSelection(handleDupesLoc);
                            alreadyDisplayedOtherDialogToUser = true;
                        }
                        /* Evaluate user preferred action */
                        switch (handleDupesLoc) {
                        case EXCLUDE:
                            toKeepInLinkgrabber.add(cl);
                            break;
                        case EXCLUDE_AND_REMOVE:
                            toDelete.add(cl);
                            break;
                        }
                    }
                }
                final ArrayList<CrawledLink> toMove = new ArrayList<CrawledLink>();
                boolean createNewSelectionInfo = false;
                for (final CrawledLink cl : selection.getChildren()) {
                    if (toDelete.contains(cl)) {
                        createNewSelectionInfo = true;
                        continue;
                    } else if (toKeepInLinkgrabber.contains(cl)) {
                        createNewSelectionInfo = true;
                        continue;
                    } else {
                        toMove.add(cl);
                    }
                }
                if (toDelete.size() > 0) {
                    /* Delete items which user wants to be deleted. */
                    LinkCollector.getInstance().removeChildren(new ArrayList<CrawledLink>(toDelete));
                }
                if (toMove.size() == 0) {
                    /* No items to move left -> Do nothing */
                    return;
                }
                final SelectionInfo<CrawledPackage, CrawledLink> finalSelection;
                if (createNewSelectionInfo) {
                    finalSelection = new SelectionInfo<CrawledPackage, CrawledLink>(null, toMove);
                } else {
                    finalSelection = selection;
                }
                final int numberofPackages = selection.getPackageViews().size();
                final int numberofLinks = selection.getChildren().size();
                final ConfirmationDialogBehavior confirmationDialogBehavior = settings.getConfirmationDialogBehavior();
                if (((confirmationDialogBehavior == ConfirmationDialogBehavior.ENABLED_THRESHOLD_AUTO && !alreadyDisplayedOtherDialogToUser) || confirmationDialogBehavior == ConfirmationDialogBehavior.ENABLED_THRESHOLD_SIMPLE) && numberofPackages >= 1 && numberofLinks >= 1) {
                    /* Ask user if he really wants to move items to downloadlist. */
                    if (!UIOManager.I().showConfirmDialog(0, _GUI.T.literall_are_you_sure(), _GUI.T.ConfirmContextmenuAction_confirmation_dialog_text(numberofPackages, numberofLinks), new AbstractIcon(IconKey.ICON_QUESTION, 32), _GUI.T.literally_yes(), _GUI.T.literall_no())) {
                        /* Canceled by user */
                        return;
                    }
                }
                LinkCollector.getInstance().moveLinksToDownloadList(finalSelection, settings);
                if (Boolean.TRUE.equals(settings.isSwitchToDownloadlistOnConfirm())) {
                    switchToDownloadTab();
                }
                if (Boolean.TRUE.equals(settings.isClearLinkgrabberlistOnConfirm())) {
                    clearLinkgrabber();
                }
            }
        };
        thread.setDaemon(true);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.setName(ConfirmLinksContextAction.class.getName());
        thread.start();
    }

    protected static void switchToDownloadTab() {
        if (!Application.isHeadless()) {
            new EDTRunner() {
                @Override
                protected void runInEDT() {
                    JDGui.getInstance().requestPanel(JDGui.Panels.DOWNLOADLIST);
                }
            };
        }
    }

    protected static void clearLinkgrabber() {
        LinkCollector.getInstance().getQueue().add(new QueueAction<Void, RuntimeException>() {
            @Override
            protected Void run() throws RuntimeException {
                if (!Application.isHeadless()) {
                    new EDTRunner() {
                        @Override
                        protected void runInEDT() {
                            LinkgrabberSearchField.getInstance().setText("");
                            LinkgrabberSearchField.getInstance().onChanged();
                        }
                    };
                }
                LinkCollector.getInstance().clear();
                return null;
            }
        });
    }

    public static String getTranslationForHandleOffline() {
        return _JDT.T.ConfirmLinksContextAction_getTranslationForHandleOffline();
    }

    @Customizer(link = "#getTranslationForHandleOffline")
    @Order(10)
    public OnOfflineLinksAction getHandleOffline() {
        return handleOffline;
    }

    public ConfirmLinksContextAction setHandleOffline(OnOfflineLinksAction handleOffline) {
        if (handleOffline == null) {
            handleOffline = OnOfflineLinksAction.GLOBAL;
        }
        this.handleOffline = handleOffline;
        return this;
    }

    public static String getTranslationForHandleDupes() {
        return _JDT.T.ConfirmLinksContextAction_getTranslationForHandleDupes();
    }

    @Customizer(link = "#getTranslationForHandleDupes")
    @Order(11)
    public OnDupesLinksAction getHandleDupes() {
        return handleDupes;
    }

    public ConfirmLinksContextAction setHandleDupes(OnDupesLinksAction handleDupes) {
        if (handleDupes == null) {
            handleDupes = OnDupesLinksAction.GLOBAL;
        }
        this.handleDupes = handleDupes;
        return this;
    }

    public ConfirmLinksContextAction() {
        super(false, true);
        GUIEventSender.getInstance().addListener(this, true);
        metaCtrl = KeyObserver.getInstance().isMetaDown(true) || KeyObserver.getInstance().isControlDown(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (!isEnabled()) {
            return;
        }
        final ConfirmLinksSettings cls = new ConfirmLinksSettings(MoveLinksMode.MANUAL);
        cls.setAutoStartDownloads(doAutostart());
        cls.setClearLinkgrabberlistOnConfirm(isClearListAfterConfirm());
        if (isAssignPriorityEnabled()) {
            cls.setPriority(getPriority());
        }
        cls.setPackageExpandBehavior(this.getPackageExpandBehavior());
        cls.setForceDownloads(isForceDownloads());
        cls.setHandleOffline(getHandleOffline());
        cls.setHandleDupes(getHandleDupes());
        cls.setConfirmationDialogBehavior(this.getConfirmationDialogBehavior());
        cls.setConfirmationDialogThresholdMinPackages(getMinNumberofPackagesForMoveToDownloadlistConfirmDialog());
        cls.setConfirmationDialogThresholdMinLinks(getMinNumberofLinksForMoveToDownloadlistConfirmDialog());
        final SelectionInfo<CrawledPackage, CrawledLink> si;
        if (isSelectionOnly()) {
            si = getSelection();
        } else {
            si = getAllLinkgrabberItems();
        }
        confirmSelection(si, cls);
    }

    public SelectionInfo<CrawledPackage, CrawledLink> getAllLinkgrabberItems() {
        return LinkGrabberTable.getInstance().getSelectionInfo(false, true);
    }

    protected boolean doAutostart() {
        final boolean ret = autoStart != null && autoStart.isEnabled();
        if (metaCtrl && isCtrlToggle()) {
            return !ret;
        } else {
            return ret;
        }
    }

    @Order(300)
    public AutoStartOptions getAutoStart() {
        return autoStart;
    }

    @Override
    public void initContextDefaults() {
        setAutoStart(AutoStartOptions.AUTO);
    }

    public static String getTranslationForClearListAfterConfirm() {
        return _JDT.T.ConfirmLinksContextAction_getTranslationForClearListAfterConfirm();
    }

    @Customizer(link = "#getTranslationForClearListAfterConfirm")
    @Order(200)
    public boolean isClearListAfterConfirm() {
        return clearListAfterConfirm;
    }

    @Override
    public void onGuiMainTabSwitch(View oldView, View newView) {
    }

    @Override
    public void onKeyModifier(int parameter) {
        if (KeyObserver.getInstance().isControlDown(false) || KeyObserver.getInstance().isMetaDown(false)) {
            metaCtrl = true;
        } else {
            metaCtrl = false;
        }
        updateLabelAndIcon();
    }

    @Override
    protected SelectionInfo<CrawledPackage, CrawledLink> getSelection() {
        if (!isSelectionOnly()) {
            return LinkGrabberTable.getInstance().getSelectionInfo(false, true);
        } else {
            return LinkGrabberTable.getInstance().getSelectionInfo(true, true);
        }
    }

    @Override
    public void requestUpdate(Object requestor) {
        super.requestUpdate(requestor);
        onKeyModifier(-1);
        updateLabelAndIcon();
    }

    public static String getTranslationForAutoStart() {
        return _JDT.T.ConfirmLinksContextAction_getTranslationForAutoStart();
    }

    @Customizer(link = "#getTranslationForAutoStart")
    public ConfirmLinksContextAction setAutoStart(AutoStartOptions autoStart) {
        if (autoStart == null) {
            autoStart = AutoStartOptions.AUTO;
        }
        this.autoStart = autoStart;
        updateLabelAndIcon();
        return this;
    }

    public void setClearListAfterConfirm(boolean clearListAfterConfirm) {
        this.clearListAfterConfirm = clearListAfterConfirm;
    }

    private boolean selectionOnly = true;

    public static String getTranslationForSelectionOnly() {
        return _JDT.T.ConfirmLinksContextAction_getTranslationForSelectionOnly();
    }

    @Customizer(link = "#getTranslationForSelectionOnly")
    @Order(1)
    public boolean isSelectionOnly() {
        return selectionOnly;
    }

    public void setSelectionOnly(boolean selectionOnly) {
        this.selectionOnly = selectionOnly;
        updateLabelAndIcon();
    }

    protected void updateLabelAndIcon() {
        if (isForceDownloads()) {
            if (isSelectionOnly()) {
                setName(getTextForForcedSelectionOnly());
            } else {
                setName(getTextForForcedAll());
            }
            final Image add = NewTheme.I().getImage("media-playback-start", 20);
            final Image play = NewTheme.I().getImage("prio_3", 14);
            setSmallIcon(new ImageIcon(ImageProvider.merge(add, play, -4, 0, 6, 10)));
            setIconKey(null);
        } else if (doAutostart()) {
            if (isSelectionOnly()) {
                setName(getTextForAutoStartSelectionOnly());
            } else {
                setName(getTextForAutoStartAll());
            }
            final Image add = NewTheme.I().getImage("media-playback-start", 16);
            final Image play = NewTheme.I().getImage("add", 14);
            setSmallIcon(new ImageIcon(ImageProvider.merge(add, play, 0, 0, 6, 6)));
            setIconKey(null);
        } else {
            if (isSelectionOnly()) {
                setName(getTextForNoAutoStartSelectionOnly());
            } else {
                setName(getTextForNoAutoStartAll());
            }
            setSmallIcon(NewTheme.I().getIcon(IconKey.ICON_GO_NEXT, 20));
        }
    }

    /**
     * @return
     */
    protected String getTextForForcedAll() {
        return _GUI.T.ConfirmAllContextmenuAction_context_add_and_force();
    }

    /**
     * @return
     */
    protected String getTextForForcedSelectionOnly() {
        return _GUI.T.ConfirmAction_ConfirmAction_context_add_and_force();
    }

    /**
     * @return
     */
    protected String getTextForNoAutoStartAll() {
        return _GUI.T.ConfirmAllContextmenuAction_context_add();
    }

    /**
     * @return
     */
    protected String getTextForNoAutoStartSelectionOnly() {
        return _GUI.T.ConfirmAction_ConfirmAction_context_add();
    }

    /**
     * @return
     */
    protected String getTextForAutoStartAll() {
        return _GUI.T.ConfirmAllContextmenuAction_context_add_and_start();
    }

    /**
     * @return
     */
    protected String getTextForAutoStartSelectionOnly() {
        return _GUI.T.ConfirmAction_ConfirmAction_context_add_and_start();
    }

    @Override
    public boolean isEnabled() {
        final SelectionInfo<CrawledPackage, CrawledLink> allItems;
        if (this.isSelectionOnly() && !this.hasSelection()) {
            /* Only selected items but none are selected */
            return false;
        } else if ((allItems = getAllLinkgrabberItems()) == null || allItems.isEmpty()) {
            /* All items but no items are in linkgrabber */
            return false;
        } else {
            return super.isEnabled();
        }
    }
}
