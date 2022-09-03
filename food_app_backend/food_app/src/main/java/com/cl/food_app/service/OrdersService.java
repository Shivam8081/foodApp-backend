package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.Exceptions.IDnotFound;
import com.cl.food_app.dao.OrderDao;
import com.cl.food_app.dao.StaffDao;
import com.cl.food_app.dto.Orders;
import com.cl.food_app.structure.ResponseStructure;

@Service

public class OrdersService {

	@Autowired
	OrderDao orderDao;

	@Autowired
	StaffDao staffDao;

	// save
	public ResponseEntity<ResponseStructure<Orders>> saveorders(Orders orders) {
		// orders.setStaff(staffDao.getby(id).get());
		ResponseStructure<Orders> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Saved successfully");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(orderDao.saveorders(orders));
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.CREATED);
	}

	// getby
	public ResponseEntity<ResponseStructure<Orders>> getby(int id) {
		Optional<Orders> orders = orderDao.getby(id);
		ResponseStructure<Orders> responseStructure = new ResponseStructure<>();
		if (orders.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("Found Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(orders.get());
			return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);
		}
	}

	// delete

	public ResponseEntity<ResponseStructure<Orders>> delete(int id) {
		Optional<Orders> orders = orderDao.getby(id);
		ResponseStructure<Orders> responseStructure = new ResponseStructure<>();
		if (orders.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(orderDao.delete(id));
			return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);
		}
	}

	// update
	public ResponseEntity<ResponseStructure<Orders>> update(Orders orders, int id) {
		Optional<Orders> orders2 = orderDao.getby(id);
		ResponseStructure<Orders> responseStructure = new ResponseStructure<>();
		if (orders2.isEmpty()) {
			throw new IDnotFound();
		} else {
			responseStructure.setMessage("Updated Successfully");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(orderDao.update(orders, id));
			return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);
		}
	}

	// getall
	public ResponseEntity<ResponseStructure<List<Orders>>> getall() {
		ResponseStructure<List<Orders>> responseStructure = new ResponseStructure<List<Orders>>();
		responseStructure.setMessage("Found all");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(orderDao.getall());
		return new ResponseEntity<ResponseStructure<List<Orders>>>(responseStructure, HttpStatus.OK);

	}

}
