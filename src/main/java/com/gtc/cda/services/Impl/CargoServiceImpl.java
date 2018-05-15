package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.CargoRepository;
import com.gtc.cda.models.Cargo;
import com.gtc.cda.services.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	protected CargoRepository cargoRepository;
	
	@Override
	public Cargo save(Cargo cargo) {
		// TODO Auto-generated method stub
		return this.cargoRepository.save(cargo);
	}

	@Override
	public List<Cargo> findAll() {
		// TODO Auto-generated method stub
		return this.cargoRepository.findAll();
	}

	@Override
	public void deleteCargo(Long id) {
		// TODO Auto-generated method stub
		this.cargoRepository.delete(id);
	}
	
	@Override
	public Cargo findByCargoId(long cargoId) {
		// TODO Auto-generated method stub
		return this.cargoRepository.findOne(cargoId);
	}

}
