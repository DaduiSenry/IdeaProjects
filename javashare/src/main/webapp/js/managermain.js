$(function() {
	// fun("#user_insert","#show_insertuser",closeallfile());
    // fun("#user_manage","#table_user",closealltable());
	$("#user_insert").click(function() {
        closeallfile();
		$("#show_insertuser").css("display","");
	})
	$("#user_delete").click(function() {
        closeallfile();
		$("#show_deleteuser").css("display","");
	})
	$("#user_update").click(function() {
        closeallfile();
		$("#show_updateuser").css("display","");
	})
	$("#user_select").click(function() {
        closeallfile();
		$("#show_selectuser").css("display","");
	})
    $("#interview_manage").click(function() {
        closealltable();
        closeallfile();
        $("#showmessage").html("");
        $("#table_interview").css("display","");
    })
	$("#user_manage").click(function () {
        closealltable();
        closeallfile();
        $("#showmessage").html("");
        $("#table_user").css("display","");
    })
    $("#book_manage").click(function () {
        closealltable();
        closeallfile();
        $("#showmessage").html("");
        $("#table_book").css("display","");
    })
    $("#node_manage").click(function () {
        closealltable();
        closeallfile();
        $("#showmessage").html("");
        $("#table_node").css("display","");
    })
    $("#video_manage").click(function () {
        closealltable();
        closeallfile();
        $("#showmessage").html("");
        $("#table_video").css("display","");
    })
	$("#interview_insert").click(function () {
        closeallfile();
        $("#show_insertiq").css("display","");
    })
    $("#interview_delete").click(function () {
        closeallfile();
        $("#show_deleteiq").css("display","");
    })
    $("#interview_update").click(function () {
        closeallfile();
        $("#show_updateiq").css("display","");
    })
    $("#interview_select").click(function () {
        closeallfile();
        $("#show_selectiq").css("display","");
    })

    /**
     *书籍导航栏
     */
    $("#book_insert").click(function () {
        closeallfile();
        $("#show_insertbook").css("display","");
    })
    $("#book_delete").click(function () {
        closeallfile();
        $("#show_deletebook").css("display","");
    })
    $("#book_update").click(function () {
        closeallfile();
        $("#show_updatebook").css("display","");
    })
    $("#book_select").click(function () {
        closeallfile();
        $("#show_selectbook").css("display","");
    })

    /**
     *笔记导航栏
     */
    $("#node_insert").click(function () {
        closeallfile();
        $("#show_insertnode").css("display","");
    })
    $("#node_delete").click(function () {
        closeallfile();
        $("#show_deletenode").css("display","");
    })
    $("#node_update").click(function () {
        closeallfile();
        $("#show_updatenode").css("display","");
    })
    $("#node_select").click(function () {
        closeallfile();
        $("#show_selectnode").css("display","");
    })

    /**
     *视频导航栏
     */
    $("#video_insert").click(function () {
        closeallfile();
        $("#show_insertvideo").css("display","");
    })
    $("#video_delete").click(function () {
        closeallfile();
        $("#show_deletevideo").css("display","");
    })
    $("#video_update").click(function () {
        closeallfile();
        $("#show_updatevideo").css("display","");
    })
    $("#video_select").click(function () {
        closeallfile();
        $("#show_selectvideo").css("display","");
    })


	$("#btn_insert").click(function() {
		var insertData=$("#form_insert").serialize();
		$.ajax({
			  url:"http://localhost:8080/insertuser",
			  type:"POST",
			  data:insertData,
			  async:true,
			  success:function(data){
			    if(data==1){
			    	alert("添加成功");
			    	$(location).attr("href","");
			    }else{
			    	alert("该用户名已被注册");
			    }
			  },
			  error:function(){
			    alert("erro");
			  }
			})
	})
	$("#btn_delete").click(function() {
		var deleteData=$("#form_delete").serialize();
		$.ajax({
			  url:"http://localhost:8080/deleteuser",
			  type:"POST",
			  data:deleteData,
			  async:true,
			  success:function(data){
			    if(data==1){
			    	alert("删除成功");
			    	$(location).attr("href","");
			    }else{
			    	alert("该用户名不存在");
			    }
			  },
			  error:function(){
			    alert("erro");
			  }
			})
	})
	
	$("#btn_update").click(function() {
		var updateData=$("#form_update").serialize();
		$.ajax({
			  url:"http://localhost:8080/updateuser",
			  type:"POST",
			  data:updateData,
			  async:true,
			  success:function(data){
				  	if(data==1){
				  		alert("修改成功");
				    	$(location).attr("href","");
				  	}else{
				  		alert("没有该用户");
				  	}
			  },
			  error:function(){
			    alert("erro");
			  }
			})
	})
	$("#btn_select").click(function() {
	    var ur='<h3>查询结果</h3><div class="col-xs-12"><div class="box"><div class="box-body"><table id="example10" class="table table-bordered table-hover"><thead>'
        ur+="<tr><th>用户名<th>用户密码<th>用户类型</tr></thead><tbody>";
		var selectData=$("#form_select").serialize();
		$.ajax({
			  url:"http://localhost:8080/selectum",
			  type:"POST",
			  data:selectData,
			  async:true,
			  success:function(data){
				  ajaxobj=eval("("+data+")");
				  ur+="<tr><td>"+ajaxobj.username+"</td><td>"+ajaxobj.password+"</td><td>"+ajaxobj.userType+"</td></tr>";
                  ur+="<script>$(function() {$('#example10').DataTable({'paging' : true,'lengthChange' : false,'searching' : false,'ordering' : true,'info' : true,'autoWidth' : false,\"bRetrieve\": true})})</script>";
			    $(".showmessage").html(ur);
			  },
			  error:function(){
			    alert("erro");
			  }
			})
	})

    $("#btn_insertiq").click(function() {

        var formData = new FormData($('#form_iq_insert')[0]);
        $.ajax({
            url: 'http://localhost:8080/insertiq',
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                if(data==1){
                    alert("添加成功");
                    $(location).attr("href","");
                }else{
                    alert("添加失败");
                }

            },
			error:function(){
            	alert("添加失败");
                $(location).attr("href","");
			}
        });


        // var muForm=new FormData();
        // var iqKind=$("#iq_kind").val();
        // var iqFile=$("#iq_file")[0].files[0];
        // muForm.append("iq_kind",iqKind);
        // muForm.append("iq_file",iqFile);
        // $.ajax({
        //     url:"http://localhost:8080/insertiq",
        //     type:"POST",
        //     data:muForm,
        //     async:false,
		// 	cache:"false",
        //     processData: false,
        //     contentType: false,
        //     success:function(data){
        //         if(data==1){
        //             alert("上传成功");
        //         }else{
        //             alert("上传失败");
        //         }
        //     },
        //     error:function(){
        //         alert("erro");
        //     }
        // })
    })

    $("#btn_deleteiq").click(function () {
        $.ajax({
            url:"http://localhost:8080/deleteiq",
            type:"POST",
            data:$("#form_deleteiq").serialize(),
            async:true,
            success:function(data){
                if(data==1){
                    alert("删除成功");
                    $(location).attr("href","");
                }else{
                    alert("该id不存在");
                }
            },
            error:function(){
                alert("erro");
            }
        })
    })

    $("#btn_updateiq").click(function () {
        $.ajax({
            url:"http://localhost:8080/updateiq",
            type:"POST",
            data:$("#form_updateiq").serialize(),
            async:true,
            success:function(data){
                if(data==1){
                    alert("修改成功");
                    $(location).attr("href","");
                }else{
                    alert("修改失败，请检查输入的信息");
                }
            },
            error:function(){
                alert("该id不存在");
            }
        })
    })

    $("#btn_selectiq").click(function() {
        var ur='<h3>查询结果</h3><div class="col-xs-12"><div class="box"><div class="box-body"><table id="example10" class="table table-bordered table-hover"><thead>'
        ur+="<tr><th>面试题id<th>面试题名称<th>面试题路径<th>面试题类型</tr></thead><tbody>";
        var selectData=$("#form_selectiq").serialize();
        $.ajax({
            url:"http://localhost:8080/selectiq",
            type:"POST",
            data:selectData,
            async:true,
            success:function(data){
                ajaxobj=eval("("+data+")");
                for(var i=0;i<ajaxobj.length;i++){
                    ur+="<tr><td>"+ajaxobj[i].id+"</td><td>"+ajaxobj[i].name+"</td><td>"+ajaxobj[i].path+"</td><td>"+ajaxobj[i].kind+"</td></tr>";
                }
                ur+="<script>$(function() {$('#example10').DataTable({'paging' : true,'lengthChange' : false,'searching' : false,'ordering' : true,'info' : true,'autoWidth' : false,\"bRetrieve\": true})})</script>";
                $(".showmessage").html(ur);
            },
            error:function(){
                alert("erro");
            }
        })
    })

    $("#btn_insertbook").click(function() {

        var formData = new FormData($('#form_book_insert')[0]);
        $.ajax({
            url: 'http://localhost:8080/insertbook',
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                if (data == 1) {
                    alert("添加成功");
                    $(location).attr("href", "");
                } else {
                    alert("添加失败");
                }

            },
            error: function () {
                alert("添加失败");
                $(location).attr("href", "");
            }
        });
    })

    $("#btn_deletebook").click(function () {
        $.ajax({
            url:"http://localhost:8080/deletebook",
            type:"POST",
            data:$("#form_deletebook").serialize(),
            async:true,
            success:function(data){
                if(data==1){
                    alert("删除成功");
                    $(location).attr("href","");
                }else{
                    alert("该id不存在");
                }
            },
            error:function(){
                alert("erro");
            }
        })
    })

    $("#btn_updatebook").click(function () {
        $.ajax({
            url:"http://localhost:8080/updatebook",
            type:"POST",
            data:$("#form_updatebook").serialize(),
            async:true,
            success:function(data){
                if(data==1){
                    alert("修改成功");
                    $(location).attr("href","");
                }else{
                    alert("修改失败，请检查输入的信息");
                }
            },
            error:function(){
                alert("该id不存在");
            }
        })
    })

    $("#btn_selectbook").click(function() {
        var ur='<h3>查询结果</h3><div class="col-xs-12"><div class="box"><div class="box-body"><table id="example10" class="table table-bordered table-hover"><thead>'
        ur+="<tr><th>书籍id<th>书籍名称<th>书籍路径<th>书籍类型</tr></thead><tbody>";
        var selectData=$("#form_selectbook").serialize();
        $.ajax({
            url:"http://localhost:8080/selectbook",
            type:"POST",
            data:selectData,
            async:true,
            success:function(data){
                ajaxobj=eval("("+data+")");
                for(var i=0;i<ajaxobj.length;i++){
                    ur+="<tr><td>"+ajaxobj[i].id+"</td><td>"+ajaxobj[i].name+"</td><td>"+ajaxobj[i].path+"</td><td>"+ajaxobj[i].kind+"</td></tr>";
                }
                ur+="<script>$(function() {$('#example10').DataTable({'paging' : true,'lengthChange' : false,'searching' : false,'ordering' : true,'info' : true,'autoWidth' : false,\"bRetrieve\": true})})</script>";
                $(".showmessage").html(ur);
            },
            error:function(){
                alert("erro");
            }
        })
    })

    $("#btn_insertnode").click(function() {

        var formData = new FormData($('#form_node_insert')[0]);
        $.ajax({
            url: 'http://localhost:8080/insertnode',
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                if (data == 1) {
                    alert("添加成功");
                    $(location).attr("href", "");
                } else {
                    alert("添加失败");
                }

            },
            error: function () {
                alert("添加失败");
                $(location).attr("href", "");
            }
        });
    })

    $("#btn_deletenode").click(function () {
        $.ajax({
            url:"http://localhost:8080/deletenode",
            type:"POST",
            data:$("#form_deletenode").serialize(),
            async:true,
            success:function(data){
                if(data==1){
                    alert("删除成功");
                    $(location).attr("href","");
                }else{
                    alert("该id不存在");
                }
            },
            error:function(){
                alert("erro");
            }
        })
    })

    $("#btn_updatenode").click(function () {
        $.ajax({
            url:"http://localhost:8080/updatenode",
            type:"POST",
            data:$("#form_updatenode").serialize(),
            async:true,
            success:function(data){
                if(data==1){
                    alert("修改成功");
                    $(location).attr("href","");
                }else{
                    alert("修改失败，请检查输入的信息");
                }
            },
            error:function(){
                alert("该id不存在");
            }
        })
    })

    $("#btn_selectnode").click(function() {
        var ur='<h3>查询结果</h3><div class="col-xs-12"><div class="box"><div class="box-body"><table id="example10" class="table table-bordered table-hover"><thead>'
        ur+="<tr><th>书籍id<th>书籍名称<th>书籍路径<th>书籍类型</tr></thead><tbody>";
        var selectData=$("#form_selectnode").serialize();
        $.ajax({
            url:"http://localhost:8080/selectnode",
            type:"POST",
            data:selectData,
            async:true,
            success:function(data){
                ajaxobj=eval("("+data+")");
                for(var i=0;i<ajaxobj.length;i++){
                    ur+="<tr><td>"+ajaxobj[i].id+"</td><td>"+ajaxobj[i].name+"</td><td>"+ajaxobj[i].path+"</td><td>"+ajaxobj[i].kind+"</td></tr>";
                }
                ur+="<script>$(function() {$('#example10').DataTable({'paging' : true,'lengthChange' : false,'searching' : false,'ordering' : true,'info' : true,'autoWidth' : false,\"bRetrieve\": true})})</script>";
                $(".showmessage").html(ur);
            },
            error:function(){
                alert("erro");
            }
        })
    })


    /**
     * 视频
     */
    $("#btn_insertvideo").click(function() {

        var formData = new FormData($('#form_video_insert')[0]);
        $.ajax({
            url: 'http://localhost:8080/insertvideo',
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                if (data == 1) {
                    alert("添加成功");
                    $(location).attr("href", "");
                } else {
                    alert("添加失败");
                }

            },
            error: function () {
                alert("添加失败");
                $(location).attr("href", "");
            }
        });
    })

    $("#btn_deletevideo").click(function () {
        $.ajax({
            url:"http://localhost:8080/deletevideo",
            type:"POST",
            data:$("#form_deletevideo").serialize(),
            async:true,
            success:function(data){
                if(data==1){
                    alert("删除成功");
                    $(location).attr("href","");
                }else{
                    alert("该id不存在");
                }
            },
            error:function(){
                alert("erro");
            }
        })
    })

    $("#btn_updatevideo").click(function () {
        $.ajax({
            url:"http://localhost:8080/updatevideo",
            type:"POST",
            data:$("#form_updatevideo").serialize(),
            async:true,
            success:function(data){
                if(data==1){
                    alert("修改成功");
                    $(location).attr("href","");
                }else{
                    alert("修改失败，请检查输入的信息");
                }
            },
            error:function(){
                alert("该id不存在");
            }
        })
    })

    $("#btn_selectvideo").click(function() {
        var ur='<h3>查询结果</h3><div class="col-xs-12"><div class="box"><div class="box-body"><table id="example10" class="table table-bordered table-hover"><thead>'
        ur+="<tr><th>视频id<th>视频名称<th>视频路径<th>视频类型</tr></thead><tbody>";
        var selectData=$("#form_selectvideo").serialize();
        $.ajax({
            url:"http://localhost:8080/selectvideo",
            type:"POST",
            data:selectData,
            async:true,
            success:function(data){
                ajaxobj=eval("("+data+")");
                for(var i=0;i<ajaxobj.length;i++){
                    ur+="<tr><td>"+ajaxobj[i].id+"</td><td>"+ajaxobj[i].name+"</td><td>"+ajaxobj[i].path+"</td><td>"+ajaxobj[i].kind+"</td></tr>";
                }
                ur+="<script>$(function() {$('#example10').DataTable({'paging' : true,'lengthChange' : false,'searching' : false,'ordering' : true,'info' : true,'autoWidth' : false,\"bRetrieve\": true})})</script>";
                $(".showmessage").html(ur);
            },
            error:function(){
                alert("erro");
            }
        })
    })

    /**
     * 方法
     */
    function closeallfile(){
		$(".show_file").css("display","none");
	}

	function closealltable(){
		$(".table_file").css("display","none");
	}

	function fun(btn,showarea,method){
		$(btn).click(function () {
            if($(showarea).css("display")==none){
                method;
                $(showarea).css("display","");
            }
        })

	}
})