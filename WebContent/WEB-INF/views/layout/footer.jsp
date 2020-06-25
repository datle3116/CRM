<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- /.container-fluid -->
<footer class="footer text-center"> 2018 &copy; myclass.com </footer>
<!-- /#wrapper -->
<!-- jQuery -->
<script src='<c:url value="/assets/plugins/bower_components/jquery/dist/jquery.min.js"></c:url>'></script>
<!-- Bootstrap Core JavaScript -->
<script src='<c:url value="/assets/bootstrap/dist/js/bootstrap.min.js"></c:url>'></script>
<!-- Menu Plugin JavaScript -->
<script
	src='<c:url value="/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></c:url>'></script>
<!--slimscroll JavaScript -->
<script src='<c:url value="/assets/js/jquery.slimscroll.js"></c:url>'></script>
<script src='<c:url value="/assets/js/jquery.dataTables.js"></c:url>'></script>
<!--Wave Effects -->
<script src='<c:url value="/assets/js/waves.js"></c:url>'></script>
<!--Counter js -->
<script
	src='<c:url value="/assets/plugins/bower_components/waypoints/lib/jquery.waypoints.js"></c:url>'></script>
<script
	src='<c:url value="/assets/plugins/bower_components/counterup/jquery.counterup.min.js"></c:url>'></script>
<!--Morris JavaScript -->
<script src='<c:url value="/assets/plugins/bower_components/raphael/raphael-min.js"></c:url>'></script>
<script src='<c:url value="/assets/plugins/bower_components/morrisjs/morris.js"></c:url>'></script>
<!-- Custom Theme JavaScript -->
<script src='<c:url value="/assets/js/custom.min.js"></c:url>'></script>
<script src='<c:url value="/assets/js/dashboard1.js"></c:url>'></script>
<script
	src='<c:url value="/assets/plugins/bower_components/toast-master/js/jquery.toast.js"></c:url>'></script>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<script type="text/javascript">
    $(function() {
        $(".preloader").fadeOut();
    });
    </script>