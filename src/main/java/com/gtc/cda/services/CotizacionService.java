package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.Proyecto;

public interface CotizacionService {

	Cotizacion save(Cotizacion empleado);

	List<Cotizacion> findAll();

	void deleteCotizacion(Long id);

	Cotizacion findByCotizacionId(Long id);
	
	//List<Cotizacion> findByCotizacion(Long id);
	
	List<Cotizacion> findByProyecto(Long id);

}
