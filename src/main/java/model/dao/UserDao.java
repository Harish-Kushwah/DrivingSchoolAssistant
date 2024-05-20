/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.entity.User;
import model.helper.ConnectionProvider;

/**
 *
 * @author haris
 */
public class UserDao {
   private Connection connection = null;
   
   public boolean addUserDetails(User user)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "INSERT INTO public.user(first_name, middle_name, last_name, mobile_no, email) VALUES (?, ?, ?, ?, ?);";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getFirstName());
            st.setString(2, user.getMiddleName());
            st.setString(3, user.getLastName());
            st.setString(4, user.getMobileNumber());
            st.setString(5, user.getEmail());
            
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
}
