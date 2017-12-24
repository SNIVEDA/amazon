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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">



<title>Womens's Fashion - ${title}</title>

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
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">
			<!-- Page Content -->
			<!-- Load Home -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load About -->
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load Contact-->
			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load Cart-->
			<c:if test="${userClickShowCart==true}">
				<%@include file="cart.jsp"%>
			</c:if>

			<!-- Load All / Category -->
			<c:if
				test="${userClickAllProducts==true or userClickCategoryProducts==true }">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<!-- Single Product -->
			<c:if test="${userClickShowProduct==true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

			<!-- Manage products -->
			<c:if test="${userClickManageProducts==true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>

		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/popper.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
		<!-- Datatable plugin -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		<!-- Datatable bootstrap -->
		<script src="${js}/jquery.dataTables.js"></script>


		<!-- Bootbox -->
		<script src="${js}/bootbox.min.js"></script>


		<!-- JavaScript for active menu -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
