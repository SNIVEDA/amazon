<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />



<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Women's Fashion - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">


<!-- Bootstrap Theme -->

<%-- <link href="${css}/bootstrap-theme.css" rel="stylesheet"> --%>

<!-- Bootstrap Datatable -->

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">



</head>

<body>

	<div class="wrapper">

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Online
						Shopping</a>
				</div>
			</div>
		</nav>


		<div class="content">

			<c:if test="${not empty logout}">
				<div class="row">
					<div class="col-xs-12 col-md-offset-2 col-md-8">
						<div class="alert alert-success">${logout}</div>
					</div>
				</div>
			</c:if>
			<div class="row">
				<div class="col-6 col-md-4"></div>
				<div class="col-6 col-md-4">

					<div class="card">

						<div class="card-header">
							<h4>Login</h4>
						</div>

						<div class="card-title">
							<form action="${contextRoot}/login" method="POST"
								class="form-horizontal" id="loginForm">
								<div class="form-group">

									<div class="col-md-8">
										<label></label> <input type="text" name="username"
											id="username" placeholder="email" class="form-control" />
									</div>
								</div>
								<div class="form-group">

									<div class="col-md-8">
										<input type="password" name="password" id="password"
											placeholder="password" class="form-control" />
									</div>
								</div>

								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" /> <input type="submit" value="Login"
											class="btn btn-primary" />
									</div>
								</div>

								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										<a href="register.jsp">Register new User</a>
									</div>
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
			<!-- Footer -->
			<%@include file="./shared/footer.jsp"%>
			<!-- Bootstrap core JavaScript -->
			<script src="${js}/jquery.js"></script>
			<script src="${js}/popper.js"></script>
			<script src="${js}/bootstrap.min.js"></script>


			<!-- JavaScript for active menu -->
			<script src="${js}/myapp.js"></script>
		</div>
</body>

</html>
