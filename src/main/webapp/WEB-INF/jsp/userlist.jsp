<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Users</title>
<%@ include file="header.jsp" %>
</head>
<body>

<table class="table table-striped">
	<tr>
		<th>Username</th>
		<th>email</th>
		
	</tr>
	
	<c:forEach var="tempUser" items="${user}">
	
	<tr>
		<td>${tempUser.username}</td>
		<td>${tempUser.email}</td>
	</tr>
	
	</c:forEach>
	
</table>

</body>
</html>