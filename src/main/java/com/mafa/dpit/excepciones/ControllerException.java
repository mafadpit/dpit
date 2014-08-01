package com.mafa.dpit.excepciones;

@SuppressWarnings("serial")
public class ControllerException extends Exception{
String msg;

public ControllerException(String msg) {
	super();
	this.msg = msg;
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}


}
