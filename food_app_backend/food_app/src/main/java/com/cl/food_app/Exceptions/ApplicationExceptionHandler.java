package com.cl.food_app.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cl.food_app.structure.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(IDnotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IDnotFound iDnotFound){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage(iDnotFound.getMessage());
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setT("NO Such ID found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<ResponseStructure<String>> productNotFoundException(ProductNotFound found){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage(found.getMessage());
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setT("Product not available now");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ItemNotFound.class)
	public ResponseEntity<ResponseStructure<String>> itemNotFound(ItemNotFound found){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage(found.getMessage());
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setT("Item is not present in stock");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MenuNotFound.class)
	public ResponseEntity<ResponseStructure<String>> menuNotFound(MenuNotFound found){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage(found.getMessage());
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setT("Menu is not available");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
}
