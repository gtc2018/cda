package com.gtc.cda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.interfaces.UsuarioRepository;
import com.gtc.cda.interfaces.UsuarioService;
import com.gtc.cda.modelo.Usuario;


@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	protected UsuarioRepository usuarioRepository;

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findAll();
	}

	@Override
	public void deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		this.usuarioRepository.delete(id);
	}

	@Override
	public void loginUsuario(String email, String password) {
		// TODO Auto-generated method stub
		//this.usuarioRepository.fi)
	}


}
