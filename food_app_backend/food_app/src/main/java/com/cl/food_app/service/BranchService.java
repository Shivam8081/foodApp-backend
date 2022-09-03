package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.Exceptions.IDnotFound;
import com.cl.food_app.dao.BranchDao;
import com.cl.food_app.dto.Branch;
import com.cl.food_app.structure.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	// save
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Saved Successfully");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	// getby
	public ResponseEntity<ResponseStructure<Branch>> getby(int id) {
		Optional<Branch> branch = branchDao.getby(id);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		if (branch.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("found successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(branch.get());
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}

	}

	// delete
	public ResponseEntity<ResponseStructure<Branch>> delete(int id) {
		Optional<Branch> branch = branchDao.getby(id);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		if (branch.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("deleted successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(branchDao.delete(id));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}

	}

	// update
	public ResponseEntity<ResponseStructure<Branch>> update(Branch branch, int id) {
		Optional<Branch> branch2 = branchDao.getby(id);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		if (branch2.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("updated successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(branchDao.update(branch, id));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
	}

	// getall
	public ResponseEntity<ResponseStructure<List<Branch>>> getall() {
		ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<List<Branch>>();
		responseStructure.setMessage("found all successfully");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(branchDao.getall());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.OK);
	}

}
