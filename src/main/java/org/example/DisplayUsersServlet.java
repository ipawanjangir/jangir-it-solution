package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; // Session ke liye import

@WebServlet("/displayUsers")
public class DisplayUsersServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. Sabse pehle Session check karein (Security Lock)
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("adminUser") == null) {
            // Agar admin login nahi hai, toh login page par redirect karein
            response.sendRedirect("login.html");
            return;
        }

        List<User> userList = new ArrayList<>();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // 2. Database Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jangir_it_db", "root", "");
            
            // 3. Data Fetching
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            
            int count = 0;
            while(rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                userList.add(user);
                count++;
            }

            // 4. JSP par data bhejna
            if (count > 0) {
                request.setAttribute("users", userList);
                request.getRequestDispatcher("/display.jsp").forward(request, response);
            } else {
                out.println("<html><body>");
                out.println("<h3>Database connected but Table is EMPTY!</h3>");
                out.println("<a href='index.html'>Naya user register karein</a>");
                out.println("</body></html>");
            }
            
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(out);
        }
    }
}