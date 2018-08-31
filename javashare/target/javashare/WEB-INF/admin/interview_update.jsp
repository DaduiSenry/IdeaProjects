<%@page pageEncoding="UTF-8" language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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
<!-- Horizontal Form -->
					<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">修改面试题</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal" id="form_updateiq">
              <div class="box-body">
                <div class="form-group">
                  <label for="inputIQId3" class="col-sm-2 control-label">面试题id</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputIQId3" placeholder="输入面试题id" name="iq_id">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputIQName3" class="col-sm-2 control-label">面试题名称</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputIQName3" placeholder="输入密码" name="iq_name">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputIQPath3" class="col-sm-2 control-label">面试题路径</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputIQPath3" placeholder="输入面试题路径" name="iq_path">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputIQKind3" class="col-sm-2 control-label">面试题种类</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputIQKind3" placeholder="输入面试题种类" name="iq_kind">
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="button" class="btn btn-default">清空</button>
                <button type="button" class="btn btn-info pull-right" id="btn_updateiq">确认修改</button>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
</body>
</html>