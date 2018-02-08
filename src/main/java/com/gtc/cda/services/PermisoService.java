package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Permiso;

public interface PermisoService {

	Permiso save(Permiso permiso);

	List<Permiso> findAll();

	void deletePermiso(Long id);

}
