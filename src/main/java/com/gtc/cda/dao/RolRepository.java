package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
	
	@SuppressWarnings("unchecked")
	Rol save(Rol rol);

}
