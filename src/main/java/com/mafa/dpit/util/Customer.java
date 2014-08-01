package com.mafa.dpit.util;

public class Customer {
private String cif;
private String nombre;
private String direccion;
private String localidad;
private String pais;
private String telefono;
private String estado;
private String codigo_user;
public Customer(String cif, String nombre, String direccion, String localidad,
		String pais,String telefono,String estado,String codigo_user) {
	this.cif = cif;
	this.nombre = nombre;
	this.direccion = direccion;
	this.localidad = localidad;
	this.telefono = telefono;
	this.estado=estado;
	this.codigo_user=codigo_user;
	this.pais=pais;
}
public String getCif() {
	return cif;
}
public void setCif(String cif) {
	this.cif = cif;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getLocalidad() {
	return localidad;
}
public void setLocalidad(String localidad) {
	this.localidad = localidad;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public String getCodigo_user() {
	return codigo_user;
}
public void setCodigo_user(String codigo_user) {
	this.codigo_user = codigo_user;
}
public String getPais() {
	return pais;
}
public void setPais(String pais) {
	this.pais = pais;
}

}
