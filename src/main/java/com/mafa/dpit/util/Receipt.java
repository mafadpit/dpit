package com.mafa.dpit.util;

public class Receipt {
	private String codigo;
	private String servicio;
	private String importe;
	private String codigo_instalacion;
	public Receipt(String codigo, String servicio, String importe,String codigo_instalacion) {
		this.codigo = codigo;
		this.servicio = servicio;
		this.importe = importe;
		this.codigo_instalacion=codigo_instalacion;
	}
	public String getCodigo_instalacion() {
		return codigo_instalacion;
	}
	public void setCodigo_instalacion(String codigo_instalacion) {
		this.codigo_instalacion = codigo_instalacion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	

}
