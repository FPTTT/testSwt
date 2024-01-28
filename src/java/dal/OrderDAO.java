/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import model.Cart;
import model.Customer;
import model.Item;

/**
 *
 * @author Admin
 */
public class OrderDAO extends DBContext {

    public void addOrder(Customer u, Cart cart) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try {
            //add vao bang order
            String sql = "insert into [order] values(?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, date);
            st.setInt(2, u.getId());
            st.setDouble(3, cart.getTotalMoney());
            st.executeUpdate();
            // lay ra id cua Order vua add, de add vao orderDetail
            String sql1 = "select top 1 id from [order] order by id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();

            if (rs.next()) {
                int oid = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into [OrderLine] values(?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setInt(2, i.getProduct().getId());
                    st2.setInt(3, i.getQuantity());
                    st2.setDouble(4, i.getPrice());
                    st2.executeUpdate();
                }
            }

        } catch (SQLException e) {
        }

    }
}
