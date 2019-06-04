<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Freelance registration</title>
</head>
<body>
<form:form method="POST" action="/SpringMongo/register" modelAttribute="uservo">
    <form:label path="username">UserName</form:label>
    <form:input name = "username" path="username" />
    <form:label path="password">Password</form:label>
    <form:input name = "password" path="password" />
<%--        <form:label path="confirmpassword"> Confirm Password</form:label>
    <form:input name = "confirmpassword" path="confirmpassword" /> --%>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>