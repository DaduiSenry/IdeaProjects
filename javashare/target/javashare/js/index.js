$(function() {
	$("#a_login").click(function() {
		$(location).attr("href","http://localhost:8080/login");
	})
	$("#a_register").click(function() {
		$(location).attr("href","http://localhost:8080/register");
	})
})