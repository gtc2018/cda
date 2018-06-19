package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Epica;
import com.gtc.cda.models.Requerimiento;

public interface EpicaRepository extends JpaRepository<Epica, Long>{
	
	@SuppressWarnings("unchecked")
	Epica save(Epica Epica);

	@Query(value = "SELECT 	* FROM 	EPICAS WHERE 	proyectos_id = ?1 " , nativeQuery = true)
	public List<Epica> findAllToProject(@Param("id") Long project);

}
