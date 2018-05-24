package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Tarea;

public interface TareaService {

	Tarea save(Tarea tarea);

	List<Tarea> findAll();

	void deleteTarea(Long id);
	
	Tarea findByTareaId(long tareaId);

}
