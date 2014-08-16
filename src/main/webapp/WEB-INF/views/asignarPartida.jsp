<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${nombre } / ${rol }
<hr>
<table>
<tr><td>
<fieldset><legend>Trabajadores</legend>
${trabajadores }
</fieldset>
</td><td>
<fieldset><legend>Materiales</legend>
${materiales }
</fieldset>
</td></tr>
<tr><td>
<fieldset><legend>Soportes</legend>
${soportes }
</fieldset>
</td><td>
<fieldset><legend>Instalaciones</legend>
${instalaciones }
</fieldset>
</td></tr>
</table>
<a href="nuevaAsignacion.html">Nueva</a>
<a href="accesoPartida.html?id=${id }">Volver</a>
<hr>
${recursos }

<hr>
</body>
</html>