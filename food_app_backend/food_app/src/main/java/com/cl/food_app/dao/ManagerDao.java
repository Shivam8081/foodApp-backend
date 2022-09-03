package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Branch;
import com.cl.food_app.dto.Manager;
import com.cl.food_app.repositories.ManagerRepository;

@Repository
public class ManagerDao {
	
	@Autowired
	ManagerRepository managerRepository;
	
	//save
	public Manager saveManager(Manager manager) {
		return managerRepository.save(manager);
	}
	
	//getby
	public Optional<Manager> getby(int id){
		return managerRepository.findById(id);
	}
	
	//delete
	public Manager delete(int id) {
		Manager manager=getby(id).get();
		managerRepository.delete(manager);
		return manager;
	}
	
	//update
	public Manager update(Manager manager, int id) {
		manager.setId(id);
		return managerRepository.save(manager);
	}
	
	//getall
	public List<Manager> getall(){
		return managerRepository.findAll();
	}
	
	//findbymail
	public Manager findByEmailAndPassword(Manager manager) throws Exception {
		String email=manager.getEmail();
		String password=manager.getPassword();
		Manager obj=null;
		if(email!=null && password!=null) {
			obj=managerRepository.findByEmailAndPassword(email, password);
		}
		if(obj==null) {
			throw new Exception("invalid");
		}
		return obj;
	}
	
}
