package com.gtc.cda.services.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.ProyectoRepository;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.services.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	
	
	@Autowired
	protected ProyectoRepository proyectoRepository;

	@Override
	public Proyecto save(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return this.proyectoRepository.save(proyecto);
	}

	@Override
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return this.proyectoRepository.findAll();
	}

	@Override
	public void deleteProyecto(Long id) {
		// TODO Auto-generated method stub
		this.proyectoRepository.delete(id);
	}
	
	
	

}
