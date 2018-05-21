package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Alcance;

public interface AlcanceService {

	Alcance save(Alcance alcance);

	List<Alcance> findAll();

	void deleteAlcance(Long id);
	
	Alcance findByAlcanceId(long alcanceId);

}
