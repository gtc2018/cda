package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.EmpleadoRepository;
import com.gtc.cda.models.Cotizacion;
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
	
	public Empleado getOne(Long id) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.getOne(id);
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
	
	@Override
	public List<Empleado> findEmployeesToEnterprise(Long empresaId) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.findEmployeesToEnterprise(empresaId);
	}
	
	@Override
	public List<Empleado> findEmployeeByRequest(Long cliente, Long rqm) {
		// TODO Auto-generated method stub
		
		return this.empleadoRepository.findEmployeeByRequest(cliente, rqm);

	}
	
	@Override
	public List<Empleado> findEmployeeForRegistre(String email, Long documento) {
		// TODO Auto-generated method stub
		
		return this.empleadoRepository.findEmployeeForRegistre(email, documento);

	}

}