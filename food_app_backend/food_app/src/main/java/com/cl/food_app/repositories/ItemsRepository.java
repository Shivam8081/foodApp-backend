package com.cl.food_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
