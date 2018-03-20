package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.EmpleadoRepository;
import com.gtc.cda.models.Empleado;
import com.gtc.cda.services.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	
	@Autowired
	protected EmpleadoRepository empleadoRepository;

	@Override
	public Empleado save(Empleado empleado) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.save(empleado);
	}

	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return this.empleadoRepository.findAll();
	}

	@Override
	public void deleteEmpleado(Long id) {
		// TODO Auto-generated method stub
		this.empleadoRepository.delete(id);
	}

	@Override
	public Empleado findByEmpleadoId(Long empleadoId) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.findOne(empleadoId);
	}

}
