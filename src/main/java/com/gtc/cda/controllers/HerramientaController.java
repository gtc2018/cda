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
import com.gtc.cda.models.Herramienta;
import com.gtc.cda.services.HerramientaService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class HerramientaController {
	
	@Autowired
	protected HerramientaService herramientaService;
	
	protected ObjectMapper mapper;
	
	/**
	 * Metodo Guardar o Editar Cargo
	 * @param cargoJson
	 * @throws ParseException 
	 * @throws Exception
	 */
	@RequestMapping(value ="/saveOrUpdateHerramienta", method = RequestMethod.POST)
	public RestResponse saveOrUpdateHerramienta(@RequestBody String herramientaJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		Herramienta herramienta = this.mapper.readValue(herramientaJson, Herramienta.class);
		
		if (!this.validate(herramienta)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(herramienta.getId() ==null ) {
			herramienta.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
			herramienta.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
			herramienta.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		this.herramientaService.save(herramienta);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar Herramienta
	 * @param herramientaJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteHerramienta", method = RequestMethod.POST)
	public RestResponse deleteHerramienta(@RequestBody String herramientaJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Herramienta herramienta = this.mapper.readValue(herramientaJson, Herramienta.class);
		
		if(herramienta.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.herramientaService.deleteHerramienta(herramienta.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar Herramienta
	 * @return
	 */
	@RequestMapping(value ="/getAllHerramientas", method = RequestMethod.GET)
	public List<Herramienta> getAllHerramienta(){
		return  this.herramientaService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener Herramienta por ID.
	 * @param herramientaJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/findByHerramientaId", method = RequestMethod.POST)
	public Herramienta findOne(@RequestBody String herramientaId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Herramienta herramienta = this.mapper.readValue(herramientaId, Herramienta.class);
	
		if(herramienta.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.herramientaService.findByHerramientaId(herramienta.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.herramientaService.findByHerramientaId(herramienta.getId()) ;
		} 

	}
	
	private boolean validate(Herramienta herramienta) {		
		boolean isValid = true;	
		
		if (herramienta.getDescripcion() == null ) {

			isValid = false;

		}
		
		return isValid;	
	}

}
