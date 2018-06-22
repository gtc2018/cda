package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Epica;
import com.gtc.cda.models.HerramientasxCotizacion;
import com.gtc.cda.models.Requerimiento;


public interface EpicaService {
	
	Epica save(Epica epica);

	List<Epica> findAll();

	void deleteEpica(Long id);
	
	List<Epica> findAllToProject(Long project);
	
	List<Epica> findEpicaToRequest(Long request);
	
}
