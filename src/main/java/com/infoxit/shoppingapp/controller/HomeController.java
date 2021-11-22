package com.infoxit.shoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infoxit.shoppingapp.dto.Response;
import com.infoxit.shoppingapp.entity.Item;
import com.infoxit.shoppingapp.service.ItemService;

@RestController
public class HomeController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/")
	public Response allItems(){
		Response response = new Response();
		
		try {
			List<Item> items = itemService.getAllItems();
			if(items.size() > 0) {
				response.setMessage("Item present");
				response.setData(items);
				response.setStatus(true);
				
			}else {
				response.setMessage("No Item found.");
				response.setStatus(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return response;
	}
	
	@GetMapping("/item")
	public Response allItems(@RequestParam String productName){
		Response response = new Response();
		
		try {
			Item item = itemService.getSigleItemByName(productName);
			if(item != null) {
				response.setMessage("Item present");
				response.setData(item);
				response.setStatus(true);
				
			}else {
				response.setMessage("No Item found.");
				response.setStatus(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return response;
	}
	
	
	
	
	
}
