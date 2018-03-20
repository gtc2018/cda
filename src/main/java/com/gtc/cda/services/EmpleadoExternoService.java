package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.EmpleadoExterno;


public interface EmpleadoExternoService {

	EmpleadoExterno save(EmpleadoExterno empleadoExterno);

	List<EmpleadoExterno> findAll();

	void deleteEmpleadoExterno(Long id);

	EmpleadoExterno findByEmpleadoId(Long id);

}
