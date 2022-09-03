package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.Exceptions.IDnotFound;
import com.cl.food_app.dao.AdminDao;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Customer;
import com.cl.food_app.structure.ResponseStructure;
import com.cl.food_app.util.Encryp;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

	@Autowired
	Encryp encryp;

	// save
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		admin.setPassword(Encryp.encrypt(admin.getPassword(),"any"));
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Saved Successfully");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(adminDao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.CREATED);
	}

	// update
	public ResponseEntity<ResponseStructure<Admin>> updateadmin(Admin admin, int id) {
		admin.setPassword(Encryp.encrypt(admin.getPassword(),"any"));
		Optional<Admin> optional = adminDao.getby(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("updated successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(adminDao.updatAdmin(admin, id));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		}
	}

	// getbyid
	public ResponseEntity<ResponseStructure<Admin>> getby(int id) {
		Optional<Admin> optional = adminDao.getby(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("found successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);

		}

	}

	// delete
	public ResponseEntity<ResponseStructure<Admin>> delete(int id) {
		Optional<Admin> optional = adminDao.getby(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("deleted successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(adminDao.delete(id));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		}
	}

	// getall
	public ResponseEntity<ResponseStructure<List<Admin>>> getall() {
		ResponseStructure<List<Admin>> responseStructure = new ResponseStructure<List<Admin>>();
		responseStructure.setMessage("found all successfully");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(adminDao.getall());

		return new ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure, HttpStatus.OK);
	}
	
	//getRole
	
	public String getRole(int id) {
		Optional<Admin> optional=adminDao.getby(id);
		if(optional.isEmpty()) {
			throw new IDnotFound();
		}
		else {
			return optional.get().getRole();
		}
	}
	
	
	public Admin findbyEmailnPassword(Admin admin) throws Exception {
		return adminDao.findbyEmailnPassword(admin);
	}

}
