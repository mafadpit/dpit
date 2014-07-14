<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="guardarMaterial.html" method="POST">
Código: <input type="text" name="codigo" value=${codigo } />
Nombre: <input type="text" name="material" value=${material } />
Utilidad: <input type="text" name="utilidad" value=${utilidad } />
Precio/Unidad: <input type="text" name="precio" value=${precio } />
<input type="Submit" value="Guardar"/>
</body>
</html>