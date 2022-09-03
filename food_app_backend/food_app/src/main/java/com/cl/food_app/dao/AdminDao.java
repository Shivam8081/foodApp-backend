package com.cl.food_app.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.repositories.AdminRepository;

@Repository
public class AdminDao {
	
	@Autowired
	AdminRepository adminRepository;
	
	//save
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	//getbyid
	public Optional<Admin> getby(int id) {
		return adminRepository.findById(id);
	}
	
	//delete
	public Admin delete(int id) {
		Admin admin=getby(id).get();
		adminRepository.delete(admin);
		return admin;
	}
	
	//update
	public Admin updatAdmin(Admin admin,int id) {
			admin.setId(id);
			return adminRepository.save(admin);
		}
	
	//getall
	public List<Admin> getall(){
		return adminRepository.findAll();
	}
	
	
	//login
	public String getRole(int id) {
		String admin=getby(id).get().getRole();
		return admin;
	}
	
	
	//findby
	public Admin findbyEmailnPassword(Admin admin) throws Exception {
		String email=admin.getEmail();
		String password=admin.getPassword();
		Admin obj=null;
		if(email!=null && password!=null) {
			obj=adminRepository.findByEmailAndPassword(email, password);
		}
		if(obj==null) {
			throw new Exception("invalid");
		}
		return obj;
	}
	
	
}
