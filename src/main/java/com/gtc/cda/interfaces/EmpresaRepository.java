package com.gtc.cda.interfaces;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.modelo.Empresa;

public interface EmpresaRepository  extends JpaRepository<Empresa, Long>{
	
	@SuppressWarnings("unchecked")
	Empresa save(Empresa empresa);
	
	

}
