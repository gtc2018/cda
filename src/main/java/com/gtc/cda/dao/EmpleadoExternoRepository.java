package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.EmpleadoExterno;

public interface EmpleadoExternoRepository extends JpaRepository<EmpleadoExterno, Long> {
	
	@SuppressWarnings("unchecked")
	EmpleadoExterno save(EmpleadoExterno empleadoExterno);
	
	/*@Query(value = "SELECT * FROM EMPLEADOS_EXTERNOS WHERE id = ?1 AND estado = 1" , nativeQuery = true)
	public EmpleadoExterno findByEmpresaId(@Param("id") Long id);
	
	
	@Query(value = "SELECT * FROM EMPLEADOS_EXTERNOS WHERE cliente_id = ?1" , nativeQuery = true)
	public List<EmpleadoExterno> findEmployeesToEnterprise(@Param("empresaId") Long clienteId);*/
	

}
