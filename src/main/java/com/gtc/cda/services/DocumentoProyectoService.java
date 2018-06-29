package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.DocumentoProyecto;



public interface DocumentoProyectoService {

	DocumentoProyecto save(DocumentoProyecto proyecto);

	List<DocumentoProyecto> findAll();

	void deleteDocumentoProyecto(Long id);
	
	DocumentoProyecto getDocumentoProyectoId(long id);
	
	List<DocumentoProyecto> getDocumentByProject(Long id);

}

