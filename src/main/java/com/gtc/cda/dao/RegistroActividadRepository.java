package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.RegistroActividad;


public interface RegistroActividadRepository extends JpaRepository<RegistroActividad, Long> {
	
	
	@SuppressWarnings("unchecked")
	RegistroActividad save(RegistroActividad registroActividad);
	
	@Query(value = "SELECT * FROM REGISTRO_ACTIVIDADES WHERE empleados_id = ?1" , nativeQuery = true)
	public List<RegistroActividad> findRegistreToEmployee(@Param("empleadoId") Long empleadoId);
	
	@Query(value = "SELECT * FROM REGISTRO_ACTIVIDADES WHERE empleados_id = ?1 AND fecha_trabajo = ?2" , nativeQuery = true)
	public List<RegistroActividad> findRegistreByEmployeeAndDate(@Param("empleadoId") Long empleadoId, @Param("fechaTrabajo") String fechaTrabajo);

}
