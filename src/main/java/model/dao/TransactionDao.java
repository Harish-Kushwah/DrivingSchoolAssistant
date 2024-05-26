package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.entity.Payment;
import model.entity.Transaction;
import model.helper.ConnectionProvider;

/**
 *
 * @author haris
 */
public class TransactionDao {
  private Connection connection = null;
   
   public boolean addTransactionDetails(Transaction transaction)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "INSERT INTO public.transaction(amount, date, mode, payment_id)VALUES (?, ?, ?, ?, ?);";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, transaction.getAmount());
            st.setDate(2, transaction.getDate());  
            st.setString(3, transaction.getMode());
            st.setInt(4, transaction.getPaymentId());
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
   
//   public Payment getTransactionDetails(int userId)
//   {
//       try{
//            connection = ConnectionProvider.getConnection();
//            String sql = "Select * from public.payment where user_id = ?;";
//            
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, userId);
//           
//            ResultSet set = st.executeQuery();
//            
//            Payment payment = new Payment();
//            while(set.next()){
//                payment.setId(set.getInt("id"));
//                payment.setTotalGiven(set.getInt("total_given"));
//                payment.setTotalDecide(set.getInt("total_decided"));
//                payment.setPaymentStatus(set.getString("status"));
//                payment.setUserId(userId);
//                return payment;
//            }
//       }
//       
//       catch(Exception exp)
//       {
//           exp.printStackTrace();
//       }
//       return new Payment();    
//   }
}
