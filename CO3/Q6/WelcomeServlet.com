package com.elgoog;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class WelcomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = "Meghna";
        String course = "B.Tech Information Technology";

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Welcome</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Welcome to Student Portal</h1>");

        out.println("<h2>Student Details</h2>");

        out.println("<p><b>Student Name:</b> " + name + "</p>");

        out.println("<p><b>Course:</b> " + course + "</p>");

        out.println("<p><b>Current Date and Time:</b> "
                + now.format(format) + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}
