package com.gtc.cda.interfaces;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.cda.modelo.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@SuppressWarnings("unchecked")
	Usuario save(Usuario usuario);
   
	
	//List<Usuario> findAll();
}
