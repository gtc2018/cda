package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Planeacion;

public interface PlaneacionRepository extends JpaRepository<Planeacion, Long>{
	
	@SuppressWarnings("unchecked")
	Planeacion save(Planeacion planeacion);

}
