package javaswingdev.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javaswingdev.swing.RoundPanel;
import javaswingdev.swing.table.Table;
import javaswingdev.swing.table.TablePanel;
import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemFonts;
import javaswingdev.system.SystemStrings;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.dao.ApplicationCOVDao;
import model.dao.ApplicationDao;
import model.dao.COVDao;
import model.dao.LLApplicationDao;
import model.dao.PaymentDao;
import model.dao.UserDao;
import model.entity.LLApplication;
import model.entity.Payment;
import model.entity.User;
import net.miginfocom.swing.MigLayout;
import pdf.FullName;
import raven.crazypanel.CrazyPanel;
import raven.toast.Notifications;
import util.MyDate;
import util.swing.ComboBoxMultiSelection;
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
public class TemplatePage extends CrazyPanel {

    private final MyJTextField nameInput = new MyJTextField(SystemStrings.NAME_INPUT);
    private final MyJTextField dateInput = new MyJTextField(SystemStrings.APPLICATION_DATE);
    private final MyJTextField applicationNoInput = new MyJTextField(SystemStrings.APPLICATION_NO);

    public TablePanel outputTablePanel;
    public JPanel outputPanel;
    private final JComboBox covComboBox = new JComboBox(SystemStrings.COV);

    MyJTextField firstNameInput = new MyJTextField(SystemStrings.FIRST_NAME);
    MyJTextField middleNameInput = new MyJTextField(SystemStrings.MIDDLE_NAME);
    MyJTextField lastNameInput = new MyJTextField(SystemStrings.LAST_NAME);

    MyJTextField mobileNoInput = new MyJTextField(SystemStrings.MOBILE_NO);
    MyJTextField emailInput = new MyJTextField(SystemStrings.EMAIL);
    MyJTextField dobInput = new MyJTextField(SystemStrings.DOB);

    MyJTextField applicationNo = new MyJTextField(SystemStrings.APPLICATION_NO);
    ComboBoxMultiSelection covInput = new ComboBoxMultiSelection();
    MyJTextField enrollmentNoInput = new MyJTextField(SystemStrings.ENROLMENT_NO);

    JComboBox applicationtStatus = new JComboBox(SystemStrings.APPLICATION_STATUS);
    MyJTextField applicationDate = new MyJTextField(SystemStrings.APPLICATION_DATE);
    JComboBox applicationtType = new JComboBox(SystemStrings.APPLICATION_TYPE);

    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel<>(SystemStrings.COV);

    MyJTextField totalGivenInput = new MyJTextField(SystemStrings.TOTAL_GIVEN);
    MyJTextField totalDecidedInput = new MyJTextField(SystemStrings.TOTAL_DECIDED);

    JComboBox paymentStatus = new JComboBox(SystemStrings.PAYMENT_STATUS);
    JLabel totalApplication = new JLabel("0");

    RoundPanel infoOutputPanel = new RoundPanel();

    public TemplatePage(String title) {

        nameInput.setPlaceholder(SystemStrings.NAME_INPUT);
        setLayout(new MigLayout("fillx , insets 15 "));

        //===================================================================================
        /* Header of the form with the gradient line below */
        add(new MyTitlePanel(title), "spanx,wrap 5,growx ");
        //===================================================================================

        /**
         * panel ->panel panel panel ->mig mig s3 mig s2 s3 panel table
         */
        JPanel pagePanel = new JPanel(new MigLayout("fillx "));

        //----------------------------------
        RoundPanel inputPanel = new RoundPanel();

        inputPanel.setLayout(new MigLayout("fillx ,inset 15", ""));
        inputPanel.setBackground(Color.white);
        inputPanel.setRound(10);

        inputPanel.add(new JLabel("Name"), "al right");
        inputPanel.add(nameInput, "growx,al right");
        inputPanel.add(new JLabel("Application No"), "al right");
        inputPanel.add(applicationNoInput, "growx,al right");
        inputPanel.add(new JLabel("COV"), "al right");
        inputPanel.add(covComboBox, "growx,al right");

        inputPanel.add(new JLabel("Date"), "al right");
        inputPanel.add(dateInput, "wrap 15,growx,al right");

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new MigLayout("fillx"));

        MySubmitButton submit = new MySubmitButton("Search");
        MyResetButton clear = new MyResetButton("Clear");
        buttonPanel1.setBackground(Color.white);
        buttonPanel1.add(clear, "al right");
        buttonPanel1.add(submit, "al left,wrap");
        buttonPanel1.setBackground(Color.white);

        inputPanel.add(buttonPanel1, "span,growx");

        pagePanel.add(inputPanel, "wrap,growx");

        //-------------------------------
        JPanel infoPanel = new JPanel(new MigLayout("fillx"));

        infoPanel.add(new MySubtitle("Total Applications :"), "al right");

        totalApplication.setText(Integer.toString(new UserDao().getTotalUser()));
        infoPanel.add(totalApplication, "al left");
        infoPanel.setBackground(Color.white);
        pagePanel.add(infoPanel, "wrap,growx 50");

        //----------------------------
        addTableSection();
        //--------------------------------------------------------
        outputPanel = new JPanel();

