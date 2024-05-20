package javaswingdev.form;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;
import javaswingdev.main.Main;
import javaswingdev.swing.RoundPanel;
import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemFonts;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.event.ListDataListener;
import jnafilechooser.api.JnaFileChooser;
import net.miginfocom.swing.MigLayout;
import pdf.Application;
import pdf.FullName;
import pdf.ExtractReciptDetails;
import raven.combobox.ComboBoxMultiSelection;
import raven.crazypanel.CrazyPanel;
import raven.toast.Notifications;
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
public class Form_NewApplication extends CrazyPanel {

    MyJTextField firstNameInput = new MyJTextField("First Name");
    MyJTextField middleNameInput = new MyJTextField("Middle Name");
    MyJTextField lastNameInput = new MyJTextField("Last Name");

    MyJTextField mobileNoInput = new MyJTextField("Enter Mobile No");
    MyJTextField emailInput = new MyJTextField("Enter Email ");
    MyJTextField dobInput = new MyJTextField("Enter DOB");

    MyJTextField applicationNoInput = new MyJTextField("Enter Application No");
    ComboBoxMultiSelection covInput = new ComboBoxMultiSelection();
    MyJTextField enrollmentNoInput = new MyJTextField("Enter Enrolment No.");

    JComboBox applicationtStatus = new JComboBox(new String[]{"Pending", "Completed", "Enrolled", "Not Enrolled"});
    MyJTextField applicationDate = new MyJTextField("11-11-2024");
    JComboBox applicationtType = new JComboBox(new String[]{"Learning Licence", "Driving Licence", "Other"});
    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel<>(new String[]{"MCWG", "LMV", "LMV-TR", "Trans", "3W-GV"});



    public void setApplicationDetails(Application application) {
        FullName name = application.getApllicantName();

        firstNameInput.setMyText(name.getFirstName());
        middleNameInput.setMyText(name.getMiddleName());
        lastNameInput.setMyText(name.getLastName());
        dobInput.setMyText(application.getDOB());
        applicationNoInput.setMyText(application.getApplicationNo());
        applicationDate.setMyText(application.getDate());
        covInput.setSelectedItems(application.getSelectedCOV());
        applicationtType.setSelectedIndex(application.getApplicationTypeIndex());
    }

    public void resetPage() {
        firstNameInput.setPlaceholder("First Name");
        middleNameInput.setPlaceholder("Middle Name");
        lastNameInput.setPlaceholder("Last Name");
        dobInput.setPlaceholder("Enter DOB");
        applicationNoInput.setPlaceholder("Enter Application No");
        applicationDate.setPlaceholder("11-11-2024");
        covInput.clearSelectedItems();
        applicationtType.setSelectedIndex(2);
   
    }

    public Form_NewApplication() {

//        this.setRound(10);
        setLayout(new MigLayout("fillx , insets 15"));

        /* Header of the form with the gradient line below */
        add(new MyTitlePanel("Add New Applications"), "spanx,wrap 25,growx ");

        RoundPanel panel = new RoundPanel();
        panel.setLayout(new MigLayout("fillx,inset 10", "", "[][]10[][]10[][]10[][]10"));
        panel.setBackground(Color.WHITE);
        panel.setRound(10);
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        addFormSeperator(panel, "Personal Details");

        panel.add(new JLabel("First Name"), "al right,growx");
        panel.add(new JLabel("Middle Name"), "al right,growx");
        panel.add(new JLabel("Last Name"), "al right,wrap,growx");

        panel.add(firstNameInput, "pushx,growx");
        panel.add(middleNameInput, "pushx,growx");
        panel.add(lastNameInput, "wrap,pushx,growx");

        panel.add(new JLabel("Mobile No"), "al right,growx");
        panel.add(new JLabel("Email"), "al right,growx");
        panel.add(new JLabel("DOB"), "al right,wrap,growx");

        panel.add(mobileNoInput, "pushx,growx");
        panel.add(emailInput, "pushx,growx");
        panel.add(dobInput, "wrap 15,pushx,growx");

        addFormSeperator(panel, "Application Details");

        panel.add(new JLabel("Application No"), "al right,growx");
        panel.add(new JLabel("COV"), "al right,growx");
        panel.add(new JLabel("Enrolment No."), "al right,wrap,growx");

        covInput.setModel(comboBoxModel);

        panel.add(applicationNoInput, "pushx,growx");
        panel.add(covInput, "pushx,growx");
        panel.add(enrollmentNoInput, "wrap,pushx,growx");

        panel.add(new JLabel("Application Status"), "al right,growx");
        panel.add(new JLabel("Application Date"), "al right,growx");
        panel.add(new JLabel("Application Type"), "al right,wrap,growx");

        panel.add(applicationtStatus, "pushx,growx");
        panel.add(applicationDate, "pushx,growx");
        panel.add(applicationtType, "wrap 15,pushx,growx");

        addFormSeperator(panel, "Payment Details");
        panel.add(new JLabel("Total Decided"), "al right,growx");
        panel.add(new JLabel("Total Pending"), "al right,growx");
        panel.add(new JLabel("Payement Status"), "al right,wrap,growx");

        panel.add(new MyJTextField("Rs.9999"), "pushx,growx");
        panel.add(new MyJTextField("Rs.9999"), "pushx,growx");
        panel.add(new JComboBox(new String[]{"Pending", "Completed"}), "wrap 20,pushx,growx");

        MySubmitButton reciptUploadButton = new MySubmitButton("Upload");
        MyResetButton clearButton = new MyResetButton("Clear");
        panel.add(reciptUploadButton, "al left");
        panel.add(clearButton, "split 2, al center");
        panel.add(new MySubmitButton("Submit"), "wrap");
        panel.add(new JLabel(""), "wrap 50");

        add(new MyJScrollPane(panel), "growx");

        reciptUploadButton.addActionListener((e) -> {

            JnaFileChooser fc = new JnaFileChooser();

            fc.addFilter("All Files", "pdf");
            if (fc.showOpenDialog(Main.getMain())) {
                File f = fc.getSelectedFile();
                Runnable rh = () -> {
                    Application application = ExtractReciptDetails.getApplicationsDetails(f, 1);
                    System.out.println(application);
                    if (application.getOfficeName() != null) {
                        resetPage();
                        setApplicationDetails(application);

                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Recipt loaded successfully.");
                    } else {
                        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Upload valid recipt.");
                    }

                };
                Thread th = new Thread(rh);
                th.start();
            }
        });
        clearButton.addActionListener((e) -> {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Page Successfuly cleared");
            resetPage();

        });
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

    private void addFormSeperator(JPanel panel, String label) {
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
