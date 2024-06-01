package model.helper;

import java.util.Random;
import model.entity.LLApplication;
import model.entity.User;
import util.MyDate;

/**
 *
 * @author haris
 */
public class RandomData {

    public User getUser() {
        User user = new User();
        user.setMobileNumber(getRandomNumber(10));
        user.setFirstName(getRandomName(5));
        user.setMiddleName(getRandomName(5));
        user.setLastName(getRandomName(5));
        user.setEmail(getRandomEmail(12));
        user.setDob(getRandomDate("-"));
        return user;

    }
    public LLApplication getLLApplication()
    {
        LLApplication application = new LLApplication();
        application.setApp_date(getRandomDate("-"));
        application.setApp_no(getRandomNumber(10));
        application.setAppStatus(getRandomStatus());
        return application;
        
    }

    public boolean getRandomStatus()
    {
         return new Random().nextBoolean();
        
    }
    public String getRandomNumber(int digit) {
        Random rand = new Random();
        String number = "";
        for (int i = 0; i < digit; i++) {
            number += Integer.toString(rand.nextInt(10));
        }
        return number;
    }
    public String getRandomNumber(int start,int end) {
        Random rand = new Random();
        String number =Integer.toString(rand.nextInt(start,end));
        return number;
    }

    public String getRandomName(int len) {
        Random rand = new Random();
        String name = "";
        for (int i = 0; i < len; i++) {
            char ch = (char) rand.nextInt(96, 123);
            if (i == 0) {
                name += Character.toUpperCase(ch);
            } else {
                name += ch;
            }
        }
        return name;
    }
    

    public String getRandomEmail(int len) {
        Random rand = new Random();
        String email = "";
        for (int i = 0; i < len; i++) {
            char ch = (char) rand.nextInt(97, 123);
            email += ch;
        }
        email += "@gmail.com";
        return email;
    }

    public java.sql.Date getRandomDate(String separator) {
        String dob = "";
        dob += getRandomNumber(2);
        dob += separator;
        dob += getRandomNumber(2);
        dob += separator;
        dob += getRandomNumber(2000,2024);

        java.sql.Date date = null;
        try {
            date = MyDate.getSQLDate(dob);
        } catch (Exception exp) {

        }
        return date;

    }

    public static void main(String[] args) {
        User user = new RandomData().getUser();
        System.out.println(user);
    }
}
