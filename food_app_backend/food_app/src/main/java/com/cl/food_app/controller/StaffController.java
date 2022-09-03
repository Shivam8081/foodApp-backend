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
import com.cl.food_app.dto.Staff;
import com.cl.food_app.service.StaffServices;
import com.cl.food_app.structure.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {
	
	@Autowired
	StaffServices staffServices;
	
	@PostMapping("/savesatff")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ResponseStructure<Staff>> saveManager(@RequestBody Staff staff){
		return staffServices.saveStaff(staff);
	}
	
	@GetMapping("/getstaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getby(@PathVariable int id){
		return staffServices.getby(id);
	}
	
	@DeleteMapping("/deletestaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> delete(@PathVariable int id){
		return staffServices.delete(id);
	}
	
	@PutMapping("/updatestaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> update(@RequestBody Staff staff,@PathVariable int id){
		return staffServices.update(staff,id);
	}
	
	@GetMapping("/getallstaff")
	public ResponseEntity<ResponseStructure<List<Staff>>> getall(){
		return staffServices.getall();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getbystaff")
	public Staff get(@RequestBody Staff staff) throws Exception {
		return staffServices.findbyEmailnPassword(staff);
	}
	

}
