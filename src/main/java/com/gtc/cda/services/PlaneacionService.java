package com.gtc.cda.services;

import com.gtc.cda.models.Planeacion;
import java.util.List;

public interface PlaneacionService {
	
	Planeacion save(Planeacion planeacion);
	
	List<Planeacion> findAll();
	
	void deletePlaneacion(Long id);

}
