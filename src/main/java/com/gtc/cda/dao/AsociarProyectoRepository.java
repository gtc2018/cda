package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.AsociarProyecto;

public interface AsociarProyectoRepository extends JpaRepository<AsociarProyecto, Long>{
	
	@Query(value = "SELECT * FROM asociar_proyectos WHERE proyecto_id = ?1" , nativeQuery = true)
	public List<AsociarProyecto> findAllForProject(@Param("proyectoId") String proyectoId);

}
