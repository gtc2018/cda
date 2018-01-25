package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long>{
	
	@SuppressWarnings("unchecked")
	Menu save(Menu menu);

}
