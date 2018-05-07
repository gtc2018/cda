package com.gtc.cda.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.FaseRepository;
import com.gtc.cda.models.Fase;
import com.gtc.cda.services.FaseService;

@Service
public class FaseServiceImpl implements FaseService {
	
	@Autowired
	protected FaseRepository faseRepository;

	@Override
	public Fase save(Fase fase) {
		// TODO Auto-generated method stub
		return this.faseRepository.save(fase);
	}

	@Override
	public List<Fase> findAll() {
		// TODO Auto-generated method stub
		return this.faseRepository.findAll();
	}

	@Override
	public void deleteFase(Long id) {
		// TODO Auto-generated method stub
		this.faseRepository.delete(id);
		
	}
	
	public List<Fase> existe(Long id) {
		// TODO Auto-generated method stub
		List<Fase> fase = new ArrayList<>();
		this.faseRepository.existe(id).forEach(fase::add);
		return  fase;
	}

}
