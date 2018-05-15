package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.gtc.cda.models.Requerimiento;
import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.Involucrado;
import com.gtc.cda.services.InvolucradoService;
import com.gtc.cda.util.RestResponse;


@CrossOrigin(origins="*")
@RestController

public class InvolucradoController {
	
	@Autowired
	protected InvolucradoService involucradoService;
	
	protected ObjectMapper mapper;
	
	// Guardar o Editar
	@RequestMapping(value ="/saveOrUpdateInvolucrado", method = RequestMethod.POST)
	public RestResponse saveOrUpdateInvolucrado(@RequestBody String involucradoJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		Involucrado involucrado = this.mapper.readValue(involucradoJson, Involucrado.class);// Se mapea requerimiento con respecto al modelo
		
		//Se ejecuta las validaciones
		if (!this.validate(involucrado)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		//Generacion fecha creacion
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		//seteo la fecha de creacion al campo fechaCreacion.
		if(involucrado.getId() ==null ) {
			involucrado.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
			involucrado.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
			involucrado.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		//Valida la entrada de los datos por estructura
		if (involucrado.getEmpleadoId() != null | involucrado.getRequerimientoId() != null) {
		
			Empleado empleado = new Empleado();//Variable de empleado
			
			Requerimiento requerimiento = new Requerimiento();//Variable de requerimiento
			
	        //Se le pasan las variables del arreglo a las variables ---------------------------------------------------------
			empleado.setId(new Long(involucrado.getEmpleadoId()));
			
			requerimiento.setId(new Long(involucrado.getRequerimientoId()));
			
			// Se le setean las variables al arreglo --------------------------------------------------------------------------
			involucrado.setEmpleado(empleado);
			
			involucrado.setRequerimiento(requerimiento);
			
			this.involucradoService.save(involucrado);// Ejecuta el servicio para guardar el arreglo

			return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");//Retorna una respuesta exitosa
			
		}else {
			
		this.involucradoService.save(involucrado);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
		}
	}
	
	
	/**
	 * Metodo consultar todos los involucrados.
	 * @return
	 */
	@RequestMapping(value ="/getAllInvolucrado", method = RequestMethod.GET)
	public List<Involucrado> getAllInvolucrado(){
		
		return  this.involucradoService.findAll();// Regresa todos los involucrados
		
	}
	
	/**
	 * Metodo Obtener  el involucrado por ID.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getInvolucrado", method = RequestMethod.POST)
	public Involucrado getInvolucradoById(@RequestBody String id) throws Exception {

		this.mapper = new ObjectMapper();
		
		Involucrado involucrado = this.mapper.readValue(id, Involucrado.class);
		
		//Se asegura que el ID no sea nulo
		if(involucrado.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		if (this.involucradoService.findByInvolucradoId(involucrado.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.involucradoService.findByInvolucradoId(involucrado.getId()) ;
		} 

	}
	
	/**
	 * Metodo Eliminar involucrado.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteInvolucrado", method = RequestMethod.POST)
	public RestResponse deleteInvolucrado(@RequestBody String usuarioJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Involucrado involucrado = this.mapper.readValue(usuarioJson, Involucrado.class);
		
		if(involucrado.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo ID no puede ser nulo");
		}
		
		this.involucradoService.deleteInvolucrado(involucrado.getId());
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}

	/**
	 * Metodo de VALIDACIONES.
	 */
	private boolean validate(Involucrado involucrado) {
		
		boolean isValid = true;
				
		return isValid;
		
	}
	

}
