package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Cargo;


public interface CargoRepository extends JpaRepository<Cargo, Long> {
	
	
	@SuppressWarnings("unchecked")
	Cargo save(Cargo cargo);

}
