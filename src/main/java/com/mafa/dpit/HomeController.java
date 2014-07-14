package com.mafa.dpit;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mafa.dpit.excepciones.ControllerException;
import com.mafa.dpit.util.Installation;
import com.mafa.dpit.util.Material;
import com.mafa.dpit.util.Support;
import com.mafa.dpit.util.User;
import com.mafa.dpit.util.Worker;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	HttpSession sesion;
	@RequestMapping("home")
	public String home() {
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
					model.addAttribute("usuarios", "<a href=\"usuarios.html\">Gestión de Usuario</a>");	
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
		if(rol.compareTo("Administrador")==0){
			model.addAttribute("proyectos", "<a href=\"proyectos.html\">Proyectos</a>");
			model.addAttribute("recursos", "<a href=\"recursos.html\">Recursos</a>");	
		}
		}catch(Exception e){
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("session");
			return "sesion";
		}
		return "entorno";
	}
	@RequestMapping("proyectos")
	public String proyectos(ModelMap model){
		try{
		String rol=(String)sesion.getAttribute("rol");
		}catch(Exception e){
			ModelAndView modelE = new ModelAndView();
			modelE.setViewName("sesion");
			return "sesion";
		}
		return "proyectos";
		
	}
	/**
	 * RECURSOS
	 */
	
	@RequestMapping("recursos")
	public String recursos(ModelMap model){
		String user= (String) sesion.getAttribute("user");
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
		ResourceManager r= new ResourceManager();
		Support soporte= r.accessSupport(id);
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
		Support s= r.accessSupport(codigo);
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
		ResourceManager r= new ResourceManager();
		Material mat= r.accessMaterial(id);
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
		Material s= r.accessMaterial(codigo);
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
		Installation mat= r.accessInstallation(id,user);
		if(mat!=null){
			model.addAttribute("codigo", mat.getCodigo());
			model.addAttribute("instalacion", mat.getNombre());
			model.addAttribute("direccion", mat.getDireccion());
			model.addAttribute("localidad", mat.getLocalidad());
			model.addAttribute("pais", mat.getPais());
			model.addAttribute("tipo", mat.getTipo());
			model.addAttribute("duracion", mat.getDuración());
			model.addAttribute("precio", mat.getPrecio());
			model.addAttribute("costemediohora",mat.getCostemediohora());
			try {
				model.addAttribute("recibos", r.showReceipt(mat.getCodigo()));
			} catch (ControllerException e) {
				ModelAndView modelE = new ModelAndView();
				modelE.setViewName("error");
				return "error";
			}
		}
		return "actualizarInstalacion";
	}
	@RequestMapping("guardarInstalacion")
	public String guardarInstalacion(String codigo, String instalacion ,String direccion,String localidad,String pais,String tipo,String duracion,String precio, String costemediohora,ModelMap model){
		String user= (String) sesion.getAttribute("user");
		ResourceManager r= new ResourceManager();
		Installation s= r.accessInstallation(codigo,user);
		if(s==null){
			// Crear un nuevo soporte
			try {
				codigo=r.maxCode("instalaciones");
				s=new Installation(codigo,instalacion,direccion,localidad,pais,tipo,precio,duracion,costemediohora,user);
				r.createInstallation(s,user);	
			} catch (ControllerException e) {
				System.out.println("Fallo:"+e.getMsg());
				return "error";
			}
		}else{
			// Actualizar soporte
			codigo=s.getCodigo();
			s.setNombre(instalacion);
			s.setDireccion(direccion);
			s.setLocalidad(localidad);
			s.setPais(pais);
			s.setTipo(tipo);
			s.setDuración(duracion);
			s.setPrecio(precio);
			s.setCostemediohora(costemediohora);
			try {
				r.updateInstallation(codigo,s);
				
		} catch (ControllerException e) {
			System.out.println("Fallo:"+e.getMsg());
			return "error";
		}
		
	}
		try {
			model.addAttribute("instalaciones",r.showMaterial(user) );
		} catch (ControllerException e) {
			System.out.println("Fallo:"+e.getMsg());
			return "error";
		}
		return "instalaciones";
	}
}

