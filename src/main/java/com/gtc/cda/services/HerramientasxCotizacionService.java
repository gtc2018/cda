package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.HerramientasxCotizacion;

public interface HerramientasxCotizacionService {

	
	List<HerramientasxCotizacion> findAllForQuotation(int cotizacionId);
	
	Iterable<HerramientasxCotizacion> save(Iterable<HerramientasxCotizacion> herramientasxCotizacion);
	
	void deleteAllByQuotation(Iterable<HerramientasxCotizacion> herramientasxCotizacion);

}
