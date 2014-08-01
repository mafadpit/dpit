package com.mafa.dpit.excepciones;
@SuppressWarnings("serial")
public class AccessException extends Exception{

	String msg;
	public AccessException(String msg){
		super();
		this.msg=msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
