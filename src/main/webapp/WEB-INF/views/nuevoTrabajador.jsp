<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="guardarTrabajador.html" method="POST">
Categoria: <input type="text" name="categoria" value="" />
Sueldo Base: <input type="text" name="sueldoBase" value="" />
Complementos: <input type="text" name="complementos" value=""/>
Especie: <input type="text" name="especie" value="" />
Extras: <input type="text" name="extras" value="" />
Otros: <input type="text" name="otros" value="" />
Indemnización: <input type="text" name="indemnizacion" value="" />
Contingencias Comunes: <input type="text" name="ccomunes" value="23,60"  />
FOGASA: <input type="text" name="fogasa" value="0,4" />
AT y ET: <input type="text" name="atyet" value="10" />
Desempleo: <input type="text" name="desempleo" value="0,6" />
Formación: <input type="text" name="formacion" value="0,1" />
IRPF: <input type="text" name="irpf" value="2" />
Seguros: <input type="text" name="seguros" value="" />
Jornada Diaria: <input type="text" name="jornada" value="8" />
Productividad: <input type="text" name="productividad" value="80" />
Coste Medio Hora: <input type="text" name="costemediohora" value="" /><button>Calcular</button>
<input type="Submit" value="Guardar"/>
</form>
</body>
</html>