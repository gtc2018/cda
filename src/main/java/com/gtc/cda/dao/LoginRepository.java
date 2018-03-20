package com.gtc.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gtc.cda.models.Usuario;




public interface LoginRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findByEmailAndPassword(String email, String password);
	
	

}
