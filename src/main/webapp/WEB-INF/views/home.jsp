<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<form action="autentificar.html" method="POST">
<table>
<tr><td>
<img src="/resources/Logo.png" />
</td></tr><tr><td>
Usuario: </td><td><input type="text" name="user" value="" />
</td></tr><tr><td>
Contraseña: </td><td><input type="password" name="pass" value="" />
</td></tr><tr><td>
<input type="Submit" value="Entrar" />
</td></tr></table>

</form>
</body>
</html>
