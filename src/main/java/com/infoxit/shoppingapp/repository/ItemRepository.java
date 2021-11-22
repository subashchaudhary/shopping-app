package com.infoxit.shoppingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infoxit.shoppingapp.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	public Item findByItemName(String itemName);
	
}
