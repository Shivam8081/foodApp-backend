package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.Exceptions.IDnotFound;
import com.cl.food_app.dao.StaffDao;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Staff;
import com.cl.food_app.structure.ResponseStructure;
import com.cl.food_app.util.Encryp;

@Service
public class StaffServices {

	@Autowired
	StaffDao staffDao;
	
	@Autowired
	Encryp encryp;

	// save
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff) {
		staff.setPassword(Encryp.encrypt(staff.getPassword(),"any"));
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Saved successfully");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(staffDao.saveStaff(staff));
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.CREATED);
	}

	// getby
	public ResponseEntity<ResponseStructure<Staff>> getby(int id) {
		Optional<Staff> staff = staffDao.getby(id);
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		if (staff.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(staff.get());
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.OK);
		}
	}

	// delete
	public ResponseEntity<ResponseStructure<Staff>> delete(int id) {
		Optional<Staff> staff = staffDao.getby(id);
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		if (staff.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("Deleted");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(staffDao.delete(id));
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.OK);
		}
	}

	// update
	public ResponseEntity<ResponseStructure<Staff>> update(Staff staff, int id) {
		staff.setPassword(Encryp.encrypt(staff.getPassword(),"any"));
		Optional<Staff> staff2 = staffDao.getby(id);
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		if (staff2.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("updated");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(staffDao.update(staff, id));
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.OK);
		}
	}

	// getall
	public ResponseEntity<ResponseStructure<List<Staff>>> getall() {
		ResponseStructure<List<Staff>> responseStructure = new ResponseStructure<List<Staff>>();
		responseStructure.setMessage("Found all");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(staffDao.getall());
		return new ResponseEntity<ResponseStructure<List<Staff>>>(responseStructure, HttpStatus.OK);
	}
	
	//getbyEmail
	public Staff findbyEmailnPassword(Staff staff) throws Exception {
		return staffDao.findbyEmailnPassword(staff);
	}
}
