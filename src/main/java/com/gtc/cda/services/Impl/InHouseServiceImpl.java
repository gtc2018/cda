package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.InHouseRepository;
import com.gtc.cda.models.InHouse;
import com.gtc.cda.services.InHouseService;

@Service
public class InHouseServiceImpl implements InHouseService {

	@Autowired
	protected InHouseRepository inHouseRepository;
	
	@Override
	public InHouse save(InHouse inHouse) {
		// TODO Auto-generated method stub
		return this.inHouseRepository.save(inHouse);
	}

	@Override
	public List<InHouse> findAll() {
		// TODO Auto-generated method stub
		return this.inHouseRepository.findAll();
	}

	@Override
	public void deleteInHouse(Long id) {
		// TODO Auto-generated method stub
		this.inHouseRepository.delete(id);
	}
	
	@Override
	public InHouse findByInHouseId(long id) {
		// TODO Auto-generated method stub
		return this.inHouseRepository.findOne(id);
	}
	
	@Override
	public List<InHouse> getInHouseByEmployee(Long id) {
		// TODO Auto-generated method stub
		return this.inHouseRepository.findInHouseByEmployee(id);
	}
	
	@Override
	public List<InHouse> getInHouseByDate(String fecha1, String fecha2) {
		// TODO Auto-generated method stub
		return this.inHouseRepository.findInHouseByDate(fecha1, fecha2);
	}
	
	@Override
	public List<InHouse> getInHouseToDate(String fecha1, String fecha2, Long empleado) {
		// TODO Auto-generated method stub
		return this.inHouseRepository.findInHouseToDate(fecha1, fecha2, empleado);
	}
	
//	@Override
//	public List<Area> getAllAreasToEnterprise(Long empresaId) {
//		// TODO Auto-generated method stub
//		return this.areaRepository.getAllAreasToEnterprise(empresaId);
//	}

}
