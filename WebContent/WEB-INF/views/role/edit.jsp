<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>QUYỀN - SỬA</title>
</head>

<body>
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Chỉnh sửa quyền</h4>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form action='<c:url value="/role/edit"></c:url>' class="form-horizontal form-material" method="post">
                                <div class="form-group">
                                    <label class="col-md-12">Id</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="Id" name="id"
                                            class="form-control form-control-line" value="${role.id}" readonly/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Tên quyền</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="Tên quyền" name = "name"
                                            class="form-control form-control-line" value="${role.name}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Mô tả</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="Mô tả" name="description" class="form-control form-control-line" value="${role.description}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Edit Role</button>
                                        <a href='<c:url value="/role"></c:url>' class="btn btn-primary">Quay lại</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-2 col-12"></div>
                </div>
                <!-- /.row -->
            </div>
        </div>
        <!-- /#page-wrapper -->
    <!-- /#wrapper -->
</body>

</html>