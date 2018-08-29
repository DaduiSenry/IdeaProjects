$(function() {
	$("#btn_register").click(function() {
		var loginData=$("#form_register").serialize();
		$.ajax({
			  url:"http://localhost:8080/insertuser",
			  type:"POST",
			  data:loginData,
			  async:true,
			  success:function(data){
			    if(data==1){
			    	alert("注册成功");
			    	$(location).attr("href","http://localhost:8080/login");
			    }else{
			    	alert("该用户名已被注册");
			    }
			  },
			  error:function(){
			    alert("erro");
			  }
			})
	})
})