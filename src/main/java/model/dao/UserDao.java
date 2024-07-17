package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import model.entity.Application;
import model.entity.User;
import model.helper.ConnectionProvider;

/**
 *
 * @author haris
 */
public class UserDao {

    private Connection connection = null;

    public boolean addUserDetails(User user) {
        try {
            connection = ConnectionProvider.getConnection();
            String sql = "INSERT INTO public.user(first_name, middle_name, last_name, mobile_no, email,dob) VALUES (?, ?, ?, ?, ?,?);";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getFirstName());
            st.setString(2, user.getMiddleName());
            st.setString(3, user.getLastName());
            st.setString(4, user.getMobileNumber());
            st.setString(5, user.getEmail());
            st.setDate(6, user.getDob());

            if (st.executeUpdate() != 0) {
                return true;
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return false;
    }

    public boolean updateUserDetails(User user) {
        try {
            connection = ConnectionProvider.getConnection();
            String sql = "UPDATE public.user set first_name =? , middle_name = ? , last_name = ?, mobile_no = ? , email = ? ,dob = ? where id = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getFirstName());
            st.setString(2, user.getMiddleName());
            st.setString(3, user.getLastName());
            st.setString(4, user.getMobileNumber());
            st.setString(5, user.getEmail());
            st.setDate(6, user.getDob());
            st.setInt(7, user.getId());

            if (st.executeUpdate() != 0) {
                return true;
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return false;
    }

    public boolean removeUserDetails(int user_id) {
        try {
            connection = ConnectionProvider.getConnection();
            String sql = "Delete from public.user where id = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user_id);

            if (st.executeUpdate() != 0) {
                return true;
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return false;
    }

    public User getUserDetails(String mobile_no) {
        try {
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.user where mobile_no = ?;";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, mobile_no);

            ResultSet set = st.executeQuery();

            User user = new User();
            while (set.next()) {
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                user.setDob(set.getDate("dob"));
                return user;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return new User();
    }

    public User getUserDetailsUpTo(java.sql.Date date) {
        try {
            connection = ConnectionProvider.getConnection();
            String sql1 = "Select * from public.user where mobile_no = ?;";
            String sql = "select * from public.user where MONTH(date) = MONTH(now()) and YEAR(date) = YEAR(now());";
            String sql2 = "select * from public.user where MONTH(date) = MONTH(?) and YEAR(?) = YEAR(?);";

            PreparedStatement st = connection.prepareStatement(sql2);
//            st.setDate(1, date);
//            st.setDate(2, date);
//            st.setDate(3, date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.YEAR;
            int month = cal.MONTH;
            int day = cal.DAY_OF_MONTH;
            Timestamp time = new Timestamp(year, month, day, 0, 0, 0,0);

            st.setTimestamp(1, time);

            ResultSet set = st.executeQuery();

            User user = new User();
            while (set.next()) {
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                user.setDob(set.getDate("dob"));
                return user;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return new User();
    }

    public User getUserDetails(int userId) {
        try {
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.user where id = ?;";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);

            ResultSet set = st.executeQuery();

            User user = new User();
            while (set.next()) {
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                user.setDob(set.getDate("dob"));
                return user;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return new User();
    }

    public ArrayList<User> getAllUserDetails() {
        ArrayList<User> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.user order by id asc";

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet set = st.executeQuery();

            while (set.next()) {
                User user = new User();
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                list.add(user);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }
    public ArrayList<User> getAllUserDetailsUpTo(java.sql.Date from , java.sql.Date to) {
        ArrayList<User> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
            String fromStr = " \'"+from.toString() +" 00:00:00" +  "\'";
            String toStr = " \'"+to.toString() +" 00:00:00" +  "\'";
            String sql = " select * from public.user where created >= timestamp " + fromStr + " and created <= timestamp " + toStr;

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet set = st.executeQuery();
            while (set.next()) {
                User user = new User();
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                list.add(user);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }
    public int totalDaysCompleted(int id,java.sql.Date from)
    {
        int daysCompleted = -1;
        try{
            connection = ConnectionProvider.getConnection();
            
            String sql = "select  ? - DATE(created) as days FROM public.user where id = ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1, from);
            st.setInt(2, id);
            
            ResultSet set = st.executeQuery();
            while(set.next())
            {
                daysCompleted = set.getInt("days");
            }
           
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return daysCompleted;
    }
    
    public ArrayList<User> getAllUserDetailsUpTo(java.sql.Date to) {
        ArrayList<User> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
//            String toStr = " \'"+to.toString() +" 00:00:00" +  "\'";
            String sql = " select * from public.user where DATE(created) <= ? " ;

            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1, to);
            ResultSet set = st.executeQuery();
            while (set.next()) {
                User user = new User();
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                list.add(user);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }
    public ArrayList<User> getAllUserDetailsCompletedOn(java.sql.Date to) {
        ArrayList<User> list = new ArrayList();
        try {
          ArrayList<User> userList = getAllUserDetailsUpTo(to);
          for(User user:userList){
              int days = totalDaysCompleted(user.getId(),to);
              if( days >30){
                  list.add(user);
              }
          }
          
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }
    public ArrayList<User> getAllUserDetailsExpiredOn(java.sql.Date to) {
        ArrayList<User> list = new ArrayList();
        try {
          ArrayList<User> userList = getAllUserDetailsUpTo(to);
          for(User user:userList){
              int days = totalDaysCompleted(user.getId(),to);
              System.out.println(days);
              if( days >180){
                  list.add(user);
              }
          }
          
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }

    public ArrayList<User> getTodayAllUserDetails() {
        ArrayList<User> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
            String sql = "select * from public.user where date(created) = date(current_timestamp)";

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet set = st.executeQuery();

            while (set.next()) {
                User user = new User();
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                list.add(user);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }

    public ArrayList<User> getMonthlyAllUserDetails() {
        ArrayList<User> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
            String sql = " select * from public.user where date_trunc('month',created)::date = date_trunc('month',current_timestamp)::date";

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet set = st.executeQuery();

            while (set.next()) {
                User user = new User();
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                list.add(user);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }

    public ArrayList<User> getAllLikeNameUserDetails(String name) {
        ArrayList<User> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
            StringBuffer sql = new StringBuffer("Select * from public.user where upper(first_name) like ");
            sql.append("\'");
            sql.append("%");
            sql.append(new StringBuffer(name.toUpperCase()));
            sql.append("%'");
            sql.append("or upper(middle_name) like");
            sql.append("\'");
            sql.append("%");
            sql.append(new StringBuffer(name.toUpperCase()));
            sql.append("%'");
            sql.append("or upper(last_name) like");
            sql.append("\'");
            sql.append("%");
            sql.append(new StringBuffer(name.toUpperCase()));
            sql.append("%'");
            sql.append(";");
            PreparedStatement st = connection.prepareStatement(new String(sql));

            ResultSet set = st.executeQuery();

            while (set.next()) {
                User user = new User();
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                list.add(user);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }

    public ArrayList<User> getAllLikeApplicationUserDetails(String application) {
        ApplicationDao appDao = new ApplicationDao();
        ArrayList<Application> allApplications = appDao.getAllLikeApplicationDetails(application);
        ArrayList<User> list = new ArrayList();
        for (Application app : allApplications) {
            list.add(getUserDetails(app.getUser_id()));
        }
        return list;
    }

    public ArrayList<User> getAllCOVApplicationUserDetails(int app_id) {
        ApplicationDao appDao = new ApplicationDao();
        ArrayList<Application> allApplications = appDao.getAllApplicationDetails(app_id);
        ArrayList<User> list = new ArrayList();
        for (Application app : allApplications) {
            list.add(getUserDetails(app.getUser_id()));
        }
        return list;
    }

    public ArrayList<User> getAllDateApplicationUserDetails(java.sql.Date date) {
        ApplicationDao appDao = new ApplicationDao();
        ArrayList<Application> allApplications = appDao.getAllApplicationDetails(date);
        ArrayList<User> list = new ArrayList();
        for (Application app : allApplications) {
            list.add(getUserDetails(app.getUser_id()));
        }
        return list;
    }

    public ArrayList<User> getAllDateApplicationUserDetailsUpTo(java.sql.Date date) {
        ApplicationDao appDao = new ApplicationDao();
        ArrayList<Application> allApplications = appDao.getAllApplicationDetailsUpTo(date);
        ArrayList<User> list = new ArrayList();
        for (Application app : allApplications) {
            list.add(getUserDetails(app.getUser_id()));
        }
        return list;
    }

    public int getTotalUser() {
        return getAllUserDetails().size();
    }
    
    public ArrayList<User> getResentNUserDetails(int n) {
        ArrayList<User> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
            String sql = " select * from public.user order by created desc limit ?";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, n);
            ResultSet set = st.executeQuery();

            while (set.next()) {
                User user = new User();
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                list.add(user);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }

}
