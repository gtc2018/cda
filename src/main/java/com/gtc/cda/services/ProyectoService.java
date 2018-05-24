package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Proyecto;



public interface ProyectoService {

	Proyecto save(Proyecto proyecto);

	List<Proyecto> findAll();

	void deleteProyecto(Long id);
	
	List<Proyecto> findByCliente(Long id);
	


}
