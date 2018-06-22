package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.models.Area;
import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.models.Fase;
import com.gtc.cda.models.Permiso;
import com.gtc.cda.models.PorcentajePorFase;
import com.gtc.cda.services.PorcentajePorFasesService;
import com.gtc.cda.util.RestResponse;


@CrossOrigin(origins="*")
@RestController

public class PorcentajePorFasesController {
	
	@Autowired
	protected PorcentajePorFasesService porcentajePorFasesService;
	
	protected ObjectMapper mapper;
	
	// Guardar o Editar
	@RequestMapping(value ="/saveOrUpdatePorcentajePorFase", method = RequestMethod.POST)
	public RestResponse saveOrUpdatePorcentajePorFase(@RequestBody String porcentajePorFaseJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		PorcentajePorFase porcentajePorFase = this.mapper.readValue(porcentajePorFaseJson, PorcentajePorFase.class);// Se mapea porcentajePorFase con respecto al modelo
		
		//Se ejecuta las validaciones
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
		porcentajePorFase.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
		porcentajePorFase.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		//Valida la entrada de los datos por estructura
		if (porcentajePorFase.getClienteId() != null | porcentajePorFase.getFasesId() != null) {
		
		    Empresa empresa = new Empresa();// Variable de empresa
	        
	        Fase fases = new Fase();//Variable de fase
			
			empresa.setId(new Long(porcentajePorFase.getClienteId()));// Setea el id que viene del campo ClienteId a la variable empresa
			
			porcentajePorFase.setCliente(empresa);//Setea la empresa al cliente
			
			fases.setId(new Long(porcentajePorFase.getFasesId()));//Setea el ID que viene del campo FasesId a la variable fases
			
			porcentajePorFase.setFases(fases);//Setea fases a las fases del arreglo
			
			this.porcentajePorFasesService.save(porcentajePorFase);// Ejecuta el servicio para guardar el arreglo

			return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa"); // Se retorna una respuesta exitosa
			
		}else {
			
		this.porcentajePorFasesService.save(porcentajePorFase);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
		}
	}
	
	
	/**
	 * Metodo consultar todos los porcentajes.
	 * @return
	 */
	@RequestMapping(value ="/getAllPorcentajePorFase", method = RequestMethod.GET)
	public List<PorcentajePorFase> getAllPorcentajePorFase(){
		
		return  this.porcentajePorFasesService.findAll();// Regresa todos los porcentajesPorFases
		
	}
	
	/**
	 * Metodo Obtener Porcentaje por ID.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getPorcentajePorFasesById", method = RequestMethod.POST)
	public PorcentajePorFase getPorcentajePorFasesById(@RequestBody String id) throws Exception {

		this.mapper = new ObjectMapper();
		
		PorcentajePorFase porcentajePorFase = this.mapper.readValue(id, PorcentajePorFase.class);
		
		//Se asegura que el ID no sea nulo
		if(porcentajePorFase.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		if (this.porcentajePorFasesService.findByPorcentajePorFaseId(porcentajePorFase.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.porcentajePorFasesService.findByPorcentajePorFaseId(porcentajePorFase.getId()) ;
		} 

	}
	
	/**
	 * Metodo Obtener Porcentaje por ID de la empresa.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAllPorcentajeEmpresa", method = RequestMethod.POST)
	public List<PorcentajePorFase> getPorcentajePorFasesYEmpresa(@RequestBody String cliente) throws Exception {

		this.mapper = new ObjectMapper();
		
		PorcentajePorFase porcentajePorFase = this.mapper.readValue(cliente, PorcentajePorFase.class);
		
		if(porcentajePorFase.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.porcentajePorFasesService.findByPorcentajePorFaseYEmpresa(porcentajePorFase.getId()) == null) {
			
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.porcentajePorFasesService.findByPorcentajePorFaseYEmpresa(porcentajePorFase.getId());
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
				
		return isValid;
		
	}
	
	//Metodo para traer las fases de porcentaje por fase asociadas a una empresa y que esten en una tabla diferente a fases por detalle cotizacion
	
	@RequestMapping(value = "/PorcentajePorFase/getFasesxEmpresa/{id}/{detailId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getFasesporEmpresa(@PathVariable(value="id") Long id,@PathVariable(value="detailId") Long detailId) throws Exception {
		
		try {
			
			List<PorcentajePorFase> porcentajePorFase = this.porcentajePorFasesService.findFasesxEmpresaInPorcentajeFases(id,detailId);
			
			return ResponseEntity.ok(porcentajePorFase);		
			
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e);
		}

	}
	

}
