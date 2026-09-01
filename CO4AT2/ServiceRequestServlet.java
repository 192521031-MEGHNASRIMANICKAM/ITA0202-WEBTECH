package com.example;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServiceRequestServlet")
public class ServiceRequestServlet extends HttpServlet {

    private static int requestCounter = 1000;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("report".equals(action)) {

            ServiceRequest serviceRequest =
                (ServiceRequest) request.getSession().getAttribute("serviceRequest");

            String requestNumber =
                (String) request.getSession().getAttribute("requestNumber");

            request.setAttribute("serviceRequest", serviceRequest);
            request.setAttribute("requestNumber", requestNumber);
            request.setAttribute("showReport", true);

            request.getRequestDispatcher("acknowledgement.jsp")
                   .forward(request, response);

            return;
        }

        String employeeId = request.getParameter("employeeId");
        String employeeName = request.getParameter("employeeName");
        String department = request.getParameter("department");
        String problemCategory = request.getParameter("problemCategory");
        String problemDescription = request.getParameter("problemDescription");
        String priority = request.getParameter("priority");

        if (employeeId == null || employeeId.trim().isEmpty() ||
            employeeName == null || employeeName.trim().isEmpty() ||
            department == null || department.trim().isEmpty() ||
            problemCategory == null || problemCategory.trim().isEmpty() ||
            problemDescription == null || problemDescription.trim().isEmpty() ||
            priority == null || priority.trim().isEmpty()) {

            response.getWriter().println("All fields are mandatory.");
            return;
        }

        ServiceRequest serviceRequest = new ServiceRequest(
            employeeId,
            employeeName,
            department,
            problemCategory,
            problemDescription,
            priority
        );

        String requestNumber = "SR-" + (++requestCounter);

        request.getSession().setAttribute("serviceRequest", serviceRequest);
        request.getSession().setAttribute("requestNumber", requestNumber);

        request.setAttribute("serviceRequest", serviceRequest);
        request.setAttribute("requestNumber", requestNumber);
        request.setAttribute("showReport", false);

        request.getRequestDispatcher("acknowledgement.jsp")
               .forward(request, response);
    }
}
