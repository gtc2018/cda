package com.gtc.cda.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Empresa;


public interface EmpresaRepository  extends JpaRepository<Empresa, Long>{
	
	@SuppressWarnings("unchecked")
	Empresa save(Empresa empresa);
	
	
	Empresa findById(Long id);
	
	@Query(value = "SELECT * FROM clientes WHERE numero_documento = ?1" , nativeQuery = true)
	public List<Empresa> findEnterpriseForRegistre(@Param("documento") String documento);

}
