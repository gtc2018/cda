package com.gtc.cda.services;

import java.util.List;

import com.gtc.cda.models.PorcentajePorFase;
import com.gtc.cda.models.Usuario;


public interface UsuarioService {
	/**
	 * 
	 * @param usuario crea o actualiza un usuario
	 * @return
	 */
	Usuario save(Usuario usuario);
	
	/**
	 * 
	 * @return
	 */

	List<Usuario> findAll();

	Usuario findToOne(Long id);
	
	Usuario findByUsuarioId(String email, String password);
	
	/**
	 * Elimina un usuario recibiendo como parametro el ID
	 * @param id
	 */

	void deleteUsuario(Long id);
	
	List<Usuario> findByEmpresaId(String empresaId);
	

}
