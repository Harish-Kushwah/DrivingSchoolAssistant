package model.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author haris
 */
public class Payment {

    private int id, userId;
    private int totalGiven;
    private int totalDecide;
    private String paymentStatus, validatationErrorMessage;

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", userId=" + userId + ", totalGiven=" + totalGiven + ", totalDecide=" + totalDecide + ", paymentStatus=" + paymentStatus + ", validatationErrorMessage=" + validatationErrorMessage + '}';
    }
    

    public String getValidatationErrorMessage() {
        return validatationErrorMessage;
    }

    public void setValidatationErrorMessage(String validatationErrorMessage) {
        this.validatationErrorMessage = validatationErrorMessage;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalGiven() {
        return totalGiven;
    }

    public void setTotalGiven(int totalGiven) {
        this.totalGiven = totalGiven;
    }

    public int getTotalDecide() {
        return totalDecide;
    }

    public void setTotalDecide(int totalDecide) {
        this.totalDecide = totalDecide;
    }

    public boolean validate() {

        Pattern validAppNoPattern = Pattern.compile("^[0-9]{2,29}");

        Matcher matcher = validAppNoPattern.matcher(Integer.toString(this.totalGiven));
        if (matcher.matches() == false) {
            this.validatationErrorMessage = "Enter Valid Total given.";
            return false;
        }

        return true;
    }
}
