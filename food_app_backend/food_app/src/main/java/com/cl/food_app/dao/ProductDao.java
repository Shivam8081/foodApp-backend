package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Products;
import com.cl.food_app.repositories.ProductsRepository;

@Repository
public class ProductDao {

	@Autowired
	ProductsRepository productsRepository;
	
	//save
	public Products saveProducts(Products products) {
		return productsRepository.save(products);
	}
	
	//getby
	public Optional<Products> getby(int id){
		return productsRepository.findById(id);
	}
	
	//delete
	public Products delete(int id) {
		Products products=getby(id).get();
		productsRepository.delete(products);
		return products;
	}
	
	//update
	public Products update(Products products, int id) {
		products.setId(id);
		return productsRepository.save(products);
	}
	
	//getall
	public List<Products> getall(){
		return productsRepository.findAll();
	}
	
}
