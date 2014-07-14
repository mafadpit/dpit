package com.mafa.dpit.util;

public class Support {
	private String codigo;
	private String nombre;
	private String funcion;
	private String tipo;
	private String precio;
	private String duracion;
	private String productividad;
	private String tolerancia;
	private String costemediohora;
	
	public Support(String codigo, String nombre, String funcion, String tipo,
			String precio, String duracion, String productividad,
			String tolerancia, String costemediohora) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.funcion = funcion;
		this.tipo = tipo;
		this.precio = precio;
		this.duracion = duracion;
		this.productividad = productividad;
		this.tolerancia = tolerancia;
		this.costemediohora = costemediohora;
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
	public String getFuncion() {
		return funcion;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getProductividad() {
		return productividad;
	}
	public void setProductividad(String productividad) {
		this.productividad = productividad;
	}
	public String getTolerancia() {
		return tolerancia;
	}
	public void setTolerancia(String tolerancia) {
		this.tolerancia = tolerancia;
	}
	public String getCostemediohora() {
		return costemediohora;
	}
	public void setCostemediohora(String costemediohora) {
		this.costemediohora = costemediohora;
	}
	

}
