<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Hello World!</h2>
<table>
<c:forEach items="${requestScope.list }" var="ui">
	<tr>
		<Td>${ui.id }</Td>
		<Td>${ui.userName }</Td>
		<Td>${ui.passWd }</Td>
	</tr>
</c:forEach>
</table>
</body>
</html>
