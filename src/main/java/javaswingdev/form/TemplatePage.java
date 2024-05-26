package javaswingdev.form;

import java.awt.Color;
import java.util.ArrayList;
import javaswingdev.swing.RoundPanel;
import javaswingdev.swing.scroll.ScrollBar;
import javaswingdev.swing.table.TablePanel;
import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemFonts;
import javaswingdev.system.SystemStrings;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.dao.ApplicationDao;
import model.dao.LLApplicationDao;
import model.dao.UserDao;
import model.entity.LLApplication;
import model.entity.User;
import net.miginfocom.swing.MigLayout;
import pdf.FullName;
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
public class TemplatePage extends CrazyPanel {

    private final MyJTextField nameInput = new MyJTextField("Enter Name");
    private final MyJTextField applicationNoInput = new MyJTextField(SystemStrings.APPLICATION_NO);
    private TablePanel outputTablePanel;
    public JPanel outputPanel;

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
        inputPanel.add(new JComboBox(SystemStrings.COV), "growx,al right");

        inputPanel.add(new JLabel("Date"), "al right");
        inputPanel.add(new MyJTextField("11/11/2024"), "wrap 15,growx,al right");

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new MigLayout("fillx"));

        buttonPanel1.setBackground(Color.white);
        buttonPanel1.add(new MyResetButton("Clear"), "al right");
        buttonPanel1.add(new MySubmitButton("Search"), "al left,wrap");
        buttonPanel1.setBackground(Color.white);

        inputPanel.add(buttonPanel1, "span,growx");

        pagePanel.add(inputPanel, "wrap,growx");

//        pagePanel.add(inputPanel,"wrap 10,growx");
        //-------------------------------
        JPanel infoPanel = new JPanel(new MigLayout("fillx"));

        infoPanel.add(new MySubtitle("Total Applications :"), "al right");
        infoPanel.add(new MySubtitle("1234"), "al left");
//        infoPanel.add(new JLabel("Application Details"), "al Center");
//        infoPanel.add(new MySubmitButton("Print"), "wrap,al left");
        infoPanel.setBackground(Color.white);
        pagePanel.add(infoPanel, "wrap,growx 50");

        //----------------------------
        String columns[] = new String[]{
            "User ID", "Name", "App No", "Mob No.", "App Date", "App Status"
        };
//        outputTablePanel.setRowHeight(30);
        outputTablePanel = new TablePanel(columns);
        UserDao userDao = new UserDao();
        ApplicationDao appDao = new ApplicationDao();
        LLApplicationDao llAppDao = new LLApplicationDao();

        ArrayList<User> allUser = userDao.getAllUserDetails();
        for (User user : allUser) {
            LLApplication llApplication = llAppDao.getLLApplicationDetails(appDao.getApplicationDetails(user.getId()).getApp_type_id());
            String fullName = new FullName(user).getFullName();
            outputTablePanel.addRow(new Object[]{user.getId(), fullName, llApplication.getApp_no(), user.getMobileNumber(), llApplication.getApp_date(), llApplication.getStatus()});
        }

        //--------------------------------------------------------
        outputPanel = new JPanel();

        outputPanel.setLayout(new MigLayout("fillx"));
        outputPanel.add(outputTablePanel, "growx ");
        pagePanel.add(new MyJScrollPane(outputPanel), "growx");

        add(new MyJScrollPane(pagePanel), "growx");

        addRecordsBasedOnName();

    }

    public void addInfoOutputPanel(JPanel infoOutputPanel) {
        outputPanel.add(infoOutputPanel, "growx , wrap , top,pushy");
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
    }

    public void setUserDetails(ArrayList<User> allUser) {
        ApplicationDao appDao = new ApplicationDao();
        LLApplicationDao llAppDao = new LLApplicationDao();
        for (User user : allUser) {
            LLApplication llApplication = llAppDao.getLLApplicationDetails(appDao.getApplicationDetails(user.getId()).getApp_type_id());
            String fullName = new FullName(user).getFullName();
            outputTablePanel.addRow(new Object[]{user.getId(), fullName, llApplication.getApp_no(), user.getMobileNumber(), llApplication.getApp_date(), llApplication.getStatus()});
        }
    }

}