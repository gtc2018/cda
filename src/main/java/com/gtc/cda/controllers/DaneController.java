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
import com.gtc.cda.models.Dane;
import com.gtc.cda.services.DaneService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class DaneController {
	
	@Autowired
	protected DaneService daneService;
	
	protected ObjectMapper mapper;
	
	/**
	 * Metodo Obtener Paises.
	 * @param pais
	 * @throws Exception
	 */
	@RequestMapping(value = "/getCountry", method = RequestMethod.GET)
	public List<Dane> getCountry(){	 			
		return this.daneService.findCountry() ;
		 

	}
	
	/**
	 * Metodo Obtener Departamentos.
	 * @param areaJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDeparment", method = RequestMethod.POST)
	public List<Dane> getDeparment(@RequestBody String departamento) throws Exception {

		this.mapper = new ObjectMapper();
			
		Dane dane = this.mapper.readValue(departamento, Dane.class);
			 			
		return this.daneService.findDeparment(dane.getId()) ;
		 

	}
	
	/**
	 * Metodo Obtener Ciudades.
	 * @param areaJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getCity", method = RequestMethod.POST)
	public List<Dane> getCity(@RequestBody String ciudad) throws Exception {

		this.mapper = new ObjectMapper();
			
		Dane dane = this.mapper.readValue(ciudad, Dane.class);
			 			
		return this.daneService.findCity(dane.getId()) ;
		 
	}
	
	
	// Validaciones
	private boolean validate(Dane dane) {		
		boolean isValid = true;			

		return isValid;	
	}

}
