<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>IT Service Request</title>

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

        .header p {
            margin: 6px 0 0;
            color: #cbd5e1;
            font-size: 14px;
        }

        .container {
            width: 750px;
            max-width: 92%;
            margin: 40px auto;
        }

        .card {
            background: white;
            padding: 35px 40px;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.08);
        }

        .card h2 {
            margin-top: 0;
            color: #172554;
            font-size: 22px;
        }

        .subtitle {
            color: #64748b;
            font-size: 14px;
            margin-bottom: 28px;
        }

        .row {
            display: flex;
            gap: 20px;
        }

        .field {
            flex: 1;
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            font-size: 14px;
            margin-bottom: 8px;
        }

        input[type="text"],
        select,
        textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #cbd5e1;
            border-radius: 7px;
            font-size: 14px;
            outline: none;
        }

        input[type="text"]:focus,
        select:focus,
        textarea:focus {
            border-color: #2563eb;
        }

        textarea {
            resize: vertical;
        }

        .priority {
            display: flex;
            gap: 25px;
            margin-top: 8px;
        }

        .priority label {
            font-weight: normal;
            margin: 0;
        }

        .submit-btn {
            width: 100%;
            padding: 13px;
            background: #2563eb;
            color: white;
            border: none;
            border-radius: 7px;
            font-size: 15px;
            font-weight: bold;
            cursor: pointer;
            margin-top: 10px;
        }

        .submit-btn:hover {
            background: #1d4ed8;
        }

        .required {
            color: #dc2626;
        }
    </style>
</head>

<body>

<div class="header">
    <h1>IT Service Request Management</h1>
    <p>Internal Technical Support Portal</p>
</div>

<div class="container">

    <div class="card">

        <h2>Submit a Service Request</h2>

        <p class="subtitle">
            Please provide the details of your technical issue.
        </p>

        <form action="ServiceRequestServlet" method="post">

            <div class="row">

                <div class="field">
                    <label>Employee ID <span class="required">*</span></label>
                    <input type="text" name="employeeId" required>
                </div>

                <div class="field">
                    <label>Employee Name <span class="required">*</span></label>
                    <input type="text" name="employeeName" required>
                </div>

            </div>

            <div class="field">
                <label>Department <span class="required">*</span></label>
                <input type="text" name="department" required>
            </div>

            <div class="field">
                <label>Problem Category <span class="required">*</span></label>

                <select name="problemCategory" required>
                    <option value="">Select Problem Category</option>
                    <option value="Network">Network</option>
                    <option value="Software">Software</option>
                    <option value="Hardware">Hardware</option>
                    <option value="Account">Account</option>
                    <option value="Other">Other</option>
                </select>
            </div>

            <div class="field">
                <label>Problem Description <span class="required">*</span></label>

                <textarea name="problemDescription"
                          rows="5"
                          placeholder="Describe the technical issue..."
                          required></textarea>
            </div>

            <div class="field">
                <label>Priority <span class="required">*</span></label>

                <div class="priority">
                    <label>
                        <input type="radio" name="priority" value="Low" required>
                        Low
                    </label>

                    <label>
                        <input type="radio" name="priority" value="Medium">
                        Medium
                    </label>

                    <label>
                        <input type="radio" name="priority" value="High">
                        High
                    </label>
                </div>
            </div>

            <input type="submit" value="Submit Service Request" class="submit-btn">

        </form>

    </div>

</div>

</body>
</html>
