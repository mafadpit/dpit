<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="guardarInstalacion.html" method="POST">
Nombre: <input type="text" name="instalacion" value="" />
Dirección: <input type="text" name="direccion" value="" />
Localidad: <input type="text" name="localidad" value="" />
Pais: <input type="text" name="pais" value="" />
Tipo: 
<select name="tipo" value="Oficina">
<option>Oficina</option>
<option>Laboracitorio</option>
<option>Otros</option>
</select>
Precio: <input type="text" name="precio" value="" />
Duración: <input type="text" name="duracion" value="" />
Coste Medio Hora: <input type="text" name="costemediohora" value="" /><button>Calcular</button>
<input type="Submit" value="Guardar"/>
</form>
</body>
</html>