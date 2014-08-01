package com.mafa.dpit;

import com.mafa.dpit.excepciones.AccessException;
import com.mafa.dpit.excepciones.ControllerException;
import com.mafa.dpit.util.User;

public class UserManager {
	public UserManager(){
		
	}
	public User comprobarUsuario(String user,String pass) throws ControllerException{
		User result=null;
		DataLayer data= new DataLayer();
		try{

			result=data.findUser("select * from usuarios where usuario=? and contraseña=?",user,pass);
			
			return result;
			
		}catch(AccessException e){
			throw new ControllerException(e.getMsg());
		}catch(Exception ee){
			throw new ControllerException(ee.getMessage());
		}
		
		
	}
	public User findUser(String user) throws ControllerException {
		DataLayer data= new DataLayer();
		try{
			return data.findUser("select * from usuarios where dni=?", user);
			
		}catch(AccessException e){
			throw new ControllerException(e.getMsg());
		}
	}

}
