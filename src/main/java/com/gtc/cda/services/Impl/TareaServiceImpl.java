package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.TareaRepository;
import com.gtc.cda.models.Tarea;
import com.gtc.cda.services.TareaService;

@Service
public class TareaServiceImpl implements TareaService {

	@Autowired
	protected TareaRepository tareaRepository;
	
	@Override
	public Tarea save(Tarea tarea) {
		// TODO Auto-generated method stub
		return this.tareaRepository.save(tarea);
	}

	@Override
	public List<Tarea> findAll() {
		// TODO Auto-generated method stub
		return this.tareaRepository.findAll();
	}

	@Override
	public void deleteTarea(Long id) {
		// TODO Auto-generated method stub
		this.tareaRepository.delete(id);
	}
	
	@Override
	public Tarea findByTareaId(long tareaId) {
		// TODO Auto-generated method stub
		return this.tareaRepository.findOne(tareaId);
	}

}
