package com.cl.food_app.Exceptions;

public class IDnotFound extends RuntimeException {
	
	String message="ID not found";
	
	@Override
	public String getMessage() {
	
		return message;
	}

}
