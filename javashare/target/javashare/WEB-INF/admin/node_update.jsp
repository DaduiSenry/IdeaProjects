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
              <h3 class="box-title">修改笔记</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal" id="form_updatenode">
              <div class="box-body">
                <div class="form-group">
                  <label for="inputNodeId3" class="col-sm-2 control-label">笔记id</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputNodeId3" placeholder="输入笔记id" name="node_id">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputNodeName3" class="col-sm-2 control-label">笔记名称</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputNodeName3" placeholder="输入笔记名称" name="node_name">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputNodePath3" class="col-sm-2 control-label">笔记路径</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputNodePath3" placeholder="输入笔记路径" name="node_path">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputNodeKind3" class="col-sm-2 control-label">笔记种类</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputNodeKind3" placeholder="输入笔记种类" name="node_kind">
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="button" class="btn btn-default">清空</button>
                <button type="button" class="btn btn-info pull-right" id="btn_updatenode">确认修改</button>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
</body>
</html>