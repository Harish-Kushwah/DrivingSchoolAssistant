package javaswingdev.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import model.dao.ApplicationDao;
import model.dao.LLApplicationDao;
import model.dao.UserDao;
import model.entity.Application;
import model.entity.User;
import net.miginfocom.swing.MigLayout;
import raven.toast.Notifications;
import util.swing.button.MyDeleteButton;
import util.swing.button.MyResetButton;
import util.swing.button.MySubmitButton;

/**
 *
 * @author haris
 */
public class Form_DeleteApplications extends TemplatePage {

    public Form_DeleteApplications() {
        super("Delete Record");

        infoOutputPanel.add(getInfoLabel("If Application Available"), "al left,wrap 17,growx");

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new MigLayout("fillx"));

        MyResetButton clear = new MyResetButton("Clear");
        MyDeleteButton delete = new MyDeleteButton("Delete");

        buttonPanel1.setBackground(Color.white);
        buttonPanel1.add(clear, "al right");
        buttonPanel1.add(delete, "al left,wrap");

        infoOutputPanel.add(buttonPanel1, "span,growx");
        outputPanel.add(infoOutputPanel, "growx , wrap , top,pushy");

        setInputesEditable(false);

        delete.addActionListener((ActionEvent e) -> {
            deleteUserDetails();
            resetPage();
            clearUser();
        });

        clear.addActionListener((ActionEvent e) -> {
            resetPage();
            clearUser();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Inputes Cleared Successfully");
        });

    }

    public void deleteUserDetails() {
        User user = getSelectedUser();
        UserDao userDao = new UserDao();
        if (user != null) {

            ApplicationDao applicationDao = new ApplicationDao();

            Application application = applicationDao.getApplicationDetails(user.getId());
            if (application != null) {
                LLApplicationDao llAppDao = new LLApplicationDao();
                if (llAppDao.removeLLApplicationDetails(application.getApp_type_id())) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Application Removed Successfully");
                }
            }

            if (userDao.removeUserDetails(user.getId())) {
                resetTable();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "User Removed Successfully");
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Unable to Removed User");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "No User Selected");

        }
    }
}
