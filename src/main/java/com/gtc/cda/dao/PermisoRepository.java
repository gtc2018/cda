package com.gtc.cda.dao;



import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Permiso;



public interface PermisoRepository extends JpaRepository<Permiso, Long> {
	
	@SuppressWarnings("unchecked")
	Permiso save(Permiso permiso);
	
	//
	//@Query(value = " call cda.getMenuSession(:rol)" , nativeQuery = true)
	 @Query(value = "SELECT * FROM PERMISOS WHERE rol_id = ?1 AND estado = 1" , nativeQuery = true)
	//@Procedure(name = "getMenuSession")
	 public List<Permiso> findByRolId(@Param("rol") String rolId);
	//public List<Permiso> findByRolId(String rolId);
	 
	 @Query(value = "SELECT * FROM PERMISOS WHERE rol_id = ?1 AND menu_id = ?2" , nativeQuery = true)
	 public	 List<Permiso> existe(@Param("rol") String rolId, @Param("menu") String menuId);

}
