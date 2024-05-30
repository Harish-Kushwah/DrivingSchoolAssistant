package javaswingdev.form;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javaswingdev.swing.RoundPanel;
import javaswingdev.swing.scroll.ScrollBar;
import javaswingdev.swing.table.Table;
import javaswingdev.swing.table.TablePanel;
import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemFonts;
import javaswingdev.system.SystemStrings;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.dao.ApplicationDao;
import model.dao.LLApplicationDao;
import model.dao.UserDao;
import model.entity.LLApplication;
import model.entity.User;
import net.miginfocom.swing.MigLayout;
import pdf.FullName;
import raven.crazypanel.CrazyPanel;
import raven.toast.Notifications;
import util.swing.MyJTextField;
import util.swing.MyJScrollPane;
import util.swing.MySubtitle;
import util.swing.MyTitle;
import util.swing.MyTitlePanel;
import util.swing.button.MyResetButton;
import util.swing.button.MySubmitButton;

/**
 *
 * @author haris
 */
public class Form_SearchApplications extends TemplatePage {

    public Form_SearchApplications() {
        super("Search Applications");
 
        infoOutputPanel.add(getInfoLabel("If Application Available"), "al left,wrap 61,growx");
        outputPanel.add(infoOutputPanel, "growx , wrap , top,pushy");
       
    }

    public JLabel getInfoLabel(String label) {
        JLabel info = new JLabel(label);
        info.setForeground(SystemColor.PRIMARY);
        info.setFont(SystemFonts.INFO_FONT);

        return info;
    }
}
