package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Requerimiento;

public interface RequerimientoService {

	Requerimiento save(Requerimiento empleado);

	List<Requerimiento> findAll();

	void deleteRequerimiento(Long id);

	Requerimiento findByRequerimientoId(Long id);
	

	List<Requerimiento> findRequestToProject(Long project);


}
