<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h3>Message : ${message}</h3>
	<h3>Username : ${username}</h3>

	<a href="<c:url value="/home1" />"> home1</a>
	
	<a href="<c:url value="/admin/home1" />"> admin home1</a>

	<form name='fo' action="<c:url value='j_spring_security_logout' />"
		method='POST'>
		<input type="submit" value="Logout" />
	</form>
</body>
</html>