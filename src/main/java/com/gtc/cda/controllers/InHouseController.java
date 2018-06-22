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
import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.models.InHouse;
//import com.gtc.cda.models.Empresa;
import com.gtc.cda.services.InHouseService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class InHouseController {
	
	@Autowired
	protected InHouseService inHouseService;
	
	protected ObjectMapper mapper;
	
	/**
	 * 
	 * @param InHouseJson
	 * @return 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException 
	 */
	// Guardar o Editar
	@RequestMapping(value ="/saveOrUpdateInHouse", method = RequestMethod.POST)
	public RestResponse saveOrUpdateInHouse(@RequestBody String inHouseJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		
		this.mapper = new ObjectMapper();
		
		InHouse inHouse = this.mapper.readValue(inHouseJson, InHouse.class);
		
		if (!this.validate(inHouse)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}	
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(inHouse.getId() ==null ) {
			inHouse.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
			inHouse.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
			inHouse.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		if(inHouse.getEmpleadoId() != null | inHouse.getClienteId() != null ) {
		
			Empresa empresa = new Empresa();
			Empleado empleado = new Empleado();
			
			empresa.setId(new Long(inHouse.getClienteId()));
			empleado.setId(new Long(inHouse.getEmpleadoId()));
			
			inHouse.setCliente(empresa);
			inHouse.setEmpleado(empleado);
		}
		
		this.inHouseService.save(inHouse);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar InHouse
	 * @param inHouseJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteInHouse", method = RequestMethod.POST)
	public RestResponse deleteInHouse(@RequestBody String inHouseJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		InHouse inHouse = this.mapper.readValue(inHouseJson, InHouse.class);
		
		if(inHouse.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.inHouseService.deleteInHouse(inHouse.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar el empleado en InHouse
	 * @param inHouseJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/getInHouseByEmployee", method = RequestMethod.POST)
	public List<InHouse> getInHouseByEmployee(@RequestBody String inHouseJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		InHouse inHouse = this.mapper.readValue(inHouseJson, InHouse.class);
		
			
		return this.inHouseService.getInHouseByEmployee(inHouse.getId());
	}
	
	/**
	 * Metodo consultar el empleado inHouse por fechas
	 * @param inHouseJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/getInHouseByDate", method = RequestMethod.POST)
	public List<InHouse> getInHouseByDate(@RequestBody String inHouseJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		InHouse inHouse = this.mapper.readValue(inHouseJson, InHouse.class);
		
			
		return this.inHouseService.getInHouseByDate(inHouse.getDesde(), inHouse.getHasta());
	}
	
	/**
	 * Metodo consultar inHouse
	 * @return
	 */
	@RequestMapping(value ="/getAllInHouse", method = RequestMethod.GET)
	public List<InHouse> getAllInHouse(){
		return  this.inHouseService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener InHouse por ID.
	 * @param inHouseJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getFindByInHouseId", method = RequestMethod.POST)
	public InHouse findByInHouseId(@RequestBody String inHouseId) throws Exception {

		this.mapper = new ObjectMapper();
			
		InHouse inHouse = this.mapper.readValue(inHouseId, InHouse.class);
	
		if(inHouse.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.inHouseService.findByInHouseId(inHouse.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.inHouseService.findByInHouseId(inHouse.getId()) ;
		} 

	}
	
//	/**
//	 * Metodo Obtener InHouses por ID de empresa.
//	 * @param InHouseJson
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/getAllAreasToEnterprise", method = RequestMethod.POST)
//	public List<Area> getAllAreasToEnterprise(@RequestBody String areaId) throws Exception {
//
//		this.mapper = new ObjectMapper();
//			
//		Empresa empresa = this.mapper.readValue(areaId, Empresa.class);
//	
//		if(empresa.getId() == null){
//			
//			throw new Exception("El ID no puede ser nulo.");
//		}
//		
//		// Se valida la existencia del registro
//		
//		if (this.areaService.getAllAreasToEnterprise(empresa.getId()) == null) {
//			throw new Exception("No existen registros con este ID");
//		}
//		else {
//			 			
//			return this.areaService.getAllAreasToEnterprise(empresa.getId()) ;
//		} 
//
//	}
	
	// Validaciones
	private boolean validate(InHouse inHouse) {		
		boolean isValid = true;			
		

		return isValid;	
	}

}
