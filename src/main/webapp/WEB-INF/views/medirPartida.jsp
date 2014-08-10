<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function entradas(){
	var in10= Number(document.getElementById("in1").value)+Number(document.getElementById("in4").value)+Number(document.getElementById("in7").value);
	var in11= Number(document.getElementById("in2").value)+Number(document.getElementById("in5").value)+Number(document.getElementById("in8").value);
	var in12= Number(document.getElementById("in3").value)+Number(document.getElementById("in6").value)+Number(document.getElementById("in9").value);
	document.getElementById("inB").value=in10;
	document.getElementById("inM").value=in11;
	document.getElementById("inA").value=in12;
	var a= Number(document.getElementById("inB").value)*Number(document.getElementById("cA").value);
	var b= Number(document.getElementById("inM").value)*Number(document.getElementById("cB").value);
	var c= Number(document.getElementById("inA").value)*Number(document.getElementById("cC").value);
	document.getElementById("A").value=a;
	document.getElementById("B").value=b;
	document.getElementById("C").value=c;
	calcular();
}
function salidas(){
	var in10= Number(document.getElementById("out1").value)+Number(document.getElementById("out4").value)+Number(document.getElementById("out7").value);
	var in11= Number(document.getElementById("out2").value)+Number(document.getElementById("out5").value)+Number(document.getElementById("out8").value);
	var in12= Number(document.getElementById("out3").value)+Number(document.getElementById("out6").value)+Number(document.getElementById("out9").value);
	document.getElementById("outB").value=in10;
	document.getElementById("outM").value=in11;
	document.getElementById("outA").value=in12;
	var a= Number(document.getElementById("outB").value)*Number(document.getElementById("cD").value);
	var b= Number(document.getElementById("outM").value)*Number(document.getElementById("cE").value);
	var c= Number(document.getElementById("outA").value)*Number(document.getElementById("cF").value);
	document.getElementById("D").value=a;
	document.getElementById("E").value=b;
	document.getElementById("F").value=c;
	calcular();
}
function consultas(){
	var in10= Number(document.getElementById("q1").value)+Number(document.getElementById("q4").value)+Number(document.getElementById("q7").value);
	var in11= Number(document.getElementById("q2").value)+Number(document.getElementById("q5").value)+Number(document.getElementById("q8").value);
	var in12= Number(document.getElementById("q3").value)+Number(document.getElementById("q6").value)+Number(document.getElementById("q9").value);
	document.getElementById("qB").value=in10;
	document.getElementById("qM").value=in11;
	document.getElementById("qA").value=in12;
	var a= Number(document.getElementById("qB").value)*Number(document.getElementById("cG").value);
	var b= Number(document.getElementById("qM").value)*Number(document.getElementById("cH").value);
	var c= Number(document.getElementById("qA").value)*Number(document.getElementById("cI").value);
	document.getElementById("G").value=a;
	document.getElementById("H").value=b;
	document.getElementById("I").value=c;
	calcular();
}
function archivos(){
	var in10= Number(document.getElementById("fm1").value)+Number(document.getElementById("fm4").value)+Number(document.getElementById("fm7").value);
	var in11= Number(document.getElementById("fm2").value)+Number(document.getElementById("fm5").value)+Number(document.getElementById("fm8").value);
	var in12= Number(document.getElementById("fm3").value)+Number(document.getElementById("fm6").value)+Number(document.getElementById("fm9").value);
	document.getElementById("fmB").value=in10;
	document.getElementById("fmM").value=in11;
	document.getElementById("fmA").value=in12;
	var a= Number(document.getElementById("fmB").value)*Number(document.getElementById("cJ").value);
	var b= Number(document.getElementById("fmM").value)*Number(document.getElementById("cK").value);
	var c= Number(document.getElementById("fmA").value)*Number(document.getElementById("cL").value);
	document.getElementById("J").value=a;
	document.getElementById("K").value=b;
	document.getElementById("L").value=c;
	calcular();
}
function interfaces(){
	var in10= Number(document.getElementById("ie1").value)+Number(document.getElementById("ie4").value)+Number(document.getElementById("ie7").value);
	var in11= Number(document.getElementById("ie2").value)+Number(document.getElementById("ie5").value)+Number(document.getElementById("ie8").value);
	var in12= Number(document.getElementById("ie3").value)+Number(document.getElementById("ie6").value)+Number(document.getElementById("ie9").value);
	document.getElementById("ieB").value=in10;
	document.getElementById("ieM").value=in11;
	document.getElementById("ieA").value=in12;
	var a= Number(document.getElementById("ieB").value)*Number(document.getElementById("cM").value);
	var b= Number(document.getElementById("ieM").value)*Number(document.getElementById("cN").value);
	var c= Number(document.getElementById("ieA").value)*Number(document.getElementById("cO").value);
	document.getElementById("M").value=a;
	document.getElementById("N").value=b;
	document.getElementById("O").value=c;
	calcular();
}
function calcular(){
	document.getElementById("fde").value=Number(document.getElementById("A").value)+
	Number(document.getElementById("B").value)+
	Number(document.getElementById("C").value)+
	Number(document.getElementById("D").value)+
	Number(document.getElementById("E").value)+
	Number(document.getElementById("F").value)+
	Number(document.getElementById("G").value)+
	Number(document.getElementById("H").value)+
	Number(document.getElementById("I").value)+
	Number(document.getElementById("J").value)+
	Number(document.getElementById("K").value)+
	Number(document.getElementById("L").value)+
	Number(document.getElementById("M").value)+
	Number(document.getElementById("N").value)+
	Number(document.getElementById("O").value);
}
</script>
</head>
<body>
${nombre } /${rol }
<hr>
<h2>Mediciones (Estudio de Estructura del Módulo)</h2>
<hr>
<table>
<tr><th>Entradas (IN)</th><th>Baja</th><th>Media</th><th>Alta</th></tr>
<tr><td>0 ó 1 archivo accedidos</td><td><input type="text" id="in1" value=0></td><td><input type="text" id="in2" value=0></td><td><input type="text" id="in3" value=0></td></tr>
<tr><td>2 archivos accedidos</td><td><input type="text" id="in4" value=0></td><td><input type="text" id="in5" value=0></td><td><input type="text" id="in6" value=0></td></tr>
<tr><td>3 o más archivos</td><td><input type="text" id="in7" value=0></td><td><input type="text" id="in8" value=0></td><td><input type="text" id="in9" value=0></td></tr>
<tr><td colspan=4 class="result"><button onclick='entradas()' >Calcular</button></td></tr>
</table>
<hr>
<table>
<tr><th>Salidas (OUT)</th><th>Baja</th><th>Media</th><th>Alta</th></tr>
<tr><td>0 ó 1 archivo accedidos</td><td><input type="text" id="out1"  value=0></td><td><input type="text" id="out2" value=0></td><td><input type="text" id="out3" value=0></td></tr>
<tr><td>2 archivos accedidos</td><td><input type="text" id="out4" value=0></td><td><input type="text" id="out5" value=0></td><td><input type="text" id="out6" value=0></td></tr>
<tr><td>3 o más archivos</td><td><input type="text" id="out7" value=0></td><td><input type="text" id="out8" value=0></td><td><input type="text" id="out9" value=0></td></tr>
<tr><td colspan=4 class="result"><button onclick='salidas()' >Calcular</button></td></tr>
</table>
<hr>
<table>
<tr><th>Consultas (Q)</th><th>Baja</th><th>Media</th><th>Alta</th></tr>
<tr><td>0 ó 1 archivo accedidos</td><td><input type="text" id="q1"  value=0></td><td><input type="text" id="q2" value=0></td><td><input type="text" id="q3" value=0></td></tr>
<tr><td>2 archivos accedidos</td><td><input type="text" id="q4" value=0></td><td><input type="text" id="q5" value=0></td><td><input type="text" id="q6" value=0></td></tr>
<tr><td>3 o más archivos</td><td><input type="text" id="q7" value=0></td><td><input type="text" id="q8" value=0></td><td><input type="text" id="q9" value=0></td></tr>
<tr><td colspan=4 class="result"><button onclick='consultas()' >Calcular</button></td></tr>
</table>
<hr>
<table>
<tr><th>Archivos Internos (FM)</th><th>Baja</th><th>Media</th><th>Alta</th></tr>
<tr><td>1 registro lógico</td><td><input type="text" id="fm1"  value=0></td><td><input type="text" id="fm2" value=0></td><td><input type="text" id="fm3" value=0></td></tr>
<tr><td>2 a 5 resgistros</td><td><input type="text" id="fm4" value=0></td><td><input type="text" id="fm5" value=0></td><td><input type="text" id="fm6" value=0></td></tr>
<tr><td>más de 6 registros</td><td><input type="text" id="fm7" value=0></td><td><input type="text" id="fm8" value=0></td><td><input type="text" id="fm9" value=0></td></tr>
<tr><td colspan=4 class="result"><button onclick='archivos()' >Calcular</button></td></tr>
</table>
<hr>
<table>
<tr><th>Interfaces Externas (I)</th><th>Baja</th><th>Media</th><th>Alta</th></tr>
<tr><td>1 registro lógico</td><td><input type="text" id="ie1"  value=0></td><td><input type="text" id="ie2" value=0></td><td><input type="text" id="ie3" value=0></td></tr>
<tr><td>2 a 5 resgistros</td><td><input type="text" id="ie4" value=0></td><td><input type="text" id="ie5" value=0></td><td><input type="text" id="ie6" value=0></td></tr>
<tr><td>más de 6 registros</td><td><input type="text" id="ie7" value=0></td><td><input type="text" id="ie8" value=0></td><td><input type="text" id="ie9" value=0></td></tr>
<tr><td colspan=4 class="result"><button onclick='interfaces()' >Calcular</button></td></tr>
</table>
<hr>

