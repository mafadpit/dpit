package com.mafa.dpit;

public class TemplateManager {

	public void TemplateManager(){
		
	}
	public String[] template(String template){
		String[] result=null;
		if(template.compareToIgnoreCase("desarrollo de software")==0){
			result= new String[20];
			result[0]="C";
			result[1]="Diseño";
			result[2]="SC";
			result[3]="Estudio";
			result[4]="Formación";
			result[5]="Guía";
			result[6]="Propuesta";
			result[7]="C";
			result[8]="Desarrollo";
			result[9]="SC";
			result[10]="Subsistema";
			result[11]="Componente";
			result[13]="C";
			result[14]="Implantación";
			result[15]="SC";
			result[16]="Instalación";
			result[17]="Test de sistema";
			result[18]="C";
			result[19]="Internacionalización";
			
		}
		return result;
	}

}
