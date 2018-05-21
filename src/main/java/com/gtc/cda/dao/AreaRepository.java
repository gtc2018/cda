package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Area;


public interface AreaRepository extends JpaRepository<Area, Long> {
	
	
	@SuppressWarnings("unchecked")
	Area save(Area area);
	
	@Query(value = "SELECT * FROM AREAS WHERE cliente_id = ?1" , nativeQuery = true)
	public List<Area> getAllAreasToEnterprise(@Param("empresaId") Long clienteId);

}
