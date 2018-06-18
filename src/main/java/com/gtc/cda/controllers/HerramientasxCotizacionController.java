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
import com.gtc.cda.services.HerramientasxCotizacionService;
import com.gtc.cda.services.SistemasxCotizacionesService;

/**
 * Controlador Herramientas por cotizacion, esta clase controla los servicios expuestos
 * de la entidad Herramientas por cotizacion.
 * @author Santiago Carrillo
 *
 */

@CrossOrigin(origins="*")
@RequestMapping(value ="/ToolsXQuotation")
@RestController

public class HerramientasxCotizacionController {
	
	@Autowired
	protected HerramientasxCotizacionService herramientasxCotizacionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<HerramientasxCotizacion> getAllTools(@RequestParam("id") int quotationId){
		
		return  this.herramientasxCotizacionService.findAllForQuotation(quotationId);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateToolsxQuotation(@RequestParam("quotationId") int QuotationId,@RequestBody Iterable<HerramientasxCotizacion> herramientasxCotizacionJson)
			throws JsonParseException, JsonMappingException, IOException{
		
		try{
			
		Iterable<HerramientasxCotizacion> herramientasxCotizacionForDelete = this.herramientasxCotizacionService.findAllForQuotation(QuotationId);
		
		if (!String.valueOf(herramientasxCotizacionForDelete).equals("[]")) {
		
		this.herramientasxCotizacionService.deleteAllByQuotation(herramientasxCotizacionForDelete);
		
		}
		this.herramientasxCotizacionService.save(herramientasxCotizacionJson);
		
		return (ResponseEntity) ResponseEntity.ok().body("");
		
		}catch(Exception e){
			
			System.out.println(e);
			
			return (ResponseEntity) ResponseEntity.badRequest().body("Error al insertar los involucrados");
		}
		
	}
	
	

}
