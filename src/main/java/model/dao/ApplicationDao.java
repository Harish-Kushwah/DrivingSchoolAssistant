package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.entity.Application;
import model.entity.LLApplication;
import model.helper.ConnectionProvider;

/**
 *
 * @author haris
 */
public class ApplicationDao {
    private Connection connection = null;
   
   public boolean addApplicationDetails(Application application)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "INSERT INTO public.application(user_id, app_type_id, licence_type) VALUES (?, ?, ?);";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, application.getUser_id());
            st.setInt(2, application.getApp_type_id());
            st.setString(3, application.getLicence_type());
            
            if(st.executeUpdate()!=0){
                return true;
            }
       
       }
       catch(Exception exp)
       {
           exp.printStackTrace();
       }
       return false;     
   }
    public Application getApplicationDetails(int user_id)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.application where user_id = ?;";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user_id);
           
            ResultSet set = st.executeQuery();
            
            Application application = new Application();
            while(set.next()){
                application.setId(set.getInt("id"));
                application.setApp_type_id(set.getInt("app_type_id"));
                application.setLicence_type(set.getString("licence_type"));
                application.setUser_id(user_id);
                return application;
            }
       }
       
       catch(Exception exp)
       {
           exp.printStackTrace();
       }
       return new Application();    
   }
   
   
    
}
