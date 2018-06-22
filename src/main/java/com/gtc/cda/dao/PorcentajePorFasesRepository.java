package com.gtc.cda.dao;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Fase;
import com.gtc.cda.models.PorcentajePorFase;;


public interface PorcentajePorFasesRepository extends JpaRepository<PorcentajePorFase, Long>{
	
	@SuppressWarnings("unchecked")
	PorcentajePorFase save(PorcentajePorFase porcentaje_por_fases);
	
	@Query(value = "SELECT * FROM PORCENTAJE_POR_FASES WHERE clientes_id = ?1" , nativeQuery = true)
	public List<PorcentajePorFase> findByPorcentajePorFaseYEmpresa(@Param("id") Long id);
	
//	@Query(value = "SELECT *"
//			+ " FROM PORCENTAJE_POR_FASES p"
//			+ " LEFT JOIN fasesxdetalle_cotizacion f on p.fases_id = f.fase_id"
//			+ " WHERE f.fase_id is null"
//			+ " AND p.clientes_id = ?1"
//			+ " AND f.detalle_cotizacion_id= ?2" , nativeQuery = true)
//	public List<PorcentajePorFase> findFasesxEmpresaInPorcentajeFases(@Param("id") Long id, @Param("detailId") Long detailId);
	
	@Query(value = "SELECT *"
			+ " FROM PORCENTAJE_POR_FASES p"
			+ " LEFT JOIN fasesxdetalle_cotizacion f"
			+ " on p.fases_id = f.fase_id"
			+ " WHERE f.fase_id is null"
			+ " AND p.clientes_id = ?1"
			+ " UNION"
			+ " SELECT *"
			+ " FROM PORCENTAJE_POR_FASES p"
			+ " RIGHT JOIN fasesxdetalle_cotizacion f"
			+ " ON p.fases_id = f.fase_id"
			+ " WHERE"
			+ " f.detalle_cotizacion_id <> ?2" 
			+ " AND p.clientes_id = ?1" , nativeQuery = true)
	public List<PorcentajePorFase> findFasesxEmpresaInPorcentajeFases(@Param("id") Long id, @Param("detailId") Long detailId);
	
	

}
