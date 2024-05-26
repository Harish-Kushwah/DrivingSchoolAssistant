package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.entity.LLApplication;
import model.helper.ConnectionProvider;

/**
 *
 * @author haris
 */
public class LLApplicationDao {
   private Connection connection = null;
   
   public boolean addLLApplicationDetails(LLApplication application)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "INSERT INTO public.LLapplication(app_no, app_date, status) VALUES (?, ?, ?);";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, application.getApp_no());
            st.setDate(2, application.getApp_date());
            st.setString(3, application.getStatus());    
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
   
   public LLApplication getLLApplicationDetails(int id)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.LLapplication where id = ?;";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
           
            ResultSet set = st.executeQuery();
            
            LLApplication application = new LLApplication();
            while(set.next()){
                application.setId(set.getInt("id"));
                application.setApp_date(set.getDate("app_date"));
                application.setStatus(set.getString("status"));
                application.setApp_no(set.getString("app_no"));
                return application;
            }
       }
       
       catch(Exception exp)
       {
           exp.printStackTrace();
       }
       return new LLApplication();    
   }
   public LLApplication getLLApplication(String app_no)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.LLapplication where app_no = ?;";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, app_no);
           
            ResultSet set = st.executeQuery();
            
            LLApplication application = new LLApplication();
            while(set.next()){
                application.setId(set.getInt("id"));
                application.setApp_date(set.getDate("app_date"));
                application.setStatus(set.getString("status"));
                application.setApp_no(set.getString("app_no"));
                return application;
            }
       }
       
       catch(Exception exp)
       {
           exp.printStackTrace();
       }
       return new LLApplication();    
   }
   
}
