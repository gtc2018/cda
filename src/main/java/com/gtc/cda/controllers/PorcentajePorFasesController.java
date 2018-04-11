package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
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
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.models.PorcentajePorFase;
import com.gtc.cda.services.PorcentajePorFasesService;
import com.gtc.cda.util.RestResponse;

@RestController
public class PorcentajePorFasesController {
	
	@Autowired
	protected PorcentajePorFasesService porcentajePorFasesService;
	
	protected ObjectMapper mapper;
	
	
	@RequestMapping(value ="/saveOrUpdatePorcentajePorFase", method = RequestMethod.POST)
	public RestResponse saveOrUpdatePorcentajePorFase(@RequestBody String porcentajePorFaseJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		PorcentajePorFase porcentajePorFase = this.mapper.readValue(porcentajePorFaseJson, PorcentajePorFase.class);
		
		if (!this.validate(porcentajePorFase)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		//Generacion fecha creacion
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		//seteo la fecha de creacion al campo fechaCreacion.
		if(porcentajePorFase.getId() ==null ) {
		porcentajePorFase.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		porcentajePorFase.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		this.porcentajePorFasesService.save(porcentajePorFase);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	
	/**
	 * Metodo consultar todos los porcentajes.
	 * @return
	 */
	@RequestMapping(value ="/getAllPorcentajePorFase", method = RequestMethod.GET)
	public List<PorcentajePorFase> getAllPorcentajePorFase(){
		
		return  this.porcentajePorFasesService.findAll();
		
	}
	
	/**
	 * Metodo Obtener Porcentaje por ID.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getPorcentajePorFasesById", method = RequestMethod.POST)
	public PorcentajePorFase getPorcentajePorFasesById(@RequestBody String clienteId) throws Exception {

		this.mapper = new ObjectMapper();
			
		PorcentajePorFase porcentajePorFases = this.mapper.readValue(clienteId, PorcentajePorFase.class);
	
		if(porcentajePorFases.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.porcentajePorFasesService.findByPorcentajePorFaseId(porcentajePorFases.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.porcentajePorFasesService.findByPorcentajePorFaseId(porcentajePorFases.getId());
		} 

	}
	
	/**
	 * Metodo Eliminar Porcentajes.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deletePorcentajePorFase", method = RequestMethod.POST)
	public RestResponse deletePorcentajePorFase(@RequestBody String usuarioJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		PorcentajePorFase porcentajePorFase = this.mapper.readValue(usuarioJson, PorcentajePorFase.class);
		
		if(porcentajePorFase.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo ID no puede ser nulo");
		}
		
		this.porcentajePorFasesService.deletePorcentajePorFase(porcentajePorFase.getId());
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}

	/**
	 * Metodo de VALIDACIONES.
	 */
	private boolean validate(PorcentajePorFase porcentajePorFases) {
		
		boolean isValid = true;
		
		if (porcentajePorFases.getClienteId() == null ) {

			isValid = false;

		}
		
		if (porcentajePorFases.getPorcentaje() == null ) {

			isValid = false;

		}
		
		if (StringUtils.trimToNull(porcentajePorFases.getEtapa()) == null ) {

			isValid = false;

		}
		
		return isValid;
		
	}
	

}
