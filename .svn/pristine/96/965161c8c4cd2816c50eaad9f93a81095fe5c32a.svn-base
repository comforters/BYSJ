<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>可编辑的树</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>

<body>
	<div class="easyui-panel" style="padding: 5px">
		<ul id="tt" class="easyui-tree"
			data-options="
				url: 'tree',
				method: 'get',
				animate: true,
				onClick: function(node){
					$(this).tree('beginEdit',node.target);
				}">
		</ul>
	</div>
	<script type="text/javascript">
		var text="";
		$('#tt').tree({
			onAfterEdit : function(node) {
				if(node.text==text){
					alert("编辑前后无变化");
				}
				//获取内容
				alert(node.text);
				//获取id
				//alert(node.id);
			},
			onBeforeEdit : function(node){
				text=node.text;
			}
			
		});
	</script>
</body>

</html>