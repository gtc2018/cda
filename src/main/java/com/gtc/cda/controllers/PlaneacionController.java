package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
import com.gtc.cda.models.Empresa;
import com.gtc.cda.models.Epica;
import com.gtc.cda.models.Planeacion;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.models.Requerimiento;
import com.gtc.cda.services.PlaneacionService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")
@RequestMapping(value ="/Planeacion")
@RestController
public class PlaneacionController {

	@Autowired
	protected PlaneacionService planeacionService;
	
	protected ObjectMapper mapper;
	
	/**
	 * 	Metodo consultar Epicas 
	 * @return
	 */
	@RequestMapping( method = RequestMethod.GET)
	public List<Planeacion> getAllPlaneacion(){
		return  this.planeacionService.findAll();
		
	}
	

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity saveOrUpdatePlaneacion(@RequestBody String planeacionJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		try {					
				this.mapper = new ObjectMapper();
				
				Planeacion planeacion = this.mapper.readValue(planeacionJson, Planeacion.class);// Se mapea epica con respecto al modelo

				//Generacion fecha creacion
				FormatoFecha fecha = new FormatoFecha();
				Date fech = new Date();
				
				//Se setea la fecha de creación o modificación según corresponda.
				if(planeacion.getId() ==null ) {
					planeacion.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
				}
				else {
				//Seteo la fecha de modificacion al campo fechaModificacion.
					planeacion.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
				}
				

				if (planeacion.getClienteId() != null ) {
			    	
					
		        	Empresa empresa = new Empresa();
					
		        	empresa.setId(new Long(planeacion.getClienteId()));
		        	
		        	planeacion.setCliente(empresa);
					
			    }
			     
			    
			    if (planeacion.getProyectoId() != null ) {
			    	
					
		        	Proyecto proyecto = new Proyecto();
					
		        	proyecto.setId(new Long(planeacion.getProyectoId()));
		        	
		        	planeacion.setProyecto(proyecto);
					
			    }
			    
			    if (planeacion.getRequerimientoId() != null ) {
			    	
					
		        	Requerimiento requerimiento = new Requerimiento();
					
		        	requerimiento.setId(new Long(planeacion.getRequerimientoId()));
		        	
		        	planeacion.setRequerimiento(requerimiento);
					
			    }
			    
			    if (planeacion.getEpicaId() != null ) {
			    	
					
		        	Epica epica = new Epica();
					
		        	epica.setId(new Long(planeacion.getEpicaId()));
		        	
		        	planeacion.setEpica(epica);
					
			    }
			        
			        
			     this.planeacionService.save(planeacion);
			        
			     return (ResponseEntity) ResponseEntity.ok(planeacion);
			        
			        
			        
			} catch(Exception e) {
					
				return (ResponseEntity) ResponseEntity.badRequest().body(e);
					
			}
		
	}
	
	/**
	 * Metodo Eliminar Requerimiento.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public RestResponse deletePlaneacion(@PathVariable(value="id") Long id) throws Exception{
		
		this.planeacionService.deletePlaneacion(id);
		
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
}
