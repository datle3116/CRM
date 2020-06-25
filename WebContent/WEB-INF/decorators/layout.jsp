<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/plugins/images/favicon.png">
<title><dec:title /></title>
<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>

</head>
<body>
	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
	<!-- navbar -->
	<jsp:include page="/WEB-INF/views/layout/navbar.jsp"></jsp:include>
	<!-- sidebar -->
	<jsp:include page="/WEB-INF/views/layout/sidebar.jsp"></jsp:include>

	
		<dec:body />
	</div>

	<!-- /.container-fluid -->
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>