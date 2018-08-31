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
        <h3 class="box-title">上传面试题</h3>
    </div>
    <!-- /.box-header -->
    <!-- form start -->
    <form role="form" enctype="multipart/form-data" id="form_iq_insert">
        <div class="box-body">
            <div class="form-group">
                <label for="iq_kind">面试题种类
                </label>
                <input type="text" class="form-control" id="iq_kind" name="iq_kind" placeholder="输入面试题种类">
            </div>
            <div class="form-group">
                <label for="iq_file">上传文件</label>
                <input type="file" id="iq_file" name="iq_file">

                <p class="help-block">选择你要上传的文件</p>
            </div>
        </div>
        <!-- /.box-body -->

        <div class="box-footer">
            <button type="button" class="btn btn-primary" id="btn_insertiq">添加</button>
        </div>
    </form>
</div>
<!-- /.box -->
</body>
</html>










