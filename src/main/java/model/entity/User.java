package model.entity;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaswingdev.system.SystemStrings;

/**
 *
 * @author haris
 */
public class User {

    private int id;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", email=" + email + ", validatationErrorMessage=" + validatationErrorMessage + '}';
    }
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String validatationErrorMessage;
    private Date dob;

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getValidatationErrorMessage() {
        return validatationErrorMessage;
    }

    public Date getDob() {
        return dob;
    }

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
        Pattern validNamePattern = Pattern.compile("^[A-Za-z]{2,29}$");
        Pattern validMobileNoPattern = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
        Pattern validEmailPattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@" + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$");

        
        if (this.firstName.equals(SystemStrings.FIRST_NAME)) {
            this.validatationErrorMessage = "Enter First name";
            return false;
        }
        else{
            Matcher matcher = validNamePattern.matcher(this.firstName);
            if (matcher.matches() == false) {
                this.validatationErrorMessage = "Enter Valid First Name";
                return false;
            }
        }
        
        if (!this.middleName.equals(SystemStrings.MIDDLE_NAME)) {
            Matcher matcher = validNamePattern.matcher(this.middleName);
            if (matcher.matches() == false) {
                this.validatationErrorMessage = "Enter Valid middle Name";
                return false;
            }
        }
        else{
            this.middleName = null; 
        }
        
        if (!this.lastName.equals(SystemStrings.LAST_NAME)) {
            Matcher matcher = validNamePattern.matcher(this.lastName);
            if (matcher.matches() == false) {
                this.validatationErrorMessage = "Enter Valid Last Name";
                return false;
            }
        }
        else{
            this.lastName = null;
        }
        
        if (this.mobileNumber.equals(SystemStrings.MOBILE_NO)) {
            this.validatationErrorMessage = "Enter Mobile Number";
            return false;

        } else {
            Matcher matcher = validMobileNoPattern.matcher(this.mobileNumber);
            if (matcher.matches() == false) {
                this.validatationErrorMessage = "Enter Valid Mobile Number";
                return false;
            }
        }

        /*
          Make the email null is it is empty
        */
        if(this.email.equals(SystemStrings.EMAIL)){
            this.email = null;
            
        }
        else{
            Matcher matcher = validEmailPattern.matcher(this.email);
            if(matcher.matches() == false){
             this.validatationErrorMessage = "Enter valid email";
             return false;
            }
        }
       
        return true;
    }

    public String getVlidationErrorMessage() {
        return this.validatationErrorMessage;
    }

}
