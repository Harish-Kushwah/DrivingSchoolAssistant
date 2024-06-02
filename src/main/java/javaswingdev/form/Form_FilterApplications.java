package javaswingdev.form;

import java.awt.Color;
import java.util.ArrayList;
import javaswingdev.swing.RoundPanel;
import javaswingdev.swing.table.TablePanel;
import javaswingdev.system.SystemStrings;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.dao.ApplicationCOVDao;
import model.dao.ApplicationDao;
import model.dao.COVDao;
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
import util.swing.MyTitlePanel;
import util.swing.button.MyResetButton;
import util.swing.button.MySubmitButton;

/**
 *
 * @author haris
 */
public class Form_FilterApplications extends CrazyPanel {

    ArrayList<JCheckBox> selectedCOV = new ArrayList();
    TablePanel outputPanel;
    JLabel totalApplication = new JLabel("0");

    public Form_FilterApplications() {

        setLayout(new MigLayout("fillx , insets 10 "));

        //===================================================================================
        /* Header of the form with the gradient line below */
        add(new MyTitlePanel("Filter Applications"), "spanx,wrap 5,growx ");
        //===================================================================================

        /**
         * panel ->panel panel panel ->mig mig s3 mig s2 s3 panel table
         */
        JPanel pagePanel = new JPanel(new MigLayout("fillx "));

        //----------------------------------
        RoundPanel inputPanel = new RoundPanel();
        inputPanel.setLayout(new MigLayout("fillx ,inset 15", "[]20[]20[]"));
        inputPanel.setRound(10);
        inputPanel.setBackground(Color.white);

        JPanel covPanel = new JPanel(new MigLayout("fillx", "30[]5[]30[]5[]"));
        covPanel.setBackground(Color.white);

        covPanel.add(new MySubtitle("COV Filter"), "wrap,span,al left");
        addCheckBox(covPanel);
        JPanel dateFilterPanel = new JPanel(new MigLayout("fillx", ""));
        dateFilterPanel.setBackground(Color.white);
        dateFilterPanel.add(new MySubtitle("Date Filter"), "wrap,span,al center");
        dateFilterPanel.add(new JLabel("Date"), "al right");
        dateFilterPanel.add(new MyJTextField("From"), "pushx,growx");
        dateFilterPanel.add(new MyJTextField("To"), "wrap,pushx,growx");

        dateFilterPanel.add(new JLabel("Completed On"), "al right");
        dateFilterPanel.add(new MyJTextField("11/11/2024"), "span,wrap,pushx,growx");

        dateFilterPanel.add(new JLabel("Expired On"), "al right");
        dateFilterPanel.add(new MyJTextField("11/11/2024"), "span,wrap,pushx,growx");

        JPanel totalApplicationsPanel = new JPanel(new MigLayout());
        totalApplicationsPanel.setBackground(Color.white);
        totalApplicationsPanel.add(new MySubtitle("Other Filters"), "wrap 15,span,al center");
        totalApplicationsPanel.add(new JLabel("Today"), "al right ");
        totalApplicationsPanel.add(new JCheckBox(), "wrap");

        totalApplicationsPanel.add(new JLabel("Previous Month"), "al right");
        totalApplicationsPanel.add(new JCheckBox(), "wrap");

        totalApplicationsPanel.add(new JLabel("Resent"), "al right");
        totalApplicationsPanel.add(new MyJTextField("5"), "span,wrap,growx");

        inputPanel.add(covPanel, "growx");
        inputPanel.add(dateFilterPanel, "growx");
        inputPanel.add(totalApplicationsPanel, "growx");

        //-------------------------------
        pagePanel.add(inputPanel, "wrap,growx");

        JPanel infoPanel = new JPanel(new MigLayout("fillx"));

        infoPanel.add(new MySubtitle("Total Applications :"), "al right");
        infoPanel.add(totalApplication, "al left");

        MyResetButton clear = new MyResetButton("Clear");
        clear.addActionListener((e) -> {

            for (JCheckBox chk : selectedCOV) {
                System.out.print(chk.getText() + " ");
            }

            System.out.println();

        });
        infoPanel.add(clear, "al right");
        infoPanel.add(new MySubmitButton("Print"), "wrap,al left");
        infoPanel.setBackground(Color.white);
        pagePanel.add(infoPanel, "wrap,growx");

        //----------------------------  
        String columns[] = new String[]{
            "User ID", "Name", "App No", "Mob No.", "App Date", "App Status"
        };
        outputPanel = new TablePanel(columns);

        UserDao userDao = new UserDao();
        ArrayList<User> allUser = userDao.getAllUserDetails();
        setTable(allUser);

        //--------------------------------------------------------
        pagePanel.add(new MyJScrollPane(outputPanel), "growx");

        add(new MyJScrollPane(pagePanel), "growx");

    }

    public void addCheckBox(JPanel covpanel) {
        String allCOV[] = SystemStrings.COV;

        int size = allCOV.length;
        JCheckBox allChk = new JCheckBox("ALL");
        covpanel.add(allChk, "al left");
        allChk.addItemListener((i) -> {
            UserDao userDao = new UserDao();
            ArrayList<User> allUser = userDao.getAllUserDetails();
            setTable(allUser);

        });

        for (int i = 0; i < size; i++) {
            JCheckBox chk = new JCheckBox(allCOV[i]);
            if (i % 2 != 0) {
                covpanel.add(chk, "al left");
            } else {
                covpanel.add(chk, "wrap , al left");

            }

            chk.addItemListener((e) -> {
                if (chk.isSelected()) {
                    if (allChk.isSelected()) {
                        allChk.setSelected(false);
                    }

                    selectedCOV.add(chk);
                } else {
                    selectedCOV.remove(chk);
                }
                setDetailsOnSelectedCheckBox();
            });

        }

    }

    public void setDetailsOnSelectedCheckBox() {
        UserDao userDao = new UserDao();
        COVDao covdao = new COVDao();
        ApplicationCOVDao appCovDao = new ApplicationCOVDao();

        ArrayList<Integer> covIdList = new ArrayList();
        for (JCheckBox check : selectedCOV) {
            covIdList.add(covdao.getCOVId(check.getText()));
        }
        ArrayList<Integer> allAppId = appCovDao.getApplicationId(covIdList);
        outputPanel.removeAllRow();
        for (Integer id : allAppId) {
            setTable(userDao.getAllCOVApplicationUserDetails(id));
        }
        totalApplication.setText(Integer.toString(allAppId.size()));
    }

    public void setTable(ArrayList<User> allUser) {

        ApplicationDao appDao = new ApplicationDao();
        LLApplicationDao llAppDao = new LLApplicationDao();
        totalApplication.setText(Integer.toString(allUser.size()));
        for (User user : allUser) {
            LLApplication llApplication = llAppDao.getLLApplicationDetails(appDao.getApplicationDetails(user.getId()).getApp_type_id());
            String fullName = new FullName(user).getFullName();
            outputPanel.addRow(new Object[]{user.getId(), fullName, llApplication.getApp_no(), user.getMobileNumber(), llApplication.getApp_date(), llApplication.getStatus()});
        }
    }

}
