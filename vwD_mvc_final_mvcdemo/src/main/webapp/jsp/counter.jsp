



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
<<p>Counter details</p>
${mycounter}

<form:form action="/counter" method="post" modelAttribute="mycounter">
	<form:button>Increment Counter</form:button>
</form:form>


</div>
</body>
</html>