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

import org.appwork.utils.formatter.SizeFormatter;

import jd.PluginWrapper;
import jd.controlling.ProgressController;
import jd.nutils.encoding.Encoding;
import jd.parser.Regex;
import jd.plugins.CryptedLink;
import jd.plugins.DecrypterPlugin;
import jd.plugins.DownloadLink;
import jd.plugins.FilePackage;
import jd.plugins.LinkStatus;
import jd.plugins.PluginException;
import jd.plugins.PluginForDecrypt;

@DecrypterPlugin(revision = "$Revision: 48678 $", interfaceVersion = 2, names = { "microsoft.com" }, urls = { "https?://(?:www\\.)?microsoft\\.com/(?:en\\-us|de\\-de)/download/(?:details|confirmation)\\.aspx\\?id=\\d+" })
public class MicrosoftComCrawler extends PluginForDecrypt {
    public MicrosoftComCrawler(PluginWrapper wrapper) {
        super(wrapper);
    }

    public ArrayList<DownloadLink> decryptIt(final CryptedLink param, ProgressController progress) throws Exception {
        final String dlid = new Regex(param.getCryptedUrl(), "(\\d+)$").getMatch(0);
        final String contentur = "https://www.microsoft.com/en-us/download/details.aspx?id=" + dlid;
        br.setFollowRedirects(true);
        br.getPage(contentur);
        if (br.getHttpConnection().getResponseCode() == 404) {
            throw new PluginException(LinkStatus.ERROR_FILE_NOT_FOUND);
        }
        br.getPage("https://www.microsoft.com/en-us/download/confirmation.aspx?id=" + dlid);
        String fpName = br.getRegex("<h2 class=\"title\">([^<>\"]*?)</h2>").getMatch(0);
        if (fpName == null) {
            fpName = "Microsoft.com download " + dlid;
        }
        final String dlTable = br.getRegex("<div class=\"chooseFile jsOff\">(.*?)</div>").getMatch(0);
        if (dlTable == null) {
            throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
        }
        final ArrayList<DownloadLink> ret = new ArrayList<DownloadLink>();
        final String[] entries = new Regex(dlTable, "<tr>(.*?)</tr>").getColumn(0);
        if (entries.length > 0) {
            for (final String dlentry : entries) {
                final String filename = new Regex(dlentry, "class=\"file\\-name\\-view1\">([^<>\"]*?)</span>").getMatch(0);
                final String filesize = new Regex(dlentry, "class=\"file\\-size\\-view1\">([^<>\"]*?)</span>").getMatch(0);
                final String dllink = new Regex(dlentry, "href=\"(https?://download\\.microsoft\\.com/download/[^<>\"]+)\"").getMatch(0);
                if (filename != null && filesize != null && dllink != null) {
                    final DownloadLink dl = createDownloadlink(dllink);
                    dl.setFinalFileName(Encoding.htmlDecode(filename.trim()));
                    dl.setDownloadSize(SizeFormatter.getSize(filesize));
                    dl.setAvailable(true);
                    ret.add(dl);
                }
            }
        } else {
            /* Probably single file */
            final String directurl = br.getRegex("href=\"(https?://download\\.microsoft\\.com/download/[^<>\"]+)\"").getMatch(0);
            final String filesize = br.getRegex("class=\"file-size\">([^<>\"]+)</td>").getMatch(0);
            if (directurl == null) {
                throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
            }
            final DownloadLink link = this.createDownloadlink(directurl);
            if (filesize != null) {
                link.setDownloadSize(SizeFormatter.getSize(filesize));
            }
            link.setAvailable(true);
            ret.add(link);
        }
        if (ret.size() == 0) {
            throw new PluginException(LinkStatus.ERROR_PLUGIN_DEFECT);
        }
        final FilePackage fp = FilePackage.getInstance();
        fp.setName(Encoding.htmlDecode(fpName).trim());
        fp.addLinks(ret);
        return ret;
    }
}
