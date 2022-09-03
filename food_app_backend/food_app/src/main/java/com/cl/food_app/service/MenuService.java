package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cl.food_app.Exceptions.MenuNotFound;
import com.cl.food_app.dao.MenuDao;
import com.cl.food_app.dto.Menu;
import com.cl.food_app.structure.ResponseStructure;

@Service
public class MenuService {

	@Autowired
	MenuDao menuDao;

	// save
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Saved Successfully");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(menuDao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
	}

	// getby
	public ResponseEntity<ResponseStructure<Menu>> getby(int id) {
		Optional<Menu> menu = menuDao.getby(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu.isEmpty()) {
			throw new MenuNotFound();
		} else {
			responseStructure.setMessage("Found Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(menu.get());
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		}
	}

	// delete

	public ResponseEntity<ResponseStructure<Menu>> delete(int id) {
		Optional<Menu> menu = menuDao.getby(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu.isEmpty()) {
			throw new MenuNotFound();
		} else {
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(menuDao.delete(id));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		}
	}

	// update
	public ResponseEntity<ResponseStructure<Menu>> update(Menu menu, int id) {
		Optional<Menu> menu2 = menuDao.getby(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu2.isEmpty()) {
			throw new MenuNotFound();
		} else {
			responseStructure.setMessage("Updated Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(menuDao.update(menu, id));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		}
	}

	// getall
	public ResponseEntity<ResponseStructure<List<Menu>>> getall() {
		ResponseStructure<List<Menu>> responseStructure = new ResponseStructure<List<Menu>>();
		responseStructure.setMessage("Found all");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(menuDao.getall());
		return new ResponseEntity<ResponseStructure<List<Menu>>>(responseStructure, HttpStatus.OK);

	}

}
