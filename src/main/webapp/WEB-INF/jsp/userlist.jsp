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
<a href="${pageContext.request.contextPath}/users/userform" class="btn btn-primary">Add User</a>
<table class="table table-striped">
	<tr>
		<th>Username</th>
		<th>Email</th>
		<th>Actions</th>
		
	</tr>
	
	<c:forEach var="tempUser" items="${user}">
	
	<c:url var="updateUser" value="/users/updateuser">
		<c:param name="userId" value="${tempUser.id}"/>
	</c:url>
	
	<c:url var="deleteUser" value="/users/deleteuser">
		<c:param name="userId" value="${tempUser.id}"/>
	</c:url>
	
	<tr>
		<td>${tempUser.username}</td>
		
		<td>${tempUser.email}</td>
		
		<td>
		<a href="${updateUser}">Update</a>
		|
		<a href="${deleteUser}">Delete</a>
		</td>
		
	</tr>
	
	</c:forEach>
	
</table>

</body>
</html>