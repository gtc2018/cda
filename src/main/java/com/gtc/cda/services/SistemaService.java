package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Sistema;

public interface SistemaService {

	Sistema save(Sistema sistema);

	List<Sistema> findAll();

	void deleteSistema(Long id);
	
	Sistema findBySistemaId(long sistemaId);

}
