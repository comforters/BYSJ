<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理首页</title>
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>

<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
	<div class="easyui-layout" style="width: 100%; height: 765px;">
		<!-- header -->
		<div region="north" id="northId" split="true" border="false">
			<span id="span1">欢迎${sessionScope.userinfo.userName}
				<a href="#" id="editpass">修改密码</a> 
				<a href="#" id="loginOut">安全退出</a>
			</span> 
			<span id="span2"> 
				<img src="images/blocks.gif" width="20"	height="20" align="absmiddle" />基于RBAC权限管理系统
			</span>
		</div>
		<div data-options="region:'west',split:true" title="菜单导航"	style="width: 200px;">
			<!-- 菜单导航 -->
			<div class="easyui-panel" style="padding: 5px;border:0px">
				<ul id="tt" class="easyui-tree"	data-options="url:'tree',method:'get',animate:true,lines:true,state:closed"></ul>
			</div>
		</div>
		<!-- footer -->
		<div region="south" split="true"
			style="height: 30px; background: #D2E0F2;">
			<div class="footer">By 成都兴学9班</div>
		</div>
		<!-- 选项卡 -->
		<div id="tabId" class="easyui-tabs" style="border: 0px" data-options="region:'center'">
			 
		</div>
	</div>
	<!--修改密码窗口-->
	<div id="w" class="easyui-window" title="修改密码" collapsible="false" 	minimizable="false" maximizable="false" icon="icon-save"
		style="width: 300px; height: 200px; padding: 5px; background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>旧密码：</td>
						<td><input id="txtOldPass" type="Password" class="txt01" /></td>
					</tr>
					<tr>
						<td>新密码：</td>
						<td><input id="txtNewPass" type="Password" class="txt01" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="txtRePass" type="Password" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnOk" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)"> 确定</a> 
				<a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
			</div>
		</div>
	</div>
	 
</body>
<script type="text/javascript">
	$(document).ready(function() {
		//页面加载隐藏修改密码div
		$('#w').window('close');
		//退出登录
		$('#loginOut').click(function() {
			$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
				if (r) {
					location.href = '#';
				}
			});
		});
		//修改密码的超链接
		$('#editpass').click(function() {
			$('#w').window('open');
		});
		// 修改密码的确定按钮
		$('#btnOk').click(function() {
			var $oldpass = $('#txtOldPass');
			var $newpass = $('#txtNewPass');
			var $repass = $('#txtRePass');
			
			if($oldpass.val() == '') {
				$.messager.alert('系统提示','旧密码不能为空','error');
			}else if($newpass.val() == '') {
				$.messager.alert('系统提示','新密码不能为空','error');
			}else if($repass.val() == '') {
				$.messager.alert('系统提示','重复密码不能为空','error');
			}else if($newpass.val() != $rePass.val()) {
				$.messager.alert('系统提示','两次密码不一致','error');
			}else{
				
			}
		});
		// 修改密码的取消按钮
		$('#btnCancel').click(function() {
			$('#w').window('close');
		});
		// 菜单事件
		$('#tt').tree({
			onClick : function(node) {
				//获取内容
				//alert(node.text);
				//获取id
				//alert(node.id);
				
				//var parentNode =$('#tt').tree('getParent',node.target);
				// 获取父节点
				//alert(parentNode.text);
				
					var content = '<iframe scrolling="auto" frameborder="0"  src="'+node.note1+'" style="width:100%;height:100%;"></iframe>';
					$('#tabId').tabs('add',{
						title:node.text,
						content:content,
						closable:true
					});
			}
		});
		
	});
</script>
</html>