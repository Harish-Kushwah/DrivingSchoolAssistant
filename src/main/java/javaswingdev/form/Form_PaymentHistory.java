package javaswingdev.form;

import java.awt.Color;
import javaswingdev.swing.RoundPanel;
import javaswingdev.swing.table.TablePanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import raven.crazypanel.CrazyPanel;
import util.swing.MyJScrollPane;
import util.swing.MyJTextField;
import util.swing.MySubtitle;
import util.swing.MyTitlePanel;
import util.swing.button.MyResetButton;
import util.swing.button.MySubmitButton;

/**
 *
 * @author haris
 */
public class Form_PaymentHistory extends CrazyPanel {

    MyJTextField firstName = new MyJTextField("First Name");
    MyJTextField middleName = new MyJTextField("Middle Name");
    MyJTextField lastName = new MyJTextField("Last Name");
    MyJTextField mobileNo = new MyJTextField("Enter Mobile No");
    public Form_PaymentHistory() {
                
        setLayout(new MigLayout("fillx , insets 10 "));
        
        //===================================================================================
        /* Header of the form with the gradient line below */
        add(new MyTitlePanel("Payment History"), "spanx,wrap 5,growx ");
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
        inputPanel.setLayout(new MigLayout("fillx,inset 10",""));
        inputPanel.setRound(10);
        inputPanel.setBackground(Color.WHITE);
      
//        inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
      
        inputPanel.add(new JLabel("First Name"), "al right,growx");
        inputPanel.add(new JLabel("Middle Name"), "al right,growx");
        inputPanel.add(new JLabel("Last Name"), "al right,wrap,growx");
        
        inputPanel.add(firstName, "pushx,growx");
        inputPanel.add(middleName, "pushx,growx");
        inputPanel.add(lastName, "wrap,pushx,growx");

        inputPanel.add(new JLabel("Mobile No"), "al right,growx");
        inputPanel.add(new JLabel("Email"), "al right,growx");
        inputPanel.add(new JLabel("DOB"), "al right,wrap,growx");
        
        inputPanel.add(new MyJTextField("Enter Mobile No"), "pushx,growx");
        inputPanel.add(new MyJTextField("Enter Email "), "pushx,growx");
        inputPanel.add(new MyJTextField("Enter DOB"), "wrap 15,pushx,growx");
        
        inputPanel.add(new JLabel(""));
        inputPanel.add(new MyResetButton("Clear"), "split 2 , al center");
        inputPanel.add(new MySubmitButton("Search"), "wrap 10");
        //-------------------------------
        pagePanel.add(inputPanel,"wrap,growx");
        
        JPanel infoPanel = new JPanel(new MigLayout("fillx"));
        infoPanel.setBackground(Color.white);
        infoPanel.add(new MySubtitle("Total Transactions :"),"al right");
        infoPanel.add(new MySubtitle("1234"), "al left");
        infoPanel.add(new MySubtitle("Total Given :"),"al right");
        infoPanel.add(new MySubtitle("1234"), "al left");
        infoPanel.add(new MySubtitle("Total Pending :"),"al right");
        infoPanel.add(new MySubtitle("1234"), "al left");
        infoPanel.add(new MySubmitButton("Print"), "wrap,al center");
                
        pagePanel.add(infoPanel,"wrap,growx 10");
        
        //----------------------------
        String columns[] = new String [] {
                "#", "Name", "Application No.", "Type", "Payment Date","Amount"
            };
        TablePanel outputPanel = new TablePanel(columns);
        
        outputPanel.addRow(new Object[]{"1", "Mike Bhand", "mikebhand@gmail.com", "Admin", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"2", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"3", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"4", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"5", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"6", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"7", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"8", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"9", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"10", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"11", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"12", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"13", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
        outputPanel.addRow(new Object[]{"14", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});

        //--------------------------------------------------------
        pagePanel.add(new MyJScrollPane(outputPanel),"growx");
        
        
        add(new MyJScrollPane(pagePanel),"growx");

    }
       
}

