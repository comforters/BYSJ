<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>基础树</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function getCookie(name) {
		var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
		if (arr = document.cookie.match(reg))
			return unescape(arr[2]);
		else
			return null;
	}
	function setCookie(name, value,days) {
		var exp = new Date();
		exp.setTime(exp.getTime() + days * 24 * 60 * 60 * 1000);
		document.cookie = name + "=" + escape(value) + ";expires="+ exp.toGMTString();
	}
	$(document).ready(function(){
		var pwd= getCookie("password");
		var name= getCookie("username");
		$("#pwd").val(pwd);
		$("#name").val(name);
	});
	function remberMe(){
		var v =$("#name").val();
		setCookie("username",v,1);
		var p =$("#pwd").val();
		setCookie("password",p,1);
		
	}
</script>
</head>

<body>
	<input type="button" value="写cookie" onclick="setCookie('key1','value1',1)">
	<input type="button" value="读cookie" onclick="alert(getCookie('key1'));">
	<input type="button" value="登录成功记录cookie" onclick="remberMe()">
	UserName:<input id="name" />
	PassWord:<input id="pwd"/>
	<input type="checkbox">记住密码

</body>

</html>