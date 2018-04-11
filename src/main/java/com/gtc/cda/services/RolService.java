package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.Rol;

public interface RolService {
    
	
	/**
	 * Este metodo crea o actualiza un rol
	 * @param rol
	 * @return
	 */
	Rol save(Rol rol);
    
	
	/**
	 * Este metodo consulta todos los roles existentes en la tabla Roles.
	 * @return
	 */
	List<Rol> findAll();

    
	
	/**
	 * Metodo eliminar Rol.
	 * @param id
	 */
	void deleteRol(Long id);
	
	Rol getOne(Long id);

}
