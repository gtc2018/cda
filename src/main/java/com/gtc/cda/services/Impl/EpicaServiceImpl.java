package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.CotizacionRepository;
import com.gtc.cda.dao.EpicaRepository;
import com.gtc.cda.models.Epica;
import com.gtc.cda.services.EpicaService;

@Service
public class EpicaServiceImpl implements EpicaService{
	
	@Autowired
	protected EpicaRepository epicaRepository;

	@Override
	public Epica save(Epica epica) {
		// TODO Auto-generated method stub
		return this.epicaRepository.save(epica);
	}

	@Override
	public List<Epica> findAll() {
		// TODO Auto-generated method stub
		return this.epicaRepository.findAll();
	}

	@Override
	public void deleteEpica(Long id) {
		// TODO Auto-generated method stub
		this.epicaRepository.delete(id);
		
	}

	@Override
	public List<Epica> findAllToProject(Long project) {
		// TODO Auto-generated method stub
		return this.epicaRepository.findAllToProject(project);
	}

	@Override
	public List<Epica> findEpicaToRequest(Long request) {
		// TODO Auto-generated method stub
		return this.epicaRepository.findEpicaToRequest(request);
	}


}
