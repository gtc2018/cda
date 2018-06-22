package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.gtc.cda.models.HerramientasxCotizacion;

public interface HerramientasxCotizacionRepository extends JpaRepository<HerramientasxCotizacion, Long>{
	
	@Query(value = "SELECT * FROM herramientasxcotizaciones WHERE cotizacion_id = ?1" , nativeQuery = true)
	public List<HerramientasxCotizacion> findAllForQuotation(@Param("quotationId") int quotationId);
	
}
 