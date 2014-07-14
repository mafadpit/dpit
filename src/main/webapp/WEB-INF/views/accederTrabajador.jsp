<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr bgcolor="blue"><td ><font color="white">Bienvenido:${nombre }/ <a href="cerrar.html">Cerrar</a></font></td></tr>
<tr><td>
<h1>Gestión de Trabajadores</h1>
<table><tr>
<td>
<form action="guardarTrabajador.html" method="POST">
Código: <input type="text" name="codigo" value=${codigo } />
Categoria: <input type="text" name="categoria" value=${categoria } />
Sueldo Base: <input type="text" name="sueldoBase" value=${sueldoBase } />
Complementos: <input type="text" name="complementos" value=${complementos } />
Especie: <input type="text" name="especie" value=${especie } />
Extras: <input type="text" name="extras" value=${extras } />
Otros: <input type="text" name="otros" value=${otros } />
Indemnización: <input type="text" name="indemnizacion" value=${indemnizacion } />
Contingencias Comunes: <input type="text" name="ccomunes" value=${ccomunes } />
FOGASA: <input type="text" name="fogasa" value=${fogasa } />
AT y ET: <input type="text" name="atyet" value=${atyet } />
Desempleo: <input type="text" name="desempleo" value=${desempleo } />
Formación: <input type="text" name="formacion" value=${formacion } />
IRPF: <input type="text" name="irpf" value=${irpf } />
Seguros: <input type="text" name="seguros" value=${seguros } />
Jornada Diaria: <input type="text" name="jornada" value=${jornada } />
Productividad: <input type="text" name="productividad" value=${productividad } />
Coste Medio Hora: <input type="text" name="costemediohora" value=${costemediohora } />
<input type="Submit" value="Guardar"/>
</form>

</td>
</tr></table>
</td></tr>
</table>

<a href="recursos.html">Volver</a>

</body>
</html>