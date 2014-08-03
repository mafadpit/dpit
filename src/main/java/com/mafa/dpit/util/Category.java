package com.mafa.dpit.util;

public class Category {
	String codigo;
	String nombre;
	String estimacionTemporal;
	String estimacionCoste;
	String costeReal;
	String costeTemporal;
	String codigo_proyecto;
	
	public Category(String codigo, String nombre, String estimacionTemporal,
			String estimacionCoste, String costeReal, String costeTemporal,
			String codigo_proyecto) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.estimacionTemporal = estimacionTemporal;
		this.estimacionCoste = estimacionCoste;
		this.costeReal = costeReal;
		this.costeTemporal = costeTemporal;
		this.codigo_proyecto = codigo_proyecto;
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

	public String getEstimacionTemporal() {
		return estimacionTemporal;
	}

	public void setEstimacionTemporal(String estimacionTemporal) {
		this.estimacionTemporal = estimacionTemporal;
	}

	public String getEstimacionCoste() {
		return estimacionCoste;
	}

	public void setEstimacionCoste(String estimacionCoste) {
		this.estimacionCoste = estimacionCoste;
	}

	public String getCosteReal() {
		return costeReal;
	}

	public void setCosteReal(String costeReal) {
		this.costeReal = costeReal;
	}

	public String getCosteTemporal() {
		return costeTemporal;
	}

	public void setCosteTemporal(String costeTemporal) {
		this.costeTemporal = costeTemporal;
	}

	public String getCodigo_proyecto() {
		return codigo_proyecto;
	}

	public void setCodigo_proyecto(String codigo_proyecto) {
		this.codigo_proyecto = codigo_proyecto;
	}
	
}
