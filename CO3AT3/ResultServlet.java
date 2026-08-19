package com.elgoog;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String regno = request.getParameter("regno");

        try {

            int m1 = Integer.parseInt(request.getParameter("m1"));
            int m2 = Integer.parseInt(request.getParameter("m2"));
            int m3 = Integer.parseInt(request.getParameter("m3"));

            // Validation
            if (name == null || name.trim().isEmpty() ||
                regno == null || regno.trim().isEmpty() ||
                m1 < 0 || m1 > 100 ||
                m2 < 0 || m2 > 100 ||
                m3 < 0 || m3 > 100) {

                out.println("<h2>Invalid Input</h2>");
                out.println("<p>Please enter valid student details and marks between 0 and 100.</p>");
                return;
            }

            // Calculations
            int total = m1 + m2 + m3;
            double average = total / 3.0;

            int highest = Math.max(m1, Math.max(m2, m3));

            String result;

            if (m1 >= 40 && m2 >= 40 && m3 >= 40) {
                result = "PASS";
            } else {
                result = "FAIL";
            }

            // Display result
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student Result</title>");
            out.println("</head>");

            out.println("<body>");

            out.println("<h2>Student Result</h2>");

            out.println("<p><b>Name:</b> " + name + "</p>");
            out.println("<p><b>Register Number:</b> " + regno + "</p>");
            out.println("<p><b>Subject 1:</b> " + m1 + "</p>");
            out.println("<p><b>Subject 2:</b> " + m2 + "</p>");
            out.println("<p><b>Subject 3:</b> " + m3 + "</p>");

            out.println("<p><b>Total:</b> " + total + "</p>");
            out.println("<p><b>Average:</b> " + average + "</p>");
            out.println("<p><b>Highest Mark:</b> " + highest + "</p>");
            out.println("<p><b>Result:</b> " + result + "</p>");

            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {

            out.println("<h2>Invalid Input</h2>");
            out.println("<p>Please enter valid numbers for all marks.</p>");
        }
    }
}
