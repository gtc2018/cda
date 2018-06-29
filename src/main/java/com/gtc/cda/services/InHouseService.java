package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.InHouse;


public interface InHouseService {

	InHouse save(InHouse inHouse);

	List<InHouse> findAll();

	void deleteInHouse(Long id);
	
	InHouse findByInHouseId(long id);
	
	List<InHouse> getInHouseByEmployee(Long id);
	
	List<InHouse> getInHouseByDate(String fecha1, String fecha2);
	
	List<InHouse> getInHouseToDate(String fecha1, String fecha2, Long empleado);
	
//	List<InHouse> getAllAreasToEnterprise(Long empresaId);

}

