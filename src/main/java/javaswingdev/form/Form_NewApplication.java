package javaswingdev.form;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaswingdev.main.Main;
import javaswingdev.swing.RoundPanel;
import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemStrings;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import jnafilechooser.api.JnaFileChooser;
import model.dao.ApplicationCOVDao;
import model.dao.ApplicationDao;
import model.dao.COVDao;
import model.dao.EnrollmentDao;
import model.dao.LLApplicationDao;
import model.dao.PaymentDao;
import model.dao.UserDao;
import model.entity.Application;
import model.entity.ApplicationCOV;
import model.entity.COV;
import model.entity.Enrollment;
import model.entity.LLApplication;
import model.entity.Payment;
import net.miginfocom.swing.MigLayout;
import model.entity.Recipt;
import model.entity.User;
import model.helper.RandomData;
import pdf.FullName;
import pdf.ExtractReciptDetails;
import util.swing.ComboBoxMultiSelection;
import raven.crazypanel.CrazyPanel;
import raven.toast.Notifications;
import util.MyDate;
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

    MyJTextField totalGivenInput = new MyJTextField(SystemStrings.TOTAL_GIVEN);
    MyJTextField totalDecidedInput = new MyJTextField(SystemStrings.TOTAL_DECIDED);

    JComboBox paymentStatus = new JComboBox(SystemStrings.PAYMENT_STATUS);

    public void setApplicationDetailsFromReport(Recipt application) {
        FullName name = application.getApllicantName();
        firstNameInput.setMyText(name.getFirstName());

        if (name.getMiddleName() != null) {
            middleNameInput.setMyText(name.getMiddleName());
        }

        if (name.getLastName() != null) {
            lastNameInput.setMyText(name.getLastName());
        }

        dobInput.setMyText(application.getDOB());
        applicationNoInput.setMyText(application.getApplicationNo());
        applicationDate.setMyText(application.getDate());
        covInput.setSelectedItems(application.getSelectedCOV());
        applicationtType.setSelectedIndex(application.getApplicationTypeIndex());
        totalGivenInput.setText(SystemStrings.TOTAL_GIVEN);
    }

    public void setRandomApplicationDetails() {

        RandomData data = new RandomData();
        User user = data.getUser();
        firstNameInput.setMyText(user.getFirstName());
        middleNameInput.setMyText(user.getMiddleName());
        lastNameInput.setMyText(user.getLastName());
        mobileNoInput.setMyText(user.getMobileNumber());
        emailInput.setMyText(user.getEmail());
        dobInput.setMyText(MyDate.getFormatedDate(user.getDob()));

        LLApplication application = data.getLLApplication();
        applicationNoInput.setMyText(application.getApp_no());
        applicationDate.setMyText(MyDate.getFormatedDate(application.getApp_date()));
        for(int i =0 ; i<2;i++){
            Random rand = new Random();
            covInput.setSelectedIndex(rand.nextInt(5));
        }
        
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
        totalGivenInput.setPlaceholder(SystemStrings.TOTAL_DECIDED);
        mobileNoInput.setPlaceholder(SystemStrings.MOBILE_NO);
        emailInput.setPlaceholder(SystemStrings.EMAIL);

        setDefaultPageDetails();

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
        panel.add(new JLabel("Total Given"), "al right,growx");
        panel.add(new JLabel("Payement Status"), "al right,wrap,growx");

        totalDecidedInput.setMyText("3500");
        panel.add(totalDecidedInput, "pushx,growx");
        panel.add(totalGivenInput, "pushx,growx");
        panel.add(paymentStatus, "wrap 20,pushx,growx");

        MySubmitButton submitButton = new MySubmitButton("Submit");
        MySubmitButton reciptUploadButton = new MySubmitButton("Upload");
        MySubmitButton reandomDetailsBtn = new MySubmitButton("Generate");
        MyResetButton clearButton = new MyResetButton("Clear");

        panel.add(reciptUploadButton, "al left, split 2");
        panel.add(reandomDetailsBtn, "al right");

        panel.add(clearButton, "split 2, al center");
        panel.add(submitButton, "wrap");
        panel.add(new JLabel(""), "wrap 50");

        add(new MyJScrollPane(panel), "growx");

        setDefaultPageDetails();

        //=====================
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
                        setApplicationDetailsFromReport(application);

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

        reandomDetailsBtn.addActionListener((e) -> {
            setRandomApplicationDetails();
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
        PaymentDao paymentDao = new PaymentDao();

        User user = getUserDetails();
        LLApplication llapplication = getLLApplicationDetails();
        boolean status = getCOVSelectedDetails();
        String enrollmentNumbers[] = getEnrollmentDetails();
        Payment payment = getPaymentDetails();

        if (user != null && llapplication != null && status && enrollmentNumbers != null && payment != null) {
            System.out.println(payment);
            if (userDao.addUserDetails(user)) {
                int userId = userDao.getUserDetails(user.getMobileNumber()).getId();

                payment.setUserId(userId);
                if (applicationDao.addLLApplicationDetails(llapplication)) {
                    int appId = applicationDao.getLLApplication(llapplication.getApp_no()).getId();

                    if (addCOVDetails(appId, enrollmentNumbers) && addApplicationToUserDetails(appId, userId) && paymentDao.addPaymentDetails(payment)) {
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

    public Payment getPaymentDetails() {
        Pattern validPaymentPattern = Pattern.compile("^[0-9]{1,29}");
        Payment payment = new Payment();
        if (!totalDecidedInput.getText().equals(SystemStrings.TOTAL_DECIDED)) {
            Matcher matcher = validPaymentPattern.matcher(totalDecidedInput.getText());
            if (matcher.matches() == false) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Enter Valid total decided payment");
                return null;
            } else {
                payment.setTotalDecide(Integer.parseInt(totalDecidedInput.getText()));
            }
        }

        if (!totalGivenInput.getText().equals(SystemStrings.TOTAL_GIVEN)) {
            Matcher matcher = validPaymentPattern.matcher(totalGivenInput.getText());
            if (matcher.matches() == false) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Enter Valid total Given payment");
                return null;
            } else {
                payment.setTotalGiven(Integer.parseInt(totalGivenInput.getText()));
            }

        }

        payment.setPaymentStatus((String) paymentStatus.getSelectedItem());
        return payment;
    }

    public LLApplication getLLApplicationDetails() {

        LLApplication llapplication = new LLApplication();
        llapplication.setApp_no(applicationNoInput.getText());
        llapplication.setStatus((String) applicationtStatus.getSelectedItem());
        if (!applicationDate.equals(SystemStrings.APPLICATION_DATE)) {
            try {
                java.sql.Date date = MyDate.getSQLDate(applicationDate.getText());
                
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

    public boolean addCOVDetails(int app_id, String enrollmentNumbers[]) {

        List<String> selectedCOV = covInput.getSelectedItems();
        COVDao covdao = new COVDao();
        ApplicationCOV appCov = new ApplicationCOV();
        ApplicationCOVDao applicationCOVDao = new ApplicationCOVDao();
        for (String vehical : selectedCOV) {
            appCov.setApp_id(app_id);
            int cov_id = covdao.getCOVId(vehical);
            appCov.setCov_id(cov_id);

            if (!applicationCOVDao.addApplicationCOVDetails(appCov)) {
                return false;
            } else {

                Enrollment enroll = new Enrollment();
                if (enrollmentNumbers != null && enrollmentNumbers.length != 0) {
                    if (enrollmentNumbers.length == 1 && (cov_id == COV.LMVTR || cov_id == COV.TRANS)) {
                        int appCOVId = applicationCOVDao.getApplicationCOVId(app_id, cov_id);
                        enroll.setApplicationCOVid(appCOVId);
                        enroll.setEnrollmentNumber(enrollmentNumbers[0]);

                    } else if (enrollmentNumbers.length == 2) {
                        if (cov_id == COV.LMVTR) {
                            int appCOVId = applicationCOVDao.getApplicationCOVId(app_id, cov_id);
                            enroll.setApplicationCOVid(appCOVId);
                            enroll.setEnrollmentNumber(enrollmentNumbers[0]);
                        }
                        if (cov_id == COV.A3WGV) {
                            int appCOVId = applicationCOVDao.getApplicationCOVId(app_id, cov_id);
                            enroll.setApplicationCOVid(appCOVId);
                            enroll.setEnrollmentNumber(enrollmentNumbers[1]);
                        }
                    }

                    EnrollmentDao enrollmentDao = new EnrollmentDao();
                    enrollmentDao.addEnrollmentDetails(enroll);
                }
            }
        }
        return true;
    }

    public String[] getEnrollmentDetails() {
        if (enrollmentNoInput.getText().equals(SystemStrings.ENROLMENT_NO)) {
            return new String[0];

        } else {
            String numbers[] = enrollmentNoInput.getText().split("[\\s,]+");
            Pattern validNoPattern = Pattern.compile("^[0-9]{2,29}");

            for (String num : numbers) {
                Matcher matcher = validNoPattern.matcher(num);
                if (matcher.matches()) {
                    System.out.println(num);

                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Enter valid Enrollment number");
                    return null;
                }
            }
            return numbers;
        }

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

    public void setDefaultPageDetails() {
        applicationDate.setMyText(getTodayDate());
    }

    public String getTodayDate() {
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        return ft.format(new java.util.Date());
    }

}
