<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DPIT - PFC 2015</title>
</head>
<body><table><tr bgcolor="blue"><td><img src="${pageContext.servletContext.contextPath }/resources/images/Logo.png" /></td><td colspan=4><font color="white">Bienvenido:${nombre } / <a href="cerrar.html">Cerrar</a> ( ${rol } )</font></td></tr>
<tr><td><h2>Entorno</h2></td></tr>
<tr><td><a href="proyectos.html"><img src="${pageContext.servletContext.contextPath }/resources/images/Proyecto.png" /></a><br/> Proyectos</td>
<td><a href="colaboraciones.html"><img src="${pageContext.servletContext.contextPath }/resources/images/Colaboracion.png" /></a><br/>Colaboraciones</td>
<td><a href="recursos.html"><img src="${pageContext.servletContext.contextPath }/resources/images/recursos.png" /></a><br/>Recursos</td>
<td>${usuarios}</td>
<td>${publicador}</td></tr>
<tr> <td colspan=5><hr /></td></tr>
<tr bgcolor="blue"><td><font color="white">Info<br/>Política de uso</font></td><td colspan=3><font color="white">PFC DPIT Universidad de Oviedo</font></td><td><font color="white">Manual<br/>Acerca de...</font></td></tr>
</table>
</body>
</html>