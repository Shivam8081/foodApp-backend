package com.cl.food_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dto.Products;
import com.cl.food_app.service.ProductsService;
import com.cl.food_app.structure.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductsControler {
	
	@Autowired
	ProductsService productsService;
	
	@PostMapping("/addproducts")
	public ResponseEntity<ResponseStructure<Products>> saveManager(@RequestBody Products products){
		return productsService.saveProducts(products);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Products>> getby(@PathVariable int id){
		return productsService.getby(id);
	}
	
	@DeleteMapping("/deleteproducts/{id}")
	public ResponseEntity<ResponseStructure<Products>> delete(@PathVariable int id){
		return productsService.delete(id);
	}
	
	@PutMapping("/editproducts/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ResponseStructure<Products>> update(@RequestBody Products products,@PathVariable int id){
		return productsService.update(products, id);
	}
	
	@GetMapping("/products")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ResponseStructure<List<Products>>> getall(){
		return productsService.getall();
	}

}
