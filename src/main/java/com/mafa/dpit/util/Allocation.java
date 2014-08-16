package com.mafa.dpit.util;

public class Allocation {
	String codigo;
	String partida;
	String recurso;
	String cantidad;
	String horas;
	String jornada;
	String tipo;
	String coste;
	String nombre;
	public Allocation(String codigo, String partida, String recurso,
			String cantidad, String horas, String jornada, String tipo,
			String coste, String nombre) {
		this.codigo = codigo;
		this.partida = partida;
		this.recurso = recurso;
		this.cantidad = cantidad;
		this.horas = horas;
		this.jornada = jornada;
		this.tipo = tipo;
		this.coste = coste;
		this.nombre=nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getPartida() {
		return partida;
	}
	public void setPartida(String partida) {
		this.partida = partida;
	}
	public String getRecurso() {
		return recurso;
	}
	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCoste() {
		return coste;
	}
	public void setCoste(String coste) {
		this.coste = coste;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
}
