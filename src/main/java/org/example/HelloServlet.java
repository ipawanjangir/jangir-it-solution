package org.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Is URL ko dhyaan se dekhein, yahi HTML ke 'action' mein hona chahiye
@WebServlet("/submitForm")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Form se data nikalna
        String name = request.getParameter("userName");
        String email = request.getParameter("userEmail");

        // 2. Browser ko batana ki hum HTML bhej rahe hain
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 3. Output print karna
        out.println("<html><body style='font-family: Arial; text-align: center; padding-top: 50px;'>");
        out.println("<h2 style='color: green;'>Data Received Successfully!</h2>");
        out.println("<div style='border: 1px solid #ccc; display: inline-block; padding: 20px;'>");
        out.println("<p><strong>Welcome:</strong> " + (name != null ? name : "Guest") + "</p>");
        out.println("<p><strong>Your Email:</strong> " + (email != null ? email : "Not Provided") + "</p>");
        out.println("</div>");
        out.println("<br><br><a href='index.html'>Back to Form</a>");
        out.println("</body></html>");
    }
}