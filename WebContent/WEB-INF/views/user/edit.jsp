<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <h4 class="page-title">Chỉnh sửa thông tin</h4>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-4 col-xs-12">
                        <div class="white-box">
                            <div class="user-bg"> <img width="100%" alt="user" src='<c:url value="/assets/plugins/images/large/img1.jpg"></c:url>'>
                                <div class="overlay-box">
                                    <div class="user-content">
                                        <a href="javascript:void(0)"><img src='<c:url value="/assets/plugins/images/users/genu.jpg"></c:url>'
                                                class="thumb-lg img-circle" alt="img"></a>
                                        <h4 class="text-white">User Name</h4>
                                        <h5 class="text-white">info@myadmin.com</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="user-btm-box">
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-purple"><i class="ti-facebook"></i></p>
                                    <h4>20%</h4>
                                    <h6>Chưa thực hiện</h6>
                                </div>
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-blue"><i class="ti-twitter"></i></p>
                                    <h4>50%</h4>
                                    <h6>Đang thực hiện</h6>
                                </div>
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-danger"><i class="ti-dribbble"></i></p>
                                    <h4>30%</h4>
                                    <h6>Hoàn thành</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box container">
                        <div class="row">
                            <form action='<c:url value="/user/edit"></c:url>' class="form-horizontal form-material" method="post">
                                <div class="form-group">
                                    <label class="col-md-12">Id: </label>
                                    <input type="text" name="id" value="${user.id}" readonly/>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Full Name: </label>
                                    <input type="text" name="fullname" value="${user.fullname}"/>
                                </div>
                                <div class="form-group">
                                    <label for="example-email" class="col-md-12">Email: </label>
                                    <input type="text" name="email" value="${user.email}"/>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Password: </label>
                                    <input type="text" name="password" placeholder="New Password"/>
                                </div>
                                <div class="col">
                                <div class="form-group">
                                    <label class="col-sm-12">Role</label>
                                    <select name="roleId">
                                    	<option value="" disabled selected>Chọn quyền</option>
                                    	<option value="1" ${user.roleId == 1 ? 'selected' : ''}>Admin</option>
                                    	<option value="2" ${user.roleId == 2 ? 'selected' : ''}>Manager</option>
                                    	<option value="3" ${user.roleId == 3 ? 'selected' : ''}>User</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-success">Sửa</button>
                                    <a href='<c:url value="/user"></c:url>' class="btn btn-danger">Huỷ</a>
                                </div>
                                </div>
                            </form>
                            </div>
                        </div>
                    </div>
                </div><br />
                <!-- /.row -->
                <!-- BEGIN DANH SÁCH CÔNG VIỆC -->
                <h4>DANH SÁCH CÔNG VIỆC</h4>
                <div class="row">
                    <div class="col-md-4">
                        <div class="white-box">
                            <h3 class="box-title">Chưa thực hiện</h3>
                            <div class="message-center">
                                <a href="#">
                                    <div class="mail-contnet">
                                        <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span
                                            class="time">9:30 AM</span>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="mail-contnet">
                                        <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span>
                                        <span class="time">9:10 AM</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="white-box">
                            <h3 class="box-title">Đang thực hiện</h3>
                            <div class="message-center">
                                <a href="#">
                                    <div class="mail-contnet">
                                        <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span
                                            class="time">9:30 AM</span>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="mail-contnet">
                                        <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span>
                                        <span class="time">9:10 AM</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="white-box">
                            <h3 class="box-title">Đã hoàn thành</h3>
                            <div class="message-center">
                                <a href="#">
                                    <div class="mail-contnet">
                                        <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span
                                            class="time">9:30 AM</span>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="mail-contnet">
                                        <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span>
                                        <span class="time">9:10 AM</span>
                                    </div>
                                </a>
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