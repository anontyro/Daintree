<!-- Java dependancies -->
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<link href="/resources/css/style.css" rel="stylesheet" />

<!-- Scripts -->

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<nav class="navbar navbar-default">
	<!-- Start of nav -->

	<div class="container-fluid">
		<!-- Main container -->

		<div class="navbar-header">
			<!--  Navbar header -->

			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-traget="#navbar-collapse"
				aria-expanded="false">
				<!-- header collapsed button -->

				<span class="sr-only">Toggle navigation </span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/" />">Daintree</a>
		</div>
		<!--  End of navbar header -->

		<!-- Main collapsable part of the nav bar -->
		<div class="collapse navbar-collapse" id="#navbar-collapse">
			<ul class="nav navbar-nav">
				<!--  main nav list -->


			</ul>
			<!-- end of main nav list -->

			<ul class="nav navbar-nav navbar-right">
				<!--  Nav bar right -->

				<security:authorize access="!isAuthenticated()">
					<li><a href="<c:url value="/login" />">Login</a></li>
				</security:authorize>


				<security:authorize access="isAuthenticated()">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><security:authentication
								property="principal.username" /> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="users/profile" />">Profile</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="<c:url value="/logout" />">Logout</a></li>
					</ul></li>
					</security:authorize>

			</ul>
			<!--  End of Nav bar right -->

		</div>

	</div>
	<!--  Main container end -->

</nav>
<!-- End of nav -->





