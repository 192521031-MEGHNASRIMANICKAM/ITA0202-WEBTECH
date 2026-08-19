package com.elgoog;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/life")
public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet() {
        System.out.println("Constructor called");
    }

    public void init() throws ServletException {
        System.out.println("init() called");
    }

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
                         throws IOException {

        System.out.println("doGet() called");

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("<h2>Servlet Lifecycle Demo</h2>");
    }

    public void destroy() {
        System.out.println("destroy() called");
    }
}
