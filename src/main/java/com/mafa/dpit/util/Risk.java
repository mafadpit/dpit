package com.mafa.dpit.util;
 
public class Risk {
	String codigo;
	String nombre;
	String evento;
	String solucion;
	String coste;
	String tiempo;
	String impacto;
	String probabilidad;
	String nivel;
	String partida;
	public Risk(String codigo, String nombre, String evento, String solucion,
			String coste, String tiempo, String impacto, String probabilidad,String partida) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.evento = evento;
		this.solucion = solucion;
		this.coste = coste;
		this.tiempo = tiempo;
		this.impacto = impacto;
		this.probabilidad = probabilidad;
		this.partida=partida;
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
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public String getSolucion() {
		return solucion;
	}
	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}
	public String getCoste() {
		return coste;
	}
	public void setCoste(String coste) {
		this.coste = coste;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getImpacto() {
		return impacto;
	}
	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}
	public String getProbabilidad() {
		return probabilidad;
	}
	public void setProbabilidad(String probabilidad) {
		this.probabilidad = probabilidad;
	}
	public String getNivel() {
		return String.valueOf(Integer.parseInt(impacto)*Integer.parseInt(probabilidad));
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getPartida() {
		return partida;
	}
	public void setPartida(String partida) {
		this.partida = partida;
	}
}
