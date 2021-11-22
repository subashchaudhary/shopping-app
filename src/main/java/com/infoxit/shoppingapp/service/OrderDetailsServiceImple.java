package com.infoxit.shoppingapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoxit.shoppingapp.entity.Item;
import com.infoxit.shoppingapp.entity.OrderDetails;
import com.infoxit.shoppingapp.repository.ItemRepository;
import com.infoxit.shoppingapp.repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImple implements OrderService{

	
	@Autowired
	private OrderDetailsRepository orderRepo;
	@Autowired
	ItemRepository itemRepo;
	
	@Override
	public OrderDetails orderItems(OrderDetails order) throws Exception {
		
		Integer itemId = order.getItemId();
		
		Optional<Item> item = itemRepo.findById(itemId);
		if(item.get() == null) return null;
		
		order.setItemName(item.get().getItemName());
		order.setOrderDate(new Date());
	
		return orderRepo.save(order);
	}

	@Override
	public List<OrderDetails> getAllOrderDetails(Integer id) throws Exception {
		 
		return orderRepo.findByOrderBy(id);
	}

	
	
}
