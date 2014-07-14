package com.mafa.dpit.util;

public class Material {
	private String codigo;
	private String nombre;
	private String utilidad;
	private String precio;
	public Material(String codigo, String nombre, String utilidad, String precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.utilidad = utilidad;
		this.precio = precio;
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
	public String getUtilidad() {
		return utilidad;
	}
	public void setUtilidad(String utilidad) {
		this.utilidad = utilidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
}
