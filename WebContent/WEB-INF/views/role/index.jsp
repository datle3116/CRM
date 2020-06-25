<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>DANH SÁCH QUYỀN</title>
</head>

<body>
	<!-- Page Content -->
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Danh sách quyền</h4>
				</div>
				<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
					<a href='<c:url value="/role/add"></c:url>' class="btn btn-sm btn-success">Thêm mới</a>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /row -->
			<div class="row">
				<div class="col-sm-12">
					<div class="white-box">
						<div class="table-responsive">
							<table class="table" id="example">
								<thead>
									<tr>
										<th>STT</th>
										<th>Tên Quyền</th>
										<th>Mô Tả</th>
										<th>Hành Động</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="role" items="${roles}" varStatus="loop">
										<tr>
											<td>${loop.index + 1}</td>
											<td>${role.name}</td>
											<td>${role.description}</td>
											<td><a href='<c:url value="/role/edit?id=${role.id}"></c:url>' class="btn btn-sm btn-primary">Sửa</a> <a
												href='<c:url value="/role/delete?id=${role.id}"></c:url>' class="btn btn-sm btn-danger">Xóa</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- /.row -->
		</div>
	</div>
	<!-- /#page-wrapper -->
	<!-- /#wrapper -->
</body>

</html>