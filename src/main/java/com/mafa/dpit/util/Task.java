package com.mafa.dpit.util;

public class Task {
	private String codigo;
	private String definicion;
	private String unidad;
	private String cantidad;
	private String precioUnidad;
	private String tipo;
	private String costeFinal;
	private String estado;
	private String orden;
	private String colchon;
	private String costesDerivados;
	private String asignaciones;
	private String partidaSuperior;
	private String categoria;
	
	public Task(String codigo, String definicion, String unidad,
			String cantidad, String precioUnidad, String tipo,
			String costeFinal, String estado, String orden, String colchon,
			String costesDerivados, String asignaciones,
			String partidaSuperior, String categoria) {
		this.codigo = codigo;
		this.definicion = definicion;
		this.unidad = unidad;
		this.cantidad = cantidad;
		this.precioUnidad = precioUnidad;
		this.tipo = tipo;
		this.costeFinal = costeFinal;
		this.estado = estado;
		this.orden = orden;
		this.colchon = colchon;
		this.costesDerivados = costesDerivados;
		this.asignaciones = asignaciones;
		this.partidaSuperior = partidaSuperior;
		this.categoria = categoria;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDefinicion() {
		return definicion;
	}
	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(String precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCosteFinal() {
		return costeFinal;
	}
	public void setCosteFinal(String costeFinal) {
		this.costeFinal = costeFinal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public String getColchon() {
		return colchon;
	}
	public void setColchon(String colchon) {
		this.colchon = colchon;
	}
	public String getCostesDerivados() {
		return costesDerivados;
	}
	public void setCostesDerivados(String costesDerivados) {
		this.costesDerivados = costesDerivados;
	}
	public String getAsignaciones() {
		return asignaciones;
	}
	public void setAsignaciones(String asignaciones) {
		this.asignaciones = asignaciones;
	}
	public String getPartidaSuperior() {
		return partidaSuperior;
	}
	public void setPartidaSuperior(String partidaSuperior) {
		this.partidaSuperior = partidaSuperior;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void calcular(){
		float costeF= Float.valueOf(cantidad)*Float.valueOf(precioUnidad);
		float costeAsignaciones = Float.valueOf(asignaciones);
		float coste= costeF+costeAsignaciones;
		costeFinal=String.valueOf(coste);
	}

}
