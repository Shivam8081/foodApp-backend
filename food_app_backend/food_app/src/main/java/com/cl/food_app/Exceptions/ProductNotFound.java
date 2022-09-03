package com.cl.food_app.Exceptions;


public class ProductNotFound extends RuntimeException {
	
	String message="Product not present";
	
	@Override
	public String getMessage() {
	
		return message;
	}

}
