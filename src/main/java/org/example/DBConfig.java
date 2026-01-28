package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    public static Connection getConnection() {
        Connection con = null;
        try {
            // 1. Driver Load karna
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Connection establish karna
            // Dhyan de: Password agar "root" hai toh "" ki jagah "root" likhein
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jangiir_it_db", "root", "");
            
            System.out.println("Success: Jangiir IT Database Connected! ✅");
            
        } catch (ClassNotFoundException | SQLException e) {
            // Sirf ek catch block jo dono problems ko sambhal lega
            System.out.println("Connection Error: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        getConnection(); // Test run
    }
}