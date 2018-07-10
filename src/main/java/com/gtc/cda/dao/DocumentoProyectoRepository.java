package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.DocumentoProyecto;


public interface DocumentoProyectoRepository extends JpaRepository<DocumentoProyecto, Long> {
	
	
	@SuppressWarnings("unchecked")
	DocumentoProyecto save(DocumentoProyecto documentoProyecto);

	@Query(value = "SELECT * FROM DOCUMENTO_PROYECTO WHERE proyectos_id = ?1" , nativeQuery = true)
	public List<DocumentoProyecto> findDocumentByProject(@Param("id") Long id);

}
