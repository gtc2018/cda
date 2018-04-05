package com.gtc.cda.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.Usuario;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	
	@SuppressWarnings("unchecked")
	Empleado save(Empleado empleado);
	
	@Query(value = "SELECT * FROM EMPLEADOS WHERE id = ?1 AND estado = 1" , nativeQuery = true)
	public Empleado findByEmpresaId(@Param("id") Long id);
	
	
	@Query(value = "SELECT * FROM EMPLEADOS WHERE cliente_id = ?1" , nativeQuery = true)
	public List<Empleado> findEmployeesToEnterprise(@Param("empresaId") Long clienteId);

}