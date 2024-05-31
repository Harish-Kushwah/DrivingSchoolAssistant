package javaswingdev.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javaswingdev.system.SystemColor;
import javaswingdev.system.SystemFonts;
import javaswingdev.system.SystemStrings;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.dao.UserDao;
import model.entity.User;
import net.miginfocom.swing.MigLayout;
import raven.toast.Notifications;
import util.MyDate;
import util.swing.button.MyResetButton;
import util.swing.button.MySubmitButton;

/**
 *
 * @author haris
 */
/**
 *
 * @author haris
 */
public class Form_UpdateApplications extends TemplatePage {

    public Form_UpdateApplications() {
        super("Upadate Record");

        infoOutputPanel.add(getInfoLabel("If Application Available"), "al left,wrap 17,growx");

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new MigLayout("fillx"));

        MyResetButton clear = new MyResetButton("Clear");
        MySubmitButton update = new MySubmitButton("Update");

        buttonPanel1.setBackground(Color.white);
        buttonPanel1.add(clear, "al right");
        buttonPanel1.add(update, "al left,wrap");

        infoOutputPanel.add(buttonPanel1, "span,growx");
        this.outputPanel.add(infoOutputPanel, "growx , wrap , top,pushy");

        clear.addActionListener((ActionEvent e) -> {
            resetPage();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Inputes Cleared Successfully");

        });
        
        update.addActionListener((ActionEvent e)->{
                 updateUser();
        });

        
    }
    
    public void updateUser()
    {
        User user = getUserDetails();
        if(user!=null)
        {
            UserDao userDao = new UserDao();
          
            if(userDao.updateUserDetails(user)){
                resetTable();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "User Details Updtaed Successfully");
            }
                    
        }
    }
    
    public User getUserDetails() {
        User user = new User();
        user.setId(getSelectedUser().getId());
        user.setFirstName(firstNameInput.getText());
        user.setMiddleName(middleNameInput.getText());
        user.setLastName(lastNameInput.getText());
        user.setEmail(emailInput.getText());
        user.setMobileNumber(mobileNoInput.getText());
        if (!dobInput.getText().startsWith(SystemStrings.DOB)) {
            try {
                java.sql.Date date = MyDate.getSQLDate(dobInput.getText());
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
}
