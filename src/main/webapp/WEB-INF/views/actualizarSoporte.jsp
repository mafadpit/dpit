<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table><tr bgcolor="blue"><td colspan="3"><font color="white">Bienvenido:${nombre }/ <a href="cerrar.html">Cerrar</a></font></td></tr>

<tr><td>
<form action="guardarSoporte.html" method="POST">
Codigo: <input type="text" name="codigo" value=${codigo } />
Nombre: <input type="text" name="soporte" value=${soporte } />
Función: <input type="text" name="funcion" value=${funcion } />
Tipo: 
<select name="tipo" value=${tipo }>
<option>Hardware</option>
<option>Software</option>
<option>Comunicación</option>
<option>Otros</option>
</select>
Precio: <input type="text" name="precio" value=${precio } />
Duración: <input type="text" name="duracion" value=${duracion } />
Productividad: <input type="text" name="productividad" value=${productividad } />
Tolerancia: <input type="text" name="tolerancia" value=${tolerancia } />
Coste Medio Hora: <input type="text" name="costemediohora" value=${costemediohora } /><button>Calcular</button>
<input type="Submit" value="Guardar"/>
</form></td></tr>


</table>

</body>
</html>