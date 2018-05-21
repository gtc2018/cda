package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.models.Sistema;
import com.gtc.cda.services.SistemaService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class SistemaController {
	
	@Autowired
	protected SistemaService sistemaService;
	
	protected ObjectMapper mapper;
	
	/**
	 * Metodo Guardar o Editar Sistema
	 * @param sistemaJson
	 * @throws ParseException 
	 * @throws Exception
	 */
	@RequestMapping(value ="/saveOrUpdateSistema", method = RequestMethod.POST)
	public RestResponse saveOrUpdateSistema(@RequestBody String sistemaJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		Sistema sistema = this.mapper.readValue(sistemaJson, Sistema.class);
		
		if (!this.validate(sistema)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(sistema.getId() ==null ) {
		sistema.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		sistema.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
		sistema.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		this.sistemaService.save(sistema);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar Sistema
	 * @param sistemaJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteSistema", method = RequestMethod.POST)
	public RestResponse deleteSistema(@RequestBody String sistemaJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Sistema sistema = this.mapper.readValue(sistemaJson, Sistema.class);
		
		if(sistema.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.sistemaService.deleteSistema(sistema.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar Sistema
	 * @return
	 */
	@RequestMapping(value ="/getAllSistemas", method = RequestMethod.GET)
	public List<Sistema> getAllSistema(){
		return  this.sistemaService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener Sistemas por ID.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/findBySistemaId", method = RequestMethod.POST)
	public Sistema findOne(@RequestBody String sistemaId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Sistema sistema = this.mapper.readValue(sistemaId, Sistema.class);
	
		if(sistema.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.sistemaService.findBySistemaId(sistema.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.sistemaService.findBySistemaId(sistema.getId()) ;
		} 

	}
	
	private boolean validate(Sistema sistema) {		
		boolean isValid = true;	
		
		if (sistema.getDescripcion() == null ) {

			isValid = false;

		}
		
		return isValid;	
	}

}
