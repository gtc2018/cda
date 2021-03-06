package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Fase;



public interface FaseRepository extends JpaRepository<Fase, Long> {
	
	@SuppressWarnings("unchecked")
	Fase save(Fase fase);
	
	 @Query(value = "SELECT * FROM FASES WHERE id = ?1" , nativeQuery = true)
	 public	 List<Fase> existe(@Param("id") Long id);

	 @Query(value = "SELECT * FROM FASES F WHERE id NOT IN(SELECT fases_id FROM PORCENTAJE_POR_FASES WHERE clientes_id = ?1 AND fases_id = F.id)" , nativeQuery = true)
	public List<Fase> findFaseByEnterprise(@Param("empresa") Long empresa);
}
