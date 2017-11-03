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
<script>
		$(document).ready(function(){
			//取审批人信息
			$(".seeprogress").click(function(){
				var nodeId=$(this).val(); //注意这儿this的用法
				var jsonObj={id:nodeId};
				var data=JSON.stringify(jsonObj); 
				$.ajax({
					 type:'POST',
					 url:'/lsd/nextnode',
					 dataType:'json',
					 contentType:'application/json',
					 data:data,
					 success:function(data){
						alert(data+"中~~");
					 } 
				 });
			});
		});
		
		function onsee(){
			alert("此事件当前由您审批")
		}
</script>

<body>
待申请事件:
	<table id="tt" class="easyui-datagrid"
		style="width: 60% px; height: auto;">
		<thead>
			<tr>
				<th field="name1" width="150">事件编号</th>
				<th field="name2" width="150">事件名称</th>
				<th field="name3" width="150">事件状态</th>
				<th field="name4" width="200">事件进度</th>
				<th field="name5" width="200">事件操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="ui">
				<tr>
					<td>${ui.id}</td>
					<td>${ui.defid}</td>
					<td>${ui.status}</td>
					<td><a class="seeprogress" value="${ui.nextNodeId}" href='#'>查看进度</a></td>
					<td><a href="delAsk.do?id=${ui.id}">撤销申请</td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>
待处理事件:
	<table id="tt" class="easyui-datagrid"
		style="width: 60% px; height: auto;">
		<thead>
			<tr>
				<th field="name1" width="150">事件申请者</th>
				<th field="name2" width="150">事件名称</th>
				<th field="name3" width="150">事件状态</th>
				<th field="name4" width="200">事件进度</th>
				<th field="name5" width="200">事件操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list2 }" var="ui">
				<tr>
					<td>${ui.userId}</td>
					<td>${ui.defid}</td>
					<td>${ui.status}</td>
					<td><a href='javascript:onsee()' >查看进度</a></td>
					<td><a id="btnOk" href="ok.do?id=${ui.id}" class="easyui-linkbutton"	iconCls="icon-ok" style="width: 60px; height: 20px" onclick="close()">同意</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        <a id="btnNo" href="#" class="easyui-linkbutton"        icon="icon-cancel" style="width: 60px; height: 20px" onclick="close()">拒绝</a>
				    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</html>