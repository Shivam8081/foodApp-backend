package com.cl.food_app.structure;

public class ResponseStructure<T> {
	String message;
	int statuscode;
	T t;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	

}
