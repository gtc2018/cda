package com.gtc.cda.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.models.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@SuppressWarnings("unchecked")
	Usuario save(Usuario usuario);
   
	
	//List<Usuario> findAll();
	
	
	
}
