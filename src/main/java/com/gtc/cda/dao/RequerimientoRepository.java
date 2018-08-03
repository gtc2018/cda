package com.gtc.cda.dao;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.Requerimiento;

public interface RequerimientoRepository extends JpaRepository<Requerimiento, Long>{

	
		
		@SuppressWarnings("unchecked")
		Requerimiento save(Requerimiento requerimiento);
		

		@Query(value = "SELECT * FROM REQUERIMIENTOS WHERE proyectos_id = ?1" , nativeQuery = true)
		public List<Requerimiento> findRequestToProject(@Param("id") Long project);
		
		@Query(value = "SELECT * FROM REQUERIMIENTOS C WHERE (CASE (?1) WHEN 1 THEN FECHA_INICIO WHEN 2 THEN FECHA_PLAN_ENTREGA WHEN 3 THEN FECHA_ENTREGA END)>= ?3 AND (CASE (?2) WHEN 1 THEN FECHA_INICIO WHEN 2 THEN FECHA_PLAN_ENTREGA WHEN 3 THEN FECHA_ENTREGA END)<= ?4" , nativeQuery = true)
        public List<Requerimiento> findByDate(@Param("columna1") Long columna1, @Param("columna2") Long columna2, @Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin);
		
		@Query(value = "SELECT * FROM requerimientos R where proyectos_id = ?1 AND id in(select requerimientos_id FROM involucrados where empleados_id = ?2 AND requerimientos_id = R.id)" , nativeQuery = true)
        public List<Requerimiento> findRequestByProjectAndEmployee(@Param("project") Long project, @Param("cliente") Long cliente);
		
		@Procedure(procedureName = "SQ_SAVE_EPICASTORQM")
		public void insertEpicasxRQM(@Param("id") Long RQMID);


	}
