package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Usuario;




public interface LoginRepository extends JpaRepository<Usuario, Long> {
	
	//@Query(value = "SELECT * FROM USUARIOS WHERE email = ?1 AND password = ?2" , nativeQuery = true)
	public Usuario findByEmailAndPassword(String email, String password);
	
//	@Query(value = "SELECT * FROM USUARIOS WHERE id = ?1" , nativeQuery = true)
//	public Usuario findByEmail(@Param("id") Long id);
	
	

}
