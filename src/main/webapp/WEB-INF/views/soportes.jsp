<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr bgcolor="blue"><td ><font color="white">Bienvenido:${nombre }/ <a href="cerrar.html">Cerrar</a></font></td></tr>
<tr><td>
<h1>Gestión de Soportes</h1>
<table><tr>
<td>${soportes }</td>
</tr></table>
<a href="nuevoSoporte.html">Nuevo</a>
</td></tr>
</table>
<a href="recursos.html">Volver</a>
</body>
</html>