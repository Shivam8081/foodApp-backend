package com.cl.food_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
	public Manager findByEmailAndPassword(String email, String password);
}
