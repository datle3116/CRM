<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">

<head>
<title>Chi tiết công việc</title>
</head>

<body>
	<!-- Page Content -->
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">${jobName}</h4>
				</div>
				<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
					<ol class="breadcrumb">
						<li><a href='<c:url value="/task/add"></c:url>' class="btn btn-success">Thêm mới task</a></li>
						<li><a href='<c:url value="/job"></c:url>' class="btn btn-warning">Quay lại</a></li>
					</ol>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- BEGIN THỐNG KÊ -->
			<div class="row">
				<!--col -->
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="white-box">
						<div class="col-in row">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<i data-icon="E" class="linea-icon linea-basic"></i>
								<h5 class="text-muted vb">CHƯA BẮT ĐẦU</h5>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<h3 class="counter text-right m-t-15 text-danger">20%</h3>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="progress">
									<div class="progress-bar progress-bar-danger"
										role="progressbar" aria-valuenow="40" aria-valuemin="0"
										aria-valuemax="100" style="width: 20%"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
				<!--col -->
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="white-box">
						<div class="col-in row">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
								<h5 class="text-muted vb">ĐANG THỰC HIỆN</h5>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<h3 class="counter text-right m-t-15 text-megna">50%</h3>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="progress">
									<div class="progress-bar progress-bar-megna" role="progressbar"
										aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
										style="width: 50%"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
				<!--col -->
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="white-box">
						<div class="col-in row">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
								<h5 class="text-muted vb">HOÀN THÀNH</h5>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<h3 class="counter text-right m-t-15 text-primary">30%</h3>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="progress">
									<div class="progress-bar progress-bar-primary"
										role="progressbar" aria-valuenow="40" aria-valuemin="0"
										aria-valuemax="100" style="width: 30%"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- END THỐNG KÊ -->

			<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
			<c:forEach var="task" items="${tasks}">
			<div class="row">
					<div class="col-xs-12">
						<div class="box-title white-box"> <img width="30"
							src='<c:url value="/assets/plugins/images/users/pawandeep.jpg"></c:url>'
							class="img-circle" /> <span>${task.name}</span>
							<div class="pull-right">
								<a href='<c:url value="/task/edit?id=${task.id}"></c:url>' class="btn btn-warning">Sửa</a>
								<a href='<c:url value="/task/delete?id=${task.id}"></c:url>' class="btn btn-danger">Xoá</a>
							</div>
						</div>
						
					</div>
					<div class="col-md-4">
						<div class="white-box h-100" style="height: 210px">
							<h3 class="box-title">Người thực hiện</h3>
							<div class="message-center">
								<a href="#">
									<div class="mail-contnet">
										<h5>${task.userName}</h5>
										<span class="text">Id: ${task.userId}</span>
									</div>
								</a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="white-box h-100" style="height: 210px">
							<h3 class="box-title">Trạng thái</h3>
							<div class="message-center">
								<a href="#">
									<div class="mail-contnet">
										<h5>${task.statusName}</h5>
									</div>
								</a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="white-box h-100" style="height: 210px">
							<h3 class="box-title">Thời gian</h3>
							<div class="message-center">
								<a href="#">
									<div class="mail-contnet">
										<h5>Bắt đầu:</h5>
										<span class="mail-desc">${task.startDate}</span>
									</div>
								</a> <a href="#">
									<div class="mail-contnet">
										<h5>Kết thúc:</h5>
										<span class="mail-desc">${task.endDate}</span>
									</div>
								</a>
							</div>
						</div>
					</div>
			</div>
			</c:forEach>
			<!-- END DANH SÁCH CÔNG VIỆC -->
		</div>
	</div>
</body>

</html>