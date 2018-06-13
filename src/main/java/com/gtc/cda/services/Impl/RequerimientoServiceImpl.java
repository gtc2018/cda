package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.RequerimientoRepository;
import com.gtc.cda.models.Requerimiento;
import com.gtc.cda.services.RequerimientoService;

@Service
public class RequerimientoServiceImpl implements RequerimientoService {
	
	
	@Autowired
	protected RequerimientoRepository requerimientoRepository;

	@Override
	public Requerimiento save(Requerimiento requerimiento) {
		// TODO Auto-generated method stub
		return this.requerimientoRepository.save(requerimiento);
	}

	@Override
	public List<Requerimiento> findAll() {
		// TODO Auto-generated method stub
		return this.requerimientoRepository.findAll();
	}

	@Override
	public void deleteRequerimiento(Long id) {
		// TODO Auto-generated method stub
		this.requerimientoRepository.delete(id);
	}

	@Override
	public Requerimiento findByRequerimientoId(Long requerimientoId) {
		// TODO Auto-generated method stub
		return this.requerimientoRepository.findOne(requerimientoId);
	}
	
	@Override
	public List<Requerimiento> findRequestToProject(Long project) {
		// TODO Auto-generated method stub
		return this.requerimientoRepository.findRequestToProject(project);
	}
	
	@Override
	public List<Requerimiento> findRequestByProjectAndEmployee(Long project, Long cliente) {
		// TODO Auto-generated method stub
		return this.requerimientoRepository.findRequestByProjectAndEmployee(project, cliente);
	}
	
	@Override
    public List<Requerimiento> findByDate(Long columna1, Long columna2, String fechaInicio, String fechaFin) {
        // TODO Auto-generated method stub
        return this.requerimientoRepository.findByDate(columna1, columna2, fechaInicio, fechaFin);
    }

}
