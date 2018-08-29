<%@page pageEncoding="UTF-8" language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/manageruser.js"></script>
</head>
<body>
	<h3>用户管理界面</h3>
	<table class="table table-hover">
		<tr>
			<th>用户名
			<th>用户密码
			<th>用户类型
		</tr>

		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.userType}</td>
			</tr>
		</c:forEach>


		<tr>
			<td>第${pages }页 共${totalpages }页 <a
				href="http://localhost:8080/selectalluser?pages=1">首页</a>
			<td><a
				href="http://localhost:8080/selectalluser?pages=${pages-1 }">上一页</a>
			<td><a
				href="http://localhost:8080/selectalluser?pages=${pages+1 }">下一页</a>
			<td><a
				href="http://localhost:8080/selectalluser?pages=${totalpages }">最后一页</a>
		</tr>
	</table>
	<input type="button" value="添加用户" id="btn_insert">
	<input type="button" value="删除用户" id="btn_delete">
	<input type="button" value="修改用户" id="btn_update">
	<input type="button" value="查找用户" id="btn_select">
	<div class="insertuser" style="display: none">
		<form id="form_insert">
			用户名：<input type="text" name="username"> 密码：<input type="text"
				name="password"> 类型：<input type="text" name="usertype">
			<input type="button" value="确认添加" id="btn_qinsert">
		</form>
	</div>
	<div class="deleteuser" style="display: none">
		<form id="form_delete">
			用户名：<input type="text" name="username"> <input type="button"
				value="确认删除" id="btn_qdelete">
		</form>
	</div>
	<div class="updateuser" style="display: none">
		<form id="form_update">
			用户名：<input type="text" name="username"> 密码：<input type="text"
				name="password"> 类型：<input type="text" name="usertype">
			<input type="button" value="确认修改" id="btn_qupdate">
		</form>
	</div>
	<div class="selectuser" style="display: none">
		<form id="form_select">
			用户名：<input type="text" name="username"> <input type="button"
				value="查找" id="btn_qselect">
		</form>
		<div class="showmessage">
		</div>
	</div>
</body>
</html>