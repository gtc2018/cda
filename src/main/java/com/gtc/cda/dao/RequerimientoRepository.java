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
		

		@Query(value = "SELECT * FROM REQUERIMIENTOS WHERE proyectos_id = ?1" , nativeQuery = true)
		public List<Requerimiento> findRequestToProject(@Param("id") Long project);


	}
