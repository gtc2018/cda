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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.DetalleCotizacion;
import com.gtc.cda.services.DetalleCotizacionService;
import com.gtc.cda.util.RestResponse;


@CrossOrigin(origins="*")
@RequestMapping(value ="/DetailQuotation")
@RestController

public class DetalleCotizacionController {
	
	@Autowired
	protected DetalleCotizacionService detalleCotizacionService;
	
	protected ObjectMapper mapper;
	
	// Guardar o Editar
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateDetalleCotizacion(@RequestBody String detalleCotizacionJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		try {
			
		this.mapper = new ObjectMapper();
		
		DetalleCotizacion detalleCotizacion = this.mapper.readValue(detalleCotizacionJson, DetalleCotizacion.class);// Se mapea requerimiento con respecto al modelo
		
		//Generacion fecha creacion
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		//seteo la fecha de creacion al campo fechaCreacion.
		if(detalleCotizacion.getId() ==null ) {
			
			detalleCotizacion.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
			detalleCotizacion.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
			Cotizacion cotizacion = new Cotizacion();//Variable de cotizacion
			
	        //Se le pasan las variables del arreglo a las variables ---------------------------------------------------------
			cotizacion.setId(detalleCotizacion.getCotizacionId());
			
			// Se le setean las variables al arreglo --------------------------------------------------------------------------
			detalleCotizacion.setCotizacion(cotizacion);;
			
			this.detalleCotizacionService.save(detalleCotizacion);// Ejecuta el servicio para guardar el arreglo

			return ResponseEntity.ok(detalleCotizacion);//Retorna una respuesta exitosa
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e);
		}
	}
	
	
	/**
	 * Metodo consultar todos los detalles cotizaciones.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllDetalleCotizacion(@RequestParam("cotizacionId") Long cotizacionId){
		
		try {
		
		return  ResponseEntity.ok(this.detalleCotizacionService.findAllForCotizacion(cotizacionId));
		
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e);			
			
		}
		
	}
	
	/**
	 * Metodo Obtener  el detalle de cotizacion por ID.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDetalleCotizacion", method = RequestMethod.POST)
	public DetalleCotizacion getDetalleCotizacionById(@RequestBody String id) throws Exception {

		this.mapper = new ObjectMapper();
		
		DetalleCotizacion detalleCotizacion = this.mapper.readValue(id, DetalleCotizacion.class);
		
		//Se asegura que el ID no sea nulo
		if(detalleCotizacion.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		if (this.detalleCotizacionService.findByDetalleCotizacionId(detalleCotizacion.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.detalleCotizacionService.findByDetalleCotizacionId(detalleCotizacion.getId()) ;
		} 

	}
	
	/**
	 * Metodo Eliminar detalle de cotizacion.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteDetalleCotizacion", method = RequestMethod.POST)
	public RestResponse deleteDetalleCotizacion(@RequestBody String usuarioJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		DetalleCotizacion detalleCotizacion = this.mapper.readValue(usuarioJson, DetalleCotizacion.class);
		
		if(detalleCotizacion.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo ID no puede ser nulo");
		}
		
		this.detalleCotizacionService.deleteDetalleCotizacion(detalleCotizacion.getId());
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}

	/**
	 * Metodo de VALIDACIONES.
	 */
	private boolean validate(DetalleCotizacion detalleCotizacion) {
		
		boolean isValid = true;
				
		return isValid;
		
	}
	

}
