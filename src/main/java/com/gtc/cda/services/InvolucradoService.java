package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Involucrado;

public interface InvolucradoService {

	Involucrado save(Involucrado involucrado);

	List<Involucrado> findAll();

	void deleteInvolucrado(Long id);

	Involucrado findByInvolucradoId(Long id);
	
	List<Involucrado> findInvolvedByRequest(Long id);

}
