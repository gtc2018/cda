package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Tarea;


public interface TareaRepository extends JpaRepository<Tarea, Long> {
	
	
	@SuppressWarnings("unchecked")
	Tarea save(Tarea sistema);

}
