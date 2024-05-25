/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
            String sql = "INSERT INTO public.user(first_name, middle_name, last_name, mobile_no, email,dob) VALUES (?, ?, ?, ?, ?,?);";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getFirstName());
            st.setString(2, user.getMiddleName());
            st.setString(3, user.getLastName());
            st.setString(4, user.getMobileNumber());
            st.setString(5, user.getEmail());
            st.setDate(6,user.getDob());
            
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
   
   public User getUserDetails(String mobile_no)
   {
       try{
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.user where mobile_no = ?;";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, mobile_no);
           
            ResultSet set = st.executeQuery();
            
            User user = new User();
            while(set.next()){
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                user.setDob(set.getDate("dob"));
                return user;
            }
       }
       
       catch(Exception exp)
       {
           exp.printStackTrace();
       }
       return new User();    
   }
   
   public ArrayList<User> getAllUserDetails()
   {
       ArrayList<User> list = new ArrayList();
        try{
            connection = ConnectionProvider.getConnection();
            String sql = "Select * from public.user";
            
            PreparedStatement st = connection.prepareStatement(sql);
           
            ResultSet set = st.executeQuery();
            
            while(set.next()){
                 User user = new User();
                user.setId(set.getInt("id"));
                user.setFirstName(set.getString("first_name"));
                user.setMiddleName(set.getString("middle_name"));
                user.setLastName(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setMobileNumber(set.getString("mobile_no"));
                list.add(user);
            }
       }
       
       catch(Exception exp)
       {
           exp.printStackTrace();
       }
        return list;
   }
}
