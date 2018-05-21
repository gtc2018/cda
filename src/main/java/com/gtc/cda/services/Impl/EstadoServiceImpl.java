package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.EstadoRepository;
import com.gtc.cda.models.Estado;
import com.gtc.cda.services.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	protected EstadoRepository estadoRepository;
	
	@Override
	public Estado save(Estado estado) {
		// TODO Auto-generated method stub
		return this.estadoRepository.save(estado);
	}

	@Override
	public List<Estado> findAll() {
		// TODO Auto-generated method stub
		return this.estadoRepository.findAll();
	}

	@Override
	public void deleteEstado(Long id) {
		// TODO Auto-generated method stub
		this.estadoRepository.delete(id);
	}
	
	@Override
	public Estado findByEstadoId(long estadoId) {
		// TODO Auto-generated method stub
		return this.estadoRepository.findOne(estadoId);
	}

}
