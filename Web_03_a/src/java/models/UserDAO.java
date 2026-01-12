/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class UserDAO {
    ArrayList<UserDTO> list = new ArrayList<>();
    
    public UserDAO() {
        list.add(new UserDTO("admin", "admin", "Nguyen Van A"));
        list.add(new UserDTO("user1", "user1", "Nguyen Van B"));
    }
    
    public UserDTO searchById(String id){
        for (UserDTO userDTO : list) {
            if(userDTO.getUsername().equalsIgnoreCase(id)){
                return userDTO;
            }
        }
        return null;
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
