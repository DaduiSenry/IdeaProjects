<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/28
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" language="java" import="java.util.*"
            contentType="text/html; charset=utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<html>
<head>
    <title>Title</title>
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
<header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu"
           role="button"> <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
            </ul>
        </div>
    </nav>
</header>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control"
                       placeholder="Search..."> <span class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
                                    class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active treeview"><a href="javascript:void(0)" id="user_manage"> <i
                    class="fa fa-dashboard"></i> <span>用户管理</span> <span
                    class="pull-right-container"> <i
                    class="fa fa-angle-left pull-right"></i>
						</span>
            </a>
                <ul class="treeview-menu">
                    <li class="active" ><a href="javascript:void(0)" id="user_insert"><i class="fa fa-circle-o"></i>
                        添加用户</a></li>
                    <li><a href="javascript:void(0)" id="user_delete"><i class="fa fa-circle-o"></i> 删除用户</a></li>
                    <li><a href="javascript:void(0)" id="user_update"><i class="fa fa-circle-o"></i> 修改用户</a></li>
                    <li><a href="javascript:void(0)" id="user_select"><i class="fa fa-circle-o"></i> 查找用户</a></li>
                </ul></li>
            <li class="active treeview"><a href="#"> <i
                    class="fa fa-dashboard"></i> <span>面试题管理</span> <span
                    class="pull-right-container"> <i
                    class="fa fa-angle-left pull-right"></i>
						</span>
            </a>
                <ul class="treeview-menu">
                    <li class="active" id="interview_insert"><a href="#"><i class="fa fa-circle-o"></i>
                        添加面试题</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 删除面试题</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 修改面试题</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 查找面试题</a></li>
                </ul></li>
            <li class="active treeview"><a href="#"> <i
                    class="fa fa-dashboard"></i> <span>书籍管理</span> <span
                    class="pull-right-container"> <i
                    class="fa fa-angle-left pull-right"></i>
						</span>
            </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="#"><i class="fa fa-circle-o"></i>
                        添加书籍</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 删除书籍</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 修改书籍</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 查找书籍</a></li>
                </ul></li>
            <li class="active treeview"><a href="#"> <i
                    class="fa fa-dashboard"></i> <span>笔记管理</span> <span
                    class="pull-right-container"> <i
                    class="fa fa-angle-left pull-right"></i>
						</span>
            </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="#"><i class="fa fa-circle-o"></i>
                        添加笔记</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 删除笔记</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 修改笔记</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 查找笔记</a></li>
                </ul></li>
            <li class="active treeview"><a href="#"> <i
                    class="fa fa-dashboard"></i> <span>视频管理</span> <span
                    class="pull-right-container"> <i
                    class="fa fa-angle-left pull-right"></i>
						</span>
            </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="#"><i class="fa fa-circle-o"></i>
                        添加视频</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 删除视频</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 修改视频</a></li>
                    <li><a href><i class="fa fa-circle-o"></i> 查找视频</a></li>
                </ul></li>
    </section>
    <!-- /.sidebar -->
</aside>
</body>
</html>
