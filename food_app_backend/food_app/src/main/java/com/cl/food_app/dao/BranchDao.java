package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Branch;
import com.cl.food_app.repositories.BranchRepository;

@Repository
public class BranchDao {
	
	@Autowired
	BranchRepository branchRepository;
	
	//save
	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}
	
	//getby
	public Optional<Branch> getby(int id) {
		return branchRepository.findById(id);
	}
	
	//delete
	public Branch delete(int id) {
		Branch branch=getby(id).get();
		branchRepository.delete(branch);
		return branch;
	}
	
	//update
	public Branch update(Branch branch,int id) {
		branch.setId(id);
		return branchRepository.save(branch);
	}
	//getall
	public List<Branch> getall() {
		// TODO Auto-generated method stub
		return branchRepository.findAll();
	}
}
