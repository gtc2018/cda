package com.gtc.cda.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.gtc.cda.dao.RequerimientoRepository;
import com.gtc.cda.models.Requerimiento;
import com.gtc.cda.services.RequerimientoService;

@Service
public class RequerimientoServiceImpl implements RequerimientoService {
	
	@Autowired
	protected RequerimientoRepository requerimientoRepository;

	@Override
	public Requerimiento save(Requerimiento requerimiento) {
		// TODO Auto-generated method stub
		return this.requerimientoRepository.save(requerimiento);
	}

	@Override
	public List<Requerimiento> findAll() {
		// TODO Auto-generated method stub
		return this.requerimientoRepository.findAll();
	}

	@Override
	public void deleteRequerimiento(Long id) {
		// TODO Auto-generated method stub
		this.requerimientoRepository.delete(id);
	}

	/*@Override
	public List<Requerimiento> findByRolId(String rolId) {
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
	}*/
	

}
