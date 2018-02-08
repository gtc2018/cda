package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.ItemRepository;
import com.gtc.cda.models.Item;
import com.gtc.cda.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	protected ItemRepository itemRepository;
	
	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return this.itemRepository.save(item);
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return this.itemRepository.findAll();
	}

	@Override
	public void deleteItem(Long id) {
		// TODO Auto-generated method stub
		this.itemRepository.delete(id);
	}

}
