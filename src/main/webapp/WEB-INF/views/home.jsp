<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h3>Message : ${message}</h3>
	<h3>Username : ${username}</h3>
	<h3>Username : ${username}</h3>
	
	<a href="<c:url value="/home1" />"> admin home only</a>
	<br>
	
	<a href="<c:url value="adminList" />"> admin list</a>
	<br>
	<a href="<c:url value="userList" />"> user list</a>
	<br>

	<form name='fo' action="<c:url value='j_spring_security_logout' />"
		method='POST'>
		<input type="submit" value="Logout" />
	</form>
</body>
</html>