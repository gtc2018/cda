package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.EpicasxRequerimiento;

public interface EpicasxRequerimientoService {
	
	List<EpicasxRequerimiento> findAllForRequest(int requerimientoId);
	
	Iterable<EpicasxRequerimiento> save(Iterable<EpicasxRequerimiento> epicasxRequerimiento);
	
	void deleteAllByRequest(Iterable<EpicasxRequerimiento> epicasxRequerimiento);

}
