package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.HerramientaRepository;
import com.gtc.cda.models.Herramienta;
import com.gtc.cda.services.HerramientaService;

@Service
public class HerramientaServiceImpl implements HerramientaService {

	@Autowired
	protected HerramientaRepository herramientaRepository;
	
	@Override
	public Herramienta save(Herramienta herramienta) {
		// TODO Auto-generated method stub
		return this.herramientaRepository.save(herramienta);
	}

	@Override
	public List<Herramienta> findAll() {
		// TODO Auto-generated method stub
		return this.herramientaRepository.findAll();
	}

	@Override
	public void deleteHerramienta(Long id) {
		// TODO Auto-generated method stub
		this.herramientaRepository.delete(id);
	}
	
	@Override
	public Herramienta findByHerramientaId(long herramientaId) {
		// TODO Auto-generated method stub
		return this.herramientaRepository.findOne(herramientaId);
	}

}
