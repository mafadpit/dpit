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
<form action="definirProyectoC.html" method="POST">
<table>
<tr bgcolor="blue">
<td colspan=2><font color="white">Nuevo Cliente</font></td></tr>
<tr><td>CIF</td><td><input type="text" name="cif" value=${cif } /></td></tr>
<tr><td>Nombre o Razón Social</td><td><input type="text" name="nombre"  value=${nombre } /></td></tr>
<tr><td>Dirección</td><td><input type="text" name="direccion" value=${direccion } /></td></tr>
<tr><td>Localidad</td><td><input type="text" name="localidad" value=${localidad } /></td></tr>
<tr><td>Pais</td><td><input type="text" name="pais"  value=${pais } /> </td></tr>
<tr><td>Teléfono</td><td><input type="text" name="telefono" value=${telefono } /></td></tr>
<tr bgcolor="blue"><td colspan=2><input type="Submit" value="Asignar" /></form><form action="definirProyecto.html" method="POST" ><input type="Submit" value="Volver" /></form></td></tr>
</table>

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