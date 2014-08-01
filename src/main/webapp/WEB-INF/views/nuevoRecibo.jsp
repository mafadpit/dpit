<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Nuevo Recibo</h1>
<form action="guardarRecibo.html" method="POST">
Instalación: <input type="text" name="instalacion" value=${instalacion } /><br/>
Servicio: <input type="text" name="servicio" value="" /><br/>
Importe: <input type="text" name="importe" value="" />
<input type="Submit" value="Guardar"/>
</form>
</body>
</html>