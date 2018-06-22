package com.gtc.cda.services;


import java.util.List;
import com.gtc.cda.models.SistemasxCotizaciones;

public interface SistemasxCotizacionesService {
	
	List<SistemasxCotizaciones> findAllForQuotation(int cotizacionId);
	
	Iterable<SistemasxCotizaciones> save(Iterable<SistemasxCotizaciones> sistemasxCotizaciones);
	
	void deleteAllByQuotation(Iterable<SistemasxCotizaciones> sistemasxCotizaciones);
	

}
