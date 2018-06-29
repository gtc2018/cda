package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.FasesxCotizacion;
import com.gtc.cda.models.FasesxDetalleCotizacion;

public interface FasesxDetalleCotizacionRepository extends JpaRepository<FasesxDetalleCotizacion, Long> {
	
	@Query(value = "SELECT * FROM fasesxdetalle_cotizacion WHERE detalle_cotizacion_id = ?1" , nativeQuery = true)
	public List<FasesxDetalleCotizacion> findAllForDetailQuotation(@Param("detalleCotizacion") Long detalleCotizacion);
	
	@Query
	(value = "SELECT f.descripcion, sum(fxd.horas) horas" + 
			" FROM fasesxdetalle_cotizacion fxd" + 
			" INNER JOIN detalle_cotizacion d" + 
			" ON d.id = fxd.detalle_cotizacion_id"+
			" INNER JOIN fases f" + 
			" on fxd.fase_id = f.id" + 
			" WHERE d.cotizacion_id = ?1" + 
			" GROUP by fxd.fase_id" , nativeQuery = true)
	public List<FasesxCotizacion>
	getAllFasesxCotizacion(@Param("id") Long id);

}