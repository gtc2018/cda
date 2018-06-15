package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.HerramientasxCotizacion;
import com.gtc.cda.models.SistemasxCotizaciones;

public interface HerramientasxCotizacionService {

	
	List<HerramientasxCotizacion> findAllForQuotation(int cotizacionId);
	
	Iterable<HerramientasxCotizacion> save(Iterable<HerramientasxCotizacion> herramientasxCotizacion);
	
	void deleteAllByQuotation(Iterable<HerramientasxCotizacion> herramientasxCotizacion);

}
