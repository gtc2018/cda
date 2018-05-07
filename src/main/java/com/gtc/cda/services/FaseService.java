package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Fase;



public interface FaseService {

	Fase save(Fase fase);

	List<Fase> findAll();

	void deleteFase(Long id);
	
	public List<Fase> existe(Long id);
	

}
