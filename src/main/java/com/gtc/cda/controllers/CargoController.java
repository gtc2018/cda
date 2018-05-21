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
import com.gtc.cda.models.Cargo;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.services.CargoService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class CargoController {
	
	@Autowired
	protected CargoService cargoService;
	
	protected ObjectMapper mapper;
	
	/**
	 * Metodo Guardar o Editar Cargo
	 * @param cargoJson
	 * @throws ParseException 
	 * @throws Exception
	 */
	@RequestMapping(value ="/saveOrUpdateCargo", method = RequestMethod.POST)
	public RestResponse saveOrUpdateCargo(@RequestBody String cargoJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		Cargo cargo = this.mapper.readValue(cargoJson, Cargo.class);
		
		if (!this.validate(cargo)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(cargo.getId() ==null ) {
		cargo.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		cargo.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
		cargo.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
        Empresa empresa = new Empresa();
		
		System.out.println("aqui viene cliente id " + cargo.getClienteId());
		
		empresa.setId(new Long(cargo.getClienteId()));
		
		cargo.setCliente(empresa);
		
		this.cargoService.save(cargo);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar Cargo
	 * @param cargoJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteCargo", method = RequestMethod.POST)
	public RestResponse deleteCargo(@RequestBody String cargoJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Cargo cargo = this.mapper.readValue(cargoJson, Cargo.class);
		
		if(cargo.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.cargoService.deleteCargo(cargo.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar Cargo
	 * @return
	 */
	@RequestMapping(value ="/getAllCargos", method = RequestMethod.GET)
	public List<Cargo> getAllCargo(){
		return  this.cargoService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener Cargos por ID.
	 * @param cargoJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/findByCargoId", method = RequestMethod.POST)
	public Cargo findOne(@RequestBody String cargoId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Cargo cargo = this.mapper.readValue(cargoId, Cargo.class);
	
		if(cargo.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.cargoService.findByCargoId(cargo.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.cargoService.findByCargoId(cargo.getId()) ;
		} 

	}
	
	/**
	 * Metodo Obtener Cargos por ID de empresa.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAllChargeToEnterprise", method = RequestMethod.POST)
	public List<Cargo> getAllChargeToEnterprise(@RequestBody String chargeId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Empresa empresa = this.mapper.readValue(chargeId, Empresa.class);
	
		if(empresa.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.cargoService.getAllChargeToEnterprise(empresa.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.cargoService.getAllChargeToEnterprise(empresa.getId()) ;
		} 

	}
	
	private boolean validate(Cargo cargo) {		
		boolean isValid = true;	
		
		if (cargo.getDescripcion() == null ) {

			isValid = false;

		}
		
		return isValid;	
	}

}
