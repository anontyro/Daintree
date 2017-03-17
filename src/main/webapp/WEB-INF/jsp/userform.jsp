<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
<%@ include file="header.jsp" %>
</head>
<body>
<h2>Form</h2>
<form:form action="/users/userform" modelAttribute="user" method = "POST">

	<form:hidden path="idmainuser"/>

	<label>Username</label>
	<form:input path="username" />
	
	<label>Email</label>
	<form:input path="email" />
	
	<label>Password</label>
	<form:input type="password" path="password" />
	
	<input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>
</body>
</html>