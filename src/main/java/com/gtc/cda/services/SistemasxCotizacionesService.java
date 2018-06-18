package com.gtc.cda.services;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gtc.cda.models.AsociarProyecto;
import com.gtc.cda.models.SistemasxCotizaciones;

public interface SistemasxCotizacionesService {

//	AsociarProyecto save(AsociarProyecto asociarProyecto);

//	Iterable<AsociarProyecto> save(Iterable<AsociarProyecto> asociarProyecto);

	List<SistemasxCotizaciones> findAll();
	
	List<SistemasxCotizaciones> findAllForQuotation(int cotizacionId);
	
	Iterable<SistemasxCotizaciones> save(Iterable<SistemasxCotizaciones> sistemasxCotizaciones);
	
	void deleteAllByQuotation(Iterable<SistemasxCotizaciones> sistemasxCotizaciones);
	

}
