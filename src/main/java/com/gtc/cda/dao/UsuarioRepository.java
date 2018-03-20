package com.gtc.cda.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gtc.cda.models.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@SuppressWarnings("unchecked")
	Usuario save(Usuario usuario);
   
	
	//List<Usuario> findAll();
	
	@Query(value = "SELECT * FROM USUARIOS WHERE cliente_id = ?1" , nativeQuery = true)
	public List<Usuario> findByEmpresaId(@Param("clienteId") String clienteId);
	
	
	
}
