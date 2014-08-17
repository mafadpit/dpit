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
<form action="riesgosPartida.html" method="POST">
<label>Nombre</label><input type="text" name="nombre" >
<label>Evento</label><input type="text" name="evento" >
<label>Solución</label><input type="text" name="solucion" >
<label>Coste(€)</label><input type="text" name="coste" >
<label>Tiempo</label><input type="text" name="tiempo" >
<label>Impacto</label>
<select name="impacto">
<option value="1" selected>1</option>
<option value="2" >2</option>
<option value="3" >3</option>
<option value="4" >4</option>
<option value="5" >5</option>
</select>
<label>Probabilidad</label>
<select name="probabilidad">
<option value="1" selected>1</option>
<option value="2" >2</option>
<option value="3" >3</option>
<option value="4" >4</option>
<option value="5" >5</option>
</select>
<input type="Submit" value="Guardar" >
</form>
<hr>
${riesgos }
<a href="accesoPartida.html?id=${id }">Volver</a>
</body>
</html>