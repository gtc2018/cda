package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.SistemaRepository;
import com.gtc.cda.models.Sistema;
import com.gtc.cda.services.SistemaService;

@Service
public class SistemaServiceImpl implements SistemaService {

	@Autowired
	protected SistemaRepository sistemaRepository;
	
	@Override
	public Sistema save(Sistema sistema) {
		// TODO Auto-generated method stub
		return this.sistemaRepository.save(sistema);
	}

	@Override
	public List<Sistema> findAll() {
		// TODO Auto-generated method stub
		return this.sistemaRepository.findAll();
	}

	@Override
	public void deleteSistema(Long id) {
		// TODO Auto-generated method stub
		this.sistemaRepository.delete(id);
	}
	
	@Override
	public Sistema findBySistemaId(long sistemaId) {
		// TODO Auto-generated method stub
		return this.sistemaRepository.findOne(sistemaId);
	}

}
