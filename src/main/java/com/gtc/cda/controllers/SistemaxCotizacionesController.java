package com.gtc.cda.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gtc.cda.models.AsociarProyecto;
import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.HerramientasxCotizacion;
import com.gtc.cda.models.SistemasxCotizaciones;
import com.gtc.cda.services.CotizacionService;
import com.gtc.cda.services.SistemasxCotizacionesService;

/**
 * Controlador Asociar Proyecto, esta clase controla los servicios expuestos
 * de la entidad Asociar proyectos.
 * @author Santiago Carrillo
 *
 */

@CrossOrigin(origins="*")
@RequestMapping(value ="/SystemsXQuotation")
@RestController

public class SistemaxCotizacionesController {
	
	@Autowired
	protected SistemasxCotizacionesService sistemasxCotizacionesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<SistemasxCotizaciones> getAllTools(@RequestParam("id") int quotationId){
		
		return  this.sistemasxCotizacionesService.findAllForQuotation(quotationId);
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateAsociarProyecto(@RequestParam("quotationId") int QuotationId,@RequestBody Iterable<SistemasxCotizaciones> sistemasxCotizacionesJson) throws JsonParseException, JsonMappingException, IOException{
		
		try{
			
		Iterable<SistemasxCotizaciones> sistemasxCotizacionesForDelete = this.sistemasxCotizacionesService.findAllForQuotation(QuotationId);
		
		if (!String.valueOf(sistemasxCotizacionesForDelete).equals("[]")) {
		
		this.sistemasxCotizacionesService.deleteAllByQuotation(sistemasxCotizacionesForDelete);
		
		}
		this.sistemasxCotizacionesService.save(sistemasxCotizacionesJson);
		
		return (ResponseEntity) ResponseEntity.ok().body("");
		
		}catch(Exception e){
			
			System.out.println(e);
			
			return (ResponseEntity) ResponseEntity.badRequest().body("Error al insertar los involucrados");
		}
	}
	
	

}
