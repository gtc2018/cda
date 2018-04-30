package com.gtc.cda.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

	@Override
	public List<Permiso> findByRolId(String rolId) {
		// TODO Auto-generated method stub
		List<Permiso> permisos = new ArrayList<>();
		this.permisoRepository.findByRolId(rolId).forEach(permisos::add);
		return  permisos;
	}

	
	public List<Permiso> existe(String rolId, String menuId) {
		// TODO Auto-generated method stub
		List<Permiso> permisos = new ArrayList<>();
		this.permisoRepository.existe(rolId, menuId).forEach(permisos::add);
		return  permisos;
	}
	
	
	

	

	
	
	
	

	

}