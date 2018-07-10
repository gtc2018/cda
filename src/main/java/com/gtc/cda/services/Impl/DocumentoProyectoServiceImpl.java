package com.gtc.cda.services.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.DocumentoProyectoRepository;
import com.gtc.cda.models.DocumentoProyecto;
import com.gtc.cda.services.DocumentoProyectoService;

@Service
public class DocumentoProyectoServiceImpl implements DocumentoProyectoService {
	
	
	@Autowired
	protected DocumentoProyectoRepository documentoProyectoRepository;

	@Override
	public DocumentoProyecto save(DocumentoProyecto documentoProyecto) {
		// TODO Auto-generated method stub
		return this.documentoProyectoRepository.save(documentoProyecto);
	}

	@Override
	public List<DocumentoProyecto> findAll() {
		// TODO Auto-generated method stub
		return this.documentoProyectoRepository.findAll();
	}

	@Override
	public void deleteDocumentoProyecto(Long id) {
		// TODO Auto-generated method stub
		this.documentoProyectoRepository.delete(id);
	}
	
	@Override
	public DocumentoProyecto getDocumentoProyectoId(long id) {
		// TODO Auto-generated method stub
		return this.documentoProyectoRepository.findOne(id);
	}

	@Override
	public List<DocumentoProyecto> getDocumentByProject(Long id) {
		// TODO Auto-generated method stub
		return this.documentoProyectoRepository.findDocumentByProject(id);
	}
	

}