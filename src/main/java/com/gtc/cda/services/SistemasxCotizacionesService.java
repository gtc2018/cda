package com.gtc.cda.services;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gtc.cda.models.SistemasxCotizaciones;

public interface SistemasxCotizacionesService {

//	AsociarProyecto save(AsociarProyecto asociarProyecto);

//	Iterable<AsociarProyecto> save(Iterable<AsociarProyecto> asociarProyecto);

	List<SistemasxCotizaciones> findAll();
	
//	ResponseEntity deleteAllByProject(Iterable<AsociarProyecto> asociarProyecto);
	

}
