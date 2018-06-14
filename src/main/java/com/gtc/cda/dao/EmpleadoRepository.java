package com.gtc.cda.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	
	@SuppressWarnings("unchecked")
	Empleado save(Empleado empleado);
	
	@Query(value = "SELECT * FROM EMPLEADOS WHERE id = ?1 AND estado = 1" , nativeQuery = true)
	public Empleado findByEmpresaId(@Param("id") Long id);
	
	
	@Query(value = "SELECT * FROM EMPLEADOS WHERE cliente_id = ?1" , nativeQuery = true)
	public List<Empleado> findEmployeesToEnterprise(@Param("empresaId") Long clienteId);
	
	@Query(value = "SELECT * FROM EMPLEADOS E WHERE cliente_id = ?1 AND id NOT IN(SELECT empleados_id FROM INVOLUCRADOS WHERE requerimientos_id = ?2 AND empleados_id = E.id)" , nativeQuery = true)
	public List<Empleado> findEmployeeByRequest(@Param("cliente") Long cliente, @Param("rqm") Long rqm);
	
	@Query(value = "SELECT * FROM empleados WHERE numero_documento = ?2 OR email = ?1" , nativeQuery = true)
	public List<Empleado> findEmployeeForRegistre(@Param("email") String email, @Param("documento") Long documento);

}