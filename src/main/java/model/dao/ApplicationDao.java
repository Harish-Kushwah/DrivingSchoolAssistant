package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.entity.Application;
import model.helper.ConnectionProvider;

/**
 *
 * @author haris
 */
public class ApplicationDao {

    private Connection connection = null;

    public boolean addApplicationDetails(Application application) {
        try {
            connection = ConnectionProvider.getConnection();
            String sql = "INSERT INTO public.application(user_id, app_type_id, licence_type) VALUES (?, ?, ?);";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, application.getUser_id());
            st.setInt(2, application.getApp_type_id());
            st.setString(3, application.getLicence_type());

            if (st.executeUpdate() != 0) {
                return true;
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return false;
    }

    public Application getApplicationDetails(int user_id) {
        try {
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.application where user_id = ?;";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user_id);

            ResultSet set = st.executeQuery();

            Application application = new Application();
            while (set.next()) {
                application.setId(set.getInt("id"));
                application.setApp_type_id(set.getInt("app_type_id"));
                application.setLicence_type(set.getString("licence_type"));
                application.setUser_id(user_id);
                return application;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return new Application();
    }

    public ArrayList<Application> getAllLikeApplicationDetails(String applicationStr) {
        ArrayList<Application> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
            StringBuffer sql = new StringBuffer("SELECT user_id FROM public.application FULL OUTER JOIN public.llapplication ON public.application.app_type_id=public.llapplication.id where app_no like ");
            sql.append("\'");
            sql.append("%");
            sql.append(new StringBuffer(applicationStr));
            sql.append("%'");
            sql.append(";");
            PreparedStatement st = connection.prepareStatement(new String(sql));

            ResultSet set = st.executeQuery();

            while (set.next()) {
                Application application = new Application();
                application.setUser_id(set.getInt(1));
                list.add(application);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }
    public ArrayList<Application> getAllApplicationDetails(java.sql.Date date) {
        ArrayList<Application> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
            String sql ="SELECT user_id FROM public.application FULL OUTER JOIN public.llapplication ON public.application.app_type_id=public.llapplication.id where public.llapplication.app_date = ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1, date);
            ResultSet set = st.executeQuery();

            while (set.next()) {
                Application application = new Application();
                application.setUser_id(set.getInt(1));
                list.add(application);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }
    public ArrayList<Application> getAllApplicationDetailsUpTo(java.sql.Date date) {
        ArrayList<Application> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
            String sql ="SELECT user_id FROM public.application FULL OUTER JOIN public.llapplication ON public.application.app_type_id=public.llapplication.id where public.llapplication.app_date = ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1, date);
            ResultSet set = st.executeQuery();

            while (set.next()) {
                Application application = new Application();
                application.setUser_id(set.getInt(1));
                list.add(application);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }
    public ArrayList<Application> getAllApplicationDetails(int app_id) {
        ArrayList<Application> list = new ArrayList();
        try {
            connection = ConnectionProvider.getConnection();
            String sql = "SELECT user_id FROM public.application FULL OUTER JOIN public.llapplication ON public.application.app_type_id=public.llapplication.id where public.llapplication.id = ?;";
          
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,app_id);
            
            ResultSet set = st.executeQuery();

            while (set.next()) {
                Application application = new Application();
                application.setUser_id(set.getInt(1));
                list.add(application);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }

}
