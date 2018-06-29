package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.PorcentajePorFasesRepository;
import com.gtc.cda.models.Fase;
import com.gtc.cda.models.PorcentajePorFase;
import com.gtc.cda.services.PorcentajePorFasesService;

@Service
public class PorcentajePorFasesServiceImpl implements PorcentajePorFasesService {
	
	
	@Autowired
	protected PorcentajePorFasesRepository porcentajePorFasesRepository;

	@Override
	public PorcentajePorFase save(PorcentajePorFase porcentajePorFases) {
		// TODO Auto-generated method stub
		return this.porcentajePorFasesRepository.save(porcentajePorFases);
	}

	@Override
	public List<PorcentajePorFase> findAll() {
		// TODO Auto-generated method stub
		return this.porcentajePorFasesRepository.findAll();
	}

	@Override
	public void deletePorcentajePorFase(Long id) {
		// TODO Auto-generated method stub
		this.porcentajePorFasesRepository.delete(id);
	}

	@Override
	public PorcentajePorFase findByPorcentajePorFaseId(Long porcentajePorFaseId) {
		// TODO Auto-generated method stub
		return this.porcentajePorFasesRepository.findOne(porcentajePorFaseId);
	}
	
	@Override
	public List<PorcentajePorFase> findByPorcentajePorFaseYEmpresa(Long porcentajePorFaseYEmpresa) {
		// TODO Auto-generated method stub
		return this.porcentajePorFasesRepository.findByPorcentajePorFaseYEmpresa(porcentajePorFaseYEmpresa);
	}
	
	@Override
	public List<PorcentajePorFase> findFasesxEmpresaInPorcentajeFases(Long id, Long detailId) {
		// TODO Auto-generated method stub
		return this.porcentajePorFasesRepository.findFasesxEmpresaInPorcentajeFases(id, detailId );
	}
	
	@Override
	public void updateTotal(Long id) {
		// TODO Auto-generated method stub
	 this.porcentajePorFasesRepository.updateTotal(id);
	}
	
	

}
