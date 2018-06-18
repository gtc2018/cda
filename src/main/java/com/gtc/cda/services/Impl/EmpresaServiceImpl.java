package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.EmpresaRepository;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.services.EmpresaService;



@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	protected EmpresaRepository empresaRepository;

	@Override
	public Empresa save(Empresa empresa) {
		// TODO Auto-generated method stub
		return this.empresaRepository.save(empresa);
	}

	@Override
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return this.empresaRepository.findAll();
	}
	
	public Empresa getOne(Long id) {
		// TODO Auto-generated method stub
		return this.empresaRepository.getOne(id);
	}

	@Override
	public void deleteEmpresa(Long id) {
		// TODO Auto-generated method stub
		this.empresaRepository.delete(id);
		
	}

	@Override
	public Empresa findByEmpresaId(Long id) {
		// TODO Auto-generated method stub
		return this.empresaRepository.findById(id);
	}
	
	@Override
	public List<Empresa> findEnterpriseForRegistre(String documento) {
		// TODO Auto-generated method stub
		return this.empresaRepository.findEnterpriseForRegistre(documento);
	}
	
	

}