<table>
<tr><th colspan=4>Resultados</th></tr>
<tr><td>(IN) Baja</td><td><input type="text" id="inB" name="inB" value=0 readOnly></td><td><input type="text" value=3 id="cA"readOnly></td><td><input type="text" id="A" value=0 readOnly></td></tr>
<tr><td>(IN) Media</td><td><input type="text" id="inM" name="inM" value=0 readOnly></td><td><input type="text" value=4 id="cB" readOnly></td><td><input type="text" id="B" value=0 readOnly></td></tr>
<tr><td>(IN) Alta</td><td><input type="text" id="inA" name="inA" value=0 readOnly></td><td><input type="text" value=6 id="cC" readOnly></td><td><input type="text" id="C" value=0 readOnly></td></tr>
<tr><td>(OUT) Baja</td><td><input type="text" id="outB" name="outB" value=0 readOnly></td><td><input type="text" value=4 id="cD"readOnly></td><td><input type="text" id="D" value=0 readOnly></td></tr>
<tr><td>(OUT) Media</td><td><input type="text" id="outM" name="outM" value=0 readOnly></td><td><input type="text" value=5 id="cE" readOnly></td><td><input type="text" id="E" value=0 readOnly></td></tr>
<tr><td>(OUT) Alta</td><td><input type="text" id="outA" name="outA" value=0 readOnly></td><td><input type="text" value=7 id="cF" readOnly></td><td><input type="text" id="F" value=0 readOnly></td></tr>
<tr><td>(Q) Baja</td><td><input type="text" id="qB" name="qB" value=0 readOnly></td><td><input type="text" value=3 id="cG"readOnly></td><td><input type="text" id="G" value=0 readOnly></td></tr>
<tr><td>(Q) Media</td><td><input type="text" id="qM" name="qM" value=0 readOnly></td><td><input type="text" value=4 id="cH" readOnly></td><td><input type="text" id="H" value=0 readOnly></td></tr>
<tr><td>(Q) Alta</td><td><input type="text" id="qA" name="qA" value=0 readOnly></td><td><input type="text" value=6 id="cI" readOnly></td><td><input type="text" id="I" value=0 readOnly></td></tr>
<tr><td>(FM) Baja</td><td><input type="text" id="fmB" name="fmB" value=0 readOnly></td><td><input type="text" value=7 id="cJ"readOnly></td><td><input type="text" id="J" value=0 readOnly></td></tr>
<tr><td>(FM) Media</td><td><input type="text" id="fmM" name="fmM" value=0 readOnly></td><td><input type="text" value=10 id="cK" readOnly></td><td><input type="text" id="K" value=0 readOnly></td></tr>
<tr><td>(FM) Alta</td><td><input type="text" id="fmA" name="fmA" value=0 readOnly></td><td><input type="text" value=15 id="cL" readOnly></td><td><input type="text" id="L" value=0 readOnly></td></tr>
<tr><td>(I) Baja</td><td><input type="text" id="ieB" name="ieB" value=0 readOnly></td><td><input type="text" value=5 id="cM"readOnly></td><td><input type="text" id="M" value=0 readOnly></td></tr>
<tr><td>(I) Media</td><td><input type="text" id="ieM" name="ieM" value=0 readOnly></td><td><input type="text" value=7 id="cN" readOnly></td><td><input type="text" id="N" value=0 readOnly></td></tr>
<tr><td>(I) Alta</td><td><input type="text" id="ieA" name="ieA" value=0 readOnly></td><td><input type="text" value=10 id="cO" readOnly></td><td><input type="text" id="O" value=0 readOnly></td></tr>
</table>

<form action="medirPartidaA.html" method="POST">
<table>
<tr><td>Resultado (I)</td><td><input type="text" id="fde" name="fde" value=0 readOnly></td></tr>
<tr><td colspan=2><input type="Submit" value="Seguir"></td></tr>
</table>
</form>
<a href="accesoPartida.html?id=${partida }" >Volver sin Calcular</a>
</body>
</html>
