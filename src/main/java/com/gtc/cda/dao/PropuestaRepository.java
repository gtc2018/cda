package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Propuesta;


public interface PropuestaRepository extends JpaRepository<Propuesta, Long> {
	
	
	@SuppressWarnings("unchecked")
	Propuesta save(Propuesta propuesta);

	@Query(value = "SELECT * FROM DOCUMENTO_COTIZACION WHERE cotizaciones_id = ?1" , nativeQuery = true)
	public List<Propuesta> findDocumentByQuotation(@Param("id") Long id);
//	
//	@Query(value = "SELECT * FROM IN_HOUSE WHERE desde>= ?1 AND hasta<= ?2" , nativeQuery = true)
//    public List<Propuesta> findInHouseByDate(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);

}
