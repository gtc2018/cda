package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.FasesxDetalleCotizacionRepository;
import com.gtc.cda.models.FasesxCotizacion;
import com.gtc.cda.models.FasesxDetalleCotizacion;
import com.gtc.cda.services.FasesxDetalleCotizacionService;


@Service
public class FasesxDetalleCotizacionServiceImpl implements FasesxDetalleCotizacionService {
	
	
	@Autowired
	protected FasesxDetalleCotizacionRepository fasesxDetalleCotizacionRepository;

	@Override
	public FasesxDetalleCotizacion save(FasesxDetalleCotizacion fasesxDetalleCotizacion) {
		// TODO Auto-generated method stub
		return this.fasesxDetalleCotizacionRepository.save(fasesxDetalleCotizacion);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		this.fasesxDetalleCotizacionRepository.delete(id);
	}

	@Override
	public List<FasesxDetalleCotizacion> findByDetailQuotationId(Long id) {
		// TODO Auto-generated method stub
		return  this.fasesxDetalleCotizacionRepository.findAllForDetailQuotation(id);
	}
	
	@Override
	public FasesxDetalleCotizacion findOne(Long id) {
		
		return this.fasesxDetalleCotizacionRepository.findOne(id);
		
	}
	
	@Override
	public List<FasesxCotizacion> getAllFasesxCotizacion(Long id) {
		// TODO Auto-generated method stub
		return  this.fasesxDetalleCotizacionRepository.getAllFasesxCotizacion(id);
	}
	

}
