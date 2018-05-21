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
import com.gtc.cda.models.Estado;
import com.gtc.cda.services.EstadoService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class EstadoController {
	
	@Autowired
	protected EstadoService estadoService;
	
	protected ObjectMapper mapper;
	
	/**
	 * Metodo Guardar o Editar Estado
	 * @param estadoJson
	 * @throws ParseException 
	 * @throws Exception
	 */
	@RequestMapping(value ="/saveOrUpdateEstado", method = RequestMethod.POST)
	public RestResponse saveOrUpdateEstado(@RequestBody String estadoJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		Estado estado = this.mapper.readValue(estadoJson, Estado.class);
		
		if (!this.validate(estado)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(estado.getId() ==null ) {
			estado.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
			estado.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
			estado.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		this.estadoService.save(estado);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar Estado
	 * @param estadoJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteEstado", method = RequestMethod.POST)
	public RestResponse deleteEstado(@RequestBody String estadoJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Estado estado = this.mapper.readValue(estadoJson, Estado.class);
		
		if(estado.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.estadoService.deleteEstado(estado.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar Estado
	 * @return
	 */
	@RequestMapping(value ="/getAllEstados", method = RequestMethod.GET)
	public List<Estado> getAllEstado(){
		return  this.estadoService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener Estados por ID.
	 * @param EstadoJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/findByEstadoId", method = RequestMethod.POST)
	public Estado findOne(@RequestBody String estadoId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Estado estado = this.mapper.readValue(estadoId, Estado.class);
	
		if(estado.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.estadoService.findByEstadoId(estado.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.estadoService.findByEstadoId(estado.getId()) ;
		} 

	}
	
	private boolean validate(Estado estado) {		
		boolean isValid = true;	
		
		if (estado.getDescripcion() == null ) {

			isValid = false;

		}
		
		return isValid;	
	}

}
