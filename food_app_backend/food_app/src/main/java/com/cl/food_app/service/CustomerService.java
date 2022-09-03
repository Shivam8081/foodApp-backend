package com.cl.food_app.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cl.food_app.Exceptions.IDnotFound;
import com.cl.food_app.dao.CustomerDao;
import com.cl.food_app.dao.ItemsDao;
import com.cl.food_app.dao.OrderDao;
import com.cl.food_app.dto.Customer;
import com.cl.food_app.dto.Orders;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ItemsDao itemsDao;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	
	
	public Customer saveCustomer(Customer customer, int id) {
		customer.setGst(0.18);
		customer.setServiceCost(0.05);
		Optional<Orders> orders2 = orderDao.getby(id);
		if (orders2.isEmpty()) {
			throw new IDnotFound();
		} else {
			double total = orders2.get().getTotal_price();
			customer.setT_cost(total + (total * customer.getGst()) + (total * customer.getServiceCost()));
			return customerDao.saveCustomer(customer);
		}
	
	}
	
	public String sendMessage(Customer customer, int id) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		Optional<Orders> orders3 = orderDao.getby(id);
		if (orders3.isEmpty()) {
			throw new IDnotFound();
		} else {
			//Optional<Items> items=itemsDao.getby(orders3.get().getId());
			customer.setGst(0.18);
			customer.setServiceCost(0.05);
			double total = orders3.get().getTotal_price();
			customer.setT_cost(total + (total * customer.getGst()) + (total * customer.getServiceCost()));
			simpleMailMessage.setFrom("arjunks0721@gmail.com");
			simpleMailMessage.setTo(customer.getEmail());
			simpleMailMessage.setSubject("Your Bill");
			simpleMailMessage.setText("Your order ID is "+orders3.get().getId()+". Your food price is "+orders3.get().getTotal_price()+", GST is 18%, services is 5% and your total cost is "+customer.getT_cost());
			javaMailSender.send(simpleMailMessage);
			
			String message=simpleMailMessage.getText();
			
			return message;
		}
	}

}
