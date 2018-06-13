package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.RegistroActividadRepository;
import com.gtc.cda.models.RegistroActividad;
import com.gtc.cda.services.RegistroActividadService;

@Service
public class RegistroActividadServiceImpl implements RegistroActividadService {

	@Autowired
	protected RegistroActividadRepository registroActividadRepository;
	
	@Override
	public RegistroActividad save(RegistroActividad registroActividad) {
		// TODO Auto-generated method stub
		return this.registroActividadRepository.save(registroActividad);
	}

	@Override
	public List<RegistroActividad> findAll() {
		// TODO Auto-generated method stub
		return this.registroActividadRepository.findAll();
	}

	@Override
	public void deleteRegistroActividad(Long id) {
		// TODO Auto-generated method stub
		this.registroActividadRepository.delete(id);
	}
	
	@Override
	public RegistroActividad findByRegistroActividadId(long registroActividadId) {
		// TODO Auto-generated method stub
		return this.registroActividadRepository.findOne(registroActividadId);
	}
	
	@Override
	public List<RegistroActividad> findRegistreToEmployee(Long empleadoId) {
		// TODO Auto-generated method stub
		return this.registroActividadRepository.findRegistreToEmployee(empleadoId);
	}
	
	@Override
	public List<RegistroActividad> findRegistreByEmployeeAndDate(Long empleadoId, String fechaTrabajo) {
		// TODO Auto-generated method stub
		return this.registroActividadRepository.findRegistreByEmployeeAndDate(empleadoId, fechaTrabajo);
	}

}
