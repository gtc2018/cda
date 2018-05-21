package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Alcance;


public interface AlcanceRepository extends JpaRepository<Alcance, Long> {
	
	
	@SuppressWarnings("unchecked")
	Alcance save(Alcance alcance);

}
