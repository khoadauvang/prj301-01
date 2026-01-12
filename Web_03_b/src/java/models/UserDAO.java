/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DbUtils;
import models.UserDTO;

/**
 *
 * @author DELL
 */
public class UserDAO {
    
    public UserDAO() {
    }
    
    public UserDTO searchById(String id){
        UserDTO user = null;
        
        try {
            Connection conn = DbUtils.getConnection();
            String sql = "SELECT * FROM tblUsers WHERE userID='" + id + "'";
            System.out.println(sql);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String userID = rs.getString("userID");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String roleID = rs.getString("roleID");
                boolean status = rs.getBoolean("status");
                user = new UserDTO(userID, fullName, password, roleID, status);
            }
        } catch (Exception e) {
            return null;
        }
        
        return user;
    }
    
    public UserDTO login(String username, String password){
        UserDTO user = searchById(username);
        if (user != null && user.getPassword().equals(password)){
            return user;
        } else {
            return null;
        }
    }
}
