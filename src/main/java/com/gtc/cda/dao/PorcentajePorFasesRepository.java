package com.gtc.cda.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.PorcentajePorFase;;


public interface PorcentajePorFasesRepository extends JpaRepository<PorcentajePorFase, Long>{
	
	@SuppressWarnings("unchecked")
	PorcentajePorFase save(PorcentajePorFase porcentaje_por_fases);
	

}
