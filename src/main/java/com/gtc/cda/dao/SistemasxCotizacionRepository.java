package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.AsociarProyecto;
import com.gtc.cda.models.SistemasxCotizaciones;

public interface SistemasxCotizacionRepository extends JpaRepository<SistemasxCotizaciones, Long>{
	
	@Query(value = "SELECT * FROM sistemasxcotizaciones WHERE cotizacion_id = ?1" , nativeQuery = true)
	public List<SistemasxCotizaciones> findAllForQuotation(@Param("quotationId") int quotationId);
	
}
