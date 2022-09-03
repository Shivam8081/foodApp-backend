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

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Manager;
import com.cl.food_app.service.ManagerService;
import com.cl.food_app.structure.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerControoler {
	
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/savemanager")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager){
		return managerService.saveManager(manager);
	}
	
	@GetMapping("/manager/{id}")
	public ResponseEntity<ResponseStructure<Manager>> getby(@PathVariable int id){
		return managerService.getby(id);
	}
	
	@DeleteMapping("/manager/{id}")
	public ResponseEntity<ResponseStructure<Manager>> delete(@PathVariable int id){
		return managerService.delete(id);
	}
	
	@PutMapping("/manager/{id}")
	public ResponseEntity<ResponseStructure<Manager>> update(@RequestBody Manager manager,@PathVariable int id){
		return managerService.update(manager,id);
	}
	
	@GetMapping("/manager")
	public ResponseEntity<ResponseStructure<List<Manager>>> getall(){
		return managerService.getall();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getbymanager")
	public Manager get(@RequestBody Manager manager) throws Exception {
		return managerService.findbyEmailnPassword(manager);
	}
}
