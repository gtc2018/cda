package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.AlcanceRepository;
import com.gtc.cda.models.Alcance;
import com.gtc.cda.services.AlcanceService;

@Service
public class AlcanceServiceImpl implements AlcanceService {

	@Autowired
	protected AlcanceRepository alcanceRepository;
	
	@Override
	public Alcance save(Alcance alcance) {
		// TODO Auto-generated method stub
		return this.alcanceRepository.save(alcance);
	}

	@Override
	public List<Alcance> findAll() {
		// TODO Auto-generated method stub
		return this.alcanceRepository.findAll();
	}

	@Override
	public void deleteAlcance(Long id) {
		// TODO Auto-generated method stub
		this.alcanceRepository.delete(id);
	}
	
	@Override
	public Alcance findByAlcanceId(long alcanceId) {
		// TODO Auto-generated method stub
		return this.alcanceRepository.findOne(alcanceId);
	}

}
