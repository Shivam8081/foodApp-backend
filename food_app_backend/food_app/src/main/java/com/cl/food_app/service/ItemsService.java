package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.Exceptions.ItemNotFound;
import com.cl.food_app.dao.ItemsDao;
import com.cl.food_app.dao.StaffDao;
import com.cl.food_app.dto.Items;
import com.cl.food_app.structure.ResponseStructure;

@Service
public class ItemsService {

	@Autowired
	ItemsDao itemsDao;

	@Autowired
	StaffDao staffDao;

	// save
	public ResponseEntity<ResponseStructure<Items>> saveitems(Items items) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Saved successfully");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(itemsDao.saveItems(items));
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.CREATED);
	}

	// getby
	public ResponseEntity<ResponseStructure<Items>> getby(int id) {
		Optional<Items> items = itemsDao.getby(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items.isEmpty()) {
			throw new ItemNotFound();

		} else {
			responseStructure.setMessage("Saved successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(items.get());
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
		}
	}

	// delete

	public ResponseEntity<ResponseStructure<Items>> delete(int id) {
		Optional<Items> items = itemsDao.getby(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items.isEmpty()) {
			throw new ItemNotFound();
		} else {
			responseStructure.setMessage("deleted successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(itemsDao.delete(id));
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
		}
	}

	// update
	public ResponseEntity<ResponseStructure<Items>> update(Items items, int id) {
		Optional<Items> items2 = itemsDao.getby(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items2.isEmpty()) {
			throw new ItemNotFound();

		} else {
			responseStructure.setMessage("Updated successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(itemsDao.update(items, id));
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
		}
	}

	// getall
	public ResponseEntity<ResponseStructure<List<Items>>> getall() {
		ResponseStructure<List<Items>> responseStructure = new ResponseStructure<List<Items>>();
		responseStructure.setMessage("Found all");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(itemsDao.getall());
		return new ResponseEntity<ResponseStructure<List<Items>>>(responseStructure, HttpStatus.OK);

	}

}
