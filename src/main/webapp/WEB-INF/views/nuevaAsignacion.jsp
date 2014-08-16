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
<nav>
<opcion><a href="nuevaAsignacion.html?tipo=t">Trabajador</a></opcion>|
<opcion><a href="nuevaAsignacion.html?tipo=i">Instalacion</a></opcion>|
<opcion><a href="nuevaAsignacion.html?tipo=s">Soporte</a></opcion>|
<opcion><a href="nuevaAsignacion.html?tipo=m">Material</a></opcion>
</nav>
<hr>
${recursos }
${asig }
<hr>
<a href="asignarPartida.html?id=${id }">Volver</a>
</body>
</html>