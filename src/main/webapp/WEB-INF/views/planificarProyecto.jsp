<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table><tr bgcolor="blue"><td><img src="${pageContext.servletContext.contextPath }/resources/images/Logo.png" /></td><td colspan=4><font color="white">Bienvenido:${nombre } / <a href="cerrar.html">Cerrar</a> ( ${rol } )</font></td></tr>
<tr><td><h2>Planificación del proyecto</h2></td></tr></table>
<a href="definirHito.html">Hitos</a>
</body>
</html>