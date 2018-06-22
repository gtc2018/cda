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
	
	/**
	 * Metodo consultar todos los detalles cotizaciones.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllDetalleCotizacion(@RequestParam("id") Long id){
		
		try {
		
		return  ResponseEntity.ok(this.detalleCotizacionService.findAllForCotizacion(id));
		
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e);			
			
		}
		
	}
	
	/**
	 * Metodo Obtener  el detalle de cotizacion por ID.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getDetalleCotizacionById(@PathVariable(value="id") Long id) throws Exception {
		
		DetalleCotizacion detalleCotizacion =  this.detalleCotizacionService.findByDetalleCotizacionId(id);		
		
		try {
			
			return ResponseEntity.ok(detalleCotizacion);
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e);
			
		}

	}
	
	
	// Guardar o Editar
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity saveOrUpdateDetalleCotizacion(@RequestBody String detalleCotizacionJson)
				throws JsonParseException, JsonMappingException, IOException, ParseException{
			
			try {
				
			this.mapper = new ObjectMapper();
			
			DetalleCotizacion detalleCotizacion = this.mapper.readValue(detalleCotizacionJson, DetalleCotizacion.class);// Se mapea requerimiento con respecto al modelo
			
			//Generacion fecha creacion
			FormatoFecha fecha = new FormatoFecha();
			Date fech = new Date();
			
			//seteo la fecha de creacion al campo fechaCreacion.
			if(detalleCotizacion.getId() == null ) {
				
				detalleCotizacion.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
			}
			else {
			//Seteo la fecha de modificacion al campo fechaModificacion.
				detalleCotizacion.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
				
			}
			
			this.detalleCotizacionService.save(detalleCotizacion);// Ejecuta el servicio para guardar el arreglo
			
			return ResponseEntity.ok(detalleCotizacion);//Retorna una respuesta exitosa
				
			}catch(Exception e) {
				
				return ResponseEntity.badRequest().body(e);
			}
		}
	
	/**
	 * Metodo Eliminar detalle de cotizacion.
	 */
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteDetalleCotizacion(@PathVariable(value="id") Long id) throws Exception{
		
		try {
		
		this.detalleCotizacionService.deleteDetalleCotizacion(id);
		return ResponseEntity.ok("");
		
		}catch (Exception e) {
			
			return ResponseEntity.badRequest().body(e);		
			
		}
		
	}

}
