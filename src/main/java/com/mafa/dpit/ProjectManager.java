package com.mafa.dpit;

import com.mafa.dpit.excepciones.AccessException;
import com.mafa.dpit.excepciones.ControllerException;
import com.mafa.dpit.util.Category;
import com.mafa.dpit.util.Project;
import com.mafa.dpit.util.Task;

public class ProjectManager {
	
	public String showProject(String codigo_user)throws ControllerException{
		String result="<table><tr bgcolor=\"Blue\"><td>Título</td><td>Estado</td><td>Estimación Temporal</td><td>Coste</td><td>Tipo de proyecto</td></tr>";
		DataLayer data= new DataLayer();
		try {
			result+=data.showList("Select codigo,titulo,estado,\"estimacionTemporal\",coste,\"tipoProyecto\", codigo_user from proyectos where codigo_user=?",codigo_user, 7, "eliminarProyecto.html", "accederProyecto.html");
			
			
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
		valores[8]=p.getEstimaciónTemporal();
		valores[9]=p.getCoste();
		valores[10]=p.getCapitalInicial();
		valores[11]=p.getIntereses();
		valores[12]=p.getPlazo();
		valores[13]=p.getGastosDerivados();
		valores[14]=p.getFinanciación();
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
		valores[8]=p.getEstimaciónTemporal();
		valores[9]=p.getCoste();
		valores[10]=p.getCapitalInicial();
		valores[11]=p.getIntereses();
		valores[12]=p.getPlazo();
		valores[13]=p.getGastosDerivados();
		valores[14]=p.getFinanciación();
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
		String result="<table><tr><td>Opciones</td><td>Nombre</td><td>Estimación Temporal</td><td>Estimación Económica</td><td>Coste Económico</td><td>Coste Temporal</td></tr>";
		DataLayer data= new DataLayer();
		try {
			
			result+=data.showList("select * from categorias where codigo_proyecto=?",codigo_proyecto,6, "eliminarCategoria.html", "actualizarCategoria.html");
			
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		result+="</table>";
		return result;
	}
	public String showCategoryAccess(String codigo_proyecto) throws ControllerException {
		String result="<table><tr><td>Opciones</td><td>Nombre</td><td>Estimación Temporal</td><td>Estimación Económica</td><td>Coste Económico</td><td>Coste Temporal</td></tr>";
		DataLayer data= new DataLayer();
		try {
			
			result+=data.showList("select * from categorias where codigo_proyecto=?",codigo_proyecto,6, "eliminarCategoriaAccess.html", "accesoCategoria.html");
			
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
	public Task findTask(String partida) throws ControllerException {
		// Devuelve la Partida
		String sql="select * from partidas where codigo=?";
		DataLayer data= new DataLayer();
		try {
			return data.findTask(sql,partida);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
	}
	public String showTask(String id,String categoria) throws ControllerException{
		String result="<table><tr><td>Opciones</td><td>Definición</td><td>Unidad</td><td>Cantidad</td><td>Precio/Unidad</td><td>Tipo</td><td>Coste Final</td></tr>";
		String tabla="partidas";
		String columnas="codigo,definicion,unidad,cantidad,\"precioUnidad\",tipo,\"costeFinal\"";
		int indices=7;
		String condicion="\"partidaSuperior\" ='"+ id+"' and categoria='"+categoria+"'";
		String eliminar="eliminarPartida.html";
		String acceder="accesoPartida.html";
		String medir="medirPartida.html";
		String asignar="asignarPartida.html";
		String hitos="hitosPartida.html";
		String riesgos="riesgosPartida.html";
		DataLayer data= new DataLayer();
		try {
			result+=data.showListTask(tabla, columnas, indices, condicion, eliminar, acceder,medir,asignar,hitos,riesgos);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		result+="</table>";
		return result;
	}
	public String showTaskCategory(String id) throws ControllerException{
		String result="<table><tr><td>Opciones</td><td>Definición</td><td>Unidad</td><td>Cantidad</td><td>Precio/Unidad</td><td>Tipo</td><td>Coste/Final</td></tr>";
		String tabla="partidas";
		String columnas="codigo,definicion,unidad,cantidad,\"precioUnidad\",tipo,\"costeFinal\"";
		int indices=7;
		String condicion="\"partidaSuperior\" = '0' and categoria='"+ id+"'";
		String eliminar="eliminarPartida.html";
		String actualizar="accesoPartida.html";
		DataLayer data= new DataLayer();
		try {
			result+=data.showListAccess(tabla, columnas, indices, condicion, eliminar, actualizar);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		result+="</table>";
		return result;
	}
	public void createTask(Task t) throws ControllerException{
		DataLayer data= new DataLayer();
		String[] valores= new String[14];
		valores[0]=t.getCodigo();
		valores[1]=t.getDefinicion();
		valores[2]=t.getUnidad();
		valores[3]=t.getCantidad();
		valores[4]=t.getPrecioUnidad();
		valores[5]=t.getTipo();
		valores[6]=t.getCosteFinal();
		valores[7]=t.getPartidaSuperior();
		valores[8]=t.getCategoria();
		valores[9]=t.getEstado();
		valores[10]=t.getOrden();
		valores[11]=t.getColchon();
		valores[12]=t.getAsignaciones();
		valores[13]=t.getCostesDerivados();
		
		try {
			data.create("partidas", valores);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		
		
	}
	public void deleteProject(String id) throws ControllerException{
		DataLayer data= new DataLayer();
		try {
			data.delete("proyectos", "codigo", id);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		
	}
	public void deleteTask(String id) throws ControllerException{
		DataLayer data= new DataLayer();
		try {
			data.delete("partidas", "codigo", id);
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		
	}
	public void updateTask(Task t) throws ControllerException {
		DataLayer data= new DataLayer();
		String[] atributos= new String[14];
		String[] valores= new String[14];
		atributos[0]="codigo";
		atributos[1]="definicion";
		atributos[2]="unidad";
		atributos[3]="cantidad";
		atributos[4]="\"precioUnidad\"";
		atributos[5]="tipo";
		atributos[6]="\"costeFinal\"";
		atributos[7]="\"partidaSuperior\"";
		atributos[8]="categoria";
		atributos[9]="estado";
		atributos[10]="orden";
		atributos[11]="colchon";
		atributos[12]="asignaciones";
		atributos[13]="\"costesDerivados\"";
		valores[0]=t.getCodigo();
		valores[1]=t.getDefinicion();
		valores[2]=t.getUnidad();
		valores[3]=t.getCantidad();
		valores[4]=t.getPrecioUnidad();
		valores[5]=t.getTipo();
		valores[6]=t.getCosteFinal();
		valores[7]=t.getPartidaSuperior();
		valores[8]=t.getCategoria();
		valores[9]=t.getEstado();
		valores[10]=t.getOrden();
		valores[11]=t.getColchon();
		valores[12]=t.getAsignaciones();
		valores[13]=t.getCostesDerivados();
		try {
			data.update("partidas", atributos, valores, t.getCodigo());
		} catch (AccessException e) {
			throw new ControllerException(e.getMsg());
		}
		
		
	}

}
