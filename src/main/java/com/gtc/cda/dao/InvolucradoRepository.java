package com.gtc.cda.dao;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Involucrado;


public interface InvolucradoRepository extends JpaRepository<Involucrado, Long>{
	
	@SuppressWarnings("unchecked")
	Involucrado save(Involucrado involucrado);
	
	@Query(value = "SELECT * FROM INVOLUCRADOS WHERE requerimientos_id = ?1" , nativeQuery = true)
	public List<Involucrado> findInvolvedByRequest(@Param("id") Long id);

}
