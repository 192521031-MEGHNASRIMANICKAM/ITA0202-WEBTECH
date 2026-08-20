package com.elgoog;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class WelcomeServlet extends HttpServlet {

    // Shared variable
    private AtomicInteger visitorCount = new AtomicInteger(0);

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        // Thread-safe increment
        int count = visitorCount.incrementAndGet();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Visitor Counter</title>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:#f2f2f2;text-align:center;}");
        out.println(".box{width:450px;margin:50px auto;padding:30px;");
        out.println("background:white;border-radius:10px;");
        out.println("box-shadow:0 0 10px gray;}");
        out.println("h2{color:green;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h2>Welcome!</h2>");

        out.println("<p>You are visitor number:</p>");

        out.println("<h1>" + count + "</h1>");

        out.println("<p>Counter is thread-safe using AtomicInteger.</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}
