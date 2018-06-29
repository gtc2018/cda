package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.FasesxCotizacion;
import com.gtc.cda.models.FasesxDetalleCotizacion;

public interface FasesxDetalleCotizacionService {
	
	FasesxDetalleCotizacion save(FasesxDetalleCotizacion fasesxDetalleCotizacion);
	
	void delete(Long id);
	
	List<FasesxDetalleCotizacion> findByDetailQuotationId(Long id);
	
	FasesxDetalleCotizacion findOne(Long id);
	
	List<FasesxCotizacion> getAllFasesxCotizacion(Long id);	

}
