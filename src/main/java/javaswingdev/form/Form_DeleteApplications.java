package javaswingdev.form;

import java.awt.Color;
import javaswingdev.swing.RoundPanel;
import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemFonts;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import util.swing.MyJTextField;
import util.swing.MyTitle;
import util.swing.button.MyDeleteButton;
import util.swing.button.MyResetButton;

/**
 *
 * @author haris
 */
public class Form_DeleteApplications extends TemplatePage {

    public Form_DeleteApplications() {
        super("Delete Record");

        infoOutputPanel.add(getInfoLabel("If Application Available"), "al left,wrap 17,growx");

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new MigLayout("fillx"));

        buttonPanel1.setBackground(Color.white);
        buttonPanel1.add(new MyResetButton("Clear"), "al right");
        buttonPanel1.add(new MyDeleteButton("Delete"), "wrap,al left");

        infoOutputPanel.add(buttonPanel1, "span,growx");
        outputPanel.add(infoOutputPanel, "growx , wrap , top,pushy");

    }

    public JLabel getInfoLabel(String label) {
        JLabel info = new JLabel(label);
        info.setForeground(SystemColor.PRIMARY);
        info.setFont(SystemFonts.INFO_FONT);

        return info;
    }

}
