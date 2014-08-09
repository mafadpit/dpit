<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${nombre } (${rol })<hr>
<table>
<tr><td>Definición</td><td>Unidad</td><td>Cantidad</td><td>Precio/Unidad</td></tr>
<tr><td>
<form action="nuevaPartida.html" method="POST">
<input type="text" name="definicion" >
</td><td><input type="text" name="unidad" value="Horas">
</td><td><input type="text" name="cantidad">
</td><td><input type="text" name="precioUnidad">
</td><td><input type="text" name="tipo" value="Tarea">
</td><td><input type="submit" value="Nuevo">
</form>
</td></tr></table>
${home }[${categorias }] // ${partidaSup }
${partidas }
</body>
</html>