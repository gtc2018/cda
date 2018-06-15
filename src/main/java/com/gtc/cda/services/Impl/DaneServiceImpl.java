package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.DaneRepository;
import com.gtc.cda.models.Dane;
import com.gtc.cda.services.DaneService;


@Service
public class DaneServiceImpl implements DaneService {

	@Autowired
	protected DaneRepository daneRepository;
	

	@Override
	public List<Dane> findCountry() {
		// TODO Auto-generated method stub
		return this.daneRepository.findCountry();
	}
	
	@Override
	public List<Dane> findDeparment(long departamento) {
		// TODO Auto-generated method stub
		return this.daneRepository.findDeparment(departamento);
	}
	
	@Override
	public List<Dane> findCity(long ciudad) {
		// TODO Auto-generated method stub
		return this.daneRepository.findCity(ciudad);
	}
	

}
