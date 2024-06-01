package javaswingdev.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaswingdev.system.SystemStrings;
import javax.swing.JPanel;
import model.dao.ApplicationDao;
import model.dao.LLApplicationDao;
import model.dao.PaymentDao;
import model.dao.UserDao;
import model.entity.Application;
import model.entity.LLApplication;
import model.entity.Payment;
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
            clearUser();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Inputes Cleared Successfully");

        });

        update.addActionListener((ActionEvent e) -> {
            if (updateUser() && updatePaymentDetails() && updateLLApplicationDetails()) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Details Updtaed Successfully");
            }

        });

    }

    public boolean updateUser() {
        User user = getUserDetails();
        if (user != null) {
            UserDao userDao = new UserDao();

            if (userDao.updateUserDetails(user)) {
                resetTable();
                return true;
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "User Details Unable to Save");
            }

        }
        return false;
    }

    public boolean updatePaymentDetails() {
        User user = getSelectedUser();
        Payment payment = getPaymentDetails();

        if (user != null && payment != null) {
            payment.setUserId(user.getId());
            PaymentDao paymentDao = new PaymentDao();
            if (paymentDao.updatePaymentDetails(payment)) {
                return true;
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Payment Details Not Updtaed");
            }
        }
        return false;
    }

    public boolean updateLLApplicationDetails() {
        User user = getUserDetails();

        if (user != null) {

            ApplicationDao appDao = new ApplicationDao();
            Application application = appDao.getApplicationDetails(user.getId());

            if (application != null) {
                LLApplication llapplication = getLLApplicationDetails();
                if (llapplication != null) {
                    llapplication.setId(application.getApp_type_id());
                    LLApplicationDao llapplicationDao = new LLApplicationDao();
                    if (llapplicationDao.updateLLApplicationDetails(llapplication)) {
                        resetTable();
                        return true;
                    } else {
                        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Application Details Unbale to Save");
                    }

                }
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "No Application Found");

            }
        }
        return false;

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

    public User getUserDetails() {
        User selectedUser = getSelectedUser();

        if (selectedUser != null) {
            User user = new User();
            user.setId(selectedUser.getId());

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
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "No User selected");

        }
        return null;

    }

    public LLApplication getLLApplicationDetails() {

        LLApplication llapplication = new LLApplication();
        llapplication.setApp_no(applicationNo.getText());
        llapplication.setStatus((String) applicationtStatus.getSelectedItem());

        if (llapplication.validate()) {
            return llapplication;
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, llapplication.getValidatationErrorMessage());
        }
        return null;
    }
}
