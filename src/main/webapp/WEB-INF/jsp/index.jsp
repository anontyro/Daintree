<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<%@ include file="header.jsp" %>

</head>
<body>
<h2>Welcome to Daintree</h2>

<a href="#" class="btn btn-default">Hello</a>

<security:authorize access="!isAuthenticated()">
<a href="<c:url value="/login" />">Login</a>
</security:authorize>
<br>

<security:authorize access="isAuthenticated()">
    authenticated as <security:authentication property="principal.username" /> 
    <a href="<c:url value="/logout" />">Logout</a>
</security:authorize>

</body>
<script src="/resources/js/main.js"></script>
</html>