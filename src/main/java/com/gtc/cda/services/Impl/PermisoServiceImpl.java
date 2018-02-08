package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.PermisoRepository;
import com.gtc.cda.models.Permiso;
import com.gtc.cda.services.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService {
	
	@Autowired
	protected PermisoRepository permisoRepository;

	@Override
	public Permiso save(Permiso permiso) {
		// TODO Auto-generated method stub
		return this.permisoRepository.save(permiso);
	}

	@Override
	public List<Permiso> findAll() {
		// TODO Auto-generated method stub
		return this.permisoRepository.findAll();
	}

	@Override
	public void deletePermiso(Long id) {
		// TODO Auto-generated method stub
		this.permisoRepository.delete(id);
	}

}