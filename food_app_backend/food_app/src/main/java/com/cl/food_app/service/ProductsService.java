package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cl.food_app.Exceptions.ProductNotFound;
import com.cl.food_app.dao.ProductDao;
import com.cl.food_app.dto.Products;
import com.cl.food_app.structure.ResponseStructure;

@Service
public class ProductsService {

	@Autowired
	ProductDao productDao;

	// save
	public ResponseEntity<ResponseStructure<Products>> saveProducts(Products products) {
		ResponseStructure<Products> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Saved Successfully");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(productDao.saveProducts(products));
		return new ResponseEntity<ResponseStructure<Products>>(responseStructure, HttpStatus.CREATED);
	}

	// getby
	public ResponseEntity<ResponseStructure<Products>> getby(int id) {
		Optional<Products> products = productDao.getby(id);
		ResponseStructure<Products> responseStructure = new ResponseStructure<>();
		if (products.isEmpty()) {
			throw new ProductNotFound();
		} else {
			responseStructure.setMessage("Found Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(products.get());
			return new ResponseEntity<ResponseStructure<Products>>(responseStructure, HttpStatus.OK);
		}

	}

	// delete
	public ResponseEntity<ResponseStructure<Products>> delete(int id) {
		Optional<Products> products = productDao.getby(id);
		ResponseStructure<Products> responseStructure = new ResponseStructure<>();
		if (products.isEmpty()) {
			throw new ProductNotFound();
		} else {
			responseStructure.setMessage("deleted Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(productDao.delete(id));
			return new ResponseEntity<ResponseStructure<Products>>(responseStructure, HttpStatus.OK);
		}

	}

	// update
	public ResponseEntity<ResponseStructure<Products>> update(Products products, int id) {
		Optional<Products> products2 = productDao.getby(id);
		ResponseStructure<Products> responseStructure = new ResponseStructure<>();
		if (products2.isEmpty()) {
			throw new ProductNotFound();
		} else {
			responseStructure.setMessage("updated Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(productDao.update(products, id));
			return new ResponseEntity<ResponseStructure<Products>>(responseStructure, HttpStatus.OK);
		}

	}

	// getall
	public ResponseEntity<ResponseStructure<List<Products>>> getall() {
		ResponseStructure<List<Products>> responseStructure = new ResponseStructure<List<Products>>();
		responseStructure.setMessage("Found all");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(productDao.getall());
		return new ResponseEntity<ResponseStructure<List<Products>>>(responseStructure, HttpStatus.CREATED);
	}
}
