package com.gtc.cda.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.models.Usuario;
import com.gtc.cda.services.EmpleadoExternoService;
import com.gtc.cda.services.EmpleadoService;
import com.gtc.cda.services.LoginService;
import com.gtc.cda.services.UsuarioService;

@CrossOrigin(origins="*")

@Controller
@RestController
public class LoginController {

	@Autowired
	protected LoginService loginService;
	
	@Autowired
	protected UsuarioService usuarioService;

	@Autowired
	protected EmpleadoService empleadoService;

	@Autowired
	protected EmpleadoExternoService empleadoExternoService;

	protected ObjectMapper mapper;

	/**
	 * Método de Autenticacion.
	 * Este metodo me permite validar y devolver un empleado si existe, con base a los parametros enviados (email y password)
	 * @param usuarioJson
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */

	@RequestMapping(value = "/loginUsuario", method = RequestMethod.POST)
	public ResponseEntity loginUsuario(@RequestBody String usuarioJson)

			throws JsonParseException, JsonMappingException, IOException, Exception {
		
		try {

		this.mapper = new ObjectMapper();

		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		Object empleado = new Object();

		System.out.println(usuario);
		
		if (usuario.getEmail() != null || usuario.getPassword() != " ") {

			Usuario usua = this.usuarioService.findByUsuarioId(usuario.getEmail(), usuario.getPassword());
			
			if(usua == null){
				
				return (ResponseEntity) ResponseEntity.badRequest().body("Usuario o contraseña inválidos");
				
			}
			
			usua.setClienteId(usua.getCliente().getId().toString());
			
			usua.setEmpleadoId(usua.getEmpleado().getId().toString());
			
			usua.setRolId(usua.getRol().getId().toString());
			
			usuario = usua;

		}
		
		if(usuario.getEstado() != 1) {
			
			return (ResponseEntity) ResponseEntity.badRequest().body("El usuario no se encuentra activo");
			
		}else {
			
			return (ResponseEntity) ResponseEntity.ok(usuario);
			
		}
	}catch(Exception e) {
		
		return (ResponseEntity) ResponseEntity.badRequest().body("Error Interno en el servidor");
		
	}
		
	}

}
