package com.cl.food_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
