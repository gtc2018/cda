package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.models.Epica;
import com.gtc.cda.models.HerramientasxCotizacion;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.models.Requerimiento;
import com.gtc.cda.services.EpicaService;

@CrossOrigin(origins="*")
//@RequestMapping(value ="/Epics")
@RestController

public class EpicaController {
	
	@Autowired
	protected EpicaService epicaService;
	
	protected ObjectMapper mapper;
	
	/**
	 * 	Metodo guardar/editar Epica
	 * @return
	 */
	@RequestMapping(value ="/saveOrUpdateEpica", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateEpica(@RequestBody String epicaJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		try {					
				this.mapper = new ObjectMapper();
				
				Epica epica = this.mapper.readValue(epicaJson, Epica.class);// Se mapea epica con respecto al modelo

				//Generacion fecha creacion
				FormatoFecha fecha = new FormatoFecha();
				Date fech = new Date();
				
				//Se setea la fecha de creación o modificación según corresponda.
				if(epica.getId() ==null ) {
					epica.setFecha_creacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
				}
				else {
				//Seteo la fecha de modificacion al campo fechaModificacion.
					epica.setFecha_modificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
				}
				


			     
			    
			    if (epica.getProyectoId() != null ) {
			    	
					
		        	Proyecto proyecto = new Proyecto();
					
		        	proyecto.setId(new Long(epica.getProyectoId()));
		        	
		        	epica.setProyecto(proyecto);
					
			    }
			        
			        
			     this.epicaService.save(epica);
			        
			     return (ResponseEntity) ResponseEntity.ok(epica);
			        
			        
			        
			} catch(Exception e) {
					
				return (ResponseEntity) ResponseEntity.badRequest().body(e);
					
			}
		
	}
	
	/**
	 * 	Metodo consultar Epicas 
	 * @return
	 */
	@RequestMapping(value ="/getAllEpicas", method = RequestMethod.GET)
	public List<Epica> getAllEpica(){
		return  this.epicaService.findAll();
		
	}
	
	/**
	 * 	Metodo consultar Epicas por proyecto
	 * @return
	 */
	@RequestMapping(value ="/getAllEpicasProyecto", method = RequestMethod.POST)
	public List<Epica> getAllEpicaProyecto(@RequestBody String proyectoJson) throws Exception{
		
		this.mapper = new ObjectMapper();
		
		Proyecto proyecto = this.mapper.readValue(proyectoJson, Proyecto.class);
		
		if(proyecto.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.epicaService.findAllToProject(proyecto.getId()) == null) {
			
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.epicaService.findAllToProject(proyecto.getId());
		}
		
	}
	
	
	/**
	 * 	Metodo consultar Epicas por requerimiento
	 * @return
	 */
	@RequestMapping(value ="/getAllEpicasRequerimiento", method = RequestMethod.POST)
	public List<Epica> getAllEpicaRequerimiento(@RequestBody String requerimientoJson) throws Exception{
		
		this.mapper = new ObjectMapper();
		
		Requerimiento requerimiento = this.mapper.readValue(requerimientoJson, Requerimiento.class);
		
		if(requerimiento.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.epicaService.findEpicaToRequest(requerimiento.getId()) == null) {
			
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.epicaService.findEpicaToRequest(requerimiento.getId());
		}
		
	}
	
	
	/**
	 * 	Metodo eliminar Epicas 
	 * @return
	 */
	@RequestMapping(value ="/deleteEpica", method = RequestMethod.POST)
	public void deleteEpica(@RequestBody String epicaJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Epica epica = this.mapper.readValue(epicaJson, Epica.class);
		
		if(epica.getId() == null){
			throw new Exception("El ID no puede ser nulo.");
		}
		
		this.epicaService.deleteEpica(epica.getId());
		
	}
	
	


	
}
