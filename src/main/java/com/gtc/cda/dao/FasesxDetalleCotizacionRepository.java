package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.FasesxDetalleCotizacion;

public interface FasesxDetalleCotizacionRepository extends JpaRepository<FasesxDetalleCotizacion, Long> {
	
	@Query(value = "SELECT * FROM fasesxdetalle_cotizacion WHERE detalle_cotizacion_id = ?1" , nativeQuery = true)
	public List<FasesxDetalleCotizacion> findAllForDetailQuotation(@Param("detalleCotizacion") Long detalleCotizacion);

}
