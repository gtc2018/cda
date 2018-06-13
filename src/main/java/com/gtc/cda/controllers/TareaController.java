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
import com.gtc.cda.models.Tarea;
import com.gtc.cda.services.TareaService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class TareaController {
	
	@Autowired
	protected TareaService tareaService;
	
	protected ObjectMapper mapper;
	
	/**
	 * Metodo Guardar o Editar Tarea
	 * @param tareaJson
	 * @throws ParseException 
	 * @throws Exception
	 */
	@RequestMapping(value ="/saveOrUpdateTarea", method = RequestMethod.POST)
	public RestResponse saveOrUpdateTarea(@RequestBody String tareaJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		Tarea tarea = this.mapper.readValue(tareaJson, Tarea.class);
		
		if (!this.validate(tarea)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(tarea.getId() ==null ) {
		tarea.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		tarea.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
		tarea.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		this.tareaService.save(tarea);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar Tarea
	 * @param tareaJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteTarea", method = RequestMethod.POST)
	public RestResponse deleteTarea(@RequestBody String tareaJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Tarea tarea = this.mapper.readValue(tareaJson, Tarea.class);
		
		if(tarea.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.tareaService.deleteTarea(tarea.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar Tarea
	 * @return
	 */
	@RequestMapping(value ="/getAllTareas", method = RequestMethod.GET)
	public List<Tarea> getAllTarea(){
		return  this.tareaService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener Tareas por ID.
	 * @param tareaJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/findByTareaId", method = RequestMethod.POST)
	public Tarea findOne(@RequestBody String tareaId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Tarea tarea = this.mapper.readValue(tareaId, Tarea.class);
	
		if(tarea.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.tareaService.findByTareaId(tarea.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.tareaService.findByTareaId(tarea.getId()) ;
		} 

	}
	
	private boolean validate(Tarea tarea) {		
		boolean isValid = true;	
		
		if (tarea.getDescripcion() == null ) {

			isValid = false;

		}
		
		return isValid;	
	}

}
