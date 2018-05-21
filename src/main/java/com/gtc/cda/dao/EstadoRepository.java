package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Estado;


public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	
	@SuppressWarnings("unchecked")
	Estado save(Estado estado);

}
