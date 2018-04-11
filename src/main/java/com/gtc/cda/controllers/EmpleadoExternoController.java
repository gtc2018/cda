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
import com.gtc.cda.models.EmpleadoExterno;
import com.gtc.cda.services.EmpleadoExternoService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")
@RestController
public class EmpleadoExternoController {
	
	@Autowired
	protected EmpleadoExternoService empleadoExternoService;
	
	protected ObjectMapper mapper;
	
	/**
	 * 
	 * @param empleadoExternoJson
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value ="/saveOrUpdateEmpleadoExterno", method = RequestMethod.POST)
	public RestResponse saveOrUpdateEmpleadoExterno(@RequestBody String empleadoExternoJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		EmpleadoExterno empleadoExterno = this.mapper.readValue(empleadoExternoJson, EmpleadoExterno.class);
		
		if (!this.validate(empleadoExterno)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		empleadoExterno.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		
		this.empleadoExternoService.save(empleadoExterno);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * 	Metodo consultar Empleados Externos
	 * @return
	 */
	@RequestMapping(value ="/getAllEmpleadoExterno", method = RequestMethod.GET)
	public List<EmpleadoExterno> getAllEmpleadoExterno(){
		return  this.empleadoExternoService.findAll();
		
	}
	
	
	@RequestMapping(value ="/deleteEmpleadoExterno", method = RequestMethod.POST)
	public void deleteEmpleadoExterno(@RequestBody String empleadoExternoJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		EmpleadoExterno empleadoExterno = this.mapper.readValue(empleadoExternoJson, EmpleadoExterno.class);
		
		if(empleadoExterno.getId() == null){
			throw new Exception("El ID no puede ser nulo.");
		}
		
		this.empleadoExternoService.deleteEmpleadoExterno(empleadoExterno.getId());
		
	}
	
	
	@RequestMapping(value = "/getEmpleadoExtremoById", method = RequestMethod.POST)
	public EmpleadoExterno  getEmpleadoExtremoById(@RequestBody String rolId) throws Exception {

		this.mapper = new ObjectMapper();
			
		EmpleadoExterno empleadoExterno = this.mapper.readValue(rolId, EmpleadoExterno.class);
		
		return this.empleadoExternoService.findByEmpleadoId(empleadoExterno.getId());

	}
	
	
	
	/**
	 * 
	 * @param empleadoExterno
	 * @return
	 */
	private boolean validate(EmpleadoExterno empleadoExterno) {
		
		boolean isValid = true;
		
		if (StringUtils.trimToNull(empleadoExterno.getNombres()) == null ) {

			isValid = false;

		}
		
		if (StringUtils.trimToNull(empleadoExterno.getApellidos()) == null ) {

			isValid = false;

		}
		
		return isValid;
		
	}

}
