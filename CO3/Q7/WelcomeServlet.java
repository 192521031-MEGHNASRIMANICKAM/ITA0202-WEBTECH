package com.elgoog;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class WelcomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String regno = request.getParameter("regno");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String semester = request.getParameter("semester");

        out.println("<html><head><title>Student Details</title>");
        out.println("<style>");
        out.println("body{font-family:Arial;background:#f2f2f2;}");
        out.println(".box{width:400px;margin:50px auto;padding:25px;");
        out.println("background:white;border-radius:10px;box-shadow:0 0 10px gray;}");
        out.println("h2{color:green;}");
        out.println("</style></head><body>");

        out.println("<div class='box'>");

        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            department == null || department.trim().isEmpty() ||
            semester == null || semester.trim().isEmpty()) {

            out.println("<h2>Please fill all fields!</h2>");

        } else {

            out.println("<h2>Registration Successful</h2>");
            out.println("<p><b>Name:</b> " + name + "</p>");
            out.println("<p><b>Register Number:</b> " + regno + "</p>");
            out.println("<p><b>Email:</b> " + email + "</p>");
            out.println("<p><b>Department:</b> " + department + "</p>");
            out.println("<p><b>Semester:</b> " + semester + "</p>");
        }

        out.println("</div>");
        out.println("</body></html>");
    }
}
