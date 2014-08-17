package com.mafa.dpit.util;

public class Milestone {
String codigo;
String nombre;
String descripcion;
String tipo;
String importe;
String porcentaje;
String partida;

public Milestone(String codigo, String nombre, String descripcion, String tipo,
		String importe, String porcentaje,String partida) {
	this.codigo = codigo;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.tipo = tipo;
	this.importe = importe;
	this.partida = partida;
	this.porcentaje = porcentaje;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public String getImporte() {
	return importe;
}

public void setImporte(String importe) {
	this.importe = importe;
}

public String getPartida() {
	return partida;
}

public void setPartida(String partida) {
	this.partida = partida;
}

public String getPorcentaje() {
	return porcentaje;
}

public void setPorcentaje(String porcentaje) {
	this.porcentaje = porcentaje;
}


}
