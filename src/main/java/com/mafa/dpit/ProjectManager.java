package com.mafa.dpit;

import com.mafa.dpit.excepciones.AccessException;
import com.mafa.dpit.excepciones.ControllerException;
import com.mafa.dpit.util.Category;
import com.mafa.dpit.util.Project;

public class ProjectManager {
	
	public String showProject(String codigo_user)throws ControllerException{
		String result="<table><tr bgcolor=\"Blue\"><td>T�tulo</td><td>Estado</td><td>Estimaci�n Temporal</td><td>Coste</td><td>Tipo de proyecto</td></tr>";
		DataLayer data= new DataLayer();
		try {
			result+=data.showList("Select codigo,titulo,estado,\"estimacionTemporal\",coste,\"tipoProyecto\", codigo_user from proyectos where codigo_user=?",codigo_user, 7, "eliminarProyecto.html", "actualizarProyecto.html");
			
			
		} catch (AccessException e) {
			System.out.println(e.getMsg());
			throw new ControllerException(e.getMsg());
		}
		result+="</table>";
		return result;
	}
	public String maxCode(String tabla) throws ControllerException{
		DataLayer data= new DataLayer();
		try {
			return data.autoCode(tabla);
		} catch (AccessException e) {
				throw new ControllerException(e.getMsg());
		}
		
	}
	public void createProject(Project p)throws ControllerException {
		DataLayer data= new DataLayer();
		String[] valores= new String[16];
		valores[0]=p.getCodigo();
		valores[1]=p.getTitulo();
		valores[2]=p.getModelo();
		valores[3]=p.getFechaSolicitud();
		valores[4]=p.getFechaAprobacion();
		valores[5]=p.getFechaSeguimiento();
		valores[6]=p.getFechaCierre();
		valores[7]=p.getEstado();
		valores[8]=p.getEstimaci�nTemporal();
		valores[9]=p.getCoste();
		valores[10]=p.getCapitalInicial();
		valores[11]=p.getIntereses();
		valores[12]=p.getPlazo();
		valores[13]=p.getGastosDerivados();
		valores[14]=p.getFinanciaci�n();
		valores[15]=p.getTipoProyecto();
		try {
			data.create("proyectos", valores);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		
	}
	public Project findProject(String codigo) throws ControllerException{
		DataLayer data= new DataLayer();
		try {
			return data.findProject("select * from proyectos where codigo=? ",codigo);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
	}
	public void updateProject(Project p)throws ControllerException {
		DataLayer data= new DataLayer();
		String[] atributos= new String[18];
		String[] valores= new String[18];
		atributos[0]="codigo";
		atributos[1]="titulo";
		atributos[2]="modelo";
		atributos[3]="\"fechaAprobado\"";
		atributos[4]="\"fechaPlanificacion\"";
		atributos[5]="\"fechaSeguimiento\"";
		atributos[6]="\"fechaCierre\"";
		atributos[7]="estado";
		atributos[8]="\"estimacionTemporal\"";
		atributos[9]="coste";
		atributos[10]="\"capitalInicial\"";
		atributos[11]="intereses";
		atributos[12]="plazo";
		atributos[13]="\"gastosDerivados\"";
		atributos[14]="\"tipoFinanciacion\"";
		atributos[15]="\"tipoProyecto\"";
		atributos[16]="codigo_user";
		atributos[17]="cod_cliente";
		valores[0]=p.getCodigo();
		valores[1]=p.getTitulo();
		valores[2]=p.getModelo();
		valores[3]=p.getFechaSolicitud();
		valores[4]=p.getFechaAprobacion();
		valores[5]=p.getFechaSeguimiento();
		valores[6]=p.getFechaCierre();
		valores[7]=p.getEstado();
		valores[8]=p.getEstimaci�nTemporal();
		valores[9]=p.getCoste();
		valores[10]=p.getCapitalInicial();
		valores[11]=p.getIntereses();
		valores[12]=p.getPlazo();
		valores[13]=p.getGastosDerivados();
		valores[14]=p.getFinanciaci�n();
		valores[15]=p.getTipoProyecto();
		valores[16]=p.getCodigo_user();
		valores[17]=p.getCodigo_cliente();
		try {
			data.update("proyectos", atributos, valores, p.getCodigo());
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		
	}
	public void createCategory(Category category)throws ControllerException {
		DataLayer data= new DataLayer();
		String[] valores= new String[7];
		valores[0]=category.getCodigo();
		valores[1]=category.getNombre();
		valores[2]=category.getEstimacionCoste();
		valores[3]=category.getEstimacionTemporal();
		valores[4]=category.getCosteReal();
		valores[5]=category.getCosteTemporal();
		valores[6]=category.getCodigo_proyecto();
		try {
			data.create("categorias", valores);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		
	}
	public String showCategory(String codigo_proyecto) throws ControllerException {
		String result="<table><tr><td>Opciones</td><td>Nombre</td><td>Estimaci�n Temporal</td><td>Estimaci�n Econ�mica</td><td>Coste Econ�mico</td><td>Coste Temporal</td></tr>";
		DataLayer data= new DataLayer();
		try {
			
			result+=data.showList("select * from categorias where codigo_proyecto=?; ", codigo_proyecto, 6, "eliminarCategoria.html", "actualizarCategoria.html");
			
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		result+="</table>";
		return result;
	}
	public void deleteCategory(String id) throws ControllerException{
		DataLayer data= new DataLayer();
		try {
			data.delete("categorias", "codigo", id);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		
	}
	public Category findCategory(String id) throws ControllerException{
		DataLayer data= new DataLayer();
		try {
			return data.findCategory("select * from categorias where codigo=? ",id);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
	}
	public void updateCategory(Category c) throws ControllerException {
		DataLayer data= new DataLayer();
		String[] atributos= new String[7];
		String[] valores= new String[7];
		atributos[0]="codigo";
		atributos[1]="nombre";
		atributos[2]="\"estimacionTemporal\"";
		atributos[3]="\"estimacionCoste\"";
		atributos[4]="\"costeReal\"";
		atributos[5]="\"costeTemporal\"";
		atributos[6]="codigo_proyecto";
		valores[0]=c.getCodigo();
		valores[1]=c.getNombre();
		valores[2]=c.getEstimacionTemporal();
		valores[3]=c.getEstimacionCoste();
		valores[4]=c.getCosteReal();
		valores[5]=c.getCosteTemporal();
		valores[6]=c.getCodigo_proyecto();
		try {
			System.out.println("PM1");
			data.update("categorias", atributos, valores, c.getCodigo());
			System.out.println("PM2");
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		
	}

}
