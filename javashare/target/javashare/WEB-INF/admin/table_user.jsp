<%@page pageEncoding="UTF-8" language="java" import="java.util.*"
        contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
            name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet"
          href="../../static/bower_components/bootstrap/dist/css/bootstrap.css">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="../../static/bower_components/font-awesome/css/font-awesome.css">
    <!-- Ionicons -->
    <link rel="stylesheet"
          href="../../static/bower_components/Ionicons/css/ionicons.css">
    <!-- Theme style -->
    <link rel="stylesheet"
          href="../../static/dist/css/AdminLTE.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
           folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet"
          href="../../static/dist/css/skins/_all-skins.css">
    <!-- jvectormap -->
    <link rel="stylesheet"
          href="../../static/bower_components/jvectormap/jquery-jvectormap.css">
    <!-- Date Picker -->
    <link rel="stylesheet"
          href="../../static/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css">
    <!-- Daterange picker -->
    <link rel="stylesheet"
          href="../../static/bower_components/bootstrap-daterangepicker/daterangepicker.css">
    <!-- DataTables -->
    <link rel="stylesheet"
          href="../../static/bower_components/datatables.net-bs/css/dataTables.bootstrap.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet"
          href="../../static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.css">
</head>
<body>
<div class="col-xs-12">
    <div class="box">
        <div class="box-body">
            <table id="example" class="table table-bordered table-hover">

                <thead>
                <tr>
                    <th>用户名</th>
                    <th>用户密码</th>
                    <th>用户类型</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.userType}</td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
        <!-- /.box-body -->
    </div>
    <!-- /.box -->
</div>
<!-- DataTables -->
<script
        src="../../static/bower_components/datatables.net/js/jquery.dataTables.js"></script>
<script
        src="../../static/bower_components/datatables.net-bs/js/dataTables.bootstrap.js"></script>
<script>
    $(function() {
        $('#example').DataTable({
            'paging' : true,
            'lengthChange' : false,
            'searching' : false,
            'ordering' : true,
            'info' : true,
            'autoWidth' : false,
            "bRetrieve": true
        })
    })
</script>
</html>
