package com.cl.food_app.Exceptions;

public class ItemNotFound extends RuntimeException {
	
	String message="Item is not available now";
	
	@Override
	public String getMessage() {
		return message;
	}

}
