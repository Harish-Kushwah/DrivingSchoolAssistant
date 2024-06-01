package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.entity.Enrollment;
import model.entity.Payment;
import model.helper.ConnectionProvider;

/**
 *
 * @author haris
 */
public class PaymentDao {
   private Connection connection = null;
   
   public boolean addPaymentDetails(Payment payment)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "INSERT INTO public.payment(total_given, total_decided, status, user_id)VALUES ( ?, ?, ?, ?);";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, payment.getTotalGiven());
            st.setInt(2, payment.getTotalDecide());  
            st.setString(3, payment.getPaymentStatus());
            st.setInt(4, payment.getUserId());
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
   public boolean updatePaymentDetails(Payment payment)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "UPDATE  public.payment set total_given = ? , total_decided = ? , status = ? where user_id = ?;";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, payment.getTotalGiven());
            st.setInt(2, payment.getTotalDecide());  
            st.setString(3, payment.getPaymentStatus());
            st.setInt(4, payment.getUserId());
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
   
   public Payment getPaymentDetails(int userId)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.payment where user_id = ?;";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
           
            ResultSet set = st.executeQuery();
            
            Payment payment = new Payment();
            while(set.next()){
                payment.setId(set.getInt("id"));
                payment.setTotalGiven(set.getInt("total_given"));
                payment.setTotalDecide(set.getInt("total_decided"));
                payment.setPaymentStatus(set.getString("status"));
                payment.setUserId(userId);
                return payment;
            }
       }
       
       catch(Exception exp)
       {
           exp.printStackTrace();
       }
       return new Payment();    
   }
}
