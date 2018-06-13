package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.gtc.cda.models.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
	
	
	@SuppressWarnings("unchecked")
	Proyecto save(Proyecto proyecto);
	
	@Query(value = "SELECT * FROM PROYECTOS WHERE cliente_id = ?1" , nativeQuery = true)
	public List<Proyecto> findByCliente(@Param("id") Long id);
	
	

}