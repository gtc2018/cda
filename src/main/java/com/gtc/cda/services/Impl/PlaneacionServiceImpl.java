package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.PlaneacionRepository;
import com.gtc.cda.models.Planeacion;
import com.gtc.cda.services.PlaneacionService;

@Service
public class PlaneacionServiceImpl implements  PlaneacionService{
	
	@Autowired
	protected PlaneacionRepository planeacionRepository;

	@Override
	public Planeacion save(Planeacion planeacion) {
		// TODO Auto-generated method stub
		return this.planeacionRepository.save(planeacion);
	}

	@Override
	public List<Planeacion> findAll() {
		// TODO Auto-generated method stub
		return this.planeacionRepository.findAll();
	}

	@Override
	public void deletePlaneacion(Long id) {
		// TODO Auto-generated method stub
		this.planeacionRepository.delete(id);
	}

}
