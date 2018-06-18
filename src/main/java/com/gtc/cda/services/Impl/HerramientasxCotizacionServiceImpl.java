package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.HerramientasxCotizacionRepository;
import com.gtc.cda.models.HerramientasxCotizacion;
import com.gtc.cda.services.HerramientasxCotizacionService;

/**
 * Clase de implementacion de los servicios sistemas por cotizacion.
 * @author Santiago Carrillo
 *
 */

@Service
public class HerramientasxCotizacionServiceImpl implements HerramientasxCotizacionService {
	
	@Autowired
	protected HerramientasxCotizacionRepository herramientasxCotizacionRepository;

	
	//Para traer todos los registros de determinada cotizacion
	@Override
	public List<HerramientasxCotizacion> findAllForQuotation(int quotationId) {
		// TODO Auto-generated method stub
		return this.herramientasxCotizacionRepository.findAllForQuotation(quotationId);
	}
	
	//Para guardar todos los registros de un array
	public Iterable<HerramientasxCotizacion> save(Iterable<HerramientasxCotizacion> sistemasxCotizaciones) {
		// TODO Auto-generated method stub
		return (Iterable<HerramientasxCotizacion>) this.herramientasxCotizacionRepository.save(sistemasxCotizaciones);
	}
	
	//Para traer todos los registros
	public void deleteAllByQuotation(Iterable<HerramientasxCotizacion> herramientasxCotizacion) {
		// TODO Auto-generated method stub
		this.herramientasxCotizacionRepository.delete(herramientasxCotizacion);
	}

}
