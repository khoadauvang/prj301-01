/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.UniversityDTO;
import utils.DbUtils;

/**
 *
 * @author DELL
 */
public class UniversityDAO {
    public UniversityDAO()  {
        //
    }
    
    public ArrayList<UniversityDTO> searchByColumn(String column, String value) {
        ArrayList<UniversityDTO> result = new ArrayList<>();
        
        try {
            Connection conn = DbUtils.getConnection(); //Dòng này quan trọng, học thuộc
            String sql = "SELECT * FROM tblUniversity WHERE " + column + "=?"; //Dòng này quan trọng, học thuộc
            PreparedStatement ps = conn.prepareStatement(sql); //Dòng này quan trọng, học thuộc
            ps.setString(1, value); //học thuộc
            ResultSet rs = ps.executeQuery(); //học thuộc
            
            while (rs.next()) { //extract dữ liệu từ dtb
                String id = rs.getString("id");
                String name = rs.getString("name");
                String shortName = rs.getString("shortName");
                String description = rs.getString("description");
                int foundedYear = rs.getInt("foundedYear");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String region = rs.getString("region");
                String type = rs.getString("type");
                int totalStudents = rs.getInt("totalStudents");
                int totalFaculties = rs.getInt("totalFaculties");
                boolean isDraft = rs.getBoolean("isDraft");
                // dữ liệu đủ của 1 thằng
                
                UniversityDTO u = new UniversityDTO(id, name, shortName, description, foundedYear, address, city, region, type, totalStudents, totalFaculties, isDraft);
                result.add(u);
                //end
            }
        } catch (Exception e) {
            //ko làm gì hết
        }
        return result; //một mảng ArrayList danh sách các trg ĐH
    }
    
    public ArrayList<UniversityDTO> filterByColum(String column, String value) {
        ArrayList<UniversityDTO> result = new ArrayList<>();
        try {
            Connection conn = DbUtils.getConnection();
            String sql = "SELECT * FROM tblUniversity WHERE " + column + " LIKE ?"; //QUAN TRỌNG
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + value + "%"); //QUAN TRỌNG
            System.out.println(ps.toString()); //check dòng query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String shortName = rs.getString("shortName");
                String description = rs.getString("description");
                int foundedYear = rs.getInt("foundedYear");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String region = rs.getString("region");
                String type = rs.getString("type");
                int totalStudents = rs.getInt("totalStudents");
                int totalFaculties = rs.getInt("totalFaculties");
                boolean isDraft = rs.getBoolean("isDraft");

                UniversityDTO u = new UniversityDTO(id, name, shortName, description, foundedYear, address, city, region, type, totalStudents, totalFaculties, isDraft);
                result.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<UniversityDTO> searchById(String Id) {
        return searchByColumn("id", Id);
    }
    
    public ArrayList<UniversityDTO> searchByName(String name) {
        return searchByColumn("name", name);
    }
    
    public ArrayList<UniversityDTO> filterByName(String name) {
        return filterByColum("name", name);
    }
}
