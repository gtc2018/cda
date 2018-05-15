package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.PorcentajePorFase;;

public interface PorcentajePorFasesService {

	PorcentajePorFase save(PorcentajePorFase empleado);

	List<PorcentajePorFase> findAll();

	void deletePorcentajePorFase(Long id);

	PorcentajePorFase findByPorcentajePorFaseId(Long id);
	
	List<PorcentajePorFase> findByPorcentajePorFaseYEmpresa(Long id);

}
