package javaswingdev.form;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.main.Main;
import javaswingdev.swing.RoundPanel;
import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemFonts;
import javaswingdev.system.SystemStrings;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListDataListener;
import jnafilechooser.api.JnaFileChooser;
import model.dao.ApplicationCOVDao;
import model.dao.ApplicationDao;
import model.dao.COVDao;
import model.dao.LLApplicationDao;
import model.dao.UserDao;
import model.entity.Application;
import model.entity.ApplicationCOV;
import model.entity.LLApplication;
import net.miginfocom.swing.MigLayout;
import model.entity.Recipt;
import model.entity.User;
import pdf.FullName;
import pdf.ExtractReciptDetails;
import util.swing.ComboBoxMultiSelection;
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

    MyJTextField firstNameInput = new MyJTextField(SystemStrings.FIRST_NAME);
    MyJTextField middleNameInput = new MyJTextField(SystemStrings.MIDDLE_NAME);
    MyJTextField lastNameInput = new MyJTextField(SystemStrings.LAST_NAME);

    MyJTextField mobileNoInput = new MyJTextField(SystemStrings.MOBILE_NO);
    MyJTextField emailInput = new MyJTextField(SystemStrings.EMAIL);
    MyJTextField dobInput = new MyJTextField(SystemStrings.DOB);

    MyJTextField applicationNoInput = new MyJTextField(SystemStrings.APPLICATION_NO);
    ComboBoxMultiSelection covInput = new ComboBoxMultiSelection();
    MyJTextField enrollmentNoInput = new MyJTextField(SystemStrings.ENROLMENT_NO);

    JComboBox applicationtStatus = new JComboBox(SystemStrings.APPLICATION_STATUS);
    MyJTextField applicationDate = new MyJTextField(SystemStrings.APPLICATION_DATE);
    JComboBox applicationtType = new JComboBox(SystemStrings.APPLICATION_TYPE);

    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel<>(SystemStrings.COV);

    public void setApplicationDetails(Recipt application) {
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
        firstNameInput.setPlaceholder(SystemStrings.FIRST_NAME);
        middleNameInput.setPlaceholder(SystemStrings.MIDDLE_NAME);
        lastNameInput.setPlaceholder(SystemStrings.LAST_NAME);
        dobInput.setPlaceholder(SystemStrings.DOB);
        applicationNoInput.setPlaceholder(SystemStrings.APPLICATION_NO);
        applicationDate.setPlaceholder(SystemStrings.APPLICATION_DATE);
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

        MySubmitButton submitButton = new MySubmitButton("Submit");
        MySubmitButton reciptUploadButton = new MySubmitButton("Upload");
        MyResetButton clearButton = new MyResetButton("Clear");

        panel.add(reciptUploadButton, "al left");
        panel.add(clearButton, "split 2, al center");
        panel.add(submitButton, "wrap");
        panel.add(new JLabel(""), "wrap 50");

        add(new MyJScrollPane(panel), "growx");

        reciptUploadButton.addActionListener((e) -> {

            JnaFileChooser fc = new JnaFileChooser();

            fc.addFilter("All Files", "pdf");
            if (fc.showOpenDialog(Main.getMain())) {
                File f = fc.getSelectedFile();
                Runnable rh = () -> {
                    Recipt application = ExtractReciptDetails.getApplicationsDetails(f, 1);
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

        submitButton.addActionListener((e) -> {
            saveALLDetails();

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

    //This method will save all the details into the database
    public void saveALLDetails() {

        UserDao userDao = new UserDao();
        LLApplicationDao applicationDao = new LLApplicationDao();

        User user = getUserDetails();
        LLApplication llapplication = getLLApplicationDetails();
        boolean status = getCOVSelectedDetails();

        if (user != null && llapplication != null && status) {
            if (userDao.addUserDetails(user)) {
                int userId = userDao.getUserDetails(user.getMobileNumber()).getId();

                if (applicationDao.addLLApplicationDetails(llapplication)) {
                    int appId = applicationDao.getLLApplication(llapplication.getApp_no()).getId();

                    if (addCOVDetails(appId) && addApplicationToUserDetails(appId, userId)) {
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Application details saved successfully");
                    }
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Application details unable to saved");
                }

            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "User details unable to saved");
            }
        }

    }

    public LLApplication getLLApplicationDetails() {

        LLApplication llapplication = new LLApplication();
        llapplication.setApp_no(applicationNoInput.getText());
        if (!applicationDate.equals(SystemStrings.APPLICATION_DATE)) {
            try {
                java.sql.Date date = getSQLDate(applicationDate.getText());
                llapplication.setApp_date(date);
            } catch (Exception exp) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Enter valid Application date");
                return null;
            }

        }

        if (llapplication.validate()) {
            return llapplication;
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, llapplication.getValidatationErrorMessage());
        }
        return null;
    }

    public User getUserDetails() {
        User user = new User();
        user.setFirstName(firstNameInput.getText());
        user.setMiddleName(middleNameInput.getText());
        user.setLastName(lastNameInput.getText());
        user.setEmail(emailInput.getText());
        user.setMobileNumber(mobileNoInput.getText());
        if (!dobInput.getText().startsWith(SystemStrings.DOB)) {
            try {
                java.sql.Date date = getSQLDate(dobInput.getText());
                user.setDob(date);
            } catch (Exception exp) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Enter valid DOB");
                return null;
            }

        }

        if (user.validate()) {
            return user;
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, user.getVlidationErrorMessage());
        }
        return null;
    }

    public boolean getCOVSelectedDetails() {
        List<String> selectedCOV = covInput.getSelectedItems();
        if (selectedCOV.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Selecet At least one COV");
            return false;
        }
        return true;
    }

    public boolean addCOVDetails(int app_id) {

        List<String> selectedCOV = covInput.getSelectedItems();
        COVDao covdao = new COVDao();
        ApplicationCOV appCov = new ApplicationCOV();
        ApplicationCOVDao applicationCOVDao = new ApplicationCOVDao();
        for (String vehical : selectedCOV) {
            appCov.setApp_id(app_id);
            appCov.setCov_id(covdao.getCOVId(vehical));
            if (!applicationCOVDao.addApplicationCOVDetails(appCov)) {
                return false;
            }
        }
        return true;
    }

    public boolean addApplicationToUserDetails(int app_id, int user_id) {
        ApplicationDao appDao = new ApplicationDao();

        Application application = new Application();
        application.setApp_type_id(app_id);
        application.setUser_id(user_id);
        application.setLicence_type("LL");
        return appDao.addApplicationDetails(application);
    }

    public java.sql.Date getSQLDate(String strDate) throws Exception {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = sdf1.parse(strDate);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

}
