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
              <h3 class="box-title">查找视频</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal"  id="form_selectvideo">
              <div class="box-body">
                <div class="form-group">
                  <label class="col-sm-2 control-label">视频id</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="输入视频id" name="video_id">
                  </div>
                </div>
                  <div class="form-group">
                      <label class="col-sm-2 control-label">视频名称</label>

                      <div class="col-sm-10">
                          <input type="text" class="form-control" placeholder="输入视频名称" name="video_name">
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="col-sm-2 control-label">视频路径</label>

                      <div class="col-sm-10">
                          <input type="text" class="form-control" placeholder="输入视频路径" name="video_path">
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="col-sm-2 control-label">视频种类</label>

                      <div class="col-sm-10">
                          <input type="text" class="form-control" placeholder="输入视频种类" name="video_kind">
                      </div>
                  </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="button" class="btn btn-default">清空</button>
                <button type="button" class="btn btn-info pull-right"  id="btn_selectvideo">查找</button>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
</body>
</html>