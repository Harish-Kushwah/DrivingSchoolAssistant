package javaswingdev.form;

import java.awt.Color;
import javaswingdev.swing.RoundPanel;
import javaswingdev.swing.scroll.ScrollBar;
import javaswingdev.swing.table.TablePanel;
import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemFonts;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import raven.crazypanel.CrazyPanel;
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



public class Form_SearchApplications extends CrazyPanel {

    public Form_SearchApplications() {
        
        setLayout(new MigLayout("fillx , insets 10 "));
        
        //===================================================================================
        /* Header of the form with the gradient line below */
        add(new MyTitlePanel("Search Applications"), "spanx,wrap 5,growx ");
        //===================================================================================
       
        
        /**
         * panel
         *    ->panel panel panel
         *      ->mig  mig s3 mig s2  
         *         s3    
         * panel
         *    table
         */
        
        JPanel pagePanel = new JPanel(new MigLayout("fillx "));
        
        //----------------------------------
        RoundPanel inputPanel = new RoundPanel();
        
        inputPanel.setLayout(new MigLayout("fillx ,inset 15",""));
        inputPanel.setBackground(Color.white);
        inputPanel.setRound(10);
     
        
        inputPanel.add(new JLabel("Name"),"al right");
        inputPanel.add(new MyJTextField("Enter Name") ,"growx,al right");
        inputPanel.add(new JLabel("Application No"),"al right");
        inputPanel.add(new MyJTextField("Enter Application No.") ,"growx,al right");
        inputPanel.add(new JLabel("COV"),"al right");
        inputPanel.add(new JComboBox(new String[]{"LMV", "LMV-Tr", "Trans", "3W-GV"}), "growx,al right");

        inputPanel.add(new JLabel("Date"),"al right");
        inputPanel.add(new MyJTextField("11/11/2024") ,"wrap 15,growx,al right");
        

                

             
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new MigLayout("fillx"));

        buttonPanel1.setBackground(Color.white);
        buttonPanel1.add(new MyResetButton("Clear"), "al right");
        buttonPanel1.add(new MySubmitButton("Update"), "al left,wrap");
        buttonPanel1.setBackground(Color.white);
        
        inputPanel.add(buttonPanel1,"span,growx");
        
        pagePanel.add(inputPanel,"wrap,growx");
        
//        pagePanel.add(inputPanel,"wrap 10,growx");


        //-------------------------------
        
        JPanel infoPanel = new JPanel(new MigLayout("fillx"));
        
        infoPanel.add(new MySubtitle("Total Applications :"),"al right");
        infoPanel.add(new MySubtitle("1234"), "al left");
//        infoPanel.add(new JLabel("Application Details"), "al Center");
//        infoPanel.add(new MySubmitButton("Print"), "wrap,al left");
        infoPanel.setBackground(Color.white);
        pagePanel.add(infoPanel,"wrap,growx 50");
        
        //----------------------------
        String columns[] = new String [] {
                "#", "Name", "Application Date","Mobile No."
            };
        TablePanel outputTablePanel = new TablePanel(columns);
//        outputTablePanel.setRowHeight(30);
        
        outputTablePanel.addRow(new Object[]{"1", "Mike Bhand", "mikebhand@gmail.com", "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"2", "Andrew Strauss", "andrewstrauss@gmail.com", "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"3", "Ross Kopelman", "rosskopelman@gmail.com",  "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"4", "Mike Hussy", "mikehussy@gmail.com",  "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"5", "Kevin Pietersen", "kevinpietersen@gmail.com",  "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"6", "Andrew Strauss", "andrewstrauss@gmail.com", "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"7", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"8", "Mike Hussy", "mikehussy@gmail.com",  "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"9", "Kevin Pietersen", "kevinpietersen@gmail.com",  "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"10", "Kevin Pietersen", "kevinpietersen@gmail.com",  "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"11", "Andrew Strauss", "andrewstrauss@gmail.com",  "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"12", "Ross Kopelman", "rosskopelman@gmail.com", "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"13", "Mike Hussy", "mikehussy@gmail.com", "25 Apr,2018"});
        outputTablePanel.addRow(new Object[]{"14", "Kevin Pietersen", "kevinpietersen@gmail.com", "25 Apr,2018"});

        //--------------------------------------------------------
        
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new MigLayout("fillx"));
        
        outputPanel.add(outputTablePanel,"growx ");
        
        
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
        infoOutputPanel.add(new MyJTextField("Completed"),"wrap,growx");
        
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
        infoOutputPanel.add(new MyJTextField("Pending"),"wrap,growx");
        //===========
        
        infoOutputPanel.add(getInfoLabel("If Application Available"),"al left,wrap 61,growx");
//        infoOutputPanel.add(new JLabel(""),"al left,growx");
//        infoOutputPanel.add(new JLabel(""),"wrap 20,al left,growx");
        
//        infoOutputPanel.add(buttonPanel,"span , wrap 20,growx");
        
        outputPanel.add(infoOutputPanel,"growx , wrap , top,pushy");

        
        pagePanel.add(new MyJScrollPane(outputPanel),"growx");
        
        add(new MyJScrollPane(pagePanel),"growx");

    }
    
    public JLabel getInfoLabel(String label)
    {
        JLabel info = new JLabel(label);
        info.setForeground(SystemColor.PRIMARY);
        info.setFont(SystemFonts.INFO_FONT);
        
        return info;
    }
    
}

