<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${nombre } // ${rol }
<hr>
<form action="hitosPartida.html" method="POST">
<label>Nombre</label><input type="text" name="nombre" >
<label>Descripción</label><input type="text" name="descripcion" >
<label>Tipo</label>
<select name="tipo">
<option value="Entregable" >Entregable</option>
<option value="Interno" selected>Interno</option>
</select>
<input type="Submit" value="Guardar" >
</form>
<hr>
${hitos }
<a href="accesoPartida.html?id=${id }">Volver</a>
</body>
</html>