package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register") // Ye wahi 'action' hai jo index.jsp mein diya tha
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Form se data lena
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        try {
            // 2. Database Connection (Aapka wala sahi database name)
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jangir_it_db", "root", "");

            // 3. Query chalana
            String q = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);

            int result = ps.executeUpdate();
            
            if(result > 0) {
                response.getWriter().println("<h1>Mubarak ho! " + name + " ka data save ho gaya!</h1>");
                response.getWriter().println("<a href='index.jsp'>Wapas Jayein</a>");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}