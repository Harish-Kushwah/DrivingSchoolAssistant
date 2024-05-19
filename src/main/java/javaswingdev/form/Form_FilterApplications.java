package javaswingdev.form;

import java.awt.Color;
import java.awt.ScrollPane;
import javaswingdev.swing.RoundPanel;
import javaswingdev.swing.scroll.ScrollBar;
import javaswingdev.swing.table.TablePanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import raven.crazypanel.CrazyPanel;
import util.swing.MyJTextField;
import util.swing.MyJScrollPane;
import util.swing.MySubtitle;
import util.swing.MyTitlePanel;
import util.swing.button.MyResetButton;
import util.swing.button.MySubmitButton;

/**
 *
 * @author haris
 */
public class Form_FilterApplications extends CrazyPanel {

    public Form_FilterApplications() {
        
        setLayout(new MigLayout("fillx , insets 10 "));
        
        //===================================================================================
        /* Header of the form with the gradient line below */
        add(new MyTitlePanel("Filter Applications"), "spanx,wrap 5,growx ");
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
        inputPanel.setLayout(new MigLayout("fillx ,inset 15","[]20[]20[]"));
        inputPanel.setRound(10);
        inputPanel.setBackground(Color.white);

        JPanel covPanel = new JPanel(new MigLayout("fillx","30[]5[]30[]5[]"));
        covPanel.setBackground(Color.white);

        covPanel.add(new MySubtitle("COV Filter"),"wrap,span,al center");
        covPanel.add(new JLabel("All"),"al right");
        covPanel.add(new JCheckBox(),"");
        covPanel.add(new JLabel("LMV"),"al right");
        covPanel.add(new JCheckBox(),"wrap");
        covPanel.add(new JLabel("LMV-TR"),"al right");
        covPanel.add(new JCheckBox(),"");
        covPanel.add(new JLabel("MCWG"),"al right");
        covPanel.add(new JCheckBox(),"wrap");
        covPanel.add(new JLabel("MCWOG"),"al right");
        covPanel.add(new JCheckBox(),"");
        covPanel.add(new JLabel("Trans"),"al right");
        covPanel.add(new JCheckBox(),"wrap");
        covPanel.add(new JLabel("3WGV"),"al right");
        covPanel.add(new JCheckBox(),"");

        
        JPanel dateFilterPanel = new JPanel(new MigLayout("fillx",""));
        dateFilterPanel.setBackground(Color.white);
        dateFilterPanel.add(new MySubtitle("Date Filter"),"wrap,span,al center");
        dateFilterPanel.add(new JLabel("Date"),"al right");
        dateFilterPanel.add(new MyJTextField("From"), "pushx,growx");
        dateFilterPanel.add(new MyJTextField("To"),"wrap,pushx,growx");
        
        dateFilterPanel.add(new JLabel("Completed On"),"al right");
        dateFilterPanel.add(new MyJTextField("11/11/2024"), "span,wrap,pushx,growx");
        
        dateFilterPanel.add(new JLabel("Expired On"),"al right");
        dateFilterPanel.add(new MyJTextField("11/11/2024"), "span,wrap,pushx,growx");

        
        
        JPanel totalApplicationsPanel = new JPanel(new MigLayout());
        totalApplicationsPanel.setBackground(Color.white);
        totalApplicationsPanel.add(new MySubtitle("Other Filters"),"wrap 15,span,al center");
        totalApplicationsPanel.add(new JLabel("Today"),"al right ");
        totalApplicationsPanel.add(new JCheckBox(),"wrap");
       
        totalApplicationsPanel.add(new JLabel("Previous Month"),"al right");
        totalApplicationsPanel.add(new JCheckBox(),"wrap");

        totalApplicationsPanel.add(new JLabel("Resent"),"al right");
        totalApplicationsPanel.add(new MyJTextField("5"), "span,wrap,growx");
       
        inputPanel.add(covPanel,"growx");
        inputPanel.add(dateFilterPanel,"growx");
        inputPanel.add(totalApplicationsPanel,"growx");
            
        
      

        //-------------------------------
        pagePanel.add(inputPanel,"wrap,growx");
        
        JPanel infoPanel = new JPanel(new MigLayout("fillx"));
        
        infoPanel.add(new MySubtitle("Total Applications :"),"al right");
        infoPanel.add(new MySubtitle("1234"), "al left");
        infoPanel.add(new MyResetButton("Clear"), "al right");
        infoPanel.add(new MySubmitButton("Print"), "wrap,al left");
        infoPanel.setBackground(Color.white);   
        pagePanel.add(infoPanel,"wrap,growx");
        
        //----------------------------
        String columns[] = new String [] {
                "#", "Name", "Application No.", "Class Vehical", "Application Date","Mobile No.","Enroll No"
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

