package com.gtc.cda.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.UsuarioRepository;
import com.gtc.cda.models.Usuario;
import com.gtc.cda.services.UsuarioService;


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
	public List<Usuario> findByEmpresaId(String empresaId) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findByEmpresaId(empresaId);
	}

	
	
	


}
