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

import com.cl.food_app.dto.Items;
import com.cl.food_app.service.ItemsService;
import com.cl.food_app.structure.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemsController {
	
	@Autowired
	ItemsService itemsService;
	
	@PostMapping("/additems")
	public ResponseEntity<ResponseStructure<Items>> saveManager(@RequestBody Items items){
		return itemsService.saveitems(items);
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<ResponseStructure<Items>> getby(@PathVariable int id){
		return itemsService.getby(id);
	}
	
	@DeleteMapping("/deleteitems/{id}")
	public ResponseEntity<ResponseStructure<Items>> delete(@PathVariable int id){
		return itemsService.delete(id);
	}
	
	@PutMapping("/edititems/{id}")
	public ResponseEntity<ResponseStructure<Items>> update(@RequestBody Items items,@PathVariable int id){
		return itemsService.update(items,id);
	}
	
	@GetMapping("/getitems")
	public ResponseEntity<ResponseStructure<List<Items>>> getall(){
		return itemsService.getall();
	}

}
