<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>
table, tr,td {
    border-collapse: collapse;
    background-color:#3F48CC;
    text-aling:center;
    align="center";
}
th{
padding: 15px;
}

</style>
</head>
<body>

<form action="autentificar.html" method="POST">
<table>
<tr><th colspan=2>
<img src="${pageContext.servletContext.contextPath }/resources/images/Logo.png" />
</th></tr><tr><td>
Usuario: </td><td><input type="text" name="user" value="" />
</td></tr><tr><td>
Contraseña: </td><td><input type="password" name="pass" value=""/>
</td></tr><tr><td>
<input type="Submit" value="Entrar" />
</td></tr></table>

</form>
</body>
</html>
