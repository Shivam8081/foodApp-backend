package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Staff;
import com.cl.food_app.repositories.StaffRepository;

@Repository
public class StaffDao {
	
	@Autowired
	StaffRepository staffRepository;
	
	//save 
	public Staff saveStaff(Staff staff) {
		return staffRepository.save(staff);
	}
	
	//getby
	public Optional<Staff> getby(int id){
		return staffRepository.findById(id);
	}
	
	//delete
	public Staff delete(int id) {
		Staff staff=getby(id).get();
		staffRepository.delete(staff);
		return staff;
	}
	
	//update
	public Staff update(Staff staff,int id) {
		staff.setId(id);
		return staffRepository.save(staff);
	}
	
	//getall
	public List<Staff> getall(){
		return staffRepository.findAll();
	}
	
	//getbyemail
	public Staff findbyEmailnPassword(Staff staff) throws Exception {
		String email=staff.getEmail();
		String password=staff.getPassword();
		Staff obj=null;
		if(email!=null && password!=null) {
			obj=staffRepository.findByEmailAndPassword(email, password);
		}
		if(obj==null) {
			throw new Exception("invalid");
		}
		return obj;
	}
	
		
}
