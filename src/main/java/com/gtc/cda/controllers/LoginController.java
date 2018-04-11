package com.gtc.cda.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin(origins="*")

@Controller
@RestController
public class LoginController {

	@Autowired
	protected LoginService loginService;

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
	public Object loginUsuario(@RequestBody String usuarioJson)

			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();

		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		Object empleado = new Object();

		if (usuario.getEmail() != null || usuario.getPassword() != " ") {

			Usuario usua = this.loginService.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());

			if (usua != null && usua.getEmpleadoId() != null && usua.getTipoEmpleado() != null) {

				if (usua.getTipoEmpleado().toUpperCase().equals("INTERNO")) {
					empleado = this.empleadoService.findByEmpleadoId(usua.getEmpleadoId());
				} else if (usua.getTipoEmpleado().toUpperCase().equals("EXTERNO")) {
					empleado = this.empleadoExternoService.findByEmpleadoId(usua.getEmpleadoId());
				} else {
					System.out.println("****EL EMPLEADO NO HA SIDO DEFINIDO COMO INTERNO O EXTERNO****"+ usua.getTipoEmpleado().toUpperCase());
					empleado = null;
				}

			} else {
				System.out.println("***** USUARIO O CONTRASEÑA INVALIDO: ******");
				empleado = null;
			}

		}

		return empleado;

	}

}
