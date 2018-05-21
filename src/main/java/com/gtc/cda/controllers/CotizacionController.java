package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.models.Alcance;
import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.models.Estado;
import com.gtc.cda.models.Herramienta;
import com.gtc.cda.models.Permiso;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.models.Sistema;
import com.gtc.cda.services.CotizacionService;
import com.gtc.cda.util.RestResponse;


@CrossOrigin(origins="*")
@RestController

public class CotizacionController {
	
	@Autowired
	protected CotizacionService cotizacionService;
	
	protected ObjectMapper mapper;
	
	// Guardar o Editar
	@RequestMapping(value ="/saveOrUpdateCotizacion", method = RequestMethod.POST)
	public RestResponse saveOrUpdateCotizacion(@RequestBody String cotizacionJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		Cotizacion cotizacion = this.mapper.readValue(cotizacionJson, Cotizacion.class);// Se mapea requerimiento con respecto al modelo
		
		//Se ejecuta las validaciones
		if (!this.validate(cotizacion)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		//Generacion fecha creacion
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		//seteo la fecha de creacion al campo fechaCreacion.
		if(cotizacion.getId() ==null ) {
			cotizacion.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
			cotizacion.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
			cotizacion.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		//Valida la entrada de los datos por estructura
		if (cotizacion.getClienteId() != null | cotizacion.getAlcanceId() != null
				| cotizacion.getProyectoId() != null | cotizacion.getEstadoId() != null
				| cotizacion.getHerramientaId() != null | cotizacion.getSistemaId() != null) {
		
		    Empresa empresa = new Empresa();// Variable de empresa
	        
	        Herramienta herramienta = new Herramienta();//Variable de fase
	       
	        Sistema sistema = new Sistema();//Variable de cotizacion
	        
	        Proyecto proyecto = new Proyecto();//Variable de proyecto
	        
	        Estado estado = new Estado();//Variable de estado
	        
	        Alcance alcance = new Alcance();//Variable de alcance
			
	        //Se le pasan las variables del arreglo a las variables ---------------------------------------------------------
			empresa.setId(new Long(cotizacion.getClienteId()));
			
			herramienta.setId(new Long(cotizacion.getHerramientaId()));
			
			sistema.setId(new Long(cotizacion.getSistemaId()));
			
			proyecto.setId(new Long(cotizacion.getProyectoId()));
			
			estado.setId(new Long(cotizacion.getEstadoId()));
			
			alcance.setId(new Long(cotizacion.getAlcanceId()));
			
			// Se le setean las variables al arreglo --------------------------------------------------------------------------
			cotizacion.setCliente(empresa);
			
			cotizacion.setSistema(sistema);
			
			cotizacion.setHerramienta(herramienta);
			
			cotizacion.setProyecto(proyecto);
			
			cotizacion.setEstado(estado);
			
			cotizacion.setAlcance(alcance);
			
			this.cotizacionService.save(cotizacion);// Ejecuta el servicio para guardar el arreglo

			return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa"); // Se retorna una respuesta exitosa
			
		}else {
			
		this.cotizacionService.save(cotizacion);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
		}
	}
	
	
	/**
	 * Metodo consultar todos las cotizaciones.
	 * @return
	 */
	@RequestMapping(value ="/getAllCotizacion", method = RequestMethod.GET)
	public List<Cotizacion> getAllCotizacion(){
		
		return  this.cotizacionService.findAll();// Regresa todas las cotizaciones
		
	}
	
	/**
	 * Metodo Obtener Cotizacion por ID.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getCotizacion", method = RequestMethod.POST)
	public Cotizacion getCotizacionById(@RequestBody String id) throws Exception {

		this.mapper = new ObjectMapper();
		
		Cotizacion cotizacion = this.mapper.readValue(id, Cotizacion.class);
		
		//Se asegura que el ID no sea nulo
		if(cotizacion.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		if (this.cotizacionService.findByCotizacionId(cotizacion.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.cotizacionService.findByCotizacionId(cotizacion.getId()) ;
		} 

	}
	
	/**
	 * Metodo Eliminar Cotizacion.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteCotizacion", method = RequestMethod.POST)
	public RestResponse deleteCotizacion(@RequestBody String usuarioJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Cotizacion cotizacion = this.mapper.readValue(usuarioJson, Cotizacion.class);
		
		if(cotizacion.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo ID no puede ser nulo");
		}
		
		this.cotizacionService.deleteCotizacion(cotizacion.getId());
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}

	/**
	 * Metodo de VALIDACIONES.
	 */
	private boolean validate(Cotizacion cotizacion) {
		
		boolean isValid = true;
				
		return isValid;
		
	}
	
	
	/**
	 * Metodo que obtiene las cotizaciones por proyecto
	 * 	 */
	@RequestMapping(value = "/getCotizacionByProyecto", method = RequestMethod.POST)
	public List<Cotizacion> getCotizacionPorProyecto(@RequestBody String proyectoJson) throws Exception {

		this.mapper = new ObjectMapper();
		
		Proyecto proyecto = this.mapper.readValue(proyectoJson, Proyecto.class);
		
		
		if(proyecto.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.cotizacionService.findByProyecto(proyecto.getId()) == null) {
			
			throw new Exception("No existen registros con este ID");
		}
		else {		
			return this.cotizacionService.findByProyecto(proyecto.getId());
		} 

	}
	

}
