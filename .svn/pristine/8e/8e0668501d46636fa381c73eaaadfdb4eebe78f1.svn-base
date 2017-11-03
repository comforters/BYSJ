<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>右键菜单树</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>

<body>
	<div style="margin: 20px 0;">
		<a href="#" class="easyui-linkbutton" onclick="getChecked()">GetChecked</a>
	</div>
	<div class="easyui-panel" style="padding: 5px">
		<ul id="tt" class="easyui-tree"
			data-options="
				url: 'tree',
				method: 'get',
				animate: true,
				onClick: function(node){
					$(this).tree('beginEdit',node.target);
				},
				onContextMenu: function(e,node){
					e.preventDefault();
					$(this).tree('select',node.target);
					$('#mm').menu('show',{
						left: e.pageX,
						top: e.pageY
					});
				}
			"></ul>
	</div>
	<div id="mm" class="easyui-menu" style="width: 120px;">
		<div onclick="append()" data-options="iconCls:'icon-add'">Append</div>
		<div onclick="removeit()" data-options="iconCls:'icon-remove'">Remove</div>
		<div class="menu-sep"></div>
		<div onclick="expand()">Expand</div>
		<div onclick="collapse()">Collapse</div>
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
				var parentNode =$('#tt').tree('getParent',node.target);
				// 获取父节点
				alert(parentNode.text);
			},
			onBeforeEdit : function(node){
				text=node.text;
			}
		});
		function append() {
			var t = $('#tt');
			var node = t.tree('getSelected');
			t.tree('append', {
				parent : (node ? node.target : null),
				data : [ {
					text : 'new item1'
				} ]
			});
		}
		function removeit() {
			var node = $('#tt').tree('getSelected');
			$('#tt').tree('remove', node.target);
		}
		function collapse() {
			var node = $('#tt').tree('getSelected');
			$('#tt').tree('collapse', node.target);
		}
		function expand() {
			var node = $('#tt').tree('getSelected');
			$('#tt').tree('expand', node.target);
		}
	</script>
</body>

</html>