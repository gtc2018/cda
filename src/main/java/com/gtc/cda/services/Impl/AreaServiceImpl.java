package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.AreaRepository;
import com.gtc.cda.models.Area;
import com.gtc.cda.services.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	protected AreaRepository areaRepository;
	
	@Override
	public Area save(Area area) {
		// TODO Auto-generated method stub
		return this.areaRepository.save(area);
	}

	@Override
	public List<Area> findAll() {
		// TODO Auto-generated method stub
		return this.areaRepository.findAll();
	}

	@Override
	public void deleteArea(Long id) {
		// TODO Auto-generated method stub
		this.areaRepository.delete(id);
	}
	
	@Override
	public Area findOne(long areaId) {
		// TODO Auto-generated method stub
		return this.areaRepository.findOne(areaId);
	}

}
