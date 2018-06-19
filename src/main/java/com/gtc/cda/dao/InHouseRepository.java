package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.InHouse;


public interface InHouseRepository extends JpaRepository<InHouse, Long> {
	
	
	@SuppressWarnings("unchecked")
	InHouse save(InHouse inHouse);

	@Query(value = "SELECT * FROM IN_HOUSE WHERE empleados_id = ?1" , nativeQuery = true)
	public List<InHouse> findInHouseByEmployee(@Param("id") Long id);

}
