<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>复选框树</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>

<body>
	<div style="margin: 20px 0;">
		<a href="#" class="easyui-linkbutton" onclick="getChecked()">GetChecked</a>
	</div>
	<div style="margin: 10px 0">
		<input type="checkbox" checked
			onchange="$('#tt').tree({cascadeCheck:$(this).is(':checked')})">CascadeCheck
		<input type="checkbox"
			onchange="$('#tt').tree({onlyLeafCheck:$(this).is(':checked')})">OnlyLeafCheck
	</div>
	<div class="easyui-panel" style="padding: 5px">
		<ul id="tt" class="easyui-tree"
			data-options="url:'tree',method:'get',animate:true,checkbox:true"></ul>
	</div>
	<script type="text/javascript">
		// 单击获取树的id
		function getChecked() {
			var nodes = $('#tt').tree('getChecked');
			var s = '';
			for (var i = 0; i < nodes.length; i++) {
				if (s != '')
					s += ',';
				s += nodes[i].text;
			}
			alert(s);
		}
	</script>
</body>

</html>