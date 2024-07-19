package javaswingdev.form;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javaswingdev.swing.RoundPanel;
import javaswingdev.system.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import model.dao.UserDao;
import model.entity.User;
import net.miginfocom.swing.MigLayout;

import raven.crazypanel.CrazyPanel;
import raven.toast.Notifications;
import util.swing.MyJScrollPane;
import util.swing.MyJTextField;
import util.swing.MyTitlePanel;
import util.swing.button.MyResetButton;
import util.swing.button.MySubmitButton;

/**
 *
 * @author haris
 */
public class Form_AddNewTransaction extends CrazyPanel {

    MyJTextField firstName = new MyJTextField("First Name");
    MyJTextField middleName = new MyJTextField("Middle Name");
    MyJTextField lastName = new MyJTextField("Last Name");
    MyJTextField mobileNo = new MyJTextField("Enter Mobile No");
    MyJTextField email = new MyJTextField("Enter Email ");
    MyJTextField dob = new MyJTextField("Enter DOB");

    public Form_AddNewTransaction() {

//        this.setRound(10);
        setLayout(new MigLayout("fillx , insets 15"));

        /* Header of the form with the gradient line below */
        add(new MyTitlePanel("Add New Transaction"), "spanx,wrap 25,growx ");

        RoundPanel panel = new RoundPanel();
        panel.setLayout(new MigLayout("fillx,inset 10", "", "[][]10[][]10[][]10[][]10"));
        panel.setBackground(Color.WHITE);
        panel.setRound(10);
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        addFormSeperator(panel, "Personal Details");

        panel.add(new JLabel("First Name"), "al right,growx");
        panel.add(new JLabel("Middle Name"), "al right,growx");
        panel.add(new JLabel("Last Name"), "al right,wrap,growx");

        panel.add(firstName, "pushx,growx");
        panel.add(middleName, "pushx,growx");
        panel.add(lastName, "wrap,pushx,growx");

        panel.add(new JLabel("Mobile No"), "al right,growx");
        panel.add(new JLabel("Email"), "al right,growx");
        panel.add(new JLabel("DOB"), "al right,wrap,growx");

        panel.add(mobileNo, "pushx,growx");
        panel.add(email, "pushx,growx");
        panel.add(dob, "wrap 15,pushx,growx");

        addFormSeperator(panel, "Payment Details");

        panel.add(new JLabel("Application No"), "al right,growx");
        panel.add(new JLabel("Total Decided"), "al right,growx");
        panel.add(new JLabel("Given"), "al right,wrap,growx");

        panel.add(new MyJTextField("Enter Application No"), "pushx,growx");
        panel.add(new MyJTextField("Rs.9999"), "pushx,growx");
        panel.add(new MyJTextField("Rs.9999"), "wrap,pushx,growx");

        panel.add(new JLabel("Payment Status"), "al right,growx");
        panel.add(new JLabel("Transaction Date"), "al right,growx");
        panel.add(new JLabel("Transaction Type"), "al right,wrap,growx");

        panel.add(new JComboBox(new String[]{"Pending", "Completed"}), "pushx,growx");
        panel.add(new MyJTextField("11/11/2024"), "pushx,growx");
        panel.add(new JComboBox(new String[]{"Cash", "Phone Pay"}), "wrap 20,pushx,growx");

        panel.add(new JLabel(""));
        panel.add(new MyResetButton("Clear"), "split 2 , al center");

        MySubmitButton submit = new MySubmitButton("Add");
        panel.add(submit, "wrap 50");
        submit.addActionListener((e) -> {
            saveUserDetails();
        });

        add(new MyJScrollPane(panel), "growx");

    }

    private void saveUserDetails() {
        User user = new User();
        user.setFirstName(firstName.getText());
        user.setMiddleName(middleName.getText());
        user.setLastName(lastName.getText());
        user.setMobileNumber(mobileNo.getText());
        user.setEmail(email.getText());

        if (user.validate()) {
            if (new UserDao().addUserDetails(user)) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_RIGHT, "User details saved");
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Unable to saved user details");

            }
        } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Enter valid user details");

        }

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
