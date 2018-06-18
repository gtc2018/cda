package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Dane;

public interface DaneService {
	
	List<Dane> findCountry();
	
	List<Dane> findDeparment(long departamento);
	
	List<Dane> findCity(long ciudad);
	

}

