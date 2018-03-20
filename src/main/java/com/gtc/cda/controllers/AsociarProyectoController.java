package com.gtc.cda.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.services.AsociarProyectoService;
import com.gtc.cda.util.RestResponse;

/**
 * Controlador Asociar Proyecto, esta clase controla los servicios expuestos
 * de la entidad Asociar proyectos.
 * @author Dirección Calidad
 *
 */
@RestController
public class AsociarProyectoController {
	
	
	@Autowired
	protected AsociarProyectoService asociarProyectoService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value ="/saveOrUpdateAsociarProyecto", method = RequestMethod.POST)
	public RestResponse saveOrUpdateAsociarProyecto(@RequestBody String[] asociarProyectoJson) throws JsonParseException, JsonMappingException, IOException{
		
		this.mapper = new ObjectMapper();
		
		//AsociarProyecto asociarProyecto =  this.mapper.readValue(asociarProyectoJson, AsociarProyecto.class);
		
		//this.asociarProyectoService.save(asociarProyecto);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	

}
