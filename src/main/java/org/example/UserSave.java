package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserSave {
    public static void main(String[] args) {
        try {
            // 1. Connection banana
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jangir_it_db", "root", "");
            
            if (con != null) {
                // 2. Query taiyar karna
                String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(query);
                
                ps.setString(1, "Jangir IT");
                ps.setString(2, "test@example.com");
                ps.setString(3, "pass123");
                
                // 3. Execute karna
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Mubarak ho! Data successfully save ho gaya! 🎉");
                }
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}