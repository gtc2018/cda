package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Item;

public interface ItemService {

	Item save(Item item);

	List<Item> findAll();

	void deleteItem(Long id);

}
