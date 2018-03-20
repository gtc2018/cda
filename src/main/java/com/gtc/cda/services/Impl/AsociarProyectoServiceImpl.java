package com.gtc.cda.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.AsociarProyectoRepository;
import com.gtc.cda.models.AsociarProyecto;
import com.gtc.cda.services.AsociarProyectoService;


/**
 * Clase de implementacion de los servicios Asociar Proyectos.
 * @author Dirección Calidad
 *
 */
@Service
public class AsociarProyectoServiceImpl implements AsociarProyectoService {
	
	
	@Autowired
	protected AsociarProyectoRepository asociarProyectoRepository;

	@Override
	public AsociarProyecto save(AsociarProyecto asociarProyecto) {
		// TODO Auto-generated method stub
		return (AsociarProyecto) this.asociarProyectoRepository.save(asociarProyecto);
	}

	

}
