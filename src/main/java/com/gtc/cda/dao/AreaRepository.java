package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Area;


public interface AreaRepository extends JpaRepository<Area, Long> {
	
	
	@SuppressWarnings("unchecked")
	Area save(Area area);

}
