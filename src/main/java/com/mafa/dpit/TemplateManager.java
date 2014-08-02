package com.mafa.dpit;



public class TemplateManager {

	public void TemplateManager(){
		
		
	}
	public String[] template(String template){
		String[] tokens=templateType(template).split("#");
		return tokens;
	}
	public String templateType(String template){
		String t="";
		if(template.compareTo("Desarrollo de software")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Formacion#Guia#Propuesta#";
			t+="C#Desarrollo#";
			t+="SC#Subsistema#Componente#";
			t+="C#Implantación#";
			t+="SC#Instalación#Test de Sistema#";
			t+="C#Internacionalización";
		}else if(template.compareTo("Integración de software")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Formacion#Guia#Propuesta#Reingeniería#";
			t+="C#Desarrollo#";
			t+="SC#COTS#";
			t+="C#Implantación#";
			t+="SC#Instalación#Test de Sistema#";
			t+="C#Mantenimiento#";
			t+="SC#Actualización";
		}else if(template.compareTo("Implantación de software")==0){
			t+="C#Implantación#";
			t+="SC#Transporte#Instalación#Test de Sistema#";
		}else if(template.compareTo("Mantenimiento de software")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#";
			t+="C#Mantenimiento#";
			t+="SC#Actualización#Reparación";
		}else if(template.compareTo("Business Inteligence")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Guia#Propuesta#Prototipo#";
			t+="C#Desarrollo#";
			t+="SC#Módulo#";
			t+="C#Implantación#";
			t+="SC#Instalación#Test de Sistema";
		}else if(template.compareTo("Selección de paquetes")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Propuesta#";
			t+="C#Desarrollo#";
			t+="SC#Paquete#";
			t+="C#Implantación#";
			t+="SC#Instalación";
		}else if(template.compareTo("Implantación de paquetes")==0){
			t+="C#Diseño#";
			t+="SC#Guía#Propuesta#";
			t+="C#Desarrollo#";
			t+="SC#Paquete#";
			t+="C#Implantación#";
			t+="SC#Instalación";
		}else if(template.compareTo("Outsourcing")==0){
			t+="C#Diseño#";
			t+="SC#Estudios#Guía#";
			t+="C#Desarrollo#";
			t+="SC#Transición#";
			t+="C#Implantación#";
			t+="SC#Instalación";
		}else if(template.compareTo("Selección de Hardware")==0){
			t+="C#Diseño#";
			t+="SC#Estudios#Guía#Propuesta#";
			t+="C#Soporte#";
			t+="SC#Hardware#Software";
		}else if(template.compareTo("Implantación de Hardware")==0){
			t+="C#Diseño#";
			t+="SC#Guía#Propuesta#";
			t+="C#Implantación#";
			t+="SC#Transporte#Instalación#Test de Sistema#Medios Auxiliares#";
			t+="C#Soporte#";
			t+="SC#Hardware#Software";
		}else if(template.compareTo("Administración de Hardware")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Formación#";
			t+="C#Testing#";
			t+="SC#Auditoría#";
			t+="C#Soporte#";
			t+="SC#Hardware#Software";
		}else if(template.compareTo("Selección de Comunicaciones")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Guía#Propuesta#";
			t+="C#Soporte#";
			t+="SC#Comunicaciones";
		}else if(template.compareTo("Implantación de Comunicaciones")==0){
			t+="C#Diseño#";
			t+="SC#Guía#Propuesta#";
			t+="C#Implantación#";
			t+="SC#Transporte#Instalación#Test de Sistema#Medios Auxiliares#";
			t+="C#Soporte#";
			t+="SC#Comunicaciones";
		}else if(template.compareTo("Evaluación, estudios y auditoría")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Guía#Propuesta#";
			t+="C#Testing#";
			t+="SC#Calidad#Auditoría#Otros test";
		}else if(template.compareTo("Formación")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Guía#Propuesta#";
			t+="C#Recursos Humanos#";
			t+="SC#Trabajadores#Formación Específica#Otros Costes";
		}else if(template.compareTo("Resolución de problemas")==0){
			t+="C#Diseño#";
			t+="SC#Guía#Propuesta#Reingeniería#";
			t+="C#Mantenimiento#";
			t+="SC#Actualización#Reparación";
			t+="C#Soporte#";
			t+="SC#Comunicaciones";
		}else{
			t="";
		}
		return t;
	}

}
