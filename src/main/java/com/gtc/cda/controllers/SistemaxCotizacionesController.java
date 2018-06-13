package com.gtc.cda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gtc.cda.models.Cotizacion;
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
	public List<SistemasxCotizaciones> getAllCotizacion(){
		
		return  this.sistemasxCotizacionesService.findAll();// Regresa todas las cotizaciones
		
	}
	
	

}
