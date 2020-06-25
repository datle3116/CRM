<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Chỉnh sửa nhiệm vụ</title>
</head>

<body>
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Chỉnh sửa nhiệm vụ</h4>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form action='<c:url value="/task/edit"></c:url>' class="form-horizontal form-material" method="post">
                            	<div class="form-group">
                                    <label class="col-md-12">Id:</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="Id" name="id"
                                            class="form-control form-control-line" value="${task.id}" readonly> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Tên nhiệm vụ:</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="Tên công việc" name="name"
                                            class="form-control form-control-line" value="${task.name}"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày bắt đầu:</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="yyyy-MM-dd" name="startDate"
                                            class="form-control form-control-line" value="${task.startDate}"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày kết thúc:</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="yyyy-MM-dd" name="endDate"
                                            class="form-control form-control-line" value="${task.endDate}"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Người làm:</label>
                                    <div class="col-md-12">
                                        <select class="form-control form-control-line" name="userId">
                                        	<c:forEach var="user" items="${users}">
                                        		<option value="${user.id}" ${user.id == task.userId ? 'selected' : ''}>${user.fullname}, ID: ${user.id}</option>
                                        	</c:forEach>
                                        </select></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Thuộc Công việc:</label>
                                    <div class="col-md-12">
                                    	<select class="form-control form-control-line" name="jobId">
                                        	<c:forEach var="job" items="${jobs}">
                                        		<option value="${job.id}" ${job.id == task.jobId ? 'selected' : ''}>${job.name}</option>
                                        	</c:forEach>
                                        </select>
                                        </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Trạng thái:</label>
                                    <div class="col-md-12">
                                    	<select class="form-control form-control-line" name="statusId">
                                        	<c:forEach var="status" items="${listStatus}">
                                        		<option value="${status.id}" ${status.id == task.statusId ? 'selected' : ''}>${status.name}</option>
                                        	</c:forEach>
                                        </select>
                                        </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Sửa</button>
                                        <a href='<c:url value="/job/detail?id=${task.jobId}"></c:url>' class="btn btn-primary">Quay lại</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-2 col-12"></div>
                </div>
                <!-- /.row -->
            </div></div>
</body>

</html>