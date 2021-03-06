package com.gtc.cda.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtc.cda.dao.LoginRepository;
import com.gtc.cda.models.Usuario;
import com.gtc.cda.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	
	@Override
	public Usuario findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return this.loginRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public Usuario findByEmail(Long id) {
		// TODO Auto-generated method stub
		return this.loginRepository.findOne(id);
	}

}
