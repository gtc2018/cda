package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.PropuestaRepository;
import com.gtc.cda.models.Propuesta;
import com.gtc.cda.services.PropuestaService;


@Service
public class PropuestaServiceImpl implements PropuestaService {

	@Autowired
	protected PropuestaRepository propuestaRepository;
	
	@Override
	public Propuesta save(Propuesta propuesta) {
		// TODO Auto-generated method stub
		return this.propuestaRepository.save(propuesta);
	}

	@Override
	public List<Propuesta> findAll() {
		// TODO Auto-generated method stub
		return this.propuestaRepository.findAll();
	}

	@Override
	public void deletePropuesta(Long id) {
		// TODO Auto-generated method stub
		this.propuestaRepository.delete(id);
	}
	
	@Override
	public Propuesta findByPropuestaId(long id) {
		// TODO Auto-generated method stub
		return this.propuestaRepository.findOne(id);
	}
	
	@Override
	public List<Propuesta> getDocumentByQuotation(Long id) {
		// TODO Auto-generated method stub
		return this.propuestaRepository.findDocumentByQuotation(id);
	}
}
