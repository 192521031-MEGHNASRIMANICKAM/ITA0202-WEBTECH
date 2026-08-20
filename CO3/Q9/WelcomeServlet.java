package com.elgoog;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class WelcomeServlet extends HttpServlet {

    static int constructorCount = 0;
    static int initCount = 0;
    static int serviceCount = 0;
    static int doGetCount = 0;
    static int destroyCount = 0;

    // Constructor
    public WelcomeServlet() {
        constructorCount++;

        System.out.println("Constructor called: " + constructorCount);
    }

    // init()
    public void init() throws ServletException {
        initCount++;

        System.out.println("init() called: " + initCount);
    }

    // service()
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
                           throws ServletException, IOException {

        serviceCount++;

        System.out.println("service() called: " + serviceCount);

        super.service(request, response);
    }

    // doGet()
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        doGetCount++;

        System.out.println("doGet() called: " + doGetCount);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Lifecycle</title>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:#f2f2f2;}");
        out.println(".box{width:500px;margin:50px auto;padding:25px;");
        out.println("background:white;border-radius:10px;");
        out.println("box-shadow:0 0 10px gray;}");
        out.println("h2{color:green;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h2>Servlet Lifecycle Demonstration</h2>");

        out.println("<p>Constructor calls: " + constructorCount + "</p>");
        out.println("<p>init() calls: " + initCount + "</p>");
        out.println("<p>service() calls: " + serviceCount + "</p>");
        out.println("<p>doGet() calls: " + doGetCount + "</p>");
        out.println("<p>destroy() calls: " + destroyCount + "</p>");

        out.println("<p>Refresh the page to observe service() and doGet().</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }

    // destroy()
    public void destroy() {

        destroyCount++;

        System.out.println("destroy() called: " + destroyCount);
    }
}
