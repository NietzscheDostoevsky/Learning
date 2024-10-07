//    jDownloader - Downloadmanager
//    Copyright (C) 2008  JD-Team support@jdownloader.org
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
package jd.plugins;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Icon;

import jd.controlling.linkcollector.LinkOriginDetails;
import jd.controlling.linkcrawler.CrawledLink;
import jd.nutils.Formatter;

import org.appwork.exceptions.WTFException;
import org.appwork.storage.config.JsonConfig;
import org.appwork.uio.CloseReason;
import org.appwork.uio.ConfirmDialogInterface;
import org.appwork.uio.UIOManager;
import org.appwork.utils.Application;
import org.appwork.utils.DebugMode;
import org.appwork.utils.Files;
import org.appwork.utils.Regex;
import org.appwork.utils.logging2.LogInterface;
import org.appwork.utils.swing.dialog.ConfirmDialog;
import org.jdownloader.controlling.FileCreationManager;
import org.jdownloader.gui.IconKey;
import org.jdownloader.gui.notify.AbstractBubbleSupport;
import org.jdownloader.gui.notify.BasicNotify;
import org.jdownloader.gui.notify.BubbleNotify.AbstractNotifyWindowFactory;
import org.jdownloader.gui.notify.Element;
import org.jdownloader.gui.notify.gui.AbstractNotifyWindow;
import org.jdownloader.gui.notify.gui.CFG_BUBBLE;
import org.jdownloader.gui.translate._GUI;
import org.jdownloader.images.AbstractIcon;
import org.jdownloader.logging.LogController;
import org.jdownloader.plugins.components.containers.ContainerConfig;
import org.jdownloader.plugins.components.containers.ContainerConfig.ContainerDeleteOption;
import org.jdownloader.plugins.config.AccountConfigInterface;
import org.jdownloader.plugins.config.PluginConfigInterface;
import org.jdownloader.plugins.config.PluginHost;
import org.jdownloader.translate._JDT;
import org.jdownloader.utils.JDFileUtils;

/**
 * Dies ist die Oberklasse für alle Plugins, die Containerdateien nutzen können
 *
 * @author astaldo/JD-Team
 */
public abstract class PluginsC {
    /*
     * 2024-03-06: TODO: Add translation strings for BubbleNotifications once it is clear that these notifications will stay in here as they
     * are.
     */
    private final Pattern  pattern;
    private final String   name;
    private final long     version;
    protected LogInterface logger = LogController.TRASH;

    public LogInterface getLogger() {
        return logger;
    }

    public void setLogger(LogInterface logger) {
        if (logger == null) {
            logger = LogController.TRASH;
        }
        this.logger = logger;
    }

    private static final PluginsCBubbleSupport INSTANCE = new PluginsCBubbleSupport();

    public static PluginsCBubbleSupport getBubbleSupportInstance() {
        return INSTANCE;
    }

    public static class PluginsCBubbleSupport extends AbstractBubbleSupport {

        private PluginsCBubbleSupport() {
            super(_GUI.T.plugins_optional_JDLightTray_ballon_container(), CFG_BUBBLE.BUBBLE_NOTIFY_CONTAINER_LOADED_ENABLED);
        }

        @Override
        public List<Element> getElements() {
            return null;
        }

        protected void show(final AbstractNotifyWindowFactory factory) {
            super.show(factory);
        }

    }

    public PluginsC(String name, String pattern, String rev) {
        this.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        this.matcher = this.pattern.matcher("");
        this.name = name;
        long version = -1;
        try {
            version = Formatter.getRevision(rev);
        } catch (Throwable e) {
            logger.log(e);
            version = -1;
        }
        this.version = version;
    }

    public abstract PluginsC newPluginInstance();

    protected ArrayList<CrawledLink> cls = new ArrayList<CrawledLink>();
    protected String                 md5;
    protected byte[]                 k;
    private final Matcher            matcher;

    public abstract ContainerStatus callDecryption(File file) throws Exception;

    // @Override
    public synchronized boolean canHandle(final String data) {
        if (data != null) {
            synchronized (matcher) {
                try {
                    return matcher.reset(data).find();
                } finally {
                    matcher.reset("");
                }
            }
        }
        return false;
    }

    public String createContainerString(ArrayList<DownloadLink> downloadLinks) {
        return null;
    }

    public Pattern getSupportedLinks() {
        return pattern;
    }

    public String getName() {
        return name;
    }

    public long getVersion() {
        return version;
    }

    /* hide links by default */
    public boolean hideLinks() {
        return true;
    }

    public abstract String[] encrypt(String plain);

