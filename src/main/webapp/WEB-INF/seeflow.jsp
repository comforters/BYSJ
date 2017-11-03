<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>查看流程</title>
		<!--[if lt IE 9]>
<?import namespace="v" implementation="#default#VML" ?>
<![endif]-->
		<link rel="stylesheet" type="text/css" href="gooflow/css/GooFlow2.css" />
		<!--<link rel="stylesheet" type="text/css" href="codebase/GooFlow.css"/>-->
		<style>
			.myForm {
				display: block;
				margin: 0px;
				padding: 0px;
				line-height: 1.5;
				border: #ccc 1px solid;
				font: 12px Arial, Helvetica, sans-serif;
				margin: 5px 5px 0px 0px;
				border-radius: 4px;
			}
			
			.myForm .form_title {
				background: #428bca;
				padding: 4px;
				color: #fff;
				border-radius: 3px 3px 0px 0px;
			}
			
			.myForm .form_content {
				padding: 4px;
				background: #fff;
			}
			
			.myForm .form_content table {
				border: 0px
			}
			
			.myForm .form_content table td {
				border: 0px
			}
			
			.myForm .form_content table .th {
				text-align: right;
				font-weight: bold
			}
			
			.myForm .form_btn_div {
				text-align: center;
				border-top: #ccc 1px solid;
				background: #f5f5f5;
				padding: 4px;
				border-radius: 0px 0px 3px 3px;
			}
			
			#propertyForm {
				float: right;
				width: 260px
			}
		</style>
		<!-- jquery easyui -->
		<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="themes/icon.css">
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<!-- jquery easyui -->
		
		<!-- gooflow -->
        <script type="text/javascript" src="gooflow/js/child.js"></script>
		<script type="text/javascript" src="gooflow/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="gooflow/js/GooFunc.js"></script>
		<link rel="stylesheet" type="text/css" href="gooflow/css/default.css" />
		<script type="text/javascript" src="gooflow/js/GooFlow.js"></script>
		<!-- gooflow -->
		<script type="text/javascript">
			var roledata;
			var title;
			var property = {
				width: 600,
				height: 500,
				// 配置左侧工具栏
				//toolBtns: ["start round", "end round", "task round", "node", "chat", "state", "plug", "join", "fork", "complex mix"],
				//toolBtns: ["start round", "end round", "task round"],
	//			haveHead: true,
				// 配置头部菜单栏
				//headBtns: ["new", "open", "save", "undo", "redo", "reload"], //如果haveHead=true，则定义HEAD区的按钮
				headBtns: [ "new", "save", "undo", "redo", "reload"], //如果haveHead=true，则定义HEAD区的按钮
			 haveTool: true,
				haveGroup: true,
				useOperStack: true
			};
			var remark = {
				cursor: "选择指针",
				direct: "结点连线",
				start: "入口结点",
				"end": "结束结点",
				"task": "任务结点"
				//node: "自动结点",
				//chat: "决策结点",
				//state: "状态结点",
				//plug: "附加插件",
				//fork: "分支结点",
				//"join": "联合结点",
				//"complex mix": "复合结点",
				//group: "组织划分框编辑开关"
			};
			var demo;
			$(document).ready(function() {
				demo = $.createGooFlow($("#demo"), property);
				demo.setNodeRemarks(remark);
				demo.onItemDel = function(id, type) {
					/*
					if(confirm("确定要删除该单元吗?")) {
						this.blurItem();
						return true;
					} else {
						return false;
					}*/
					return true;
				}
				var message='${requestScope.jsonData}';
				alert(message);
				// 加载数据
				demo.loadData(message);
				demo.onItemFocus = function(id, model) {
					var obj;
					$("#ele_model").val(model);
					$("#ele_id").val(id);
					if(model == "line") {
						obj = this.$lineData[id];
						$("#ele_type").val(obj.M);
						$("#ele_left").val("");
						$("#ele_top").val("");
						$("#ele_width").val("");
						$("#ele_height").val("");
						$("#ele_from").val(obj.from);
						$("#ele_to").val(obj.to);
					} else if(model == "node") {
						obj = this.$nodeData[id];
						$("#ele_type").val(obj.type);
						$("#ele_left").val(obj.left);
						$("#ele_top").val(obj.top);
						$("#ele_width").val(obj.width);
						$("#ele_height").val(obj.height);
						$("#ele_from").val("");
						$("#ele_to").val("");
					}
					$("#ele_name").val(obj.name);
					var nodeName=obj.name;
					var json2={name:nodeName};
					var data=JSON.stringify(json2); 
					$.ajax({
						 type:'POST',
						 url:'/lsd/getRole',
						 dataType:'json',
						 contentType:'application/json',
						 data:data,
						 success:function(data){
							 $("#role_id").val(data.roleId);
							 $("#user_id").val(data.userId);
						 }
						 
					 });
					return true;
				};
				demo.onItemBlur = function(id, model) {
					document.getElementById("propertyForm").reset();
					return true;
				};
				// 点击新建按钮
				demo.onBtnNewClick = function() {
					this.clearData();
					title=prompt("请输入流程名称");
					
				};
				// 点击保存按钮
				demo.onBtnSaveClick = function() {
					// 设置标题
					demo.setTitle("请假申请");
					var data= JSON.stringify(demo.exportData()); 
					alert(data);
					$.ajax({
						 type:'POST',
						 url:'/lsd/page.do',
						 dataType:'json',
						 contentType:'application/json',
						 data:data,
						 success:function(data){
							alert(data);
						 }
						 
					 });
				};
				$("#sure").click(function(){
					var roleId=$("#role_id").val();
					var nodeName=$("#ele_name").val();
					var userId=$("#user_id").val();
					var json1={roleId:roleId,userId:userId,nodeName:nodeName};
					var data=JSON.stringify(json1); 
					$.ajax({
						 type:'POST',
						 url:'/lsd/saverole',
						 dataType:'json',
						 contentType:'application/json',
						 data:data
					 });
				});
			});
			var out;

			function Export() {
				document.getElementById("result").value = JSON.stringify(demo.exportData());
			}
		</script>
	</head>
	<body style="background:#EEEEEE">
		<div id="demo" style="margin:5px;float:left"></div>
		<form class="myForm" id="propertyForm">
			<div class="form_title">属性设置</div>
			<div class="form_content">
				<table>
					<tr>
						<td class="th">Id：</td>
						<td><input  type="text" style="width:120px" id="ele_id" /></td>
					</tr>
					<tr>
						<td class="th">Name：</td>
						<td><input type="text" style="width:120px" id="ele_name" /></td>
					</tr>
					<tr>
						<td class="th">Type：</td>
						<td><input type="text" style="width:120px" id="ele_type" /></td>
					</tr>
					<tr>
						<td class="th" >RoleId</td>
						<td><input type="text" style="width:120px" id="role_id" /></td>
					</tr>
					<tr>
						<td class="th">UserId</td>
						<td><input type="text" style="width:120px" id="user_id" /></td>
					</tr>
				</table>
			</div>
			
			<div class="form_btn_div">
				<input type="reset" value="重置" />
				<input id="sure" type="button" value="确定"  />
			</div>
		  </form>
	</body>
</html>