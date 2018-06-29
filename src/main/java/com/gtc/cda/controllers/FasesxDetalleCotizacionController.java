package com.gtc.cda.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.gtc.cda.models.FasesxCotizacion;
import com.gtc.cda.models.FasesxDetalleCotizacion;
import com.gtc.cda.services.FasesxDetalleCotizacionService;
import com.gtc.cda.services.PorcentajePorFasesService;

@CrossOrigin(origins="*")
@RequestMapping(value ="/FasesxDetalleCotizacion")
@RestController
public class FasesxDetalleCotizacionController {
	
	@Autowired
	protected FasesxDetalleCotizacionService fasesxDetalleCotizacionService;
	
	@Autowired
	protected PorcentajePorFasesService porcentajePorFasesService;
	
	protected ObjectMapper mapper;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<FasesxDetalleCotizacion> getAll(@RequestParam("id") Long id){
		
		return  this.fasesxDetalleCotizacionService.findByDetailQuotationId(id);
	
		
	}
	
	@RequestMapping(value ="/getAllFasesxCotizacion", method = RequestMethod.GET)
	public ResponseEntity<List<FasesxCotizacion>> getAllFasesxCotización(@RequestParam("id") Long id){
		
		try {
			
			List<FasesxCotizacion> fasesxDetalleCotizacion =  this.fasesxDetalleCotizacionService.getAllFasesxCotizacion(id);
		
		return  ResponseEntity.ok(fasesxDetalleCotizacion);
		
		}catch(Exception e) {
			
			return (ResponseEntity) ResponseEntity.badRequest().body(e);			
			
		}
			
	}

	
	//Para guardar o actualizar
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity Save(@RequestBody FasesxDetalleCotizacion fasesxDetalleCotizacionJson )
			throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		try {
			
			this.fasesxDetalleCotizacionService.save(fasesxDetalleCotizacionJson);
			
			
			
			try {
				
				this.porcentajePorFasesService.updateTotal(new Long(fasesxDetalleCotizacionJson.getDetalleCotizacionId()));
				
				return  (ResponseEntity) ResponseEntity.ok("");
				
			}catch(Exception e) {
				
				return  (ResponseEntity) ResponseEntity.badRequest().body("Error al actualizar las horas totales de la cotización");
			}
			
			
			
		    }
		
		catch(Exception e) {
			
					
			return  (ResponseEntity) ResponseEntity.badRequest().body(e);
			
		}
		
		
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCotizacion(@PathVariable(value="id") Long id) throws Exception{
		
		try {
			
			int detalleId = this.fasesxDetalleCotizacionService.findOne(id).getDetalleCotizacionId();
		
		    this.fasesxDetalleCotizacionService.delete(id);
		
		try {
			
			this.porcentajePorFasesService.updateTotal(new Long(detalleId));
			
		}catch(Exception e) {
			
			return  (ResponseEntity) ResponseEntity.badRequest().body("Error al actualizar las horas totales de la cotización");
		}		

		return  (ResponseEntity) ResponseEntity.ok("");
		
		 
		} catch(Exception e) {
			
			return (ResponseEntity) ResponseEntity.badRequest().body(e);
			
		}
		
	}
	
	
	
	
	
	
	
}
