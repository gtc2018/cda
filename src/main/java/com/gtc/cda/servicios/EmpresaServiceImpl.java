package com.gtc.cda.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.interfaces.EmpresaRepository;
import com.gtc.cda.interfaces.EmpresaService;
import com.gtc.cda.modelo.Empresa;



@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	protected EmpresaRepository empresaRepository;

	@Override
	public Empresa save(Empresa empresa) {
		// TODO Auto-generated method stub
		return this.empresaRepository.save(empresa);
	}

}
