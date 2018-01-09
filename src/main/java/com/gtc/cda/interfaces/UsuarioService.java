package com.gtc.cda.interfaces;

import java.util.List;

import com.gtc.cda.modelo.Usuario;


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
	
	/**
	 * Elimina un usuario recibiendo como parametro el ID
	 * @param id
	 */

	void deleteUsuario(Long id);
    
	
	/**
	 * 
	 * @param email
	 * @param password
	 */
	void loginUsuario(String email, String password);

	

	

	

	

}
