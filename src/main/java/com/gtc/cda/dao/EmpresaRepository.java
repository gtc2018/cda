package com.gtc.cda.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Empresa;

public interface EmpresaRepository  extends JpaRepository<Empresa, Long>{
	
	@SuppressWarnings("unchecked")
	Empresa save(Empresa empresa);
	
	

}
