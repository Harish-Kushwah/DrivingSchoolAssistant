package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.entity.COV;
import model.helper.ConnectionProvider;

/**
 *
 * @author haris
 */
public class COVDao {
    private Connection connection = null;
   
   public boolean addCOVDetails(COV cov)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "INSERT INTO public.cov(cov_name)VALUES (?);";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cov.getCov_name());          
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
   
   public int getCOVId(String cov_name)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.cov where cov_name = ?;";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cov_name);
           
            ResultSet set = st.executeQuery();
            
           
            while(set.next()){
               return set.getInt("id");
            }
       }
       
       catch(Exception exp)
       {
           exp.printStackTrace();
       }
       return -1; // no cov found    
   }
}
