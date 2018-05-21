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
import com.gtc.cda.models.Alcance;
import com.gtc.cda.services.AlcanceService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class AlcanceController {
	
	@Autowired
	protected AlcanceService alcanceService;
	
	protected ObjectMapper mapper;
	
	/**
	 * Metodo Guardar o Editar Cargo
	 * @param cargoJson
	 * @throws ParseException 
	 * @throws Exception
	 */
	@RequestMapping(value ="/saveOrUpdateAlcance", method = RequestMethod.POST)
	public RestResponse saveOrUpdateAlcance(@RequestBody String alcanceJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		Alcance alcance = this.mapper.readValue(alcanceJson, Alcance.class);
		
		if (!this.validate(alcance)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(alcance.getId() ==null ) {
			alcance.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
			alcance.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
			alcance.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		this.alcanceService.save(alcance);
		
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar Alcance
	 * @param alcanceJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteAlcance", method = RequestMethod.POST)
	public RestResponse deleteAlcance(@RequestBody String alcanceJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Alcance alcance = this.mapper.readValue(alcanceJson, Alcance.class);
		
		if(alcance.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.alcanceService.deleteAlcance(alcance.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar Alcance
	 * @return
	 */
	@RequestMapping(value ="/getAllAlcances", method = RequestMethod.GET)
	public List<Alcance> getAllAlcance(){
		return  this.alcanceService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener Cargos por ID.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/findByAlcanceId", method = RequestMethod.POST)
	public Alcance findOne(@RequestBody String alcanceId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Alcance alcance = this.mapper.readValue(alcanceId, Alcance.class);
	
		if(alcance.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.alcanceService.findByAlcanceId(alcance.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.alcanceService.findByAlcanceId(alcance.getId()) ;
		} 

	}
	
	private boolean validate(Alcance alcance) {		
		boolean isValid = true;	
		
		if (alcance.getDescripcion() == null ) {

			isValid = false;

		}
		
		return isValid;	
	}

}
