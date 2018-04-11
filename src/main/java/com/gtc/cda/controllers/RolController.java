package com.gtc.cda.controllers;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.models.Rol;
import com.gtc.cda.services.RolService;
import com.gtc.cda.util.RestResponse;


@CrossOrigin(origins="*")

@RestController
public class RolController {
	
	@Autowired
	protected RolService rolService;
	
	protected ObjectMapper  mapper;
	
	
	/**
	 * Metodo crear o actualizar un Rol
	 * @param rolJson
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value="/saveOrUpdateRol", method = RequestMethod.POST)
	public RestResponse saveOrUpdateRol(@RequestBody String rolJson) throws JsonParseException, JsonMappingException, IOException{
		
		this.mapper = new ObjectMapper();
		
		Rol rol = this.mapper.readValue(rolJson, Rol.class);
		
		if(!this.validate(rol)){
		return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
				"Los campos obligatorios no estan diligenciados");
		}
		
		this.rolService.save(rol);
		
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo consultar todos los roles.
	 * @return
	 */
	@RequestMapping(value ="/getAllRol", method = RequestMethod.GET)
	public List<Rol> getAllRol(){
		return  this.rolService.findAll();
		
	}
	
	/**
	 * Metodo eliminar Roles
	 * @param rolJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteRol", method = RequestMethod.POST)
	public void deleteRol(@RequestBody String rolJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Rol rol = this.mapper.readValue(rolJson, Rol.class);
		
		if(rol.getId() == null){
			throw new Exception("El ID no puede ser nulo.");
		}
		
		this.rolService.deleteRol(rol.getId());
		
		//return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	
	/**
	 * Metodo para validar los campos recibidos desde el
	 * @param rol
	 * @return
	 */
	private boolean validate(Rol rol){
		boolean isValid = true;
		 
		if (StringUtils.trimToNull(rol.getDescripcion()) == null ) {

			isValid = false;

		}
		
		return isValid;
	}

}
