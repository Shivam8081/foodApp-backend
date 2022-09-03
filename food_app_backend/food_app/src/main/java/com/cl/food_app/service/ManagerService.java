package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.Exceptions.IDnotFound;
import com.cl.food_app.dao.ManagerDao;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Manager;
import com.cl.food_app.structure.ResponseStructure;
import com.cl.food_app.util.Encryp;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	Encryp encryp;

	// save
	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		manager.setPassword(Encryp.encrypt(manager.getPassword(),"any"));
		ResponseStructure<Manager> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Saved Successfully");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(managerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.CREATED);
	}

	// getby
	public ResponseEntity<ResponseStructure<Manager>> getby(int id) {
		Optional<Manager> manager = managerDao.getby(id);
		ResponseStructure<Manager> responseStructure = new ResponseStructure<>();
		if (manager.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("Found Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(manager.get());
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		}
	}

	// delete
	public ResponseEntity<ResponseStructure<Manager>> delete(int id) {
		Optional<Manager> manager = managerDao.getby(id);
		ResponseStructure<Manager> responseStructure = new ResponseStructure<>();
		if (manager.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(managerDao.delete(id));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		}
	}

	// update
	public ResponseEntity<ResponseStructure<Manager>> update(Manager manager, int id) {
		manager.setPassword(Encryp.encrypt(manager.getPassword(),"any"));
		Optional<Manager> manager2 = managerDao.getby(id);
		ResponseStructure<Manager> responseStructure = new ResponseStructure<>();
		if (manager2.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("Updated Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(managerDao.update(manager, id));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		}
	}

	// getall
	public ResponseEntity<ResponseStructure<List<Manager>>> getall() {
		ResponseStructure<List<Manager>> responseStructure = new ResponseStructure<List<Manager>>();
		responseStructure.setMessage("Found all");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(managerDao.getall());
		return new ResponseEntity<ResponseStructure<List<Manager>>>(responseStructure, HttpStatus.OK);
	}
	
	public Manager findbyEmailnPassword(Manager manager) throws Exception {
		return managerDao.findByEmailAndPassword(manager);
	}

}
