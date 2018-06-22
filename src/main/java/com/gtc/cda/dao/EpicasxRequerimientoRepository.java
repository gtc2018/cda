package com.gtc.cda.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.EpicasxRequerimiento;


public interface EpicasxRequerimientoRepository extends JpaRepository<EpicasxRequerimiento, Long> {

	@Query(value = "SELECT * FROM epicasxrequerimientos WHERE requerimientos_id = ?1" , nativeQuery = true)
	public List<EpicasxRequerimiento> findAllForRequest(@Param("requestId") int requestId);

}
