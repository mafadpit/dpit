<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function calcular(){
	var a= Number(document.getElementById("A").value);
	var b= Number(document.getElementById("B").value);
	var c= Number(document.getElementById("C").value);
	var d= Number(document.getElementById("D").value);
	var e= Number(document.getElementById("E").value);
	var f= Number(document.getElementById("F").value);
	var g= Number(document.getElementById("G").value);
	var h= Number(document.getElementById("H").value);
	var i= Number(document.getElementById("I").value);
	var j= Number(document.getElementById("J").value);
	var k= Number(document.getElementById("K").value);
	var l= Number(document.getElementById("L").value);
	var m= Number(document.getElementById("M").value);
	var n= Number(document.getElementById("N").value);
	document.getElementById("fct").value=a+b+c+d+e+f+g+h+i+j+k+l+m+n;
	
	var fct=document.getElementById("fct").value;
	var fde=document.getElementById("fde").value;
	
	var pfa=fde*(0.65+(0.001*fct));
	
	document.getElementById("pfa").value=pfa;
}
</script>
</head>
<body>
<h2>Mediciones (Estudio de Factores de Complejidad)</h2>
<hr>
<table>
<tr><th>#</th><th>Factor</th><th>Valor</th></tr>
<tr><td>1</td><td>Comunicación de datos</td><td><input type="text" id="A" value=0></td></tr>
<tr><td>2</td><td>Proceso Distribuido</td><td><input type="text" id="B" value=0></td></tr>
<tr><td>3</td><td>Objetivos de Rendimiento</td><td><input type="text" id="C" value=0></td></tr>
<tr><td>4</td><td>Config. de Explotación Compartida</td><td><input type="text" id="D" value=0></td></tr>
<tr><td>5</td><td>Tasa de Transacciones</td><td><input type="text" id="E" value=0></td></tr>
<tr><td>6</td><td>Entrada de datos EN-LINEA</td><td><input type="text" id="F" value=0></td></tr>
<tr><td>7</td><td>Eficiencia con el Usuario Final</td><td><input type="text" id="G" value=0></td></tr>
<tr><td>8</td><td>Actualizaciones EN-LINEA</td><td><input type="text" id="H" value=0></td></tr>
<tr><td>9</td><td>Logica del proceso interno Compleja</td><td><input type="text" id="I" value=0></td></tr>
<tr><td>10</td><td>Reusabilidad del Código</td><td><input type="text" id="J" value=0></td></tr>
<tr><td>11</td><td>Contempla la Conversión e Instalación</td><td><input type="text" id="K" value=0></td></tr>
<tr><td>12</td><td>Facilidad de Operación</td><td><input type="text" id="L" value=0></td></tr>
<tr><td>13</td><td>Instalaciones Múltiples</td><td><input type="text" id="M" value=0></td></tr>
<tr><td>14</td><td>Facilidad de Cambios</td><td><input type="text" id="N" value=0></td></tr>
</table>
<button onclick=calcular() >Calcular</button>
<hr>
<form action="medirPartidaB.html" method="POST">
<label>FDE</label><input type="text" id="fde" value=${fde } readOnly>
<label>FCT</label><input type="text" id="fct" value=0 readOnly>
<label>PFA (Resultado)</label><input type="text" id="pfa" name="pfa" value=0 readOnly>
<input type="Submit" value="Asignar">
</form>
</body>
</html>