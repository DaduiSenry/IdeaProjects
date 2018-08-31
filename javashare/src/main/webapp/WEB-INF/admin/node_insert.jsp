<%@page pageEncoding="UTF-8" language="java" import="java.util.*"
        contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <!-- Tell the browser to be responsive to screen width -->
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
</head>
<body>
<!-- general form elements -->
<div class="box box-primary">
    <div class="box-header with-border">
        <h3 class="box-title">上传笔记</h3>
    </div>
    <!-- /.box-header -->
    <!-- form start -->
    <form role="form" enctype="multipart/form-data" id="form_node_insert">
        <div class="box-body">
            <div class="form-group">
                <label for="node_kind">笔记种类
                </label>
                <input type="text" class="form-control" id="node_kind" name="node_kind" placeholder="输入笔记种类">
            </div>
            <div class="form-group">
                <label for="node_file">上传文件</label>
                <input type="file" id="node_file" name="node_file">

                <p class="help-block">选择你要上传的文件</p>
            </div>
        </div>
        <!-- /.box-body -->

        <div class="box-footer">
            <button type="button" class="btn btn-primary" id="btn_insertnode">添加</button>
        </div>
    </form>
</div>
<!-- /.box -->
</body>
</html>










