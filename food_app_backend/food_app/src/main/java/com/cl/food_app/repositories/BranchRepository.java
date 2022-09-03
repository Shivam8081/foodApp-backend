package com.cl.food_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
