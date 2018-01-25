package com.gtc.cda.controllers;

import java.io.IOException;
import java.util.List;

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
import com.gtc.cda.services.UsuarioService;
import com.gtc.cda.util.RestResponse;

@RestController
public class UsuarioController {
	
	@Autowired
	protected UsuarioService usuarioService;
	
	protected ObjectMapper mapper;
	
	
	/**
	 * Método crear o actualizar Usuarios.
	 * @param usuarioJson
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value ="/saveOrUpdateUsuario", method = RequestMethod.POST)
	public RestResponse saveOrUpdateUsuario(@RequestBody String usuarioJson) throws JsonParseException, JsonMappingException, IOException{
		
		this.mapper = new ObjectMapper();
		
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		if (!this.validate(usuario)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		this.usuarioService.save(usuario);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	
	/**
	 * Método consultar todos los usuarios.
	 * @return
	 */
	@RequestMapping(value ="/getAllUsuarios", method = RequestMethod.GET)
	public List<Usuario> getAllUsuarios(){
		return  this.usuarioService.findAll();
		
	}
	
	
	
	/**
	 * Método eliminar usuario.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteUsuario", method = RequestMethod.POST)
	public void deleteUsuario(@RequestBody String usuarioJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		if(usuario.getId() == null){
			throw new Exception("El ID no puede ser nulo.");
		}
		
		this.usuarioService.deleteUsuario(usuario.getId());
		
	}
	
	
	
	
	
	/**
	 * Método validar parametros de entrado creacion usuario.
	 * @param usuario
	 * @return
	 */
	private boolean validate(Usuario usuario) {
	
		boolean isValid = true;
		
		if (StringUtils.trimToNull(usuario.getNombres()) == null ) {

			isValid = false;

		}
		
		return isValid;
		
	}
	

}
