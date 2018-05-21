package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Estado;

public interface EstadoService {

	Estado save(Estado estado);

	List<Estado> findAll();

	void deleteEstado(Long id);
	
	Estado findByEstadoId(long estadoId);

}
