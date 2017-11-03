<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="newUser()">添加</a> <a href="addFlow" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a> <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="removeUser()">删除</a>
	</div>
	<table id="tt" class="easyui-datagrid"
		style="width: 60% px; height: auto;">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="name1" width="150">流程编号</th>
				<th field="name2" width="150">流程名称</th>
				<th field="name3" width="150">流程操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="ui">
				<tr>
					<td>11</td>
					<td>${ui.id }</td>
					<td>${ui.flowName }</td>
					<td><a href="gooflow?id=${ui.id }">查看流程</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<my:page />
</body>
<script type="text/javascript">
	function showRoleList(id) {
		$("#roleWin").window("open");
	}
	function newUser() {
		$("#newUserWin").window("open");
	}
	function editUser() {
		var row = $('#tt').datagrid('getSelected');
		alert(row.name1);
	}
	function removeUser() {
		var row = $('#tt').datagrid('getSelected');
		alert(row.name1);
	}
	$(document).ready(function() {
		$("#roleWin").window("close");
		$("#newUserWin").window("close");
	});
</script>
</html>