<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<table>
<tr bgcolor="blue">
<td><img src="${pageContext.servletContext.contextPath }/resources/images/Logo.png" /></td>
<td colspan=4><font color="white">Bienvenido:${nombre } / <a href="cerrar.html">Cerrar</a> ( ${rol } )</font></td></tr>
<tr>
<td colspan=3>
<img src="${pageContext.servletContext.contextPath }/resources/images/carruselB.png" />
</td></tr>
<tr bgcolor="blue"> 
<td colspan=3 ><font color="white">Asignar Cliente</font></td>
</tr>
<tr>
<td colspan=3><a href="proyectoNuevoCliente.html"><img src="${pageContext.servletContext.contextPath }/resources/images/clienteN.png" /></a>
<br>
${clientes }
</td>
</tr>
<tr bgcolor="blue">
<td><font color="white">Info<br/>Política de uso</font></td>
<td><font color="white">PFC DPIT Universidad de Oviedo</font></td>
<td><font color="white">Manual<br/>Acerca de...</font></td>
</tr>
</table>
</body>
</html>