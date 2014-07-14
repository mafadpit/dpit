package com.mafa.dpit;

import java.io.IOException;

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
			
		if(result==null){
			System.out.println("Comprobación fallida");
		}
		}catch(AccessException e){
			throw new ControllerException(e.getMsg());
		}catch(Exception ee){
			throw new ControllerException(ee.getMessage());
		}
		
		return result;
	}

}
