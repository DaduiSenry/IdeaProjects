$(function() {
	$("#btn_insert").click(function() {
		closealldiv();
		$(".insertuser").css("display","");
	})
	$("#btn_delete").click(function() {
		closealldiv();
		$(".deleteuser").css("display","");

	})
	$("#btn_update").click(function() {
		closealldiv();
		$(".updateuser").css("display","");

	})
	$("#btn_select").click(function() {
		closealldiv();
		$(".selectuser").css("display","");
		$(".showmessage").css("display","");

	})
	
	$("#btn_qinsert").click(function() {
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
	$("#btn_qdelete").click(function() {
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
	$("#btn_qupdate").click(function() {
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
	$("#btn_qselect").click(function() {
		var ur="<tr><th>用户名<th>用户密码<th>用户类型</tr>";
		var selectData=$("#form_select").serialize();
		$.ajax({
			  url:"http://localhost:8080/selectum",
			  type:"POST",
			  data:selectData,
			  async:true,
			  success:function(data){
				  ajaxobj=eval("("+data+")");
				  ur+="<tr><td>"+ajaxobj.username+"</td><td>"+ajaxobj.password+"</td><td>"+ajaxobj.userType+"</td></tr>";
			    $(".showmessage").html(ur);
			  },
			  error:function(){
			    alert("erro");
			  }
			})
	})
	function closealldiv(){
		$("div").css("display","none");
	}
})