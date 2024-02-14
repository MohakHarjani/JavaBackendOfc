<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
     <style>
        body{
            font-size: 20px;
        }
        h1{
            color : blue;
        }
        .error{
        color : red;
        }
    </style>
</head>
<body>
       <h1>Welcome to Volkswagen</h1>
       <h2>Employee Details</h2>
       
       <%
           String error = (String)request.getAttribute("errorMsg");
       %>
       
       <% if (error != null) { %>
       
           <span class = "error">${errorMsg}</span><br>
           
       <% } else  { %>
       
	       <span><b>Employee Name</b> : ${emp.empName}</span><br>
	       <span><b>Employee Salary</b> : ${emp.empSal}</span><br>
	       <span><b>Employee's Joining Date</b> : ${emp.joiningDate}</span>
	       
	   <% } %>
	       
</body>
</html>