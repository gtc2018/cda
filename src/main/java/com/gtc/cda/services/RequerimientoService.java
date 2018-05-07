package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Requerimiento;

public interface RequerimientoService {
	
	/**
     * 
     * @param requerimiento
     * @return
     */
	Requerimiento save(Requerimiento requerimiento);
	
    /**
     * 
     * @return
     */
	List<Requerimiento> findAll();
	
    /**
     * 
     * @param id
     */
	void deleteRequerimiento(Long id);
	
	/**
	 * 
	 * @param requerimientoId
	 * @return
	 */
	//public List<Requerimiento> findByProyectoId(String requerimientoId);

	/**
	 * 
	 * @param clienteId, proyectoId
	 * @return
	 */
	//public List<Requerimiento> existe(String clienteId, String proyectoId);

}
