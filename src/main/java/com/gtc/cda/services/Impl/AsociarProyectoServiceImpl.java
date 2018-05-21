package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gtc.cda.dao.AsociarProyectoRepository;
import com.gtc.cda.models.AsociarProyecto;
import com.gtc.cda.models.Empleado;
import com.gtc.cda.services.AsociarProyectoService;


/**
 * Clase de implementacion de los servicios Asociar Proyectos.
 * @author Dirección Calidad
 *
 */
@Service
public class AsociarProyectoServiceImpl implements AsociarProyectoService {
	
	
	@Autowired
	protected AsociarProyectoRepository asociarProyectoRepository;
	
	@Override
	public List<AsociarProyecto> findAllForProject(String proyectoId) {
		// TODO Auto-generated method stub
		return this.asociarProyectoRepository.findAllForProject(proyectoId);
	}

	@Override
	public AsociarProyecto save(AsociarProyecto asociarProyecto) {
		// TODO Auto-generated method stub
		return (AsociarProyecto) this.asociarProyectoRepository.save(asociarProyecto);
	}
	
	public Iterable<AsociarProyecto> save(Iterable<AsociarProyecto> asociarProyecto) {
		// TODO Auto-generated method stub
		return (Iterable<AsociarProyecto>) this.asociarProyectoRepository.save(asociarProyecto);
	}
	
	public ResponseEntity deleteAllByProject(Iterable<AsociarProyecto> asociarProyecto) {
		// TODO Auto-generated method stub
		
		try {
		this.asociarProyectoRepository.delete(asociarProyecto);
		
		return (ResponseEntity) ResponseEntity.ok();
		}catch (Exception e) {
			
		return (ResponseEntity) ResponseEntity.noContent();
			
		}
	}
	
	public Iterable<AsociarProyecto> FindForProjectArray(Iterable<AsociarProyecto> asociarProyecto) {
		// TODO Auto-generated method stub
		return (Iterable<AsociarProyecto>) this.asociarProyectoRepository.save(asociarProyecto);
	}

	

}
