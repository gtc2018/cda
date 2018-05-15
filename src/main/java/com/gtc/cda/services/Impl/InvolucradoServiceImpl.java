package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.InvolucradoRepository;
import com.gtc.cda.models.Involucrado;
import com.gtc.cda.services.InvolucradoService;

@Service
public class InvolucradoServiceImpl implements InvolucradoService {
	
	
	@Autowired
	protected InvolucradoRepository involucradoRepository;

	@Override
	public Involucrado save(Involucrado involucrado) {
		// TODO Auto-generated method stub
		return this.involucradoRepository.save(involucrado);
	}

	@Override
	public List<Involucrado> findAll() {
		// TODO Auto-generated method stub
		return this.involucradoRepository.findAll();
	}

	@Override
	public void deleteInvolucrado(Long id) {
		// TODO Auto-generated method stub
		this.involucradoRepository.delete(id);
	}

	@Override
	public Involucrado findByInvolucradoId(Long involucradoId) {
		// TODO Auto-generated method stub
		return this.involucradoRepository.findOne(involucradoId);
	}

}
