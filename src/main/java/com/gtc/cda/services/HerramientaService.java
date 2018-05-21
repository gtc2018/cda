package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Herramienta;

public interface HerramientaService {

	Herramienta save(Herramienta herramienta);

	List<Herramienta> findAll();

	void deleteHerramienta(Long id);
	
	Herramienta findByHerramientaId(long herramientaId);

}
