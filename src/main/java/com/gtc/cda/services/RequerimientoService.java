package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Requerimiento;

public interface RequerimientoService {

	Requerimiento save(Requerimiento requerimiento);

	List<Requerimiento> findAll();

	void deleteRequerimiento(Long id);

	Requerimiento findByRequerimientoId(Long id);
	

	List<Requerimiento> findRequestToProject(Long project);
	
	List<Requerimiento> findRequestByProjectAndEmployee(Long project, Long cliente);
	
	List<Requerimiento> findByDate(Long columna1, Long columna2, String fechaInicio, String fechaFin );
	
	void insertEpicasxRQM(Long RQMID);


}