        outputPanel.setLayout(new MigLayout("fillx"));
        outputPanel.add(outputTablePanel, "growx ");
        pagePanel.add(new MyJScrollPane(outputPanel), "growx");

        add(new MyJScrollPane(pagePanel), "growx");

        addRecordsBasedOnName();

        covComboBox.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == 1) {
                System.out.println(covComboBox.getSelectedItem());
                COVDao covdao = new COVDao();
                UserDao userDao = new UserDao();
                ApplicationCOVDao appCovDao = new ApplicationCOVDao();
                int covId = covdao.getCOVId((String) covComboBox.getSelectedItem());
                ArrayList<Integer> allAppId = appCovDao.getApplicationId(covId);

                outputTablePanel.removeAllRow();
                for (Integer id : allAppId) {
                    setUserDetails(userDao.getAllCOVApplicationUserDetails(id));
                }

            }
        });

        submit.addActionListener((ActionEvent e) -> {
            UserDao userDao1 = new UserDao();
            if (!dateInput.getText().equals(SystemStrings.APPLICATION_DATE)) {
                try {
                    outputTablePanel.removeAllRow();
                    java.sql.Date date = MyDate.getSQLDate(dateInput.getText());
                    setUserDetails(userDao1.getAllDateApplicationUserDetails(date));
                } catch (Exception ex) {

                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Enter Valid Date");

                }
            }
        });

        clear.addActionListener((ActionEvent e) -> {
            resetSearchInputSection();
        });

        addInfoOutputPanel();

    }

    public JLabel getInfoLabel(String label) {
        JLabel info = new JLabel(label);
        info.setForeground(SystemColor.PRIMARY);
        info.setFont(SystemFonts.INFO_FONT);

        return info;
    }

    public void addRecordsBasedOnName() {

        DocumentListener dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFieldState();
            }

            public void updateFieldState() {
                UserDao userDao = new UserDao();

                if (!nameInput.getText().equals(SystemStrings.NAME_INPUT)) {
                    outputTablePanel.removeAllRow();
                    setUserDetails(userDao.getAllLikeNameUserDetails(nameInput.getText()));
                }
                if (!applicationNoInput.getText().equals(SystemStrings.APPLICATION_NO)) {
                    outputTablePanel.removeAllRow();
                    setUserDetails(userDao.getAllLikeApplicationUserDetails(applicationNoInput.getText()));
                }

            }

        };

        nameInput.getDocument().addDocumentListener(dl);
        applicationNoInput.getDocument().addDocumentListener(dl);
        dateInput.getDocument().addDocumentListener(dl);

    }

    public void resetTable()
    {
        outputTablePanel.removeAllRow();
        setUserDetails(new UserDao().getAllUserDetails());
    }
    public void setUserDetails(ArrayList<User> allUser) {
        ApplicationDao appDao = new ApplicationDao();
        LLApplicationDao llAppDao = new LLApplicationDao();
        totalApplication.setText(Integer.toString(allUser.size()));
        for (User user : allUser) {
            LLApplication llApplication = llAppDao.getLLApplicationDetails(appDao.getApplicationDetails(user.getId()).getApp_type_id());
            String fullName = new FullName(user).getFullName();
            outputTablePanel.addRow(new Object[]{user.getId(), fullName, llApplication.getApp_no(), llApplication.getApp_date(), llApplication.getStatus()});
        }
    }

    public void addInfoOutputPanel() {

        infoOutputPanel.setLayout(new MigLayout("fill"));
        infoOutputPanel.setRound(10);
        infoOutputPanel.setBackground(Color.white);

        infoOutputPanel.add(new MyTitle("Application Details"), "al center,span,wrap 30,growx");
        infoOutputPanel.add(new JLabel("First Name"), "al left,growx");
        infoOutputPanel.add(new JLabel("Middle Name"), "al left,growx");
        infoOutputPanel.add(new JLabel("Last Name"), "wrap,al left,growx");
        //----------
        infoOutputPanel.add(firstNameInput, "growx");
        infoOutputPanel.add(middleNameInput, "growx");
        infoOutputPanel.add(lastNameInput, "wrap 25,growx");
        //===========
        infoOutputPanel.add(new JLabel("Mobile No"), "al left,growx");
        infoOutputPanel.add(new JLabel("Email"), "al left,growx");
        infoOutputPanel.add(new JLabel("DOB"), "wrap,al left,growx");
        //----------
        infoOutputPanel.add(mobileNoInput, "growx");
        infoOutputPanel.add(emailInput, "growx");
        infoOutputPanel.add(dobInput, "wrap 25,growx");
        //===========
        infoOutputPanel.add(new JLabel("Payment Given"), "al left,growx");
        infoOutputPanel.add(new JLabel("Payment Pending"), "al left,growx");
        infoOutputPanel.add(new JLabel("Payment Status"), "wrap,al left,growx");
        //----------
        infoOutputPanel.add(totalGivenInput, "growx");
        infoOutputPanel.add(totalDecidedInput, "growx");
        infoOutputPanel.add(paymentStatus, "wrap,growx");

        infoOutputPanel.add(new JLabel(""), "al left,growx");
        infoOutputPanel.add(new JLabel(""), "al left,growx");
        infoOutputPanel.add(getInfoLabel("Click Here for Payment History"), "wrap 25,al left,growx");

        //===========
        infoOutputPanel.add(new JLabel("Application No."), "al left,growx");
        infoOutputPanel.add(new JLabel("Enrolment No."), "al left,growx");
        infoOutputPanel.add(new JLabel("Application Status"), "wrap,al left,growx");
        //----------
        infoOutputPanel.add(applicationNo, "growx");
        infoOutputPanel.add(new MyJTextField("28936/4576"), "growx");
        infoOutputPanel.add(applicationtStatus, "wrap,growx");
    }

    private User selectedUser = null;

    public User getSelectedUser() {
        return this.selectedUser;
    }

    public void addTableSection() {
        String columns[] = new String[]{
            "User Id", "Name", "App No", "App Date", "App Status"
        };
        outputTablePanel = new TablePanel(columns);
        UserDao userDao = new UserDao();
        ApplicationDao appDao = new ApplicationDao();
        LLApplicationDao llAppDao = new LLApplicationDao();

        ArrayList<User> allUser = userDao.getAllUserDetails();
        setUserDetails(allUser);
        Table table = outputTablePanel.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int rowIndex = table.getSelectedRow();
                int ID = (int) model.getValueAt(rowIndex, 0);
                String tableApplicationNo = (String) model.getValueAt(rowIndex, 2);
                UserDao userDao = new UserDao();
                PaymentDao paymentDao = new PaymentDao();

                User user = userDao.getUserDetails(ID);
                selectedUser = user;

                Payment payment = paymentDao.getPaymentDetails(user.getId());

                resetPage();

                setUserDetailsOnInputes(user);

                applicationNo.setMyText(tableApplicationNo);

                if (user.getDob() != null) {
                    dobInput.setMyText(user.getDob().toString());
                }

                totalGivenInput.setMyText(Integer.toString(payment.getTotalGiven()));
                totalDecidedInput.setMyText(Integer.toString(payment.getTotalDecide()));
                paymentStatus.setSelectedItem(payment.getPaymentStatus());

                LLApplication llApplication = llAppDao.getLLApplicationDetails(appDao.getApplicationDetails(user.getId()).getApp_type_id());

                applicationtStatus.setSelectedItem(llApplication.getStatus());
                if (llApplication.getApp_date() != null) {
                    applicationDate.setMyText(llApplication.getApp_date().toString());
                }

            }
        });
    }

    public void setUserDetailsOnInputes(User user) {
        if (user != null) {
            if (user.getFirstName() != null) {
                firstNameInput.setMyText(user.getFirstName());
            }
            if (user.getMiddleName() != null) {
                middleNameInput.setMyText(user.getMiddleName());
            }

            if (user.getLastName() != null) {
                lastNameInput.setMyText(user.getLastName());
            }
            if (user.getEmail() != null) {
                emailInput.setMyText(user.getEmail());
            }
            if (user.getMobileNumber() != null) {
                mobileNoInput.setMyText(user.getMobileNumber());
            }
        }

    }

    public void resetPage() {
        firstNameInput.setPlaceholder(SystemStrings.FIRST_NAME);
        middleNameInput.setPlaceholder(SystemStrings.MIDDLE_NAME);
        lastNameInput.setPlaceholder(SystemStrings.LAST_NAME);
        dobInput.setPlaceholder(SystemStrings.DOB);
        applicationNoInput.setPlaceholder(SystemStrings.APPLICATION_NO);
        applicationDate.setPlaceholder(SystemStrings.APPLICATION_DATE);
        totalGivenInput.setPlaceholder(SystemStrings.TOTAL_GIVEN);
        totalDecidedInput.setPlaceholder(SystemStrings.TOTAL_DECIDED);
        mobileNoInput.setPlaceholder(SystemStrings.MOBILE_NO);
        emailInput.setPlaceholder(SystemStrings.EMAIL);
        applicationNo.setPlaceholder(SystemStrings.APPLICATION_NO);
    }

    public void resetSearchInputSection() {
        nameInput.setPlaceholder(SystemStrings.NAME_INPUT);
        dateInput.setPlaceholder(SystemStrings.APPLICATION_DATE);
        applicationNoInput.setPlaceholder(SystemStrings.APPLICATION_NO);
        covComboBox.setSelectedIndex(0);
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Searching Inputes Cleared Successfully");

    }

    public void setInputesEditable(boolean isEditable) {
        firstNameInput.setEditable(isEditable);
        middleNameInput.setEditable(isEditable);
        lastNameInput.setEditable(isEditable);
        dobInput.setEditable(isEditable);
        applicationNo.setEditable(isEditable);
        applicationDate.setEditable(isEditable);
        totalGivenInput.setEditable(isEditable);
        totalDecidedInput.setEditable(isEditable);
        mobileNoInput.setEditable(isEditable);
        emailInput.setEditable(isEditable);
        applicationtStatus.setEditable(isEditable);

    }
}
