package com.gtc.cda.dao;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.AsociarProyecto;
import com.gtc.cda.models.DetalleCotizacion;


public interface DetalleCotizacionRepository extends JpaRepository<DetalleCotizacion, Long>{
	
	@SuppressWarnings("unchecked")
	DetalleCotizacion save(DetalleCotizacion detalleCotizaciones);
		
		@Query(value = "SELECT * FROM detalle_cotizacion WHERE cotizacion_id = ?1" , nativeQuery = true)
		public List<DetalleCotizacion> findAllForCotizacion(@Param("cotizacionId") Long cotizacionId);

}
