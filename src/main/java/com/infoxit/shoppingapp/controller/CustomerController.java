package com.infoxit.shoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infoxit.shoppingapp.dto.LoginDetails;
import com.infoxit.shoppingapp.dto.Response;
import com.infoxit.shoppingapp.entity.Customer;
import com.infoxit.shoppingapp.entity.OrderDetails;
import com.infoxit.shoppingapp.service.CustomerService;
import com.infoxit.shoppingapp.service.OrderService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/register")
	public Response customerRegister(@RequestBody Customer customer) {
		
		Response response = new Response();
		//validate data
		try {
		Customer savedCustomer = customerService.registerCustomer(customer);
			if( savedCustomer != null) {
				response.setData(savedCustomer);
				response.setMessage("User registered success");
				response.setStatus(true);
			}else {
				response.setMessage("User registration failed");
				response.setStatus(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@PostMapping("/login")
	public Response customerLogin(@RequestBody LoginDetails login) {
		
		Response response = new Response();
		
		try {
			
			boolean res = customerService.customerLogin(login);
			if(res) {
				response.setMessage("Login Success");
				response.setStatus(true);
			}else {
				response.setMessage("Invalid Credentials.");
				response.setStatus(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return response;
	}
	
	
	@PostMapping("/order")
	public Response orderItem(@RequestBody OrderDetails order) {
		
		Response response = new Response();
		OrderDetails orderDetails = null;
	
		try {
			orderDetails = orderService.orderItems(order);
			if(order != null) {
				response.setData(orderDetails);
				response.setMessage("Ordered Successfully");
				response.setStatus(true);
			}else {
				response.setMessage("Could not orderd item");
				response.setStatus(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	 
		return response;
	}
	
	
	@GetMapping("/order/{orderBy}")
	public Response getOrder(@PathVariable("orderBy") Integer customerId) {
		Response response = new Response();
		List<OrderDetails> ordersDetails = null;
		try {
		
			ordersDetails = orderService.getAllOrderDetails(customerId);
			if(ordersDetails.size() > 0) {
				response.setData(ordersDetails);
				response.setMessage("Found Data");
				response.setStatus(true);
			}else {
				response.setMessage("No Data Found");
				response.setStatus(false);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
}
