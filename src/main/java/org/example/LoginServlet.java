package org.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Abhi ke liye hum simple ID/Pass rakh rahe hain
        if(user.equals("admin") && pass.equals("jangir123")) {
            HttpSession session = request.getSession();
            session.setAttribute("adminUser", user); // Session mein data save kiya
            response.sendRedirect("displayUsers");  // Dashboard par bhejo
        } else {
            } 
    // Sundar error message aur wapas jaane ka link
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<div style='text-align:center; margin-top:50px; font-family:Arial;'>");
    out.println("<h3 style='color:red;'>❌ Galt Password! Wapas try karein.</h3>");
    out.println("<a href='login.html' style='padding:10px 20px; background:#001f3f; color:white; text-decoration:none; border-radius:5px;'>Try Again</a>");
    out.println("</div>");
}
        
    }
