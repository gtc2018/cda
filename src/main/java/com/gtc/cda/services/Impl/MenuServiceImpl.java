package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.MenuRepository;
import com.gtc.cda.models.Menu;
import com.gtc.cda.services.MenuService;




@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	protected MenuRepository menuRepository;
	
	@Override
	public Menu save(Menu menu){
		return this.menuRepository.save(menu);
	}

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return this.menuRepository.findAll();
	}

	@Override
	public void deleteMenu(Long id) {
		// TODO Auto-generated method stub
		this.menuRepository.delete(id);
		
	}

}
