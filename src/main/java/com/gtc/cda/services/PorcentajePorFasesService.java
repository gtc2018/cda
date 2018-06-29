package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Fase;
import com.gtc.cda.models.PorcentajePorFase;;

public interface PorcentajePorFasesService {

	PorcentajePorFase save(PorcentajePorFase empleado);

	List<PorcentajePorFase> findAll();

	void deletePorcentajePorFase(Long id);

	PorcentajePorFase findByPorcentajePorFaseId(Long id);
	
	List<PorcentajePorFase> findByPorcentajePorFaseYEmpresa(Long id);
	
	List<PorcentajePorFase> findFasesxEmpresaInPorcentajeFases(Long id, Long detailId);
	
	void updateTotal(Long id);
	

}
