package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.CotizacionRepository;
import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.services.CotizacionService;

@Service
public class CotizacionServiceImpl implements CotizacionService {
	
	
	@Autowired
	protected CotizacionRepository cotizacionRepository;

	@Override
	public Cotizacion save(Cotizacion cotizacion) {
		// TODO Auto-generated method stub
		return this.cotizacionRepository.save(cotizacion);
	}

	@Override
	public List<Cotizacion> findAll() {
		// TODO Auto-generated method stub
		return this.cotizacionRepository.findAll();
	}

	@Override
	public void deleteCotizacion(Long id) {
		// TODO Auto-generated method stub
		this.cotizacionRepository.delete(id);
	}

	@Override
	public Cotizacion findByCotizacionId(Long cotizacionId) {
		// TODO Auto-generated method stub
		return this.cotizacionRepository.findOne(cotizacionId);
	}

	@Override
	public List<Cotizacion> findByProyecto(Long id) {
		// TODO Auto-generated method stub
		
		return this.cotizacionRepository.findByProyecto(id);

	}
	
	@Override
	public String LastConsecutive() {
		// TODO Auto-generated method stub
		
		return this.cotizacionRepository.LastConsecutive();

	}

}
