package javaswingdev.form;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javaswingdev.swing.RoundPanel;
import javaswingdev.system.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import net.miginfocom.swing.MigLayout;
import raven.crazypanel.CrazyPanel;
import util.swing.MyJScrollPane;
import util.swing.MyJTextField;
import util.swing.MyTitlePanel;
import util.swing.button.MyResetButton;
import util.swing.button.MySubmitButton;

/**
 *
 * @author haris
 */
public class Form_NewApplication extends CrazyPanel {

    public Form_NewApplication() {

//        this.setRound(10);

        setLayout(new MigLayout("fillx , insets 15"));
        
        /* Header of the form with the gradient line below */  
        add(new MyTitlePanel("Add New Applications"), "spanx,wrap 25,growx ");

        
        RoundPanel panel = new RoundPanel();
        panel.setLayout(new MigLayout("fillx,inset 10","","[][]10[][]10[][]10[][]10"));
        panel.setBackground(Color.WHITE);
        panel.setRound(10);
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        addFormSeperator(panel,"Personal Details");

        panel.add(new JLabel("First Name"), "al right,growx");
        panel.add(new JLabel("Middle Name"), "al right,growx");
        panel.add(new JLabel("Last Name"), "al right,wrap,growx");
        
        panel.add(new MyJTextField("First Name"), "pushx,growx");
        panel.add(new MyJTextField("Middle Name"), "pushx,growx");
        panel.add(new MyJTextField("Last Name"), "wrap,pushx,growx");

        panel.add(new JLabel("Mobile No"), "al right,growx");
        panel.add(new JLabel("Email"), "al right,growx");
        panel.add(new JLabel("DOB"), "al right,wrap,growx");
        
        panel.add(new MyJTextField("Enter Mobile No"), "pushx,growx");
        panel.add(new MyJTextField("Enter Email "), "pushx,growx");
        panel.add(new MyJTextField("Enter DOB"), "wrap 15,pushx,growx");
        
        addFormSeperator(panel,"Application Details");
          
        panel.add(new JLabel("Application No"), "al right,growx");
        panel.add(new JLabel("COV"), "al right,growx");
        panel.add(new JLabel("Enrolment No."), "al right,wrap,growx");
        
        panel.add(new MyJTextField("Enter Application No"), "pushx,growx");
        panel.add(new JComboBox(new String[]{"LMV", "LMV-Tr", "Trans", "3W-GV"}), "pushx,growx");
        panel.add(new MyJTextField("Enter Enrolment No."), "wrap,pushx,growx");
        
        panel.add(new JLabel("Application Status"), "al right,growx");
        panel.add(new JLabel("Application Date"), "al right,growx");
        panel.add(new JLabel(""), "al right,wrap,growx");
        
        
        panel.add(new JComboBox(new String[]{"Pending", "Completed", "Enrolled", "Not Enrolled"}), "pushx,growx");
        panel.add(new MyJTextField("11/11/2024"), "pushx,growx");
        panel.add(new JLabel(""), "wrap 15,pushx,growx");
        
        addFormSeperator(panel,"Payment Details");
        panel.add(new JLabel("Total Decided"), "al right,growx");
        panel.add(new JLabel("Total Pending"), "al right,growx");
        panel.add(new JLabel("Payement Status"), "al right,wrap,growx");
        
        panel.add(new MyJTextField("Rs.9999"), "pushx,growx");
        panel.add(new MyJTextField("Rs.9999"), "pushx,growx");
        panel.add(new JComboBox(new String[]{"Pending", "Completed"}), "wrap 20,pushx,growx");

        


      
        panel.add(new JLabel(""));
        panel.add(new MyResetButton("Clear"), "split 2 , al center");
        panel.add(new MySubmitButton("Submit"), "wrap 50");
        
        add(new MyJScrollPane(panel),"growx");
        
    }


    private JSeparator createJSeparator() {
        JSeparator sp = new JSeparator();
        sp.setForeground(Color.white);
//        sp.setForeground(SystemColor.MAIN_COLOR_2);
        sp.setPreferredSize(new Dimension(1, 5));
        return sp;
    }

    private void addFormSeperator(String label) {
        Font f = new Font("Sans-Serif", Font.TRUETYPE_FONT, 15);
        Font f1 = new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 15);

        JLabel subTitle = new JLabel(label);
        subTitle.setFont(f1);
        subTitle.setForeground(SystemColor.MAIN_COLOR_2);

        add(createJSeparator(), "pushx,growx");
        add(subTitle, "al center");
        add(createJSeparator(), "span,wrap 10 ,pushx,growx");
    }
    private void addFormSeperator(JPanel panel,String label) {
        Font f = new Font("Sans-Serif", Font.TRUETYPE_FONT, 15);
        Font f1 = new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 15);

        JLabel subTitle = new JLabel(label);
        subTitle.setFont(f1);
        subTitle.setForeground(SystemColor.MAIN_COLOR_2);

        panel.add(createJSeparator(), "pushx,growx");
        panel.add(subTitle, "al center");
        panel.add(createJSeparator(), "span,wrap 10 ,pushx,growx");
    }
}
