package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
	
	
	@SuppressWarnings("unchecked")
	Proyecto save(Proyecto proyecto);
	
	

}
