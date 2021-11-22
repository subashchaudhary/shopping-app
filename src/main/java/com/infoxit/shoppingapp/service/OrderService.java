package com.infoxit.shoppingapp.service;

import java.util.List;

import com.infoxit.shoppingapp.entity.OrderDetails;

public interface OrderService {

	
	public OrderDetails orderItems(OrderDetails order) throws Exception;
	
	public List<OrderDetails> getAllOrderDetails(Integer id) throws Exception;
}
