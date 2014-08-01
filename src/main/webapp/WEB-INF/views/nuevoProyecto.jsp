<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
h3{
font-color="white";
}
</style>
</head>
<body>
<table>
<tr bgcolor="blue">
<td><img src="${pageContext.servletContext.contextPath }/resources/images/Logo.png" /></td>
<td colspan=2><font color="white">Bienvenido:${nombre } / <a href="cerrar.html">Cerrar</a> ( ${rol } )</font></td>
</tr>
<tr>
<td colspan=3>
<img src="${pageContext.servletContext.contextPath }/resources/images/carruselA.png" />
</td></tr>

<tr>
<td colspan=3>
<form action="definirProyecto.html" method="POST">
<table align="center">
<tr bgcolor="blue">
<td colspan=3><b>Nuevo Proyecto</b></td>
</tr>
<tr>
<td>Título:</td><td><input type="text" name="titulo"/></td>
</tr><tr>
<td>Modelo de negocio:</td>
<td><input type="text" name="modelo"/></td>
</tr><tr>
<td colspan=2>Tipo de proyecto_________________________________________</td>
</tr><tr>
<td colspan=2>
<input type="radio" name="tipo" value="Nuevo" checked/>Nuevo<br />
<input type="radio" name="tipo" value="Desarrollo de software" /> Desarrollo de software<br />
<input type="radio" name="tipo" value="Integración de Software" />Integración de Software<br />
<input type="radio" name="tipo" value="Implantación de Software" />Implantación de Software<br />
<input type="radio" name="tipo" value="Mantenimiento de Software" />Mantenimiento de Software<br />
<input type="radio" name="tipo" value="Bussines Inteligence" />Bussines Inteligence<br />
<input type="radio" name="tipo" value="Selección de paquete" />Selección de paquete<br />
<input type="radio" name="tipo" value="Implantación de paquete" />Implantación de paquete<br />
<input type="radio" name="tipo" value="Outsourcing" />Outsourcing<br />
<input type="radio" name="tipo" value="Selección de Hardware" />Selección de Hardware<br />
<input type="radio" name="tipo" value="Implantación de Hardware" />Implantación de Hardware<br />
<input type="radio" name="tipo" value="Administración de Hardware" />Administración de Hardware<br />
<input type="radio" name="tipo" value="Selección de Comunicaciones" />Selección de Comunicaciones<br />
<input type="radio" name="tipo" value="Implantación de Comunicación" />Implantación de Comunicación<br />
<input type="radio" name="tipo" value="Evaluación, estudios y auditoría" />Evaluación, estudios y auditoría<br />
<input type="radio" name="tipo" value="Formación" />Formación<br />
<input type="radio" name="tipo" value="Resolución de Problemas" />Resolución de Problemas<br />

</td></tr>
<tr bgcolor="blue">
<td colspan=3><input type="Submit" value="Guardar" /></td>
</tr>
</table>
</form>
</td></tr>
<tr bgcolor="blue">
<td><font color="white">Info<br/>Política de uso</font></td>
<td><font color="white">PFC DPIT Universidad de Oviedo</font></td>
<td><font color="white">Manual<br/>Acerca de...</font></td></tr>
</table>
</body>
</html>