package com.gtc.cda.dao;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.PorcentajePorFase;;


public interface PorcentajePorFasesRepository extends JpaRepository<PorcentajePorFase, Long>{
	
	@SuppressWarnings("unchecked")
	PorcentajePorFase save(PorcentajePorFase porcentaje_por_fases);
	
	@Query(value = "SELECT * FROM PORCENTAJE_POR_FASES WHERE clientes_id = ?1" , nativeQuery = true)
	public List<PorcentajePorFase> findByPorcentajePorFaseYEmpresa(@Param("id") Long id);

}
