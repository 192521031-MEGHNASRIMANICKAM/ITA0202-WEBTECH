package com.elgoog;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
                          throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String reg = req.getParameter("reg");

        try {

            int[] m = {
                Integer.parseInt(req.getParameter("m1")),
                Integer.parseInt(req.getParameter("m2")),
                Integer.parseInt(req.getParameter("m3")),
                Integer.parseInt(req.getParameter("m4")),
                Integer.parseInt(req.getParameter("m5"))
            };

            if (name == null || name.isEmpty() ||
                reg == null || reg.isEmpty()) {

                out.println("<h2>Missing Student Details</h2>");
                return;
            }

            for (int x : m) {
                if (x < 0 || x > 100) {
                    out.println("<h2>Marks must be between 0 and 100</h2>");
                    return;
                }
            }

            int total = 0;
            int highest = m[0];
            int lowest = m[0];

            for (int x : m) {
                total += x;
                highest = Math.max(highest, x);
                lowest = Math.min(lowest, x);
            }

            double average = total / 5.0;

            String grade;

            if (average >= 90)
                grade = "A+";
            else if (average >= 80)
                grade = "A";
            else if (average >= 70)
                grade = "B";
            else if (average >= 60)
                grade = "C";
            else if (average >= 50)
                grade = "D";
            else
                grade = "F";

            boolean pass = true;

            for (int x : m)
                if (x < 40)
                    pass = false;

            out.println("<h2>Student Result</h2>");

            out.println("<table border='1'>");

            out.println("<tr><th>Details</th><th>Value</th></tr>");
            out.println("<tr><td>Name</td><td>" + name + "</td></tr>");
            out.println("<tr><td>Register Number</td><td>" + reg + "</td></tr>");
            out.println("<tr><td>Total</td><td>" + total + "</td></tr>");
            out.println("<tr><td>Average</td><td>" + average + "</td></tr>");
            out.println("<tr><td>Highest</td><td>" + highest + "</td></tr>");
            out.println("<tr><td>Lowest</td><td>" + lowest + "</td></tr>");
            out.println("<tr><td>Grade</td><td>" + grade + "</td></tr>");
            out.println("<tr><td>Result</td><td>" +
                        (pass ? "PASS" : "FAIL") +
                        "</td></tr>");

            out.println("</table>");

        } catch (NumberFormatException e) {

            out.println("<h2>Invalid or Non-Numeric Marks</h2>");
        }
    }
}
