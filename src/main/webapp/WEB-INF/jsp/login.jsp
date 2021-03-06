<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%@ include file="header.jsp" %>
</head>
<body>

<div class="container">

	<form method="POST" action="/login" class="form">
	
	<div class="form-group ${error != null ? 'has-error' : ''}">
		<span>${message}</span>
		<input name="username" type="text" class="form-control" placeholder="Usernname"
		autofocus="true" />
		<input name="password" type="password" class="form-control" placeholder="Password" />
		<span>${error}</span>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
		<button class="btn btn-primary" type="submit"">Log In</button>
		<h4 class="text-center"><a href="${pageContext.request.contextPath}/register">Create an account</a></h4>
		
	</div>
	
	</form>

</div>

</body>
</html>