package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Menu;

public interface MenuService {

	Menu save(Menu menu);

	List<Menu> findAll();

	void deleteMenu(Long id);

}
