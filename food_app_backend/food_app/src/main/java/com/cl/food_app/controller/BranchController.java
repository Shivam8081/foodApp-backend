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

import com.cl.food_app.dto.Branch;
import com.cl.food_app.service.BranchService;
import com.cl.food_app.structure.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	
	@GetMapping("/branch/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ResponseStructure<Branch>> getby(@PathVariable int id) {
		return branchService.getby(id);
	}
	
	@DeleteMapping("/deletebranch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> delete(@PathVariable int id) {
		return branchService.delete(id);
	}
	
	@PutMapping("/updatebranch/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ResponseStructure<Branch>> update(@RequestBody Branch branch, @PathVariable int id) {
		return branchService.update(branch,id);
	}
	
	@GetMapping("/getallbranch")
	public ResponseEntity<ResponseStructure<List<Branch>>> getall() {
		return branchService.getall();
	}

}
