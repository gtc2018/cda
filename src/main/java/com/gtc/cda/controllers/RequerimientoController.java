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
import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.models.Estado;
import com.gtc.cda.models.Fase;
import com.gtc.cda.models.Permiso;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.models.Requerimiento;
import com.gtc.cda.services.RequerimientoService;
import com.gtc.cda.util.RestResponse;


@CrossOrigin(origins="*")
@RestController

public class RequerimientoController {
	
	@Autowired
	protected RequerimientoService requerimientoService;
	
	protected ObjectMapper mapper;
	
	// Guardar o Editar
	@RequestMapping(value ="/saveOrUpdateRequerimiento", method = RequestMethod.POST)
	public RestResponse saveOrUpdateRequerimiento(@RequestBody String requerimientoJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		
		
		Requerimiento requerimiento = this.mapper.readValue(requerimientoJson, Requerimiento.class);// Se mapea requerimiento con respecto al modelo
		//Se ejecuta las validaciones
		if (!this.validate(requerimiento)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		//Generacion fecha creacion
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		//seteo la fecha de creacion al campo fechaCreacion.
		if(requerimiento.getId() ==null ) {
			requerimiento.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
			requerimiento.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
			requerimiento.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		//Valida la entrada de los datos por estructura
		if (requerimiento.getClienteId() != null | requerimiento.getFaseId() != null
				| requerimiento.getProyectoId() != null | requerimiento.getEstadoId() != null
				| requerimiento.getCotizacionId() != null) {
		
		    Empresa empresa = new Empresa();// Variable de empresa
	        
	        Fase fases = new Fase();//Variable de fase
	       
	        Cotizacion cotizacion = new Cotizacion();//Variable de cotizacion
	        
	        Proyecto proyecto = new Proyecto();//Variable de proyecto
	        
	        Estado estado = new Estado();//Variable de estado
			
	        //Se le pasan las variables del arreglo a las variables ---------------------------------------------------------
			empresa.setId(new Long(requerimiento.getClienteId()));
			
			fases.setId(new Long(requerimiento.getFaseId()));
			
			cotizacion.setId(new Long(requerimiento.getCotizacionId()));
			
			proyecto.setId(new Long(requerimiento.getProyectoId()));
			
			estado.setId(new Long(requerimiento.getEstadoId()));
			
			// Se le setean las variables al arreglo --------------------------------------------------------------------------
			requerimiento.setCliente(empresa);
			
			requerimiento.setFase(fases);
			
			requerimiento.setCotizacion(cotizacion);;
			
			requerimiento.setProyecto(proyecto);;
			
			requerimiento.setEstado(estado);;
			
			this.requerimientoService.save(requerimiento);// Ejecuta el servicio para guardar el arreglo

			return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa"); // Se retorna una respuesta exitosa
			
		}else {
			
		this.requerimientoService.save(requerimiento);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
		}
	}
	
	
	/**
	 * Metodo consultar todos los requerimientos.
	 * @return
	 */
	@RequestMapping(value ="/getAllRequerimiento", method = RequestMethod.GET)
	public List<Requerimiento> getAllRequerimiento(){
		
		return  this.requerimientoService.findAll();// Regresa todos los requerimiento
		
	}
	
	/**
	 * Metodo Obtener Requerimientos por ID.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getRequerimiento", method = RequestMethod.POST)
	public Requerimiento getRequerimientoById(@RequestBody String id) throws Exception {

		this.mapper = new ObjectMapper();
		
		Requerimiento requerimiento = this.mapper.readValue(id, Requerimiento.class);
		
		//Se asegura que el ID no sea nulo
		if(requerimiento.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		if (this.requerimientoService.findByRequerimientoId(requerimiento.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.requerimientoService.findByRequerimientoId(requerimiento.getId()) ;
		} 

	}
	
	/**
	 * Metodo Eliminar Requerimiento.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteRequerimiento", method = RequestMethod.POST)
	public RestResponse deleteRequerimiento(@RequestBody String usuarioJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Requerimiento requerimiento = this.mapper.readValue(usuarioJson, Requerimiento.class);
		
		if(requerimiento.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo ID no puede ser nulo");
		}
		
		this.requerimientoService.deleteRequerimiento(requerimiento.getId());
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}

	/**
	 * Metodo de VALIDACIONES.
	 */
	private boolean validate(Requerimiento requerimiento) {
		
		boolean isValid = true;
				
		return isValid;
		
	}
	

}
