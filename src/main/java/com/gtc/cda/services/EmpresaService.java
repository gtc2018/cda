package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Empresa;

public interface EmpresaService {

	Empresa save(Empresa empresa);

	
	List<Empresa> findAll();


	void deleteEmpresa(Long id);
	
	
	Empresa findByEmpresaId (Long id);
	

}
