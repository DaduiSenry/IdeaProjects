<%@page pageEncoding="UTF-8" language="java" import="java.util.*"
        contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/managermain.js"></script>
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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <div class="header">
        <%@ include file="header.jsp" %>
    </div>
    <div class="content-wrapper">
        <section class="content">
            <div class="row">
                <div style="display:none" id="table_user" class="table_file">
                    <%@ include file="table_user.jsp" %>
                </div>
                <div style="display:none" id="table_interview" class="table_file">
                    <%@ include file="table_interview.jsp" %>
                </div>
                <div style="display:none" id="table_book" class="table_file">
                    <%@ include file="table_book.jsp" %>
                </div>
                <div style="display:none" id="table_node" class="table_file">
                    <%@ include file="table_node.jsp" %>
                </div>
                <div style="display:none" id="table_video" class="table_file">
                    <%@ include file="table_video.jsp" %>
                </div>
                <div class="showmessage" id="showmessage"></div>
                <div class="col-md-6">
                    <div style="display:none" id="show_insertuser" class="show_file">
                        <%@ include file="insertuser.jsp" %>
                    </div>
                    <div style="display:none" id="show_deleteuser" class="show_file">
                        <%@ include file="deleteuser.jsp" %>
                    </div>
                    <div style="display:none" id="show_updateuser" class="show_file">
                        <%@ include file="updateuser.jsp" %>
                    </div>
                    <div style="display:none" id="show_selectuser" class="show_file">
                        <%@ include file="selectuser.jsp" %>
                    </div>
                    <div style="display:none" id="show_insertiq" class="show_file">
                        <%@ include file="interview_insert.jsp" %>
                    </div>
                    <div style="display:none" id="show_deleteiq" class="show_file">
                        <%@ include file="interview_delete.jsp" %>
                    </div>
                    <div style="display:none" id="show_updateiq" class="show_file">
                        <%@ include file="interview_update.jsp" %>
                    </div>
                    <div style="display:none" id="show_selectiq" class="show_file">
                        <%@ include file="interview_select.jsp" %>
                    </div>
                    <div style="display:none" id="show_insertnode" class="show_file">
                        <%@ include file="node_insert.jsp" %>
                    </div>
                    <div style="display:none" id="show_deletenode" class="show_file">
                        <%@ include file="node_delete.jsp" %>
                    </div>
                    <div style="display:none" id="show_updatenode" class="show_file">
                        <%@ include file="node_update.jsp" %>
                    </div>
                    <div style="display:none" id="show_selectnode" class="show_file">
                        <%@ include file="node_select.jsp" %>
                    </div>
                    <div style="display:none" id="show_insertvideo" class="show_file">
                        <%@ include file="video_insert.jsp" %>
                    </div>
                    <div style="display:none" id="show_deletevideo" class="show_file">
                        <%@ include file="video_delete.jsp" %>
                    </div>
                    <div style="display:none" id="show_updatevideo" class="show_file">
                        <%@ include file="video_update.jsp" %>
                    </div>
                    <div style="display:none" id="show_selectvideo" class="show_file">
                        <%@ include file="video_select.jsp" %>
                    </div>
                    <div style="display:none" id="show_insertbook" class="show_file">
                        <%@ include file="book_insert.jsp" %>
                    </div>
                    <div style="display:none" id="show_deletebook" class="show_file">
                        <%@ include file="book_delete.jsp" %>
                    </div>
                    <div style="display:none" id="show_updatebook" class="show_file">
                        <%@ include file="book_update.jsp" %>
                    </div>
                    <div style="display:none" id="show_selectbook" class="show_file">
                        <%@ include file="book_select.jsp" %>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<div>
<!-- jQuery 3 -->
<script
        src="../../static/bower_components/jquery/dist/jquery.js"></script>
<!-- jQuery UI 1.11.4 -->
<script
        src="../../static/bower_components/jquery-ui/jquery-ui.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script
        src="../../static/bower_components/bootstrap/dist/js/bootstrap.js"></script>
<!-- Sparkline -->
<script
        src="../../static/bower_components/jquery-sparkline/dist/jquery.sparkline.js"></script>
<!-- DataTables -->
<script
        src="../../static/bower_components/datatables.net/js/jquery.dataTables.js"></script>
<script
        src="../../static/bower_components/datatables.net-bs/js/dataTables.bootstrap.js"></script>
<!-- jvectormap -->
<script
        src="../../static/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="../../static/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script
        src="../../static/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script
        src="../../static/bower_components/moment/min/moment.min.js"></script>
<script
        src="../../static/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script
        src="../../static/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script
        src="../../static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.js"></script>
<!-- Slimscroll -->
<script
        src="../../static/bower_components/jquery-slimscroll/jquery.slimscroll.js"></script>
<!-- FastClick -->
<script
        src="../../static/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../static/dist/js/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../../static/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../static/dist/js/demo.js"></script>
</div>

</body>
</html>