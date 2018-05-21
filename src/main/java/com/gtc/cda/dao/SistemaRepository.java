package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Sistema;


public interface SistemaRepository extends JpaRepository<Sistema, Long> {
	
	
	@SuppressWarnings("unchecked")
	Sistema save(Sistema sistema);

}
