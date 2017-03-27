<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${user.username}Profile</title>

<c:url var="updateUser" value="/users/updateuser">
	<c:param name="userId" value="${user.id}" />
</c:url>

</head>
<body>
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading text-center">${user.firstname != null ? user.firstname : user.username }'s Profile
		</div>

		<!-- Table -->
		<table class="table">

			<tr>
				<td>Firstname</td>
				<td>${user.firstname}</td>
			</tr>

			<tr>
				<td>Lastname</td>
				<td>${user.lastname}</td>
			</tr>

			<tr>
				<td>Username</td>
				<td>${user.username}</td>
			</tr>

			<tr>
				<td>Email</td>
				<td>${user.email}</td>
			</tr>

			<tr>
				<td>Password</td>
				<td>***************</td>
			</tr>

		</table>

	</div>
	
	<a href="${updateUser}">Update Profile</a>
	
</body>
</html>