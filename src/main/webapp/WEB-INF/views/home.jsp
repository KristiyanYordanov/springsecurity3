<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div><a href="next">next</a></div>
<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
</body>
<script type="text/javascript">
function logout(){
	return false;
}
</script>
</html>
