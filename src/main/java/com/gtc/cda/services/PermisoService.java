package com.gtc.cda.services;

import java.util.*;

import com.gtc.cda.models.Permiso;

public interface PermisoService {
    /**
     * 
     * @param permiso
     * @return
     */
	Permiso save(Permiso permiso);
    /**
     * 
     * @return
     */
	List<Permiso> findAll();
    /**
     * 
     * @param id
     */
	void deletePermiso(Long id);
	/**
	 * 
	 * @param rolId
	 * @return
	 */
	public List<Permiso> findByRolId(String rolId);

	
	public List<Permiso> existe(String rolId, String menuId);
}
