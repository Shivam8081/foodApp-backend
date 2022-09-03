package com.cl.food_app.Exceptions;

public class MenuNotFound extends RuntimeException {
	
	String message="This menu is not there";
	
	public String getMessage() {
		return message;
	}

}
