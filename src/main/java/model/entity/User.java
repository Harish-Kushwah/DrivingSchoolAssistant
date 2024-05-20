package model.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaswingdev.system.SystemStrings;

/**
 *
 * @author haris
 */
public class User {

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String validatationErrorMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validate() {
        if (this.firstName.equals(SystemStrings.FIRST_NAME)) {
            this.validatationErrorMessage = "Enter First name";
            return false;
        }
        else{
            Pattern pattern = Pattern.compile("^[A-Za-z]{2,29}$");
            Matcher matcher = pattern.matcher(this.firstName);
            if (matcher.matches() == false) {
                this.validatationErrorMessage = "Enter Valid Name";
                return false;
            }
        }
        if (this.mobileNumber.equals(SystemStrings.MOBILE_NO)) {

            this.validatationErrorMessage = "Enter Mobile Number";
            return false;

        } else {

            Pattern pattern = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
            Matcher matcher = pattern.matcher(this.mobileNumber);
            if (matcher.matches() == false) {
                this.validatationErrorMessage = "Enter Valid Mobile Number";
                return false;
            }
        }

        return true;
    }

    public String getVlidationErrorMessage() {
        return this.validatationErrorMessage;
    }

}
