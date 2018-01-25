/*

package com.gtc.cda.controllers;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.models.Usuario;
import com.gtc.cda.services.LoginService;
import com.gtc.cda.util.RestResponse;


@RestController
public class LoginController {
	
	@Autowired
	protected LoginService loginService;
	
	protected ObjectMapper mapper;
	
	
	/**
	 * Método crear o actualizar Usuarios.
	 * @param usuarioJson
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
/*
	@RequestMapping(value ="/loginUsuario", method = RequestMethod.POST)
	public RestResponse loginUsuario(@RequestBody String usuarioJson) throws JsonParseException, JsonMappingException, IOException{
		
		this.mapper = new ObjectMapper();
		
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		if (!this.validate(usuario)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		this.loginService.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());

		return new RestResponse(HttpStatus.OK.value(), "Login: Operacion Exitosa");
		
	}
	
	/**
	 * Método validar parametros de entrado creacion usuario.
	 * @param usuario
	 * @return
	 */
/*
	private boolean validate(Usuario usuario) {
	
		boolean isValid = true;
		
		if (StringUtils.trimToNull(usuario.getEmail()) == null ) {

			isValid = false;

		}
		
		if (StringUtils.trimToNull(usuario.getPassword()) == null ) {

			isValid = false;

		}
		
		return isValid;
		
	}

}

*/
