package model.entity;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaswingdev.system.SystemStrings;

/**
 *
 * @author haris
 */
public class LLApplication {

    int id;
    private String app_no, status;
    private Date app_date;
    private String validatationErrorMessage;
    private boolean appStatus;


    public boolean isAppStatus() {
        return appStatus;
    }

    public void setAppStatus(boolean appStatu) {
        this.appStatus = appStatu;
    }

    public String getValidatationErrorMessage() {
        return validatationErrorMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApp_no() {
        return app_no;
    }

    public void setApp_no(String app_no) {
        this.app_no = app_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getApp_date() {
        return app_date;
    }

    public void setApp_date(Date app_date) {
        this.app_date = app_date;
    }

    public boolean validate() {
        Pattern validNamePattern = Pattern.compile("^[A-Za-z]{2,29}$");
        Pattern validAppNoPattern = Pattern.compile("^[0-9]{2,29}");

        if (this.app_no.equals(SystemStrings.APPLICATION_NO)) {
            this.validatationErrorMessage = "Enter Application Number";
            return false;
        } else {
            Matcher matcher = validAppNoPattern.matcher(this.app_no);
            if (matcher.matches() == false) {
                this.validatationErrorMessage = "Enter Valid Application No.";
                return false;
            }
        }

        return true;
    }
}
