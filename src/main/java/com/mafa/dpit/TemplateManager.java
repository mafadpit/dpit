package com.mafa.dpit;


/**
 * Manejador de Plantillas definidas en el sistema
 * @author MIGUEL �NGEL FIDALGO
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
			t+="C#Dise�o#";
			t+="SC#Estudio#Formacion#Guia#Propuesta#";
			t+="C#Desarrollo#";
			t+="SC#Subsistema#Componente#";
			t+="C#Implantaci�n#";
			t+="SC#Instalaci�n#Test de Sistema#";
			t+="C#Internacionalizaci�n";
		}else if(template.compareTo("Integraci�n de Software")==0){
			t+="C#Dise�o#";
			t+="SC#Estudio#Formacion#Guia#Propuesta#Reingenier�a#";
			t+="C#Desarrollo#";
			t+="SC#COTS#";
			t+="C#Implantaci�n#";
			t+="SC#Instalaci�n#Test de Sistema#";
			t+="C#Mantenimiento#";
			t+="SC#Actualizaci�n";
		}else if(template.compareTo("Implantaci�n de Software")==0){
			t+="C#Implantaci�n#";
			t+="SC#Transporte#Instalaci�n#Test de Sistema";
		}else if(template.compareTo("Mantenimiento de Software")==0){
			t+="C#Dise�o#";
			t+="SC#Estudio#";
			t+="C#Mantenimiento#";
			t+="SC#Actualizaci�n#Reparaci�n";
		}else if(template.compareTo("Business Inteligence")==0){
			t+="C#Dise�o#";
			t+="SC#Estudio#Guia#Propuesta#Prototipo#";
			t+="C#Desarrollo#";
			t+="SC#M�dulo#";
			t+="C#Implantaci�n#";
			t+="SC#Instalaci�n#Test de Sistema";
		}else if(template.compareTo("Selecci�n de paquete")==0){
			t+="C#Dise�o#";
			t+="SC#Estudio#Propuesta#";
			t+="C#Desarrollo#";
			t+="SC#Paquete#";
			t+="C#Implantaci�n#";
			t+="SC#Instalaci�n";
		}else if(template.compareTo("Implantaci�n de paquete")==0){
			t+="C#Dise�o#";
			t+="SC#Gu�a#Propuesta#";
			t+="C#Desarrollo#";
			t+="SC#Paquete#";
			t+="C#Implantaci�n#";
			t+="SC#Instalaci�n";
		}else if(template.compareTo("Outsourcing")==0){
			t+="C#Dise�o#";
			t+="SC#Estudios#Gu�a#";
			t+="C#Desarrollo#";
			t+="SC#Transici�n#";
			t+="C#Implantaci�n#";
			t+="SC#Instalaci�n";
		}else if(template.compareTo("Selecci�n de Hardware")==0){
			t+="C#Dise�o#";
			t+="SC#Estudios#Gu�a#Propuesta#";
			t+="C#Soporte#";
			t+="SC#Hardware#Software";
		}else if(template.compareTo("Implantaci�n de Hardware")==0){
			t+="C#Dise�o#";
			t+="SC#Gu�a#Propuesta#";
			t+="C#Implantaci�n#";
			t+="SC#Transporte#Instalaci�n#Test de Sistema#Medios Auxiliares#";
			t+="C#Soporte#";
			t+="SC#Hardware#Software";
		}else if(template.compareTo("Administraci�n de Hardware")==0){
			t+="C#Dise�o#";
			t+="SC#Estudio#Formaci�n#";
			t+="C#Testing#";
			t+="SC#Auditor�a#";
			t+="C#Soporte#";
			t+="SC#Hardware#Software";
		}else if(template.compareTo("Selecci�n de Comunicaciones")==0){
			t+="C#Dise�o#";
			t+="SC#Estudio#Gu�a#Propuesta#";
			t+="C#Soporte#";
			t+="SC#Comunicaciones";
		}else if(template.compareTo("Implantaci�n de Comunicaciones")==0){
			t+="C#Dise�o#";
			t+="SC#Gu�a#Propuesta#";
			t+="C#Implantaci�n#";
			t+="SC#Transporte#Instalaci�n#Test de Sistema#Medios Auxiliares#";
			t+="C#Soporte#";
			t+="SC#Comunicaciones";
		}else if(template.compareTo("Evaluaci�n, estudios y auditor�a")==0){
			t+="C#Dise�o#";
			t+="SC#Estudio#Gu�a#Propuesta#";
			t+="C#Testing#";
			t+="SC#Calidad#Auditor�a#Otros test";
		}else if(template.compareTo("Formaci�n")==0){
			t+="C#Dise�o#";
			t+="SC#Estudio#Gu�a#Propuesta#";
			t+="C#Recursos Humanos#";
			t+="SC#Trabajadores#Formaci�n Espec�fica#Otros Costes";
		}else if(template.compareTo("Resoluci�n de Problemas")==0){
			t+="C#Dise�o#";
			t+="SC#Gu�a#Propuesta#Reingenier�a#";
			t+="C#Mantenimiento#";
			t+="SC#Actualizaci�n#Reparaci�n";
			t+="C#Soporte#";
			t+="SC#Comunicaciones";
		}else{
			t="C";
		}
		return t;
	}

}