    /**
     * Liefert alle in der Containerdatei enthaltenen Dateien als DownloadLinks zurück.
     *
     * @param filename
     *            Die Containerdatei
     * @return Ein ArrayList mit DownloadLinks
     */
    public ArrayList<CrawledLink> getContainedDownloadlinks() {
        final ArrayList<CrawledLink> ret = cls;
        return ret == null ? new ArrayList<CrawledLink>() : ret;
    }

    public synchronized void initContainer(final CrawledLink source, final File file, final byte[] key) throws IOException {
        if (cls == null || cls.size() == 0) {
            logger.info("Init Container");
            if (key != null) {
                k = key;
            }
            try {
                final ContainerStatus cs = callDecryption(file);
                if (cs == null) {
                    logger.warning("WTF ContainerStatus null was returned");
                }
                if (cs.isStatus(ContainerStatus.STATUS_FAILED)) {
                    this.displayBubbleNotification("Invalid container", "Processing the following container failed for unknown reasons:\n" + file.getAbsolutePath(), new AbstractIcon(IconKey.ICON_ADDCONTAINER, 32));
                } else if (cs.isStatus(ContainerStatus.STATUS_INVALID_PASSWORD)) {
                    this.displayBubbleNotification("Invalid container password", "Processing the following container failed because the supplied passwords were incorrect:\n" + file.getAbsolutePath(), new AbstractIcon(IconKey.ICON_ADDCONTAINER, 32));
                } else if (cs.isStatus(ContainerStatus.STATUS_FINISHED)) {
                    if (getContainedDownloadlinks().size() > 0) {
                        this.displayBubbleNotification("Successfully crawled container", "The following container has been processed successfully:\n" + file.getAbsolutePath(), new AbstractIcon(IconKey.ICON_ADDCONTAINER, 32));
                    }
                    deleteContainer(source, file);
                }
            } catch (Throwable e) {
                logger.log(e);
            }
        }
    }

    protected ContainerDeleteOption getDeleteOption(final CrawledLink source, final File file) throws Exception {
        if (isCrawledContainer(source, file)) {
            logger.fine("Do not ask - just delete crawled container: " + getDebugString(source, file));
            return ContainerDeleteOption.DELETE;
        } else if (isTempContainer(source, file)) {
            logger.fine("Do not ask - just delete temp container: " + getDebugString(source, file));
            return ContainerDeleteOption.DELETE;
        } else if (getContainedDownloadlinks().size() == 0) {
            return ContainerDeleteOption.DONT_DELETE;
        }
        ContainerDeleteOption ret = JsonConfig.create(ContainerConfig.class).getDeleteContainerFilesAfterAddingThemAction();
        if (ContainerDeleteOption.ASK_FOR_DELETE.equals(ret)) {
            final ConfirmDialog dialog = new ConfirmDialog(0, _JDT.T.AddContainerAction_delete_container_title(), _JDT.T.AddContainerAction_delete_container_msg(file.toString()), new AbstractIcon(IconKey.ICON_HELP, 32), _GUI.T.lit_yes(), _GUI.T.lit_no()) {
                @Override
                public String getDontShowAgainKey() {
                    return null;
                }
            };
            final ConfirmDialogInterface s = UIOManager.I().show(ConfirmDialogInterface.class, dialog);
            s.throwCloseExceptions();
            if (s.getCloseReason() == CloseReason.OK) {
                ret = ContainerDeleteOption.DELETE;
            } else {
                ret = ContainerDeleteOption.DONT_DELETE;
            }
            if (s.isDontShowAgainSelected()) {
                JsonConfig.create(ContainerConfig.class).setDeleteContainerFilesAfterAddingThemAction(ret);
            }
        }
        return ret;
    }

    protected boolean isCrawledContainer(CrawledLink source, File file) throws URISyntaxException {
        final File originFile = from(source.getOriginLink());
        if (originFile == null) {
            // origin is no file
            return true;
        }
        final File sourceFile = from(source);
        if (sourceFile != null && !originFile.equals(sourceFile)) {
            // origin is a different file
            return true;
        }
        return false;
    }

    protected boolean isTempContainer(final CrawledLink source, final File file) {
        final File tmp = Application.getTempResource("");
        final String rel = Files.getRelativePath(tmp, file);
        return rel != null;
    }

