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
        
        RoundPanel infoOutputPanel = new RoundPanel();
        infoOutputPanel.setLayout(new MigLayout("fill"));
        infoOutputPanel.setRound(10);
        infoOutputPanel.setBackground(Color.white);
        
        infoOutputPanel.add(new MyTitle("Application Details"),"al center,span,wrap 30,growx");
        infoOutputPanel.add(new JLabel("First Name"),"al left,growx");
        infoOutputPanel.add(new JLabel("Middle Name"),"al left,growx");
        infoOutputPanel.add(new JLabel("Last Name"),"wrap,al left,growx");
        //----------
        infoOutputPanel.add(new MyJTextField("Rohan"),"growx");
        infoOutputPanel.add(new MyJTextField("Laxman"),"growx");
        infoOutputPanel.add(new MyJTextField("Patil"),"wrap 25,growx");
        //===========
        infoOutputPanel.add(new JLabel("Mobile No"),"al left,growx");
        infoOutputPanel.add(new JLabel("Email"),"al left,growx");
        infoOutputPanel.add(new JLabel("DOB"),"wrap,al left,growx");
        //----------
        infoOutputPanel.add(new MyJTextField("1234567890"),"growx");
        infoOutputPanel.add(new MyJTextField("rahul@gmail.com"),"growx");
        infoOutputPanel.add(new MyJTextField("11/11/2004"),"wrap 25,growx");
        //===========
        infoOutputPanel.add(new JLabel("Payment Given"),"al left,growx");
        infoOutputPanel.add(new JLabel("Payment Pending"),"al left,growx");
        infoOutputPanel.add(new JLabel("Payment Status"),"wrap,al left,growx");
        //----------
        infoOutputPanel.add(new MyJTextField("Rs.2000"),"growx");
        infoOutputPanel.add(new MyJTextField("Rs.1500"),"growx");
        infoOutputPanel.add(new JComboBox(SystemStrings.PAYMENT_STATUS),"wrap,growx");
        
        infoOutputPanel.add(new JLabel(""),"al left,growx");
        infoOutputPanel.add(new JLabel(""),"al left,growx");
        infoOutputPanel.add(getInfoLabel("Click Here for Payment History"),"wrap 25,al left,growx");
        
        //===========
        infoOutputPanel.add(new JLabel("Application No."),"al left,growx");
        infoOutputPanel.add(new JLabel("Enrolment No."),"al left,growx");
        infoOutputPanel.add(new JLabel("Application Status"),"wrap,al left,growx");
        //----------
        infoOutputPanel.add(new MyJTextField("11224457856"),"growx");
        infoOutputPanel.add(new MyJTextField("28936/4576"),"growx");
        infoOutputPanel.add(new JComboBox(SystemStrings.APPLICATION_STATUS),"wrap,growx");
        //===========
        
        infoOutputPanel.add(getInfoLabel("If Application Available"),"al left,wrap 17,growx,span");
        
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new MigLayout("fillx"));

        buttonPanel1.setBackground(Color.white);
        buttonPanel1.add(new MyResetButton("Clear"), "al right");
        buttonPanel1.add(new MySubmitButton("Update"), "al left,wrap");
//        buttonPanel1.add(new MyDeleteButton("Delete"), "wrap,al left");
        
        infoOutputPanel.add(buttonPanel1,"span,growx");
        this.outputPanel.add(infoOutputPanel,"growx , wrap , top,pushy");

    }
    
    public JLabel getInfoLabel(String label)
    {
        JLabel info = new JLabel(label);
        info.setForeground(SystemColor.PRIMARY);
        info.setFont(SystemFonts.INFO_FONT);
        
        return info;
    }
    
}


