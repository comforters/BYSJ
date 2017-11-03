<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>权限树</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>

<body>
	<div class="easyui-panel" style="padding: 5px">
		<ul id="tt" class="easyui-tree"
			data-options="url:'authTree',method:'get',animate:true,lines:true,state:closed"></ul>
	</div>
	<script type="text/javascript">
		// 单击获取
		$('#tt').tree({
			onClick : function(node) {
				//获取内容
				alert(node.text);
				//获取id
				alert(node.id);
				
				var parentNode =$('#tt').tree('getParent',node.target);
				// 获取父节点
				alert(parentNode.text);
			}
		});
	</script>
	
	
</body>

</html>