package com.gtc.cda.dao;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Cotizacion;


public interface CotizacionRepository extends JpaRepository<Cotizacion, Long>{
	
//	@SuppressWarnings("unchecked")
//	Cotizacion save(Cotizacion cotizaciones);
	
	@Query(value = "SELECT * FROM COTIZACIONES C WHERE proyectos_id = ?1 AND id NOT IN(SELECT cotizaciones_id FROM  REQUERIMIENTOS WHERE cotizaciones_id=C.id )" , nativeQuery = true)
	public List<Cotizacion> findByProyecto(@Param("id") Long id);

}
