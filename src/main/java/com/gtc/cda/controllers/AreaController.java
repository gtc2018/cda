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
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
import com.gtc.cda.models.Area;

import com.gtc.cda.models.Empresa;
//import com.gtc.cda.models.Empresa;
import com.gtc.cda.services.AreaService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class AreaController {
	
	@Autowired
	protected AreaService areaService;
	
	protected ObjectMapper mapper;
	
	/**
	 * 
	 * @param areaJson
	 * @return 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException 
	 */
	// Guardar o Editar
	@RequestMapping(value ="/saveOrUpdateArea", method = RequestMethod.POST)
	public RestResponse saveOrUpdateArea(@RequestBody String areaJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		
		this.mapper = new ObjectMapper();
		
		Area area = this.mapper.readValue(areaJson, Area.class);
		
		if (!this.validate(area)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}	
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(area.getId() ==null ) {
		area.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		area.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
		area.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		Empresa empresa = new Empresa();
		
		empresa.setId(new Long(area.getClienteId()));
		
		area.setCliente(empresa);
		
		this.areaService.save(area);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar Area
	 * @param areaJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteArea", method = RequestMethod.POST)
	public RestResponse deleteArea(@RequestBody String areaJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Area area = this.mapper.readValue(areaJson, Area.class);
		
		if(area.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.areaService.deleteArea(area.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar areas
	 * @return
	 */
	@RequestMapping(value ="/getAllAreas", method = RequestMethod.GET)
	public List<Area> getAllArea(){
		return  this.areaService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener Areas por ID.
	 * @param areaJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getFindByAreaId", method = RequestMethod.POST)
	public Area findByAreaId(@RequestBody String areaId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Area area = this.mapper.readValue(areaId, Area.class);
	
		if(area.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.areaService.findByAreaId(area.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.areaService.findByAreaId(area.getId()) ;
		} 

	}
	
	/**
	 * Metodo Obtener Areas por ID de empresa.
	 * @param areaJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAllAreasToEnterprise", method = RequestMethod.POST)
	public List<Area> getAllAreasToEnterprise(@RequestBody String areaId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Empresa empresa = this.mapper.readValue(areaId, Empresa.class);
	
		if(empresa.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.areaService.getAllAreasToEnterprise(empresa.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.areaService.getAllAreasToEnterprise(empresa.getId()) ;
		} 

	}
	
	// Validaciones
	private boolean validate(Area area) {		
		boolean isValid = true;			
		
		if (area.getDescripcion() == null ) {

			isValid = false;

		}
		return isValid;	
	}

}
