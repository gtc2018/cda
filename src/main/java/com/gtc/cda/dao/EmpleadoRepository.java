package com.gtc.cda.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	
	@SuppressWarnings("unchecked")
	Empleado save(Empleado empleado);
	
	@Query(value = "SELECT * FROM EMPLEADOS WHERE id = ?1 AND estado = 1" , nativeQuery = true)
	public Empleado findByEmpresaId(@Param("id") Long id);

}
