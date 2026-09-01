<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.example.ServiceRequest" %>

<%
    ServiceRequest serviceRequest =
        (ServiceRequest) request.getAttribute("serviceRequest");

    String requestNumber =
        (String) request.getAttribute("requestNumber");

    Boolean showReport =
        (Boolean) request.getAttribute("showReport");
%>

<!DOCTYPE html>
<html>
<head>

    <title>Service Request</title>

    <style>

        * {
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            margin: 0;
            background: #f4f7fb;
            color: #1f2937;
        }

        .header {
            background: #172554;
            color: white;
            padding: 22px 50px;
        }

        .header h1 {
            margin: 0;
            font-size: 26px;
        }

        .container {
            width: 750px;
            max-width: 92%;
            margin: 50px auto;
        }

        .card {
            background: white;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.08);
            text-align: center;
        }

        .success-icon {
            width: 60px;
            height: 60px;
            margin: 0 auto 20px;
            border-radius: 50%;
            background: #dcfce7;
            color: #16a34a;
            font-size: 34px;
            line-height: 60px;
        }

        h2 {
            color: #172554;
            margin-bottom: 10px;
        }

        .message {
            color: #64748b;
            margin-bottom: 25px;
        }

        .request-number {
            background: #eff6ff;
            border: 1px solid #bfdbfe;
            padding: 15px;
            border-radius: 8px;
            margin: 20px 0 30px;
            font-size: 18px;
            font-weight: bold;
            color: #1d4ed8;
        }

        .report {
            text-align: left;
            margin-top: 30px;
        }

        .report-title {
            border-bottom: 2px solid #e2e8f0;
            padding-bottom: 12px;
            margin-bottom: 20px;
            color: #172554;
        }

        .detail {
            display: flex;
            padding: 14px 0;
            border-bottom: 1px solid #e5e7eb;
        }

        .label {
            width: 200px;
            font-weight: bold;
            color: #475569;
        }

        .value {
            flex: 1;
            color: #1f2937;
        }

        .description {
            background: #f8fafc;
            padding: 15px;
            border-radius: 7px;
            margin-top: 5px;
            line-height: 1.5;
        }

        .btn {
            padding: 13px 25px;
            border: none;
            border-radius: 7px;
            background: #2563eb;
            color: white;
            font-size: 15px;
            font-weight: bold;
            cursor: pointer;
        }

        .btn:hover {
            background: #1d4ed8;
        }

        .print-btn {
            background: #475569;
            margin-left: 10px;
        }

        .print-btn:hover {
            background: #334155;
        }

        @media print {

            .header,
            .btn {
                display: none;
            }

            body {
                background: white;
            }

            .container {
                width: 100%;
                margin: 0;
            }

            .card {
                box-shadow: none;
            }
        }

    </style>

</head>

<body>

<div class="header">
    <h1>IT Service Request Management</h1>
</div>

<div class="container">

    <div class="card">

        <% if (showReport == null || !showReport) { %>

            <div class="success-icon">✓</div>

            <h2>Request Submitted Successfully</h2>

            <p class="message">
                Your IT service request has been successfully registered.
            </p>

            <div class="request-number">
                Request Number: <%= requestNumber %>
            </div>

            <form action="ServiceRequestServlet" method="post">

                <input type="hidden" name="action" value="report">

                <button type="submit" class="btn">
                    Generate Report
                </button>

            </form>

        <% } else { %>

            <h2 class="report-title">Service Request Report</h2>

            <div class="detail">
                <div class="label">Request Number</div>
                <div class="value"><%= requestNumber %></div>
            </div>

            <div class="detail">
                <div class="label">Employee ID</div>
                <div class="value">
                    <%= serviceRequest.getEmployeeId() %>
                </div>
            </div>

            <div class="detail">
                <div class="label">Employee Name</div>
                <div class="value">
                    <%= serviceRequest.getEmployeeName() %>
                </div>
            </div>

            <div class="detail">
                <div class="label">Department</div>
                <div class="value">
                    <%= serviceRequest.getDepartment() %>
                </div>
            </div>

            <div class="detail">
                <div class="label">Problem Category</div>
                <div class="value">
                    <%= serviceRequest.getProblemCategory() %>
                </div>
            </div>

            <div class="detail">
                <div class="label">Priority</div>
                <div class="value">
                    <%= serviceRequest.getPriority() %>
                </div>
            </div>

            <div class="detail">
                <div class="label">Problem Description</div>
                <div class="value description">
                    <%= serviceRequest.getProblemDescription() %>
                </div>
            </div>

            <br>

            <button onclick="window.print()" class="btn print-btn">
                Print Report
            </button>

        <% } %>

    </div>

</div>

</body>
</html>
