package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Items;
import com.cl.food_app.repositories.ItemsRepository;

@Repository
public class ItemsDao {
	
	@Autowired
	ItemsRepository itemsRepository;
	
	
	//save
		public Items saveItems(Items items) {
			return itemsRepository.save(items);
		}
		
		//getby
		public Optional<Items> getby(int id) {
			return itemsRepository.findById(id);
		}
		
		//delete
		public Items delete(int id) {
			Items items=getby(id).get();
			itemsRepository.delete(items);
			return items;
		}
		
		//update
		public Items update(Items items, int id) {
			items.setId(id);
			return itemsRepository.save(items);
		}
		
		//getall
		public List<Items> getall(){
			return itemsRepository.findAll();
		}

}
