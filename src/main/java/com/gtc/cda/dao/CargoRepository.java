package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Cargo;


public interface CargoRepository extends JpaRepository<Cargo, Long> {
	
	
	@SuppressWarnings("unchecked")
	Cargo save(Cargo cargo);
	
	@Query(value = "SELECT * FROM CARGOS WHERE cliente_id = ?1" , nativeQuery = true)
	public List<Cargo> getAllChargeToEnterprise(@Param("empresaId") Long clienteId);

}
