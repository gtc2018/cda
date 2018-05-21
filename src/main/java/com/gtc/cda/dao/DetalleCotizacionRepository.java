package com.gtc.cda.dao;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.DetalleCotizacion;


public interface DetalleCotizacionRepository extends JpaRepository<DetalleCotizacion, Long>{
	
	@SuppressWarnings("unchecked")
	DetalleCotizacion save(DetalleCotizacion detalleCotizaciones);

}