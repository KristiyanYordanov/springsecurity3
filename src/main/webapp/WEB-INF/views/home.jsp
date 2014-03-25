<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body onload="getCookie()">
	<h3>Message : ${message}</h3>
	<h3>Username : ${username}</h3>
	<h3>Username : ${username}</h3>
	
	<a href="<c:url value="/home1" />"> admin home only</a>
	<br>
	<a href="<c:url value="/home2" />"> admin home only can see "Hi admin"</a>
	<br>
	<a href="<c:url value="/admin/adminList" />"> admin list</a>
	<br>
	<a href="<c:url value="/user/userList" />"> user list</a>
	<br>

	<form name='fo' action="<c:url value='/j_spring_security_logout' />"
		method='POST'>
		<input type="submit" value="Logout" />
	</form>
</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
	function getCookie() {
	}
</script>
</html>