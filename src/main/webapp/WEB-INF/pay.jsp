<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>支付界面</h2>
<form action="pay" method="post">
From:<input name="fromCardNo"> To:<input name="toCardNo"> Money:<input name="money"><input type="submit" value="Pay">

</form>
</body>
</html>
