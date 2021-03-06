package com.gtc.cda.controllers;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.type.CustomType;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.models.AsociarProyecto;
import com.gtc.cda.models.Empleado;
import com.gtc.cda.services.AsociarProyectoService;
import com.gtc.cda.services.EmpleadoService;
import com.gtc.cda.util.RestResponse;

/**
 * Controlador Asociar Proyecto, esta clase controla los servicios expuestos
 * de la entidad Asociar proyectos.
 * @author Dirección Calidad
 *
 */

@CrossOrigin(origins="*")
@RequestMapping(value ="/AsociarProyecto")
@RestController
public class AsociarProyectoController {
	
	@Autowired
	protected AsociarProyectoService asociarProyectoService;
	
	@Autowired
	protected EmpleadoService empleadoService;
	
	@Autowired
	protected ObjectMapper mapper;
	
	@RequestMapping(value ="/saveOrUpdateAsociarProyecto", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateAsociarProyecto(@RequestParam("projectId") String ProyectoId,@RequestBody Iterable<AsociarProyecto> asociarProyectoJson) throws JsonParseException, JsonMappingException, IOException{
		
		try{
			
		Iterable<AsociarProyecto> asociarProyectoForDelete = this.asociarProyectoService.findAllForProject(ProyectoId);
		
		if (!String.valueOf(asociarProyectoForDelete).equals("[]")) {
		
		this.asociarProyectoService.deleteAllByProject(asociarProyectoForDelete);
		}
		this.asociarProyectoService.save(asociarProyectoJson);
		
		return (ResponseEntity) ResponseEntity.ok().body("");
		
		}catch(Exception e){
			
			System.out.println(e);
			
			return (ResponseEntity) ResponseEntity.badRequest().body("Error al insertar los involucrados");
		}
	}
	
	@RequestMapping(value ="/getAllAsociarProyecto", method = RequestMethod.GET)
	public List<AsociarProyecto> getAllForProject(@RequestParam("id") String ProyectoId){
		
		List<AsociarProyecto> asociarProyectos = this.asociarProyectoService.findAllForProject(ProyectoId);
		
		for(AsociarProyecto model : asociarProyectos){
			
			model.setNombreEmpleado(empleadoService.getOne(new Long(model.getEmpleadoId())).getNombres());
			
			model.setApellidoEmpleado(empleadoService.getOne(new Long(model.getEmpleadoId())).getApellidos());
			
			model.setFotoEmpleado(empleadoService.getOne(new Long(model.getEmpleadoId())).getFoto());						
			
		}
		
		return asociarProyectos ;
		
	}
	
	

}
