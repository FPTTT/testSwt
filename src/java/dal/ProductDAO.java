/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext{
    public List<Product> getAll(){
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Product p = new Product(rs.getInt(1), 
                        rs.getString(2),
                        rs.getDouble(3), 
                        rs.getInt(4));
                list.add(p);
            }
            
        } catch (SQLException e) {
        }
        
        return list;
    }
    
    
    public Product getProdctById(int id){       
        String sql = "select * from Product where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                Product p = new Product(id, 
                        rs.getString(2),
                        rs.getDouble(3), 
                        rs.getInt(4));
                return p;
            }
            
        } catch (SQLException e) {
        }
        
        return null;
    }
}
