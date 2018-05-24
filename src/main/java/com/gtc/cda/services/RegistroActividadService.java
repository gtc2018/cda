package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.RegistroActividad;

public interface RegistroActividadService {

	RegistroActividad save(RegistroActividad registroActividad);

	List<RegistroActividad> findAll();

	void deleteRegistroActividad(Long id);
	
	RegistroActividad findByRegistroActividadId(long registroActividadId);
	
	List<RegistroActividad> findRegistreToEmployee(Long empleadoId);
	
	List<RegistroActividad> findRegistreByEmployeeAndDate(Long empleadoId, String fechaTrabajo);

}
