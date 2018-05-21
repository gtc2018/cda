package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Herramienta;


public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {
	
	
	@SuppressWarnings("unchecked")
	Herramienta save(Herramienta herramienta);

}
