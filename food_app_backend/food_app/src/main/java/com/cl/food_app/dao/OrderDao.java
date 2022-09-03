package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cl.food_app.dto.Orders;
import com.cl.food_app.repositories.OrdersRepository;

@Service
public class OrderDao {
	
	@Autowired
	OrdersRepository ordersRepository;
	
	//save
		public Orders saveorders(Orders orders) {
			return ordersRepository.save(orders);
		}
		
		//getby
		public Optional<Orders> getby(int id) {
			return ordersRepository.findById(id);
		}
		
		//delete
		public Orders delete(int id) {
			Orders orders=getby(id).get();
			ordersRepository.delete(orders);
			return orders;
		}
		
		//update
		public Orders update(Orders orders, int id) {
			orders.setId(id);
			return ordersRepository.save(orders);
		}
		
		//getall
		public List<Orders> getall(){
			return ordersRepository.findAll();
		}

}
