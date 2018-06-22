package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Propuesta;


public interface PropuestaService {

	Propuesta save(Propuesta inHouse);

	List<Propuesta> findAll();

	void deletePropuesta(Long id);
	
	Propuesta findByPropuestaId(long id);
	
	List<Propuesta> getDocumentByQuotation(Long id);

}

