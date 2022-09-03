package com.cl.food_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
