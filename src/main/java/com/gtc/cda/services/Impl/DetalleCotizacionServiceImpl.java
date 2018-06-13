package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.DetalleCotizacionRepository;
import com.gtc.cda.models.DetalleCotizacion;
import com.gtc.cda.services.DetalleCotizacionService;

@Service
public class DetalleCotizacionServiceImpl implements DetalleCotizacionService {
	
	
	@Autowired
	protected DetalleCotizacionRepository detalleCotizacionRepository;

	@Override
	public DetalleCotizacion save(DetalleCotizacion detalleCotizacion) {
		// TODO Auto-generated method stub
		return this.detalleCotizacionRepository.save(detalleCotizacion);
	}

	@Override
	public List<DetalleCotizacion> findAll() {
		// TODO Auto-generated method stub
		return this.detalleCotizacionRepository.findAll();
	}

	@Override
	public void deleteDetalleCotizacion(Long id) {
		// TODO Auto-generated method stub
		this.detalleCotizacionRepository.delete(id);
	}

	@Override
	public DetalleCotizacion findByDetalleCotizacionId(Long detalleCotizacionId) {
		// TODO Auto-generated method stub
		return this.detalleCotizacionRepository.findOne(detalleCotizacionId);
	}
	
	
	public List<DetalleCotizacion> findAllForCotizacion(Long CotizacionId) {
		// TODO Auto-generated method stub
		return this.detalleCotizacionRepository.findAllForCotizacion(CotizacionId);
	}

}
