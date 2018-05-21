package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.Cargo;

public interface CargoService {

	Cargo save(Cargo cargo);

	List<Cargo> findAll();

	void deleteCargo(Long id);
	
	Cargo findByCargoId(long cargoId);
	
	List<Cargo> getAllChargeToEnterprise(Long empresaId);

}
