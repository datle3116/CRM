<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>NHÂN VIÊN - CHI TIẾT</title>
</head>

<body>
	<!-- Page Content -->
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Chi tiết thành viên</h4>
				</div>
				<a class="btn btn-warning pull-right"
					href='<c:url value="/user/edit?id=${user.id}"></c:url>'>Chỉnh
					Sửa</a>
			</div>
			<!-- /.row -->
			<!-- .row -->
			<div class="row">
				<div class="col-md-4 col-xs-12">
					<div class="white-box">
						<div class="user-bg">
							<img width="100%" alt="user"
								src='<c:url value="/assets/plugins/images/large/img1.jpg"></c:url>'>
							<div class="overlay-box">
								<div class="user-content">
									<a href="javascript:void(0)"><img
										src='<c:url value="/assets/plugins/images/users/genu.jpg"></c:url>'
										class="thumb-lg img-circle" alt="img"></a>
									<h4 class="text-white">${user.fullname}</h4>
									<h5 class="text-white">${user.email}</h5>
								</div>
							</div>
						</div>
						<div class="user-btm-box">
							<div class="col-md-4 col-sm-4 text-center">
								<p class="text-purple">
									<i class="ti-facebook"></i>
								</p>
								<h4>20%</h4>
								<h6>Chưa thực hiện</h6>
							</div>
							<div class="col-md-4 col-sm-4 text-center">
								<p class="text-blue">
									<i class="ti-twitter"></i>
								</p>
								<h4>50%</h4>
								<h6>Đang thực hiện</h6>
							</div>
							<div class="col-md-4 col-sm-4 text-center">
								<p class="text-danger">
									<i class="ti-dribbble"></i>
								</p>
								<h4>30%</h4>
								<h6>Hoàn thành</h6>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8 col-xs-12">
					<div class="white-box">
						<form class="form-horizontal form-material">
							<div class="form-group">
								<label class="col-md-12">ID: ${user.id}</label>
							</div>
							<div class="form-group">
								<label class="col-md-12">Full Name: ${user.fullname}</label>
							</div>
							<div class="form-group">
								<label for="example-email" class="col-md-12">Email:
									${user.email}</label>
							</div>
							<div class="form-group">
								<label class="col-md-12">Password: **********</label>
							</div>
							<div class="form-group">
								<label class="col-sm-12">Description:
									${user.description}</label>
							</div>
							<div class="form-group">
								<label class="col-sm-12">Role Name: ${user.roleName}</label>
							</div>
						</form>
					</div>
				</div>
			</div>
			<br />
			<!-- /.row -->
			<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
			<h4>DANH SÁCH CÔNG VIỆC</h4>
			<div class="row">
				<div class="col-md-4">
					<div class="white-box">
						<h3 class="box-title">Chưa thực hiện</h3>
						<div class="message-center">
							<c:forEach var="task" items="${tasks}">
								<c:if test="${task.statusId == 1}">
									<a href='<c:url value="/job/detail?id=${task.jobId}"></c:url>'>
										<div class="mail-contnet">
											<h5>${task.name}</h5>
											<span class="mail-desc">Bắt đầu: ${task.startDate}</span> <span
												class="mail-desc">Kết thúc: ${task.endDate}</span>
										</div>
									</a>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="white-box">
						<h3 class="box-title">Đang thực hiện</h3>
						<div class="message-center">
							<c:forEach var="task" items="${tasks}">
								<c:if test="${task.statusId == 2}">
									<a href='<c:url value="/job/detail?id=${task.jobId}"></c:url>'>
										<div class="mail-contnet">
											<h5>${task.name}</h5>
											<span class="mail-desc">Bắt đầu: ${task.startDate}</span> <span
												class="mail-desc">Kết thúc: ${task.endDate}</span>
										</div>
									</a>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="white-box">
						<h3 class="box-title">Đã hoàn thành</h3>
						<div class="message-center">
							<c:forEach var="task" items="${tasks}">
								<c:if test="${task.statusId == 3}">
									<a href='<c:url value="/job/detail?id=${task.jobId}"></c:url>'>
										<div class="mail-contnet">
											<h5>${task.name}</h5>
											<span class="mail-desc">Bắt đầu: ${task.startDate}</span> <span
												class="mail-desc">Kết thúc: ${task.endDate}</span>
										</div>
									</a>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<!-- END DANH SÁCH CÔNG VIỆC -->
		</div>
	</div>
	<!-- /#page-wrapper -->
	<!-- /#wrapper -->
</body>
</html>