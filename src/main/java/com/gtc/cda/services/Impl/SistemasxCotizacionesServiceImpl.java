package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.SistemasxCotizacionRepository;
import com.gtc.cda.models.SistemasxCotizaciones;
import com.gtc.cda.services.SistemasxCotizacionesService;

/**
 * Clase de implementacion de los servicios sistemas por cotizacion.
 * @author Santiago Carrillo
 *
 */

@Service
public class SistemasxCotizacionesServiceImpl implements SistemasxCotizacionesService {
	
	@Autowired
	protected SistemasxCotizacionRepository sistemasxCotizacionRepository;
	//Para traer todos los registros de determinada cotizacion
	@Override
	public List<SistemasxCotizaciones> findAllForQuotation(int quotationId) {
		// TODO Auto-generated method stub
		return this.sistemasxCotizacionRepository.findAllForQuotation(quotationId);
	}
	
	//Para guardar todos los registros de un array
	public Iterable<SistemasxCotizaciones> save(Iterable<SistemasxCotizaciones> sistemasxCotizaciones) {
		// TODO Auto-generated method stub
		return (Iterable<SistemasxCotizaciones>) this.sistemasxCotizacionRepository.save(sistemasxCotizaciones);
	}
	
	//Para traer todos los registros
	public void deleteAllByQuotation(Iterable<SistemasxCotizaciones> sistemasxCotizaciones) {
		// TODO Auto-generated method stub
		this.sistemasxCotizacionRepository.delete(sistemasxCotizaciones);
	}

}
