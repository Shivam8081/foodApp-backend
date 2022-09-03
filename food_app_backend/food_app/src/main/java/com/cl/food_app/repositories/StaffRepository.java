package com.cl.food_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cl.food_app.dto.Staff;

@RequestMapping
public interface StaffRepository extends JpaRepository<Staff, Integer> {
	public Staff findByEmailAndPassword(String email, String password);
}
