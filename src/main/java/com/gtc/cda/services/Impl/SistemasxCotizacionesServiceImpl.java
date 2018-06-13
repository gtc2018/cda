package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@Override
	public List<SistemasxCotizaciones> findAll() {
		// TODO Auto-generated method stub
		return this.sistemasxCotizacionRepository.findAll();
	}

//	@Override
//	public AsociarProyecto save(AsociarProyecto asociarProyecto) {
//		// TODO Auto-generated method stub
//		return (AsociarProyecto) this.asociarProyectoRepository.save(asociarProyecto);
//	}
//	
//	public Iterable<AsociarProyecto> save(Iterable<AsociarProyecto> asociarProyecto) {
//		// TODO Auto-generated method stub
//		return (Iterable<AsociarProyecto>) this.asociarProyectoRepository.save(asociarProyecto);
//	}
//	
	public void deleteAllByProject(Iterable<SistemasxCotizaciones> sistemasxCotizaciones) {
		// TODO Auto-generated method stub
		this.sistemasxCotizacionRepository.delete(sistemasxCotizaciones);
	}
//	
//	public Iterable<AsociarProyecto> FindForProjectArray(Iterable<AsociarProyecto> asociarProyecto) {
//		// TODO Auto-generated method stub
//		return (Iterable<AsociarProyecto>) this.asociarProyectoRepository.save(asociarProyecto);
//	}

}
