package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.entity.Enrollment;
import model.entity.User;
import model.helper.ConnectionProvider;

/**
 *
 * @author haris
 */
public class EnrollmentDao {
    private Connection connection = null;
   
   public boolean addEnrollmentDetails(Enrollment enroll)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "INSERT INTO public.enrollment(enroll_no, app_cov_id)VALUES (?, ?);";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, enroll.getEnrollmentNumber());
            st.setInt(2, enroll.getApplicationCOVid());  
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
   
   public Enrollment getEnrollDetails(String enrollmentNo)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.user where enroll_no = ?;";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, enrollmentNo);
           
            ResultSet set = st.executeQuery();
            
            Enrollment enroll = new Enrollment();
            while(set.next()){
                enroll.setId(set.getInt("id"));
                enroll.setEnrollmentNumber(set.getString("enroll_no"));
                enroll.setApplicationCOVid(set.getInt("app_cov_id"));
                return enroll;
            }
       }
       
       catch(Exception exp)
       {
           exp.printStackTrace();
       }
       return new Enrollment();    
   }
}
