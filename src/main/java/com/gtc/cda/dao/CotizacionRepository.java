package com.gtc.cda.dao;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.models.Cotizacion;


public interface CotizacionRepository extends JpaRepository<Cotizacion, Long>{
	
//	@SuppressWarnings("unchecked")
//	Cotizacion save(Cotizacion cotizaciones);
	
	@Query(value = "SELECT * FROM COTIZACIONES C WHERE proyectos_id = ?1 AND id NOT IN(SELECT cotizaciones_id FROM REQUERIMIENTOS WHERE cotizaciones_id=C.id )" , nativeQuery = true)
	public List<Cotizacion> findByProyecto(@Param("id") Long id);
	
	@Query(value = "SELECT consecutivo FROM COTIZACIONES order by consecutivo desc limit 0,1" , nativeQuery = true)
	public String LastConsecutive();

}
