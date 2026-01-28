package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exportExcel")
public class ExportExcelServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Excel file ke roop mein download karwane ke liye headers
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=User_Data.csv");

        try (PrintWriter out = response.getWriter()) {
            // Database Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jangir_it_db", "root", "");

            PreparedStatement ps = con.prepareStatement("SELECT name, email FROM users");
            ResultSet rs = ps.executeQuery();

            // Excel ki pehli row (Headers)
            out.println("Name,Email");

            // Database se data nikal kar Excel rows banana
            while (rs.next()) {
                out.println(rs.getString("name") + "," + rs.getString("email"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}