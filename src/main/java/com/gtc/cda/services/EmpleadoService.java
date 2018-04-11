package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Empleado;

public interface EmpleadoService {

	Empleado save(Empleado empleado);

	List<Empleado> findAll();

	void deleteEmpleado(Long id);

	Empleado findByEmpleadoId(Long id);
	
	Empleado getOne(Long id);
	
	List<Empleado> findEmployeesToEnterprise(Long empresaId);

}