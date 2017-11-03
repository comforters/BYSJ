<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="mytag" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function del(id) {
		$.messager.confirm('系统提示', '您确定要删除?', function(r) {
			if (r) {
				location.href = '#';
			}
		});
	}
</script>
</head>

<body>
	<div class="easyui-panel" title="条件检索"
		style="width: 600px; height: auto;">
		<form id="ff" method="post">
			<table cellpadding="5">
				<tr>
					<td>按用户编号:</td>
					<td><input class="easyui-textbox" type="text" name="name"
						data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>按用户名称:</td>
					<td><input class="easyui-textbox" type="text" name="email"
						data-options="required:true"></input></td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">搜索</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="clearForm()">清空</a>
		</div>
	</div>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="newUser()">添加</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a> <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="removeUser()">删除</a>
	</div>
	<table id="tt" class="easyui-datagrid"
		style="width: 60% px; height: auto;">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="name1" width="150">用户编号</th>
				<th field="name2" width="150">用户名称</th>
				<th field="name3" width="150">用户密码</th>
				<th field="name4" width="200">所属角色</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="ui">
				<tr>
					<td>11</td>
					<td>${ui.id }</td>
					<td>${ui.userName }</td>
					<td>${ui.passWd }</td>
					<td><a href='javascript:showRoleList(${ui.id })'>查看角色</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<my:page />
	<div id="roleWin" class="easyui-window" title="角色列表"
		style="width: 270px; height: 450px; top: 100px">
		<div class="easyui-panel" style="padding: 5px; border: 0px">
			<ul id="tt" class="easyui-tree"
				data-options="url:'tree',method:'get',animate:true,lines:true,state:closed"></ul>
		</div>
	</div>
	<div id="newUserWin" class="easyui-window" title="添加新用户"
		style="width: 500px; height: auto; top: 80px">
		<div style="margin-bottom: 20px">
			<div>用户名:</div>
			<input class="easyui-textbox" data-options="prompt:'请输入账号'"
				style="width: 100%; height: 32px">
		</div>
		<div style="margin-bottom: 20px">
			<div>密码:</div>
			<input class="easyui-textbox" data-options="prompt:'请输入密码'"
				style="width: 100%; height: 32px">
		</div>
		<div style="margin-bottom: 20px">
			<div>选择角色</div>
			<div class="easyui-panel" style="padding: 5px">
				<ul id="tt" class="easyui-tree"
					data-options="url:'tree',method:'get',animate:true,checkbox:true"></ul>
			</div>
		</div>
		<div>
			<a id="loginBtn" href="#" class="easyui-linkbutton" iconCls="icon-ok"
				style="width: 100%; height: 32px">保存</a>
		</div>
	</div>
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