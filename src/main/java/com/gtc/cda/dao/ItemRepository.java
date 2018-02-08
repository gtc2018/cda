package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {
	
	
	@SuppressWarnings("unchecked")
	Item save(Item item);

}
