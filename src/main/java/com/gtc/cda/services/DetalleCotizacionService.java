package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.DetalleCotizacion;

public interface DetalleCotizacionService {

	DetalleCotizacion save(DetalleCotizacion empleado);

	void deleteDetalleCotizacion(Long id);

	DetalleCotizacion findByDetalleCotizacionId(Long id);
	
	List<DetalleCotizacion> findAllForCotizacion(Long id);

}
