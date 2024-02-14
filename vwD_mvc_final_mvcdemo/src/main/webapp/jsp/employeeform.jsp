<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title>
<style>
.error{
color : red;
}
</style>
</head>
<body>
<div align="center">
<h2>Employee Registration</h2>
<form:form action="/web/emp/add" method="post" modelAttribute="employee">

<form:label path="empName">Emp name:</form:label>
<form:input path="empName"/><br/>
<form:errors path="empName" cssClass = "error"/><br/>

<form:label path="empSal">Emp Salary:</form:label>
<form:input path="empSal"/><br/>
<form:errors path="empSal" cssClass = "error"/><br/>

<form:label path="joiningDate">Joining Date (yyyy-mm-dd):</form:label>
<form:input path="joiningDate"/><br/>

<form:button>Register Emp</form:button>
</form:form>
</div>
</body>
</html>