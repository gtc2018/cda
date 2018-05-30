package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Requerimiento;

public interface RequerimientoService {

	Requerimiento save(Requerimiento empleado);

	List<Requerimiento> findAll();

	void deleteRequerimiento(Long id);

	Requerimiento findByRequerimientoId(Long id);
	
	//List<Requerimiento> findByRequerimiento(Long id);
	
	List<Requerimiento> findByDate(Long columna1, Long columna2, String fechaInicio, String fechaFin );

}
