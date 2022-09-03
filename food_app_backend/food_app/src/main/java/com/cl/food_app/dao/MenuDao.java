package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Menu;
import com.cl.food_app.repositories.MenuRepository;

@Repository
public class MenuDao {
	
	@Autowired
	MenuRepository menuRepository;
	
	//save
	public Menu saveMenu(Menu menu) {
		return menuRepository.save(menu);
	}
	
	//getby
	public Optional<Menu> getby(int id) {
		return menuRepository.findById(id);
	}
	
	//delete
	public Menu delete(int id) {
		Menu menu=getby(id).get();
		menuRepository.delete(menu);
		return menu;
	}
	
	//update
	public Menu update(Menu menu, int id) {
		menu.setId(id);
		return menuRepository.save(menu);
	}
	
	//getall
	public List<Menu> getall(){
		return menuRepository.findAll();
	}
}
