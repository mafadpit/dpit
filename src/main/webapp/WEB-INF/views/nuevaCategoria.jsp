<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="guardarCategoria.html" method="POST">
Codigo:<input type="text" name="codigo" value=${codigo } >
Nombre: <input type="text" name="categoria" value=${categoria } >
Estimación Temporal: <input type="text" name="estimacionTemporal" value=${estimacionTemporal }>
Estimación Económico: <input type="text" name="estimacionCoste" value=${estimacionCoste } >
Coste Real: <input type="text" name="costeReal" value=${costeReal } >
Coste Temporal: <input type="text" name="costeTemporal" value=${costeTemporal } >
<input type="Submit" value="Guardar"/>
</form>
</body>
</html>