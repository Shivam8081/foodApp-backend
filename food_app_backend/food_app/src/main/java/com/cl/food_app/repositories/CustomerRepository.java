package com.cl.food_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
