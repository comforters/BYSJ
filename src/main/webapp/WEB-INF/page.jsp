<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="mytag" prefix="m"%>
<html>
<head>
<meta charset="UTF-8">
<title>分页</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>分页</h2>
	<table>
		<c:forEach items="${requestScope.list }" var="ui">
			<tr>
				<Td>${ui.id }</Td>
				<Td>${ui.userName }</Td>
				<Td>${ui.passWd }</Td>
			</tr>
		</c:forEach>
	</table>
		
	<m:page/>
</body>
</html>