    protected void deleteContainer(final CrawledLink source, final File file) throws Exception {
        switch (getDeleteOption(source, file)) {
        case DELETE:
            FileCreationManager.getInstance().delete(file, null);
            this.displayBubbleNotification("Deleted container file", "The following container file has been deleted:\n" + file.getName(), new AbstractIcon(IconKey.ICON_ADDCONTAINER, 32));
            break;
        case RECYCLE:
            try {
                JDFileUtils.moveToTrash(file);
                this.displayBubbleNotification("Moved container file to trash", "The following processed container file has been moved to trash:\n" + file.getName(), new AbstractIcon(IconKey.ICON_ADDCONTAINER, 32));
            } catch (IOException e) {
                logger.log(e);
                logger.info("Could not move file to recycle bin: " + file);
                this.displayBubbleNotification("Failed to move processed container file to trash", "Failed to move the following processed container file to trash:\n" + file.getName(), new AbstractIcon(IconKey.ICON_ADDCONTAINER, 32));
            }
            break;
        case ASK_FOR_DELETE:
            throw new WTFException("How did this happen!?");
        case DONT_DELETE:
            break;
        }
    }

    protected String getDebugString(final CrawledLink link, File file) {
        final StringBuilder sb = new StringBuilder();
        sb.append(file);
        sb.append("|");
        sb.append(link.getURL());
        final CrawledLink originLink = link.getOriginLink();
        if (originLink != link) {
            sb.append("|");
            sb.append(originLink.getURL());
        }
        final LinkOriginDetails originDetails = link.getOrigin();
        if (originDetails != null) {
            sb.append("|");
            sb.append(originDetails.getOrigin());
        }
        return sb.toString();
    }

    private CrawledLink currentLink = null;

    public CrawledLink getCurrentLink() {
        return currentLink;
    }

    public void setCurrentLink(CrawledLink currentLink) {
        this.currentLink = currentLink;
    }

    public Class<? extends PluginConfigInterface> getConfigInterface() {
        for (final Class<?> cls : getClass().getClasses()) {
            if (PluginConfigInterface.class.isAssignableFrom(cls) && !AccountConfigInterface.class.isAssignableFrom(cls)) {
                final PluginHost anno = cls.getAnnotation(PluginHost.class);
                if (anno != null) {
                    if (DebugMode.TRUE_IN_IDE_ELSE_FALSE) {
                        final org.jdownloader.plugins.config.Type pluginType = org.jdownloader.plugins.config.Type.CONTAINER;
                        if (pluginType != null && pluginType != anno.type()) {
                            LogController.CL(true).log(new Exception("Please check:" + cls + "|type missmatch:" + anno.type() + "!=" + pluginType));
                        }
                    }
                    return (Class<? extends PluginConfigInterface>) cls;
                } else {
                    return (Class<? extends PluginConfigInterface>) cls;
                }
            }
        }
        return null;
    }

    protected File from(final CrawledLink source) throws URISyntaxException {
        // workaround for authorities in file uris
        // TODO: proper uri to file
        final String sourceURL = new Regex(source.getURL(), "(file:/.+)").getMatch(0);
        if (sourceURL == null) {
            return null;
        }
        final String currentURI = sourceURL.replaceFirst("file:///?", "file:///");
        final File ret = new File(new URI(currentURI));
        return ret;
    }

    public ArrayList<CrawledLink> decryptContainer(final CrawledLink source) {
        if (source.getURL() == null) {
            return null;
        }
        ArrayList<CrawledLink> retLinks = null;
        boolean showException = true;
        try {
            setCurrentLink(source);
            /* extract filename from url */
            final File file = from(source);
            if (file == null) {
                throw new Throwable("Invalid Container: " + source.getURL());
            } else if (file.isFile()) {
                initContainer(source, file, null);
                retLinks = getContainedDownloadlinks();
            }
        } catch (Throwable e) {
            /*
             * damn, something must have gone really really bad, lets keep the log
             */
            logger.log(e);
        } finally {
            setCurrentLink(null);
        }
        if (retLinks == null && showException) {
            /*
             * null as return value? something must have happened, do not clear log
             */
            logger.severe("ContainerPlugin out of date: " + this + " :" + getVersion());
        }
        return retLinks;
    }

    /**
     * Returns true if a user interaction in the form of a password-prompt can happen when processing this container. </br> Example: SFDL
     * containers.
     */
    protected boolean canBePasswordProtected() {
        return false;
    }

    protected void displayBubbleNotification(final String title, final String text) {
        displayBubbleNotification(title, text, new AbstractIcon(IconKey.ICON_INFO, 32));
    }

    protected void displayBubbleNotification(final String title, final String text, final Icon icon) {
        getBubbleSupportInstance().show(new AbstractNotifyWindowFactory() {
            @Override
            public AbstractNotifyWindow<?> buildAbstractNotifyWindow() {
                return new BasicNotify(title, text, icon);
            }
        });
    }
}