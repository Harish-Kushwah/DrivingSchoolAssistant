package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.entity.Application;
import model.entity.ApplicationCOV;
import model.helper.ConnectionProvider;

/**
 *
 * @author haris
 */
public class ApplicationCOVDao {
      private Connection connection = null;
   
   public boolean addApplicationCOVDetails(ApplicationCOV application)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "INSERT INTO public.applicationcov(cov_id, app_id) VALUES (?, ?);";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, application.getCov_id());
            st.setInt(2, application.getApp_id());            
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
  public int getApplicationCOVId(int app_id , int cov_id)
  {
      try{
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.applicationcov where app_id = ? and cov_id=?;";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, app_id);
            st.setInt(2, cov_id);
           
            ResultSet set = st.executeQuery();
            
         
            while(set.next()){
                return set.getInt("id");
            }
       }
       
       catch(Exception exp)
       {
           exp.printStackTrace();
       }
       return -1;    
  }
}
