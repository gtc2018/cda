package com.gtc.cda.dao;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.Requerimiento;

public interface RequerimientoRepository extends JpaRepository<Requerimiento, Long>{

	
		
		@SuppressWarnings("unchecked")
		Requerimiento save(Requerimiento requerimiento);
		
		//
		//@Query(value = " call cda.getMenuSession(:rol)" , nativeQuery = true)
		// @Query(value = "SELECT * FROM PERMISOS WHERE rol_id = ?1 AND estado = 1" , nativeQuery = true)
		//@Procedure(name = "getMenuSession")
		//public List<Permiso> findByRolId(@Param("rol") String rolId);
		//public List<Permiso> findByRolId(String rolId);
		 
		 //@Query(value = "SELECT * FROM PERMISOS WHERE rol_id = ?1 AND menu_id = ?2" , nativeQuery = true)
		 //public	 List<Permiso> existe(@Param("rol") String rolId, @Param("menu") String menuId);
		
		
		
		@Query(value = "SELECT * FROM REQUERIMIENTOS C WHERE (CASE (?1) WHEN 1 THEN FECHA_INICIO WHEN 2 THEN FECHA_PLAN_ENTREGA WHEN 3 THEN FECHA_ENTREGA END)>= '?3' AND (CASE (?2) WHEN 1 THEN FECHA_INICIO WHEN 2 THEN FECHA_PLAN_ENTREGA WHEN 3 THEN FECHA_ENTREGA END)<= '?4'" , nativeQuery = true)
		public List<Requerimiento> findByDate(@Param("columna1") Long columna1, @Param("columna2") Long columna2, @Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin);

	}
