package com.mafa.dpit.util;

public class Receipt {
	private String codigo;
	private String servicio;
	private String importe;
	public Receipt(String codigo, String servicio, String importe) {
		this.codigo = codigo;
		this.servicio = servicio;
		this.importe = importe;
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
