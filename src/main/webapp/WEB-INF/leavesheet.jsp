<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请假申请</title>
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>

	<div class="easyui-layout" fit="true">
		<div region="center" border="false"
			style="padding: 10px; background: #fff; border: 1px solid #ccc;">
			<table cellpadding=3>
				<tr>
					<td>申请姓名:</td>
					<td><input
						style="width: 150px; border-bottom: 1px solid black; border-top: 0px; border-left: 0px; border-right: 0px;"></td>
					<td>所属部门:</td>
					<td><input
						style="width: 150px; border-bottom: 1px solid black; border-top: 0px; border-left: 0px; border-right: 0px;"></td>
				</tr>
				<tr>
					<td>开始时间:</td>
					<td><input class="easyui-datetimebox" value=""
						style="width: 150px"></td>
					<td>结束时间:</td>
					<td><input class="easyui-datetimebox" value=""
						style="width: 150px"></td>
				</tr>
				<tr>
					<td>共计天数</td>
					<td colspan="3">10天</td>
				</tr>
				<tr>
					<td>请假类型</td>
					<td colspan="3"><input type="checkbox">病假<input
						type="checkbox">事假<input type="checkbox">产假<input
						type="checkbox">婚假<input type="checkbox">年假<input
						type="checkbox">换休</td>
				</tr>
				<tr>
					<td>请假原因:</td>
					<td colspan="3"><input class="easyui-textbox"
						data-options="multiline:true" value=""
						style="width: 375px; height: 100px"></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<div style="padding: 5px 0;">
							<a id="save" href="ask.do?id=${sessionScope.userinfo.id}" class="easyui-linkbutton"	iconCls="icon-ok" style="width: 150px; height: 32px">保存并提交</a>
						</div>
					</td>
					
				</tr>
			</table>
		</div>

	</div>

</body>

</html>
