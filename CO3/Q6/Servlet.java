package com.elgoog;

import java.io.*;
import java.time.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
                         throws IOException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("<h2>Welcome to Student Portal</h2>");
        out.println("<p>Student Name: Meghna</p>");
        out.println("<p>Course: B.Tech IT</p>");
        out.println("<p>Date and Time: " + LocalDateTime.now() + "</p>");
    }
}
