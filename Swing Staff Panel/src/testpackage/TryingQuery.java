/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maaz
 */
public class TryingQuery {
     public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/powergym","root","");
             Statement stmt = null;
             String query = "select * from Customer;";
             stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             while(rs.next()){
                 String cid = rs.getString(1);
                 String name = rs.getString(2);
                 String age = rs.getString(3);
                 String weight = rs.getString(4);
                 String email = rs.getString(5);
                 String gender = rs.getString(6);
                 System.out.println(cid+" "+name+" "+age+" "+weight+" "+email+" "+gender);
             }
             
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
