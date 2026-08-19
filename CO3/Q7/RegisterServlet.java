package com.elgoog;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
                          throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String reg = req.getParameter("reg");
        String email = req.getParameter("email");
        String dept = req.getParameter("dept");
        String sem = req.getParameter("sem");

        if (name == null || name.isEmpty() ||
            reg == null || reg.isEmpty() ||
            email == null || email.isEmpty() ||
            dept == null || dept.isEmpty() ||
            sem == null || sem.isEmpty()) {

            out.println("<h2>All fields are required!</h2>");
            return;
        }

        out.println("<h2>Registration Successful</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Register Number: " + reg + "<br>");
        out.println("Email: " + email + "<br>");
        out.println("Department: " + dept + "<br>");
        out.println("Semester: " + sem);
    }
}
