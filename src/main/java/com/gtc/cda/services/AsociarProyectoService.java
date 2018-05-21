package com.gtc.cda.services;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gtc.cda.models.AsociarProyecto;
import com.gtc.cda.models.Empresa;

public interface AsociarProyectoService {

	AsociarProyecto save(AsociarProyecto asociarProyecto);

	Iterable<AsociarProyecto> save(Iterable<AsociarProyecto> asociarProyecto);

	List<AsociarProyecto> findAllForProject(String proyectoId);
	
	ResponseEntity deleteAllByProject(Iterable<AsociarProyecto> asociarProyecto);
	

}
