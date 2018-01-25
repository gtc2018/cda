package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.RolRepository;
import com.gtc.cda.models.Rol;
import com.gtc.cda.services.RolService;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	protected RolRepository rolRepository;

	@Override
	public Rol save(Rol rol) {
		// TODO Auto-generated method stub
		return this.rolRepository.save(rol);
	}

	@Override
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return this.rolRepository.findAll();
	}

	@Override
	public void deleteRol(Long id) {
		// TODO Auto-generated method stub
		this.rolRepository.delete(id);
		
	}

}
