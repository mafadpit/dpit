package com.mafa.dpit;


/**
 * Manejador de Plantillas definidas en el sistema
 * @author MIGUEL ÁNGEL FIDALGO
 *
 */
public class TemplateManager {
/**
 * Constructor de la clase
 */
public void TemplateManager(){
		
		
}
/**
 * Genera la estructura de tokens de la plantilla
 * @param template Nombre de la Plantilla
 * @return Estructura de Tokens 
 */
public String[] template(String template){
		String[] tokens=templateType(template).split("#");
		return tokens;
}
/**
 * Identifica la plantilla y devuelve la linea con sus tokens e identificadores
 * @param template Nombre de la plantilla
 * @return Linea que incluye categorias y sub-categorias
 */
public String templateType(String template){
		String t="";
		if(template.compareTo("Desarrollo de Software")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Formacion#Guia#Propuesta#";
			t+="C#Desarrollo#";
			t+="SC#Subsistema#Componente#";
			t+="C#Implantación#";
			t+="SC#Instalación#Test de Sistema#";
			t+="C#Internacionalización";
		}else if(template.compareTo("Integración de Software")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Formacion#Guia#Propuesta#Reingeniería#";
			t+="C#Desarrollo#";
			t+="SC#COTS#";
			t+="C#Implantación#";
			t+="SC#Instalación#Test de Sistema#";
			t+="C#Mantenimiento#";
			t+="SC#Actualización";
		}else if(template.compareTo("Implantación de Software")==0){
			t+="C#Implantación#";
			t+="SC#Transporte#Instalación#Test de Sistema";
		}else if(template.compareTo("Mantenimiento de Software")==0){
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
		}else if(template.compareTo("Selección de paquete")==0){
			t+="C#Diseño#";
			t+="SC#Estudio#Propuesta#";
			t+="C#Desarrollo#";
			t+="SC#Paquete#";
			t+="C#Implantación#";
			t+="SC#Instalación";
		}else if(template.compareTo("Implantación de paquete")==0){
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
		}else if(template.compareTo("Resolución de Problemas")==0){
			t+="C#Diseño#";
			t+="SC#Guía#Propuesta#Reingeniería#";
			t+="C#Mantenimiento#";
			t+="SC#Actualización#Reparación";
			t+="C#Soporte#";
			t+="SC#Comunicaciones";
		}else{
			t="C";
		}
		return t;
	}

}
