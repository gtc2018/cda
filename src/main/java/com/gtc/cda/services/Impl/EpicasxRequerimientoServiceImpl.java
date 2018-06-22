package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.EpicasxRequerimientoRepository;
import com.gtc.cda.models.EpicasxRequerimiento;
import com.gtc.cda.services.EpicasxRequerimientoService;

@Service
public class EpicasxRequerimientoServiceImpl implements EpicasxRequerimientoService{
	
	@Autowired
	protected EpicasxRequerimientoRepository epicasxRequerimientoRepository;

	@Override
	public List<EpicasxRequerimiento> findAllForRequest(int requerimientoId) {
		// TODO Auto-generated method stub
		return this.epicasxRequerimientoRepository.findAllForRequest(requerimientoId);
	
	}

	@Override
	public Iterable<EpicasxRequerimiento> save(Iterable<EpicasxRequerimiento> epicasxRequerimiento) {
		// TODO Auto-generated method stub
		return (Iterable<EpicasxRequerimiento>) this.epicasxRequerimientoRepository.save(epicasxRequerimiento);
	}

	@Override
	public void deleteAllByRequest(Iterable<EpicasxRequerimiento> epicasxRequerimiento) {
		// TODO Auto-generated method stub
		this.epicasxRequerimientoRepository.delete(epicasxRequerimiento);
	}

}
