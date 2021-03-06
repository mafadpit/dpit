package com.mafa.dpit;


import java.util.Calendar;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.mafa.dpit.excepciones.ControllerException;
import com.mafa.dpit.util.Allocation;
import com.mafa.dpit.util.Category;
import com.mafa.dpit.util.Customer;
import com.mafa.dpit.util.Installation;
import com.mafa.dpit.util.Material;
import com.mafa.dpit.util.Milestone;
import com.mafa.dpit.util.Project;
import com.mafa.dpit.util.Receipt;
import com.mafa.dpit.util.Risk;
import com.mafa.dpit.util.Support;
import com.mafa.dpit.util.Task;
import com.mafa.dpit.util.User;
import com.mafa.dpit.util.Worker;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ControllerLayer {
	
	HttpSession sesion;
	
	
	@RequestMapping("home")
	public String home(Model model) {
		try{
			
		}catch(Exception e){
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "home";
	}
	@RequestMapping("cerrar")
	public String cerrar(){
		try{
		sesion.removeAttribute("user");
		sesion.removeAttribute("rol");
		sesion.invalidate();
		}catch(Exception e){
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "home";
	}
	@RequestMapping("autentificar")
	public String autentificar(String user,String pass,ModelMap model,UserManager um,HttpSession sesion){
		User u=null;
		this.sesion=sesion;
		try{
			u=um.comprobarUsuario(user, pass);
			if(u!=null){
				model.addAttribute("colab", "<a href=\"colaboraciones.html\">Colab</a>");
				if(u.getRol().compareTo("Administrador")==0 || u.getRol().compareTo("Jefe de equipo")==0 ){
					model.addAttribute("proyectos", "<a href=\"proyectos.html\">Proyectos</a>");
					model.addAttribute("recursos", "<a href=\"recursos.html\">Recursos</a>");	
				}
				if(u.getRol().compareTo("Administrador")==0){
					model.addAttribute("publicador", "<a href=\"publicador.html\">Publicador</a>");
					model.addAttribute("usuarios", "<a href=\"usuarios.html\">Gesti�n de Usuario</a>");	
				}
				sesion.setAttribute("user", u.getDni());
				sesion.setAttribute("nombre", u.getNombreCompleto().toUpperCase());
				sesion.setAttribute("rol", u.getRol());
				sesion.setMaxInactiveInterval(60*3); // 3 minutos
				
			}else{
				sesion.removeAttribute("user");
				sesion.removeAttribute("rol");
				sesion.invalidate();
				return "home";
			}
		}catch(ControllerException e){
			System.out.println("Fallo:"+e.getMsg());
			return "home";
		}catch(Exception e){
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		
		return "entorno";
	}
	@RequestMapping("entorno")
	public String volver(ModelMap model){
		try{
		String rol=(String)sesion.getAttribute("rol");
		model.addAttribute("nombreCompleto",sesion.getAttribute("nombre"));
		model.addAttribute("colab", "<a href=\"colaboraciones.html\">Colab</a>");
		if(rol.compareTo("Administrador")==0 || rol.contains("Jefe de equipo")){
			model.addAttribute("proyectos", "<a href=\"proyectos.html\">Proyectos</a>");
			model.addAttribute("recursos", "<a href=\"recursos.html\">Recursos</a>");	
		}
		if(rol.compareTo("Administrador")==0){
				model.addAttribute("publicador", "<a href=\"publicador.html\">Publicador</a>");
				model.addAttribute("usuarios", "<a href=\"usuarios.html\">Gesti�n de Usuario</a>");	
		}
		
		}catch(Exception e){
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("session");
			return "sesion";
		}
		return "entorno";
	}
	/**
	 * PROYECTOS
	 */
	
	@RequestMapping("proyectos")
	public String proyectos(ModelMap model){
		UserManager um= new UserManager();
		ProjectManager pm= new ProjectManager();
		try{
			String user= (String)sesion.getAttribute("user");
			String rol=(String)sesion.getAttribute("rol");
			
			User u= um.findUser(user);

			model.addAttribute("nombre", u.getNombreCompleto());
			model.addAttribute("rol", rol);
			model.addAttribute("proyectos", pm.showProject(u.getDni()));
		}catch(Exception e){
			System.out.println(e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "proyectos";
		
	}
	@RequestMapping("eliminarProyecto")
	public String eliminarProyecto(String id,ModelMap model){
		
		UserManager um= new UserManager();
		ProjectManager pm= new ProjectManager();
		try{
			String user= (String)sesion.getAttribute("user");
			String rol=(String)sesion.getAttribute("rol");
			User u= um.findUser(user);
			pm.deleteProject(id);
			model.addAttribute("nombre", u.getNombreCompleto());
			model.addAttribute("rol", rol);
			model.addAttribute("proyectos", pm.showProject(u.getDni()));
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "proyectos";
	}
	@RequestMapping("nuevoProyecto")
	public String nuevoProyecto(ModelMap model){
		UserManager um= new UserManager();
		try{
			String user= (String)sesion.getAttribute("user");
			String rol=(String)sesion.getAttribute("rol");
			User u= um.findUser(user);
			model.addAttribute("nombre", u.getNombreCompleto());
			model.addAttribute("rol", rol);
		}catch(Exception e){
			System.out.println(e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "nuevoProyecto";
		
	}
	@RequestMapping("accederProyecto")
	public String accederProyecto(String id,ModelMap model){
		String user=(String) sesion.getAttribute("user");
		String rol=(String)sesion.getAttribute("rol");
		ProjectManager pm=new ProjectManager();
		Project p;
		try {
			p = pm.findProject(id);
		
		
			if(p.getEstado().compareToIgnoreCase("Planificaci�n")==0){
				
				model.addAttribute("id", id);
				return "planificarProyecto";
			}
			if(p.getEstado().compareToIgnoreCase("Seguimiento")==0){
			
				model.addAttribute("id", id);
				///// QUEDA POR HACER
				//
				//
				//
				return "seguirProyecto";
			}
			if(p.getEstado().compareToIgnoreCase("Cierre")==0){
			
				model.addAttribute("id", id);
				///// QUEDA POR HACER
				//
				//
				//
				return "cerrarProyecto";
			}
		} catch (ControllerException e) {
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("error");
			return "error";
		}
		return "error";
		
	}
	@RequestMapping("definirProyecto")
	public String definirProyecto(String titulo,String modelo,String tipo,ModelMap model){
		UserManager um= new UserManager();
		ResourceManager rm=new ResourceManager();
		ProjectManager pm= new ProjectManager();
		String user = (String) sesion.getAttribute("user");
		String rol= (String) sesion.getAttribute("rol");
		Calendar c= Calendar.getInstance();
		String fecha=Integer.toString(c.get(Calendar.DATE));
		fecha+="."+Integer.toString(c.get(Calendar.MONTH)+1);
		fecha+="."+Integer.toString(c.get(Calendar.YEAR));
		User u;
		Project p;
		try {
			String codigo= pm.maxCode("proyectos");
			u = um.findUser(user);
			model.addAttribute("nombre", u.getNombreCompleto());
			model.addAttribute("rol", rol);
			// Definir el proyecto
			if(titulo!=null){
			p= new Project(codigo,titulo,modelo,fecha,null,null,null,"Iniciado","0","0","0","0","0","0","0",tipo,user,null);
			pm.createProject(p);
			}
			sesion.setAttribute("proyecto",codigo);
			model.addAttribute("clientes",rm.showCustomer(u.getDni(),"definirProyectoB.html?id="));
		} catch (ControllerException e) {
		ModelAndView m= new ModelAndView();	
		m.setViewName("error");
		return "error";
		}
		return "definirProyecto";
	}
	@RequestMapping("definirProyectoB")
	public String asignarCliente(String id,ModelMap model){
		String user = (String) sesion.getAttribute("user");
		String rol= (String) sesion.getAttribute("rol");
		ResourceManager rm= new ResourceManager();
		Customer c;
		try{
		c=rm.accessCustomer(id);
		model.addAttribute("cif", c.getCif());
		model.addAttribute("nombre",c.getNombre());
		model.addAttribute("direccion",c.getDireccion());
		model.addAttribute("localidad",c.getLocalidad());
		model.addAttribute("pais",c.getPais());
		model.addAttribute("telefono",c.getTelefono());
		
		}catch (Exception e) {
			ModelAndView m= new ModelAndView();	
			m.setViewName("error");
			return "error";
		}
		return "definirProyectoB1";
		
	}
	
	@RequestMapping("proyectoNuevoCliente")
	public String nuevoCliente(ModelMap model){
		UserManager um= new UserManager();
		User u;
		try {
			u = um.findUser((String)sesion.getAttribute("user"));
			model.addAttribute("nombre",u.getNombreCompleto() );
			model.addAttribute("rol", sesion.getAttribute("rol"));
		} catch (ControllerException e) {
			ModelAndView m= new ModelAndView();
			m.setViewName("error");
			return "error";
		}
		return "definirProyectoB1";
	}
	@RequestMapping("definirProyectoC")
	public String mostrarAlcance(String cif,String nombre,String direccion,String localidad,String pais,String telefono,ModelMap model){
		String user= (String)sesion.getAttribute("user");
		DataLayer data= new DataLayer();
		String[] plantilla;
		String nivel="Categor�a";
		String categoria;
		// Comprobar el caso que ya existe el cliente para no crear fallo
		Customer c= new Customer(cif,nombre,direccion,localidad,pais,telefono,"Privado",user);
		Customer cli;
		ResourceManager rm = new ResourceManager();
		ProjectManager pm= new ProjectManager();
		TemplateManager tp= new TemplateManager();
		Category cat;
		System.out.println("T1");
		try {
			// Buscamos el proyecto
			System.out.println("T2");
			Project p= pm.findProject((String)sesion.getAttribute("proyecto"));
			// Creamos el cliente
			System.out.println("T3");
			cli=rm.accessCustomer(c.getCif());
			if(cli==null){
				rm.createCustomer(c);
				System.out.println("T3A");
			}
			// asignamos el cliente al proyecto
			System.out.println("T4");
			p.setCodigo_cliente(c.getCif());
			p.setCodigo_user(user);
			// Actualizamos el proyecto
			System.out.println("T5");
			pm.updateProject(p);
			System.out.println("T6");
			// Actualizamos las categorias (Alcance)
			plantilla=tp.template(p.getTipoProyecto());
			System.out.println("T7");
			for(int i=0;i<plantilla.length;i++){
				//Crear Alcance (Categorias y Subcategorias)
				if(plantilla[i].compareToIgnoreCase("C")==0 || plantilla[i].compareTo(" ")==0){
					nivel="Categor�a";
					System.out.println("T8");
				}else if(plantilla[i].compareToIgnoreCase("SC")==0){
					nivel="Sub-Categor�a";
					System.out.println("T8A");
				}else{
					if(nivel.compareToIgnoreCase("Categor�a")==0){
						//Creamos Categor�a
						System.out.println("T9");
						cat=new Category(pm.maxCode("categorias"),plantilla[i],"0","0","0","0",p.getCodigo());
						System.out.println("T10:"+cat.getCodigo());
						pm.createCategory(cat);
						System.out.println("T11");
						categoria=cat.getCodigo();
					}else{
						//Creamos sub-categorias de la "Categoria"
						
					}
				}
			}
			
			model.addAttribute("categorias",pm.showCategory(p.getCodigo()));
			System.out.println("T12");
			model.addAttribute("proyecto",p.getCodigo());
			System.out.println("T13");
			
		} catch (ControllerException e) {
			ModelMap m= new ModelMap();
			m.addAttribute("error", e.getMsg());
			return "error";
		}
		return "definirProyectoC";
	}
	@RequestMapping("planificarProyecto")
	public String planificarProyecto(String id,ModelMap model){
		ProjectManager pm= new ProjectManager();
		UserManager um= new UserManager();
		String user = (String) sesion.getAttribute("user");
		String rol= (String) sesion.getAttribute("rol");
		Calendar c= Calendar.getInstance();
		String fecha=Integer.toString(c.get(Calendar.DATE));
		fecha+="."+Integer.toString(c.get(Calendar.MONTH)+1);
		fecha+="."+Integer.toString(c.get(Calendar.YEAR));
		Project p;
		try {
			p= pm.findProject(id);
			p.setFechaAprobacion(fecha);
			p.setEstado("Planificaci�n");
			pm.updateProject(p);
			model.addAttribute("nombre", um.findUser(user).getNombreCompleto());
			model.addAttribute("rol", rol);
			model.addAttribute("id", p.getCodigo());
		} catch (ControllerException e) {
		ModelAndView m= new ModelAndView();	
		m.setViewName("error");
		return "error";
		}
		return "planificarProyecto";
	}
	/**
	 * CATEGORIAS
	 */
	
	@RequestMapping("eliminarCategoria")
	public String eliminarCategoria(String id,ModelMap model){
		String codigo_proyecto=(String)sesion.getAttribute("proyecto");
		try{
		ProjectManager pm= new ProjectManager();
		pm.deleteCategory(id);
		model.addAttribute("categorias",pm.showCategory(codigo_proyecto));
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "definirProyectoC";
	}
	@RequestMapping("actualizarCategoria")
	public String accederCategoria(String id,ModelMap model){
		ProjectManager pm= new ProjectManager();
		Category categoria;
		try {
			categoria = pm.findCategory(id);
		
		if(categoria!=null){
			model.addAttribute("codigo", categoria.getCodigo());
			model.addAttribute("categoria", categoria.getNombre());
			model.addAttribute("estimacionTemporal",categoria.getEstimacionTemporal());
			model.addAttribute("estimacionCoste", categoria.getEstimacionCoste());
			model.addAttribute("costeReal", categoria.getCosteReal());
			model.addAttribute("costeTemporal", categoria.getCosteTemporal());
		}
		} catch (ControllerException e) {
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "nuevaCategoria";
		
	}
	@RequestMapping("nuevaCategoria")
	public String nuevaCategoria(ModelMap model){
		String user= (String)sesion.getAttribute("user");
		ProjectManager pm= new ProjectManager();
		try {
			model.addAttribute("codigo",pm.maxCode("categorias"));
			model.addAttribute("categoria","Nueva Categoria");
			model.addAttribute("estimacionTemporal","0");
			model.addAttribute("estimacionCoste","0");
			model.addAttribute("costeReal", "0");
			model.addAttribute("costeTemporal", "0");
		return "nuevaCategoria";
		} catch (ControllerException e) {
			return "error";
		}
	}
	@RequestMapping("guardarCategoria")
	public String guardarCategoria(String codigo,String categoria,String estimacionTemporal,String estimacionCoste,String costeReal,String costeTemporal,ModelMap model){
		String codigo_proyecto= (String) sesion.getAttribute("proyecto");
		ProjectManager pm= new ProjectManager();
		try{
			System.out.println("Busca Categoria:"+codigo);
		Category c= pm.findCategory(codigo);
		if(c==null){
			// Crear una nueva Categoria
			try {				
				c=new Category(codigo,categoria,estimacionTemporal,estimacionCoste,costeReal,costeTemporal,codigo_proyecto);
				pm.createCategory(c);
				
				
			} catch (ControllerException e) {
				System.out.println("Fallo:"+e.getMsg());
				return "error";
			}
		}else{
			// Actualizar Categor�a
			c.setCodigo(codigo);
			c.setNombre(categoria);
			c.setEstimacionTemporal(estimacionTemporal);
			c.setEstimacionCoste(estimacionCoste);
			c.setCosteTemporal(costeTemporal);
			c.setCosteReal(costeReal);
			c.setCodigo_proyecto(codigo_proyecto);
			System.out.println("Categoria Actualizada:"+c.getNombre()+" "+c.getCodigo_proyecto());
			pm.updateCategory(c);
		}
			model.addAttribute("categorias",pm.showCategory(codigo_proyecto) );
		} catch (ControllerException e) {
			return "error";
		}
		return "definirProyectoC";
	}
	/**
	 * RECURSOS
	 */
	
	@RequestMapping("recursos")
	public String recursos(ModelMap model){
		String user= (String) sesion.getAttribute("user");
		model.addAttribute("user", user);
		return "recursos";
	}
	
	// TRABAJADORES
	
	@RequestMapping("trabajadores")
	public String listarTrabajadores(ModelMap model){
		try{
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();	
		model.addAttribute("trabajadores",r.showWorkers(user) );
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "trabajadores";
	}
	@RequestMapping("eliminarTrabajador")
	public String eliminarTrabajador(String id,ModelMap model){
		try{
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		model.addAttribute("estado", r.deleteWorkers(id));
		model.addAttribute("trabajadores",r.showWorkers(user) );
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "trabajadores";
	}
	
	@RequestMapping("accederTrabajador")
	public String accederTrabajador(String id,ModelMap model){
		String user= (String)sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		Worker trabajador= r.accessWorker(id);
		if(trabajador!=null){
			model.addAttribute("codigo", trabajador.getCodigo());
			model.addAttribute("categoria", trabajador.getCategoria());
			model.addAttribute("sueldoBase", trabajador.getSueldoBase());
			model.addAttribute("complementos", trabajador.getComplementos());
			model.addAttribute("especie", trabajador.getEspecie());
			model.addAttribute("extras", trabajador.getExtras());
			model.addAttribute("otros", trabajador.getOtros());
			model.addAttribute("ccomunes", trabajador.getCcomunes());
			model.addAttribute("atyet", trabajador.getAtyet());
			model.addAttribute("formacion", trabajador.getFormacion());
			model.addAttribute("fogasa", trabajador.getFogasa());
			model.addAttribute("desempleo", trabajador.getDesempleo());
			model.addAttribute("indemnizacion", trabajador.getIndemnizacion());
			model.addAttribute("irpf", trabajador.getIrpf());
			model.addAttribute("jornada", trabajador.getJornada());
			model.addAttribute("productividad", trabajador.getProductividad());
			model.addAttribute("costemediohora", trabajador.getCostemediohora());
			model.addAttribute("seguros", trabajador.getSeguros());

		}
		return "accederTrabajador";
		
	}
	@RequestMapping("nuevoTrabajador")
	public String nuevoTrabajador(ModelMap model){
		String user= (String)sesion.getAttribute("user");
		return "nuevoTrabajador";
	}
	@RequestMapping("guardarTrabajador")
	public String guardarTrabajador(String codigo, String categoria,String sueldoBase,String complementos,String especie,String otros,String extras,String indemnizacion,String ccomunes,String atyet,String desempleo,String formacion,String fogasa,String seguros,String irpf,String jornada,String productividad,String costemediohora,ModelMap model){
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		Worker w= r.accessWorker(codigo);
		if(w==null){
			// Crear un nuevo trabajador
			try {
			
				codigo=r.maxCode("Trabajadores");
				
				w=new Worker(codigo,categoria,sueldoBase,complementos,especie,extras,otros,indemnizacion,ccomunes,fogasa,atyet,desempleo,formacion,irpf,seguros,jornada,productividad,costemediohora,user);
				
				r.createWorker(w,user);
				
			} catch (ControllerException e) {
				System.out.println("Fallo:"+e.getMsg());
				return "error";
			}
		}else{
			// Actualizar Trabajador
			codigo=w.getCodigo();
			w.setCategoria(categoria);
			w.setAtyet(atyet);
			w.setCcomunes(ccomunes);
			w.setComplementos(complementos);
			w.setCostemediohora(costemediohora);
			w.setDesempleo(desempleo);
			w.setEspecie(especie);
			w.setExtras(extras);
			w.setFogasa(fogasa);
			w.setFormacion(formacion);
			w.setIndemnizacion(indemnizacion);
			w.setIrpf(irpf);
			w.setJornada(jornada);
			w.setOtros(otros);
			w.setProductividad(productividad);
			w.setSeguros(seguros);
			w.setSueldoBase(sueldoBase);
			r.updateWorkers(codigo,w);
		}
		try {
			model.addAttribute("trabajadores",r.showWorkers(user) );
		} catch (ControllerException e) {
			System.out.println(e.getMsg());
		}
		return "trabajadores";
	}
	
	// SOPORTES
	
	@RequestMapping("soportes")
	public String listarSoporte(ModelMap model){
		String user= (String) sesion.getAttribute("user");
		try{
		
		ResourceManager r= new ResourceManager();	
		model.addAttribute("soportes",r.showSupport(user) );
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "soportes";
	}
	@RequestMapping("nuevoSoporte")
	public String nuevoSoporte(ModelMap model){
		String user= (String)sesion.getAttribute("user");
		return "nuevoSoporte";
	}
	@RequestMapping("eliminarSoporte")
	public String eliminarSoporte(String id,ModelMap model){
		try{
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		r.deleteSupport(id);
		model.addAttribute("soportes",r.showSupport(user) );
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "soportes";
	}
	@RequestMapping("actualizarSoporte")
	public String accederSoporte(String id,ModelMap model){
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		Support soporte= r.accessSupport(id,user);
		if(soporte!=null){
			model.addAttribute("codigo", soporte.getCodigo());
			model.addAttribute("soporte", soporte.getNombre());
			model.addAttribute("funcion", soporte.getFuncion());
			model.addAttribute("tipo", soporte.getTipo());
			model.addAttribute("precio", soporte.getPrecio());
			model.addAttribute("productividad", soporte.getProductividad());
			model.addAttribute("tolerancia", soporte.getTolerancia());
			model.addAttribute("costemediohora", soporte.getCostemediohora());
			model.addAttribute("duracion", soporte.getDuracion());
		}
		return "actualizarSoporte";
	}
	@RequestMapping("guardarSoporte")
	public String guardarSoporte(String codigo, String soporte,String funcion,String tipo,String precio,String duracion,String productividad,String tolerancia,String costemediohora,ModelMap model){
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		Support s= r.accessSupport(codigo,user);
		if(s==null){
			// Crear un nuevo soporte
			try {
				codigo=r.maxCode("soportes");
				s=new Support(codigo,soporte,funcion,tipo,precio,duracion,productividad,tolerancia,costemediohora);
				r.createSupport(s,user);	
			} catch (ControllerException e) {
				System.out.println("Fallo:"+e.getMsg());
				return "error";
			}
		}else{
			// Actualizar soporte
			codigo=s.getCodigo();
			s.setNombre(soporte);
			s.setFuncion(funcion);
			s.setTipo(tipo);
			s.setPrecio(precio);
			s.setDuracion(duracion);
			s.setProductividad(productividad);
			s.setTolerancia(tolerancia);
			s.setCostemediohora(costemediohora);
			try {
				r.updateSupport(codigo,s);
				
		} catch (ControllerException e) {
			System.out.println("Fallo:"+e.getMsg());
			return "error";
		}
		
	}
		try {
			model.addAttribute("soportes",r.showSupport(user) );
		} catch (ControllerException e) {
			System.out.println("Fallo:"+e.getMsg());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "soportes";
	}
	
	// MATERIALES
	
	@RequestMapping("materiales")
	public String listarMateriales(ModelMap model){
		try{
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();	
		model.addAttribute("materiales",r.showMaterial(user) );
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "materiales";
	}
	@RequestMapping("nuevoMaterial")
	public String nuevoMaterial(ModelMap model){
		String user= (String)sesion.getAttribute("user");
		return "nuevoMaterial";
	}
	@RequestMapping("eliminarMaterial")
	public String eliminarMaterial(String id,ModelMap model){
		try{
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		r.deleteMaterial(id);
		model.addAttribute("materiales",r.showMaterial(user) );
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "materiales";
	}
	@RequestMapping("actualizarMaterial")
	public String accederMaterial(String id,ModelMap model){
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		Material mat= r.accessMaterial(id,user);
		if(mat!=null){
			model.addAttribute("codigo", mat.getCodigo());
			model.addAttribute("material", mat.getNombre());
			model.addAttribute("utilidad", mat.getUtilidad());
			model.addAttribute("precio", mat.getPrecio());
		}
		return "actualizarMaterial";
	}
	@RequestMapping("guardarMaterial")
	public String guardarMaterial(String codigo, String material ,String utilidad,String precio,ModelMap model){
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		Material s= r.accessMaterial(codigo,user);
		if(s==null){
			// Crear un nuevo soporte
			try {
				codigo=r.maxCode("materiales");
				s=new Material(codigo,material,utilidad,precio);
				r.createMaterial(s,user);	
			} catch (ControllerException e) {
				System.out.println("Fallo:"+e.getMsg());
				return "error";
			}
		}else{
			// Actualizar soporte
			codigo=s.getCodigo();
			s.setNombre(material);
			s.setUtilidad(utilidad);
			s.setPrecio(precio);
			try {
				r.updateMaterial(codigo,s);
				
		} catch (ControllerException e) {
			System.out.println("Fallo:"+e.getMsg());
			return "error";
		}
		
	}
		try {
			model.addAttribute("materiales",r.showMaterial(user) );
		} catch (ControllerException e) {
			return "error";
		}
		return "materiales";
	}
	
	
	// INSTALACIONES
	
	@RequestMapping("instalaciones")
	public String listarInstalaciones(ModelMap model){
		try{
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();	
		model.addAttribute("instalaciones",r.showInstallations(user) );
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "instalaciones";
	}
	@RequestMapping("nuevaInstalacion")
	public String nuevaInstalacion(ModelMap model){
		String user= (String) sesion.getAttribute("user");
		model.addAttribute("codigo_user", user);
		return "nuevaInstalacion";
	}
	@RequestMapping("eliminarInstalacion")
	public String eliminarInstalacion(String id,ModelMap model){
		String user= (String) sesion.getAttribute("user");
		try{
		ResourceManager r= new ResourceManager();
		r.deleteInstallation(id);
		model.addAttribute("instalaciones",r.showInstallations(user) );
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "instalaciones";
	}
	@RequestMapping("actualizarInstalacion")
	public String accederInstalacion(String id,ModelMap model){
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		try{
		Installation mat= r.accessInstallation(id,user);
		if(mat!=null){
			
			model.addAttribute("codigo", mat.getCodigo());
			model.addAttribute("instalacion", mat.getNombre());
			model.addAttribute("direccion", mat.getDireccion());
			model.addAttribute("localidad", mat.getLocalidad());
			model.addAttribute("pais", mat.getPais());
			model.addAttribute("tipo", mat.getTipo());
			model.addAttribute("duracion", mat.getDuraci�n());
			model.addAttribute("precio", mat.getPrecio());
			model.addAttribute("costemediohora",mat.getCostemediohora());
			model.addAttribute("recibos", r.showReceipt(mat.getCodigo()));
			} 
		
		}catch (ControllerException e) {
				ModelAndView modelE = new ModelAndView();
				modelE.setViewName("error");
				return "error";
			}
		return "actualizarInstalacion";
		}
		
	@RequestMapping("guardarInstalacion")
	public String guardarInstalacion(String codigo, String instalacion ,String direccion,String localidad,String pais,String tipo,String duracion,String precio, String costemediohora,ModelMap model){
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		try{
		Installation s= r.accessInstallation(codigo,user);
		
		if(s==null){
			// Crear un nuevo soporte
			
				codigo=r.maxCode("instalaciones");
				s=new Installation(codigo,instalacion,direccion,localidad,pais,tipo,precio,duracion,costemediohora,user);
				r.createInstallation(s,user);	
			
		}else{
			// Actualizar soporte
			codigo=s.getCodigo();
			s.setNombre(instalacion);
			s.setDireccion(direccion);
			s.setLocalidad(localidad);
			s.setPais(pais);
			s.setTipo(tipo);
			s.setDuraci�n(duracion);
			s.setPrecio(precio);
			s.setCostemediohora(costemediohora);
		}
				
			model.addAttribute("instalaciones",r.showMaterial(user) );
		} catch (ControllerException e) {
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("error");
			return "error";
		}
		return "instalaciones";
	}
	// RECIBOS 
	
		@RequestMapping("nuevoRecibo")
		public String nuevoRecibo(String id,ModelMap model){
			String user= (String) sesion.getAttribute("user");
			model.addAttribute("user", user);
			model.addAttribute("instalacion", id);
			return "nuevoRecibo";
		}
		
		@RequestMapping("guardarRecibo")
		public String guardarRecibo(String instalacion,String servicio,String importe,ModelMap model){
			String user= (String) sesion.getAttribute("user");
			ResourceManager r= new ResourceManager();
			try{
				Installation i= r.accessInstallation(instalacion, user);
				r.createReceipt(servicio, importe,instalacion);
				model.addAttribute("codigo", i.getCodigo());
				model.addAttribute("instalacion", i.getNombre());
				model.addAttribute("direccion", i.getDireccion());
				model.addAttribute("localidad",i.getLocalidad());
				model.addAttribute("pais",i.getPais());
				model.addAttribute("tipo", i.getTipo());
				model.addAttribute("duracion", i.getDuraci�n());
				model.addAttribute("precio", i.getPrecio());
				model.addAttribute("costemediohora",i.getCostemediohora());
				model.addAttribute("recibos", r.showReceipt(i.getCodigo()));
			} catch (ControllerException e) {
				ModelAndView modelE = new ModelAndView();
				modelE.setViewName("error");
				return "error";
			}
			return "actualizarInstalacion";
		}
		@RequestMapping("eliminarRecibo")
		public String eliminarRecibo(String id,ModelMap model){
			String user= (String) sesion.getAttribute("user");
			try{
			ResourceManager r= new ResourceManager();
			Receipt rec=r.accessReceipt(id);
			r.deleteReceipt(id);
			Installation i= r.accessInstallation(rec.getCodigo_instalacion(), user);
			model.addAttribute("codigo", i.getCodigo());
			model.addAttribute("instalacion", i.getNombre());
			model.addAttribute("direccion", i.getDireccion());
			model.addAttribute("localidad",i.getLocalidad());
			model.addAttribute("pais",i.getPais());
			model.addAttribute("tipo", i.getTipo());
			model.addAttribute("duracion", i.getDuraci�n());
			model.addAttribute("precio", i.getPrecio());
			model.addAttribute("costemediohora",i.getCostemediohora());
			model.addAttribute("recibos", r.showReceipt(i.getCodigo()));
			}catch(Exception e){
				System.out.println("Fallo:"+e.getMessage());
				ModelAndView modelE = new ModelAndView();
				modelE.setViewName("sesion");
				return "sesion";
			}
			return "actualizarInstalacion";
		}

 @RequestMapping("definirTareas")
 public String definirTareas(String id,ModelMap model){
	 try {
	 String user=(String)sesion.getAttribute("user");
	
	 UserManager um= new UserManager();
	 ProjectManager pm= new ProjectManager();
	 User u;
	 
	
		u = um.findUser(user);
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol", u.getRol());
		model.addAttribute("tareas", pm.showCategoryAccess(id));
		 sesion.setAttribute("Tcategoria","0" );
		 sesion.setAttribute("Tpartida", "0");
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		return "error";
	}catch(Exception ee){
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("sesion");
		return "sesion";
	}
	return "definirTareas";
}
 @RequestMapping("accesoCategoria")
 public String accesoCategoria(String id,ModelMap model){
	 String user=(String)sesion.getAttribute("user");
	 UserManager um= new UserManager();
	 ProjectManager pm= new ProjectManager();
	 User u;
	 Category cat;
	try {
		u = um.findUser(user);
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol", u.getRol());
		model.addAttribute("partidas", pm.showTask("0",id));
		 cat=pm.findCategory(id);
		 sesion.setAttribute("Tcategoria",cat.getCodigo() );
		 sesion.setAttribute("Tpartida", "0");
		 model.addAttribute("home","<a href=\"definirTareas.html?id="+cat.getCodigo_proyecto()+"\">Categorias</a>");	
		 model.addAttribute("categorias",cat.getNombre());
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		System.out.println(e.getMsg());
		return "error";
	}
	return "accesoPartida";
}
 @RequestMapping("accesoPartida")
 public String accesoPartida(String id,ModelMap model){
	 String actual;
	 String user=(String)sesion.getAttribute("user");
	 String tcategoria=(String)sesion.getAttribute("Tcategoria");
	 UserManager um= new UserManager();
	 ProjectManager pm= new ProjectManager();
	 User u;
	 Task t;
	 Category cat;
	try {
		u = um.findUser(user);
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol", u.getRol());
		model.addAttribute("partidas", pm.showTask(id,tcategoria));
		t=pm.findTask(id);
		sesion.setAttribute("Tpartida",id);
		
		cat=pm.findCategory(tcategoria);
		model.addAttribute("home","<a href=\"definirTareas.html?id="+cat.getCodigo_proyecto()+"\">Categorias</a>");	
		model.addAttribute("categorias","<a href=\"accesoCategoria.html?id="+cat.getCodigo()+"\">"+cat.getNombre()+"</a>");	
		actual=t.getDefinicion();
		if(t.getPartidaSuperior().compareToIgnoreCase("0")!=0){
			t=pm.findTask(t.getPartidaSuperior());
			model.addAttribute("partidaSup","<a href=\"accesoPartida.html?id="+ t.getCodigo()+"\">Subir Nivel</a> // "+actual);
		}else{
			model.addAttribute("partidaSup",actual);
				
		}
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		System.out.println(e.getMsg());
		return "error";
	}
	return "accesoPartida";
}
 @RequestMapping("nuevaPartida")
 public String nuevaPartida(String definicion,String unidad,String cantidad,String precioUnidad,String tipo,ModelMap model){
	 String user=(String)sesion.getAttribute("user");
	 String tcategoria=(String)sesion.getAttribute("Tcategoria");
	 String tpartida=(String)sesion.getAttribute("Tpartida");
	 String actual;
	 UserManager um= new UserManager();
	 ProjectManager pm= new ProjectManager();
	 User u;
	 Task t;
	 Category cat;
	try {
		u = um.findUser(user);
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol", u.getRol());
		//Creamos la partida nueva
		t=new Task(pm.maxCode("partidas"),definicion,unidad,cantidad,precioUnidad,tipo,"0","0","0","0","0","0",tpartida,tcategoria);
		pm.createTask(t);
		cat=pm.findCategory(tcategoria);
		model.addAttribute("partidas", pm.showTask(t.getPartidaSuperior(),tcategoria));
		model.addAttribute("categorias","<a href=\"accesoCategoria.html?id="+cat.getCodigo()+"\">"+cat.getNombre()+"</a>");
		actual=t.getDefinicion();
		if(t.getPartidaSuperior().compareToIgnoreCase("0")!=0){
			t=pm.findTask(t.getPartidaSuperior());
			model.addAttribute("partidaSup","<a href=\"accesoPartida.html?id="+ t.getCodigo()+"\">Subir Nivel</a> // "+actual);
		}else{
			model.addAttribute("partidaSup",actual);
				
		}
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		System.out.println(e.getMsg());
		return "error";
	}
	return "accesoPartida";
}
 
 @RequestMapping("eliminarCategoriaAccess")
	public String eliminarCategoriaAccess(String id,ModelMap model){
	 	String user= (String)sesion.getAttribute("user");
		String codigo_proyecto=(String)sesion.getAttribute("proyecto");
		try{
		ProjectManager pm= new ProjectManager();
		pm.deleteCategory(id);
		model.addAttribute("tareas",pm.showCategoryAccess(codigo_proyecto));
		}catch(Exception e){
			System.out.println("Fallo:"+e.getMessage());
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("error");
			return "error";
		}
		return "definirTareas";
	}
 @RequestMapping("eliminarPartida")
 public String eliminarPartida(String id,ModelMap model){
	 String user= (String) sesion.getAttribute("user");
	 String rol= (String) sesion.getAttribute("rol");
	 String actual;
	 ProjectManager pm=new ProjectManager();
	 try {
		Task t= pm.findTask(id);
		Category cat= pm.findCategory(t.getCategoria());
		t=pm.findTask(t.getPartidaSuperior());
		pm.deleteTask(id);
		model.addAttribute("partidas", pm.showTask(t.getCodigo(),cat.getCodigo()));
		model.addAttribute("home","<a href=\"definirTareas.html?id="+cat.getCodigo_proyecto()+"\">Categorias</a>");	
		model.addAttribute("categorias","<a href=\"accesoCategoria.html?id="+cat.getCodigo()+"\">"+cat.getNombre()+"</a>");	
		actual=t.getDefinicion();
		if(t.getPartidaSuperior().compareToIgnoreCase("0")!=0){
			t=pm.findTask(t.getPartidaSuperior());
			model.addAttribute("partidaSup","<a href=\"accesoPartida.html?id="+ t.getCodigo()+"\">Subir Nivel</a> // "+actual);
		}else{
			model.addAttribute("partidaSup",actual);
				
		}
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		System.out.println(e.getMsg());
		return "error";
	}
	 return "accesoPartida";
	 
 }
 @RequestMapping("medirPartida")
 public String medirPartida(String id,ModelMap model){
	 try {
		String user= (String) sesion.getAttribute("user");
	 	String rol= (String)sesion.getAttribute("rol");
	 	UserManager um= new UserManager();
		User u= um.findUser(user);
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol",rol);
		sesion.setAttribute("tpartida", id);
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		System.out.println(e.getMsg());
		return "error";
	} 
	 return "medirPartida";
 }
 @RequestMapping("medirPartidaA")
 public String medirPartidaA(String fde,ModelMap model){
	 try {
		String user= (String) sesion.getAttribute("user");
	 	String rol= (String)sesion.getAttribute("rol");
	 	UserManager um= new UserManager();
		User u= um.findUser(user);
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol",rol);
		model.addAttribute("fde",fde);
		
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		System.out.println(e.getMsg());
		return "error";
	} 
	 return "medirPartidaA";
 }
 @RequestMapping("medirPartidaB")
 public String medirPartidaB(String pfa,ModelMap model){
	 String actual;
	 String user=(String)sesion.getAttribute("user");
	 String tcategoria=(String)sesion.getAttribute("Tcategoria");
	 String id=(String)sesion.getAttribute("tpartida");
	 UserManager um= new UserManager();
	 ProjectManager pm= new ProjectManager();
	 User u;
	 Task t;
	 Category cat;
	 float total;
	try {
		u = um.findUser(user);
		t=pm.findTask(id);
		t.setCantidad(pfa);
		total=(Float.parseFloat(t.getCantidad())*Float.parseFloat(t.getPrecioUnidad()));
		t.setCosteFinal(""+total);
		pm.updateTask(t);
		
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol", u.getRol());
		model.addAttribute("partidas", pm.showTask(t.getPartidaSuperior(),tcategoria));
		t=pm.findTask(id);
		sesion.setAttribute("Tpartida",id);
		
		cat=pm.findCategory(tcategoria);
		model.addAttribute("home","<a href=\"definirTareas.html?id="+cat.getCodigo_proyecto()+"\">Categorias</a>");	
		model.addAttribute("categorias","<a href=\"accesoCategoria.html?id="+cat.getCodigo()+"\">"+cat.getNombre()+"</a>");	
		actual=t.getDefinicion();
		if(t.getPartidaSuperior().compareToIgnoreCase("0")!=0){
			t=pm.findTask(t.getPartidaSuperior());
			model.addAttribute("partidaSup","<a href=\"accesoPartida.html?id="+ t.getCodigo()+"\">Subir Nivel</a> // "+actual);
		}else{
			model.addAttribute("partidaSup",actual);
				
		}
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		System.out.println(e.getMsg());
		return "error";
	}
	return "accesoPartida";
 }
 @RequestMapping("asignarPartida")
 public String asignarPartida(String id,ModelMap model){
	 try {
		String user= (String) sesion.getAttribute("user");
	 	String rol= (String)sesion.getAttribute("rol");
	 	UserManager um= new UserManager();
	 	ResourceManager rm= new ResourceManager();
		User u= um.findUser(user);
		ProjectManager pm= new ProjectManager();
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol",rol);
		model.addAttribute("id", id);
		model.addAttribute("trabajadores", pm.showAllocation(id,"trabajador"));
		model.addAttribute("materiales", pm.showAllocation(id,"material"));
		model.addAttribute("soportes", pm.showAllocation(id,"soporte"));
		model.addAttribute("instalaciones", pm.showAllocation(id,"instalacion"));
		sesion.setAttribute("idp", id); // id de la partida
		
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		System.out.println(e.getMsg());
		return "error";
	} 
	 return "asignarPartida";
 }
@RequestMapping("nuevaAsignacion")
public String nuevaAsignacion(String tipo,ModelMap model){
	String user=(String) sesion.getAttribute("user");
	UserManager um= new UserManager();
	ProjectManager pm= new ProjectManager();
	ResourceManager rm= new ResourceManager();
	User u;
	try {
		String id= (String) sesion.getAttribute("idp");
		u = um.findUser(user);
		String rol=u.getRol();
		if(tipo!=null){
			if(tipo.compareToIgnoreCase("t")==0){
				model.addAttribute("recursos",rm.showWorkersA(user)); 
				sesion.setAttribute("tipop", "trabajador");
			}
			if(tipo.compareToIgnoreCase("s")==0){
				model.addAttribute("recursos", rm.showSupportA(user));
				sesion.setAttribute("tipop", "soporte");
			}
			if(tipo.compareToIgnoreCase("m")==0){
				model.addAttribute("recursos", rm.showMaterialA(user));
				sesion.setAttribute("tipop", "material");
			}
			if(tipo.compareToIgnoreCase("i")==0){
				model.addAttribute("recursos", rm.showInstallationsA(user));
				sesion.setAttribute("tipop", "instalacion");
			}
		}
		model.addAttribute("id",id);
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		return "error";
	}
	return "nuevaAsignacion";
}
@RequestMapping("guardarAsignacion")
public String guardarAsignacion(String id,String cantidad,String horas,String jornada,ModelMap model){
	String user=(String) sesion.getAttribute("user");
	String idp;
	UserManager um= new UserManager();
	ProjectManager pm= new ProjectManager();
	ResourceManager rm= new ResourceManager();
	User u;
	Worker w;
	Support s;
	Installation i;
	Material m;
	Allocation a=null;
	float coste;
	int c=1,h=8,j=8;
	if(cantidad!=null){
		c=Integer.parseInt(cantidad);
		h=Integer.parseInt(horas);
		j=Integer.parseInt(jornada);
	}
	try {
		idp= (String)sesion.getAttribute("idp");
		String tipo= (String)sesion.getAttribute("tipop");
		model.addAttribute("id", idp);
		u = um.findUser(user);
		model.addAttribute("user", u.getNombreCompleto());
		model.addAttribute("rol", u.getRol());
	if(tipo.compareToIgnoreCase("trabajador")==0){
		w= rm.accessWorker(id);
		System.out.println(w.getCodigo()+"id="+id);
		coste=Float.parseFloat(w.getCostemediohora())*c*j*(h/j);
		a= new Allocation(pm.maxCode("asignaciones"),idp,id,String.valueOf(cantidad),String.valueOf(horas), String.valueOf(jornada), tipo,String.valueOf(coste),w.getCategoria());
	}
	if(tipo.compareToIgnoreCase("soporte")==0){
		s= rm.accessSupport(id,user);
		coste=Float.parseFloat(s.getCostemediohora())*c*j*(h/j);
		a= new Allocation(pm.maxCode("asignaciones"),idp,id,String.valueOf(cantidad),String.valueOf(horas), String.valueOf(jornada), tipo,String.valueOf(coste),s.getNombre());
	}
	if(tipo.compareToIgnoreCase("instalacion")==0){
		i= rm.accessInstallation(id, user);
		coste=Float.parseFloat(i.getCostemediohora())*c*j*(h/j);
		a= new Allocation(pm.maxCode("asignaciones"),idp,id,String.valueOf(cantidad),String.valueOf(horas), String.valueOf(jornada), tipo,String.valueOf(coste),i.getNombre());
	}
	if(tipo.compareToIgnoreCase("material")==0){
		m= rm.accessMaterial(id, user);
		coste=Float.parseFloat(m.getPrecio())*c*j*(h/j);
		a= new Allocation(pm.maxCode("asignaciones"),idp,id,String.valueOf(cantidad),String.valueOf(horas), String.valueOf(jornada), tipo,String.valueOf(coste),m.getNombre());
	}
		Allocation ac= pm.findAllocation(a);
		if(cantidad!=null){
			if(ac!=null ){
				pm.updateAllocation(ac);
			}else{
				pm.createAllocation(idp, a);
				
			}
			model.addAttribute("estado", "Guardado");
		}
		pm.recalcular(idp);
		
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		return "error";
	}
	model.addAttribute("asig", "<form action=\"guardarAsignacion.html\" method=\"POST\">" +
			"Partida:<input type=\"text\" name=\"id\" value=" +id+" readOnly>"+
			"Cantidad:<input type=\"text\" name=\"cantidad\" value=1 >" +
			"Horas Totales:<input type=\"text\" name=\"horas\" value=8 >" +
			"Jornada Diaria:<input type=\"text\" name=\"jornada\" value=8 >" +
			"<input type=\"Submit\" value=\"Guardar\">" +
			"</form>");
	return "nuevaAsignacion";
	//PODER ELIMINAR
}
@RequestMapping("eliminarAsignacion")
public String eliminarAsignacion(String id,ModelMap model){
	String user= (String) sesion.getAttribute("user");
	String idp=(String) sesion.getAttribute("idp");
	UserManager um= new UserManager();
	ResourceManager rm= new ResourceManager();
	ProjectManager pm= new ProjectManager();
	
	try {
		User u= um.findUser(user);
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol", u.getRol());
		pm.deleteAllocation(id);
		pm.recalcular(idp);
		
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		return "error";
	}
	
	model.addAttribute("volver", idp);
	return "eliminarAsignacion";
	
}
@RequestMapping("hitosPartida")
public String hitosPartida(String id,String nombre,String descripcion,String tipo,ModelMap model){
	String user=(String)sesion.getAttribute("user");
	UserManager um= new UserManager();
	ProjectManager pm= new ProjectManager();
	String idp=id,codigo;
	try {
		if(idp==null){
			idp=(String)sesion.getAttribute("idp");
		}else{
			sesion.setAttribute("idp", id);
		}
		User u= um.findUser(user);
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol", u.getRol());
		model.addAttribute("id", idp);
		if(nombre!=null){
			codigo = pm.maxCode("hitos");
			Milestone m= new Milestone(codigo,nombre,descripcion,tipo,"0","0",idp);
			pm.createMilestone(m);
		}
		model.addAttribute("hitos", pm.showMilestones(idp) );
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		return "error";
	}
	return "hitosPartida";
}
@RequestMapping("eliminarHito")
public String eliminarHito(String id,ModelMap model){
	ProjectManager pm= new ProjectManager();
	try{
		// Falta usuario y rol
	pm.deleteMilestone(id);
	model.addAttribute("id", (String)sesion.getAttribute("idp"));
	}catch(ControllerException e){
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		return "error";
	}
	return "eliminarHito";
}
@RequestMapping("riesgosPartida")
public String riesgosPartida(String id,String nombre,String evento,String solucion,String coste,String tiempo,String impacto,String probabilidad,ModelMap model){
	String user=(String)sesion.getAttribute("user");
	UserManager um= new UserManager();
	ProjectManager pm= new ProjectManager();
	String idp=id,codigo;
	try {
		if(idp==null){
			idp=(String)sesion.getAttribute("idp");
		}else{
			sesion.setAttribute("idp", id);
		}
		User u= um.findUser(user);
		model.addAttribute("nombre", u.getNombreCompleto());
		model.addAttribute("rol", u.getRol());
		model.addAttribute("id", idp);
		if(nombre!=null){
			codigo = pm.maxCode("riesgos");
			Risk r= new Risk(codigo,nombre,evento,solucion,coste,tiempo,impacto,probabilidad,idp);
			pm.createRisk(r);
		}
		model.addAttribute("riesgos", pm.showRisk(idp) );
	} catch (ControllerException e) {
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		return "error";
	}
	return "riesgosPartida";
}
@RequestMapping("eliminarRiesgo")
public String eliminarRiesgo(String id,ModelMap model){
	ProjectManager pm= new ProjectManager();
	try{
		// Falta usuario y rol
	pm.deleteRisk(id);
	model.addAttribute("id", (String)sesion.getAttribute("idp"));
	}catch(ControllerException e){
		ModelAndView modelE = new ModelAndView();
		modelE.setViewName("error");
		return "error";
	}
	return "eliminarRiesgo";
}
}
