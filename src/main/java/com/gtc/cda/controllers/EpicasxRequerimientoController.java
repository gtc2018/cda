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
import com.gtc.cda.models.EpicasxRequerimiento;
import com.gtc.cda.models.HerramientasxCotizacion;
import com.gtc.cda.services.EpicasxRequerimientoService;
import com.gtc.cda.services.HerramientasxCotizacionService;

@CrossOrigin(origins="*")
@RequestMapping(value ="/EpicsXRequest")
@RestController
public class EpicasxRequerimientoController {

	@Autowired
	protected EpicasxRequerimientoService epicasxRequerimientoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<EpicasxRequerimiento> getAllEpics(@RequestParam("id") int requerimientoId){
		
		return  this.epicasxRequerimientoService.findAllForRequest(requerimientoId);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateEpicsxRequest(@RequestParam("requestId") int RequestId,@RequestBody Iterable<EpicasxRequerimiento> epicasxRequerimientoJson)
			throws JsonParseException, JsonMappingException, IOException{
		
		try{
			
		Iterable<EpicasxRequerimiento> epicasxRequerimientoForDelete = this.epicasxRequerimientoService.findAllForRequest(RequestId);
		
		if (!String.valueOf(epicasxRequerimientoForDelete).equals("[]")) {
		
		this.epicasxRequerimientoService.deleteAllByRequest(epicasxRequerimientoForDelete);
		
		}
		this.epicasxRequerimientoService.save(epicasxRequerimientoJson);
		
		return (ResponseEntity) ResponseEntity.ok().body("");
		
		}catch(Exception e){
			
			System.out.println(e);
			
			return (ResponseEntity) ResponseEntity.badRequest().body("Error al insertar los involucrados");
		}
		
	}
}
