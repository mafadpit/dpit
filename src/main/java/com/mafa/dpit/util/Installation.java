package com.mafa.dpit.util;

public class Installation {
	private String codigo;
	private String nombre;
	private String direccion;
	private String localidad;
	private String pais;
	private String precio;
	private String tipo;
	private String duración;
	private String costemediohora;
	private String user;
	
	public Installation(String codigo, String nombre, String direccion,
			String localidad, String pais, String precio, String tipo,
			String duración, String costemediohora,String user) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
		this.pais = pais;
		this.precio = precio;
		this.tipo = tipo;
		this.duración = duración;
		this.costemediohora = costemediohora;
		this.user=user;
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDuración() {
		return duración;
	}
	public void setDuración(String duración) {
		this.duración = duración;
	}
	public String getCostemediohora() {
		return costemediohora;
	}
	public void setCostemediohora(String costemediohora) {
		this.costemediohora = costemediohora;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

}
