package com.mafa.dpit.util;

public class Project {
	private String codigo;
	private String titulo;
	private String modelo;
	private String fechaSolicitud;
	private String fechaAprobacion;
	private String fechaSeguimiento;
	private String fechaCierre;
	private String estado;
	private String estimaciónTemporal;
	private String coste;
	private String capitalInicial;
	private String intereses;
	private String plazo;
	private String gastosDerivados;
	private String financiación;
	private String tipoProyecto;
	private String codigo_user;
	private String codigo_cliente;
	
	
	
	public Project(String codigo, String titulo, String modelo,
			String fechaSolicitud, String fechaAprobacion,
			String fechaSeguimiento, String fechaCierre, String estado,
			String estimaciónTemporal, String coste, String capitalInicial,
			String intereses, String plazo, String gastosDerivados,
			String financiación, String tipoProyecto,String codigo_user,String codigo_cliente) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.modelo = modelo;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaAprobacion = fechaAprobacion;
		this.fechaSeguimiento = fechaSeguimiento;
		this.fechaCierre = fechaCierre;
		this.estado = estado;
		this.estimaciónTemporal = estimaciónTemporal;
		this.coste = coste;
		this.capitalInicial = capitalInicial;
		this.intereses = intereses;
		this.plazo = plazo;
		this.gastosDerivados = gastosDerivados;
		this.financiación = financiación;
		this.tipoProyecto = tipoProyecto;
		this.codigo_user=codigo_user;
		this.codigo_cliente=codigo_cliente;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public String getFechaAprobacion() {
		return fechaAprobacion;
	}
	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	public String getFechaSeguimiento() {
		return fechaSeguimiento;
	}
	public void setFechaSeguimiento(String fechaSeguimiento) {
		this.fechaSeguimiento = fechaSeguimiento;
	}
	public String getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstimaciónTemporal() {
		return estimaciónTemporal;
	}
	public void setEstimaciónTemporal(String estimaciónTemporal) {
		this.estimaciónTemporal = estimaciónTemporal;
	}
	public String getCoste() {
		return coste;
	}
	public void setCoste(String coste) {
		this.coste = coste;
	}
	public String getCapitalInicial() {
		return capitalInicial;
	}
	public void setCapitalInicial(String capitalInicial) {
		this.capitalInicial = capitalInicial;
	}
	public String getIntereses() {
		return intereses;
	}
	public void setIntereses(String intereses) {
		this.intereses = intereses;
	}
	public String getPlazo() {
		return plazo;
	}
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}
	public String getGastosDerivados() {
		return gastosDerivados;
	}
	public void setGastosDerivados(String gastosDerivados) {
		this.gastosDerivados = gastosDerivados;
	}
	public String getFinanciación() {
		return financiación;
	}
	public void setFinanciación(String financiación) {
		this.financiación = financiación;
	}
	public String getTipoProyecto() {
		return tipoProyecto;
	}
	public void setTipoProyecto(String tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}
	public String getCodigo_user() {
		return codigo_user;
	}
	public void setCodigo_user(String codigo_user) {
		this.codigo_user = codigo_user;
	}
	public String getCodigo_cliente() {
		return codigo_cliente;
	}
	public void setCodigo_cliente(String codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

}
