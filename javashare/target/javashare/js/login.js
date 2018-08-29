$(function() {
	$("#btn_login").click(function() {
		var loginData=$("#form_login").serialize();
		$.ajax({
			  url:"http://localhost:8080/loginuser",
			  type:"POST",
			  data:loginData,
			  async:true,
			  success:function(data){
			    if(data==1){
			    	$(location).attr("href","http://localhost:8080/index.html");
			    }else if(data==2){
			    	alert("欢迎管理员");
			    	$(location).attr("href","http://localhost:8080/manage");
			    }
			    else{
			    	alert("用户名或密码错误");
			    }
			  },
			  error:function(){
			    alert("erro");
			  }
			})
	})
})