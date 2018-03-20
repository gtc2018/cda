package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.EmpleadoExternoRepository;
import com.gtc.cda.models.EmpleadoExterno;
import com.gtc.cda.services.EmpleadoExternoService;

@Service
public class EmpleadoExternoServiceImpl implements EmpleadoExternoService {
	
	@Autowired
	protected EmpleadoExternoRepository empleadoExternoRepository;

	@Override
	public EmpleadoExterno save(EmpleadoExterno empleadoExterno) {
		// TODO Auto-generated method stub
		return this.empleadoExternoRepository.save(empleadoExterno);
	}

	@Override
	public List<EmpleadoExterno> findAll() {
		// TODO Auto-generated method stub
		return this.empleadoExternoRepository.findAll();
	}

	@Override
	public void deleteEmpleadoExterno(Long id) {
		// TODO Auto-generated method stub
		this.empleadoExternoRepository.delete(id);
	}

	@Override
	public EmpleadoExterno findByEmpleadoId(Long id) {
		// TODO Auto-generated method stub
		return this.empleadoExternoRepository.findOne(id);
	}

}
