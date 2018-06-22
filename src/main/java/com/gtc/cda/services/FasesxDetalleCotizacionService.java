package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.FasesxDetalleCotizacion;

public interface FasesxDetalleCotizacionService {
	
	FasesxDetalleCotizacion save(FasesxDetalleCotizacion fasesxDetalleCotizacion);
	
	void delete(Long id);
	
	List<FasesxDetalleCotizacion> findByDetailQuotationId(Long id);

}
