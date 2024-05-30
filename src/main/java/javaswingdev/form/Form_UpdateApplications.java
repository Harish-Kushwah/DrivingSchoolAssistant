package javaswingdev.form;

import java.awt.Color;
import javaswingdev.swing.RoundPanel;
import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemFonts;
import javaswingdev.system.SystemStrings;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import util.swing.MyJTextField;
import util.swing.MyTitle;
import util.swing.button.MyResetButton;
import util.swing.button.MySubmitButton;

/**
 *
 * @author haris
 */
/**
 *
 * @author haris
 */
public class Form_UpdateApplications extends TemplatePage {

    public Form_UpdateApplications() {
        super("Upadate Record");

        infoOutputPanel.add(getInfoLabel("If Application Available"), "al left,wrap 17,growx");

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new MigLayout("fillx"));

        buttonPanel1.setBackground(Color.white);
        buttonPanel1.add(new MyResetButton("Clear"), "al right");
        buttonPanel1.add(new MySubmitButton("Update"), "al left,wrap");

        infoOutputPanel.add(buttonPanel1, "span,growx");
        this.outputPanel.add(infoOutputPanel, "growx , wrap , top,pushy");

    }

    public JLabel getInfoLabel(String label) {
        JLabel info = new JLabel(label);
        info.setForeground(SystemColor.PRIMARY);
        info.setFont(SystemFonts.INFO_FONT);

        return info;
    }

}
