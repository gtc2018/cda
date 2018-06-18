package com.gtc.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Dane;


public interface DaneRepository extends JpaRepository<Dane, Long> {
	
	
	@SuppressWarnings("unchecked")
	Dane save(Dane dane);
	
	@Query(value = "SELECT * FROM DANE WHERE TYPEID = 1" , nativeQuery = true)
	public List<Dane> findCountry();
	
	@Query(value = "SELECT * FROM DANE WHERE PARENTID = ?1 AND TYPEID = 2" , nativeQuery = true)
	public List<Dane> findDeparment(@Param("departamento") Long departamento);
	
	@Query(value = "SELECT * FROM DANE WHERE PARENTID = ?1 AND TYPEID = 3" , nativeQuery = true)
	public List<Dane> findCity(@Param("ciudad") Long ciudad);

}
