package com.gtc.cda.services;

import com.gtc.cda.models.Usuario;

public interface LoginService {

	Usuario findByEmailAndPassword(String email, String password);
}
