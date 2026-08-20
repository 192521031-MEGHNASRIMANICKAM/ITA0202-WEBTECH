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

        String[] marks = {
            request.getParameter("m1"),
            request.getParameter("m2"),
            request.getParameter("m3"),
            request.getParameter("m4"),
            request.getParameter("m5")
        };

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Result</title>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:#f2f2f2;}");
        out.println(".result{width:600px;margin:40px auto;padding:25px;");
        out.println("background:white;border-radius:10px;box-shadow:0 0 10px gray;}");
        out.println("table{width:100%;border-collapse:collapse;}");
        out.println("th,td{border:1px solid black;padding:10px;text-align:center;}");
        out.println("th{background:#4CAF50;color:white;}");
        out.println(".error{color:red;font-weight:bold;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='result'>");

        // Validate student details
        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty()) {

            out.println("<p class='error'>Student Name and Register Number are required.</p>");

        } else {

            double[] mark = new double[5];
            boolean valid = true;
            String error = "";

            // Validate marks
            for (int i = 0; i < 5; i++) {

                if (marks[i] == null || marks[i].trim().isEmpty()) {

                    valid = false;
                    error = "All marks are required.";
                    break;
                }

                try {

                    mark[i] = Double.parseDouble(marks[i]);

                    if (mark[i] < 0 || mark[i] > 100) {

                        valid = false;
                        error = "Marks must be between 0 and 100.";
                        break;
                    }

                } catch (NumberFormatException e) {

                    valid = false;
                    error = "Marks must be numeric.";
                    break;
                }
            }

            if (!valid) {

                out.println("<p class='error'>" + error + "</p>");

            } else {

                double total = 0;
                double highest = mark[0];
                double lowest = mark[0];

                for (int i = 0; i < 5; i++) {

                    total += mark[i];

                    if (mark[i] > highest)
                        highest = mark[i];

                    if (mark[i] < lowest)
                        lowest = mark[i];
                }

                double average = total / 5;

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

                String status;

                if (average >= 50)
                    status = "PASS";
                else
                    status = "FAIL";

                out.println("<h2>Student Result</h2>");

                out.println("<p><b>Name:</b> " + name + "</p>");
                out.println("<p><b>Register Number:</b> " + regno + "</p>");

                out.println("<table>");

                out.println("<tr>");
                out.println("<th>Subject</th>");
                out.println("<th>Mark</th>");
                out.println("</tr>");

                for (int i = 0; i < 5; i++) {

                    out.println("<tr>");
                    out.println("<td>Subject " + (i + 1) + "</td>");
                    out.println("<td>" + mark[i] + "</td>");
                    out.println("</tr>");
                }

                out.println("<tr>");
                out.println("<th>Total</th>");
                out.println("<th>" + total + "</th>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<th>Average</th>");
                out.println("<th>" + average + "</th>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<th>Highest Mark</th>");
                out.println("<th>" + highest + "</th>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<th>Lowest Mark</th>");
                out.println("<th>" + lowest + "</th>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<th>Grade</th>");
                out.println("<th>" + grade + "</th>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<th>Result</th>");
                out.println("<th>" + status + "</th>");
                out.println("</tr>");

                out.println("</table>");
            }
        }

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
