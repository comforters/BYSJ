<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<form id="loginForm" action="login" method="post">
	<div style="margin-left: 550px;margin-top: 180px">
		<div class="easyui-panel" title="LOGIN"
			style="width: 400px; padding: 30px 60px;">
			<div style="margin-bottom: 20px">
				<div>用户名:</div>
				<input name="userName" class="easyui-textbox" data-options="prompt:'请输入账号'"
					style="width: 100%; height: 32px">
			</div>
			<div style="margin-bottom: 20px">
				<div>密码:</div>
				<input name="passWd" class="easyui-textbox" data-options="prompt:'请输入密码'"
					style="width: 100%; height: 32px">
			</div>
			<div style="margin-bottom: 20px">
				<div>
					<input type="checkbox">记住密码:
				</div>
			</div>
			<div>
				<a id="loginBtn" href="#" class="easyui-linkbutton"
					iconCls="icon-ok" style="width: 100%; height: 32px">登录</a>
			</div>
		</div>
	</div>
	</form>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#loginBtn").click(function(){
		 $("#loginForm").submit();
	});
});
</script>
</html>
