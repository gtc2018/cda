package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Area;

public interface AreaService {

	Area save(Area cargo);

	List<Area> findAll();

	void deleteArea(Long id);
	
	Area findByAreaId(long areaId);

}

