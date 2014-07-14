package com.mafa.dpit;

import com.mafa.dpit.excepciones.AccessException;
import com.mafa.dpit.excepciones.ControllerException;
import com.mafa.dpit.util.Installation;
import com.mafa.dpit.util.Material;
import com.mafa.dpit.util.Support;
import com.mafa.dpit.util.Worker;

public class ResourceManager {
	public ResourceManager(){
		
	}
	// TRABAJADORES
	/**
	 * Muestra los trabajadores que ha creado el usuario
	 * @return
	 */
	public String showWorkers(String user) throws ControllerException{
		DataLayer data= new DataLayer();
		String result="<table>";
		int indices=5;
		result+="<tr bgcolor=\"blue\"><td><font color=\"white\">Opciones</font></td><td><font color=\"white\">Categoria</font></td><td><font color=\"white\">Jornada</font></td><td><font color=\"white\">Productividad</font></td><td><font color=\"white\">Coste Medio Hora</font></td></tr>";
		try {
			result+=data.showList("\"Trabajadores\"", "codigo, categoria, jornada, productividad, costemediohora", indices, "eliminarTrabajador.html", "accederTrabajador.html",user);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		result+="<tr bgcolor=\"blue\"><td colspan=5><a href=\"nuevoTrabajador.html\">Nuevo</a></td></tr></table>";
		return result;
	}
	/**
	 * Eliminar un trabajador
	 * @param codigo
	 * @return
	 */
	public String deleteWorkers(String codigo){
		DataLayer data= new DataLayer();
		try {
			data.delete("\"Trabajadores\"","codigo",codigo);
		} catch (AccessException e) {
			return e.getMsg();
		}
		return "eliminado";
	}
	/**
	 * Actualizar los valores de una fila
	 * @param indice
	 * @param trabajador
	 * @return
	 */
	public String updateWorkers(String indice,Worker trabajador){
		String[] atributos= new String[18];
		String[] valores= new String[18];
		DataLayer data= new DataLayer();
		try {
		
		atributos[0]="codigo";
		atributos[1]="categoria";
		atributos[2]="sueldoBase";
		atributos[3]="complemento";
		atributos[4]="especie";
		atributos[5]="extras";
		atributos[6]="otros";
		atributos[7]="indemnizacion";
		atributos[8]="ccomunes";
		atributos[9]="fogasa";
		atributos[10]="atyet";
		atributos[11]="desempleo";
		atributos[12]="formacion";
		atributos[13]="irpf";
		atributos[14]="seguros";
		atributos[15]="jornada";
		atributos[16]="productividad";
		atributos[17]="costemediohora";
		valores[0]=trabajador.getCodigo();
		valores[1]=trabajador.getCategoria();
		valores[2]=trabajador.getSueldoBase();
		valores[3]=trabajador.getComplementos();
		valores[4]=trabajador.getEspecie();
		valores[5]=trabajador.getExtras();
		valores[6]=trabajador.getOtros();
		valores[7]=trabajador.getIndemnizacion();
		valores[8]=trabajador.getCcomunes();
		valores[9]=trabajador.getFogasa();
		valores[10]=trabajador.getAtyet();
		valores[11]=trabajador.getDesempleo();
		valores[12]=trabajador.getFormacion();
		valores[13]=trabajador.getIrpf();
		valores[14]=trabajador.getSeguros();
		valores[15]=trabajador.getJornada();
		valores[16]=trabajador.getProductividad();
		valores[17]=trabajador.getCostemediohora();
		System.out.println("DATA 1");
			data.update("\"Trabajadores\"", atributos, valores, indice);
			System.out.println("DATA 1");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			return e1.getMessage();
		}
		return "actualizado";
	}
	/**
	 * Devuelve el trabajador con el codigo id
	 * @param id
	 * @return
	 */
	public Worker accessWorker(String id){
		DataLayer data= new DataLayer();
		try {
			return data.findWorker("select * from \"Trabajadores\" where codigo=?", id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public void createWorker(Worker w,String user) throws ControllerException{
		String[] valores= new String[19];

		valores[0]=w.getCodigo();
		valores[1]=w.getCategoria();
		valores[2]=w.getSueldoBase();
		valores[3]=w.getComplementos();
		valores[4]=w.getEspecie();
		valores[5]=w.getExtras();
		valores[6]=w.getOtros();
		valores[7]=w.getIndemnizacion();
		valores[8]=w.getCcomunes();
		valores[9]=w.getFogasa();
		valores[10]=w.getAtyet();
		valores[11]=w.getDesempleo();
		valores[12]=w.getFormacion();
		valores[13]=w.getIrpf();
		valores[14]=w.getSeguros();
		valores[15]=w.getJornada();
		valores[16]=w.getProductividad();
		valores[17]=w.getCostemediohora();
		valores[18]=user;
		DataLayer data= new DataLayer();

		try {
			data.create("Trabajadores",valores);
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			throw new ControllerException(e.getMsg());
		}
	}
	public String maxCode(String tabla) throws ControllerException{
		DataLayer data= new DataLayer();
		try {
			return data.autoCode(tabla);
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			throw new ControllerException(e.getMsg());
		}
		
	}
	// SOPORTES
	public String showSupport(String user) throws ControllerException{
		DataLayer data= new DataLayer();
		String result="<table>";
		int indices=5;
		result+="<tr bgcolor=\"blue\"><td><font color=\"white\">Opciones</font></td><td><font color=\"white\">Soporte</font></td><td><font color=\"white\">Precio</font></td><td><font color=\"white\">Productividad</font></td><td><font color=\"white\">Coste Medio Hora</font></td></tr>";
		try {
			result+=data.showList("soportes", "codigo,nombre,precio,productividad,costemediohora", indices , "eliminarSoporte.html", "actualizarSoporte.html",user);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		result+="<tr bgcolor=\"blue\"><td colspan=5><a href=\"nuevoSoporte.html\">Nuevo</a></td></tr></table>";
		return result;
	}
	public void deleteSupport(String codigo) throws ControllerException {
		DataLayer data= new DataLayer();
		try {
			data.delete("soportes","codigo",codigo);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
	}
	public Support accessSupport(String id) {
		DataLayer data= new DataLayer();
		try {
			return data.findSupport("select * from soportes where codigo=?", id);
		} catch (Exception e) {
			return null;
		}
	}
	public void createSupport(Support s,String user) throws ControllerException{
		String[] valores= new String[10];

		valores[0]=s.getCodigo();
		valores[1]=s.getNombre();
		valores[2]=s.getFuncion();
		valores[3]=s.getTipo();
		valores[4]=s.getPrecio();
		valores[5]=s.getDuracion();
		valores[6]=s.getProductividad();
		valores[7]=s.getTolerancia();
		valores[8]=s.getCostemediohora();
		valores[9]=user;
		DataLayer data= new DataLayer();

		try {
			data.create("soportes",valores);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
	}
	public void updateSupport(String codigo, Support s) throws ControllerException{
		String[] atributos= new String[9];
		String[] valores= new String[9];
		DataLayer data= new DataLayer();
		try {
		
		atributos[0]="codigo";
		atributos[1]="nombre";
		atributos[2]="funcion";
		atributos[3]="tipo";
		atributos[4]="precio";
		atributos[5]="duracion";
		atributos[6]="productividad";
		atributos[7]="tolerancia";
		atributos[8]="costemediohora";
		valores[0]=s.getCodigo();
		valores[1]=s.getNombre();
		valores[2]=s.getFuncion();
		valores[3]=s.getTipo();
		valores[4]=s.getPrecio();
		valores[5]=s.getDuracion();
		valores[6]=s.getProductividad();
		valores[7]=s.getTolerancia();
		valores[8]=s.getCostemediohora();
		System.out.println("RM");
		data.update("soportes", atributos, valores, codigo);
		System.out.println("RM");	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new ControllerException( e1.getMessage());
		}		
	}
	// MATERIAL
	public String showMaterial(String user) throws ControllerException{
		DataLayer data= new DataLayer();
		String result="<table>";
		int indices=4;
		result+="<tr bgcolor=\"blue\"><td><font color=\"white\">Opciones</font></td><td><font color=\"white\">Material</font></td><td><font color=\"white\">Utilidad</font></td><td><font color=\"white\">Precio</font></td></tr>";
		try {
			result+=data.showList("materiales", "codigo,nombre,utilidad,precio", indices , "eliminarMaterial.html", "actualizarMaterial.html",user);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		result+="<tr bgcolor=\"blue\"><td colspan=5><a href=\"nuevoMaterial.html\">Nuevo</a></td></tr></table>";
		return result;
	}
	public void deleteMaterial(String codigo) throws ControllerException {
		DataLayer data= new DataLayer();
		try {
			data.delete("materiales","codigo",codigo);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
	}
	public Material accessMaterial(String id) {
		DataLayer data= new DataLayer();
		try {
			return data.findMaterial("select * from materiales where codigo=?", id);
		} catch (Exception e) {
			return null;
		}
	}
	public void createMaterial(Material s,String user) throws ControllerException{
		String[] valores= new String[5];

		valores[0]=s.getCodigo();
		valores[1]=s.getNombre();
		valores[2]=s.getUtilidad();
		valores[3]=s.getPrecio();
		valores[4]=user;
		DataLayer data= new DataLayer();

		try {
			data.create("materiales",valores);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
	}
	public void updateMaterial(String codigo, Material s) throws ControllerException{
		String[] atributos= new String[4];
		String[] valores= new String[4];
		DataLayer data= new DataLayer();
		try {
		atributos[0]="codigo";
		atributos[1]="nombre";
		atributos[2]="utilidad";
		atributos[3]="precio";
		
		valores[0]=s.getCodigo();
		valores[1]=s.getNombre();
		valores[2]=s.getUtilidad();
		valores[3]=s.getPrecio();
		
		data.update("materiales", atributos, valores, codigo);
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new ControllerException( e1.getMessage());
		}		
	}
// INSTALACIONES
	public String showInstallations(String user) throws ControllerException{
		DataLayer data= new DataLayer();
		String result="<table>";
		int indices=6;
		result+="<tr bgcolor=\"blue\"><td><font color=\"white\">Opciones</font></td><td><font color=\"white\">Instalación</font></td><td><font color=\"white\">Tipo</font></td><td><font color=\"white\">Direccion</font></td><td><font color=\"white\">Localidad</font></td><td><font color=\"white\">Pais</font></td><td><font color=\"white\">Coste Medio Hora</font></td></tr>";
		try {
			result+=data.showList("instalaciones", "codigo,nombre,tipo,direccion,localidad,pais,costemediohora", indices , "eliminarInstalacion.html", "actualizarInstalacion.html",user);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		result+="<tr bgcolor=\"blue\"><td colspan=7><a href=\"nuevaInstalacion.html\">Nuevo</a></td></tr></table>";
		return result;
	}
	public void deleteInstallation(String codigo) throws ControllerException {
		DataLayer data= new DataLayer();
		try {
			data.delete("instalaciones","codigo",codigo);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
	}
	public Installation accessInstallation(String id,String user) {
		DataLayer data= new DataLayer();
		try {
			return data.findInstallation("select * from instalaciones where codigo=? and user=?", id,user);
		} catch (Exception e) {
			return null;
		}
	}
	public void createInstallation(Installation s,String user) throws ControllerException{
		String[] valores= new String[10];

		valores[0]=s.getCodigo();
		valores[1]=s.getNombre();
		valores[2]=s.getDireccion();
		valores[3]=s.getLocalidad();
		valores[4]=s.getPais();
		valores[5]=s.getTipo();
		valores[6]=s.getPrecio();
		valores[7]=s.getDuración();
		valores[8]=s.getCostemediohora();
		valores[9]=user;
		DataLayer data= new DataLayer();

		try {
			data.create("instalaciones",valores);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
	}
	public void updateInstallation(String codigo, Installation s) throws ControllerException{
		String[] atributos= new String[8];
		String[] valores= new String[8];
		DataLayer data= new DataLayer();
		try {
		atributos[0]="codigo";
		atributos[1]="nombre";
		atributos[2]="direccion";
		atributos[3]="localidad";
		atributos[4]="pais";
		atributos[5]="tipo";
		atributos[6]="precio";
		atributos[7]="duracion";
		atributos[8]="costemediohora";
		
		valores[0]=s.getCodigo();
		valores[1]=s.getNombre();
		valores[2]=s.getDireccion();
		valores[3]=s.getLocalidad();
		valores[4]=s.getPais();
		valores[5]=s.getTipo();
		valores[6]=s.getPrecio();
		valores[7]=s.getDuración();
		valores[8]=s.getCostemediohora();
		
		data.update("instalaciones", atributos, valores, codigo);
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new ControllerException( e1.getMessage());
		}		
	}
	public String showReceipt(String codigo) throws ControllerException{
		String result="<table><tr><td>Servicio</td><td>Importe</td></tr>";
		DataLayer data=new DataLayer();
		try {
			result+=data.showList("recibos", "servicio,importe ", codigo);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		result+="</table>";
		return result;
	}

}
