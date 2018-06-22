package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
import com.gtc.cda.models.Area;
import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.models.Fase;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.models.RegistroActividad;
import com.gtc.cda.models.Requerimiento;
import com.gtc.cda.models.Tarea;
import com.gtc.cda.services.RegistroActividadService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class RegistroActividadController {
	
	@Autowired
	protected RegistroActividadService registroActividadService;
	
	protected ObjectMapper mapper;
	
	/**
	 * Metodo Guardar o Editar RegistroActividad
	 * @param registroActividadJson
	 * @throws ParseException 
	 * @throws Exception
	 */
	@RequestMapping(value ="/saveOrUpdateRegistroActividad", method = RequestMethod.POST)
	public RestResponse saveOrUpdateRegistroActividad(@RequestBody String registroActividadJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		RegistroActividad registroActividad = this.mapper.readValue(registroActividadJson, RegistroActividad.class);
		
		if (!this.validate(registroActividad)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(registroActividad.getId() ==null ) {
		registroActividad.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		registroActividad.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
		registroActividad.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		//Valida la entrada de los datos por estructura
		if (registroActividad.getClienteId() != null | registroActividad.getFaseId() != null
			| registroActividad.getProyectoId() != null | registroActividad.getRequerimientoId() != null
			| registroActividad.getAreaId() != null | registroActividad.getTareaId() != null
			| registroActividad.getEmpleadoId() != null) {
				
				Empresa empresa = new Empresa();// Variable de empresa
				
				Empleado empleado = new Empleado();// Variable de empleado
			    
				Proyecto proyecto = new Proyecto();//Variable de proyecto
				
				Requerimiento requerimiento = new Requerimiento();//Variable de requerimiento
				
				Area area = new Area();// Variable de area
				
			
				Fase fases = new Fase();//Variable de fase
			    
			    Tarea tarea = new Tarea();// Variable de tarea
			    	
			    //Se le pasan las variables del arreglo a las variables ---------------------------------------------------------
				empresa.setId(new Long(registroActividad.getClienteId()));
					
				fases.setId(new Long(registroActividad.getFaseId()));
					
				empleado.setId(new Long(registroActividad.getEmpleadoId()));
					
				proyecto.setId(new Long(registroActividad.getProyectoId()));
					
				requerimiento.setId(new Long(registroActividad.getRequerimientoId()));
				
				area.setId(new Long(registroActividad.getAreaId()));
				
				fases.setId(new Long(registroActividad.getFaseId()));
				
				tarea.setId(new Long(registroActividad.getTareaId()));
					
				// Se le setean las variables al arreglo --------------------------------------------------------------------------
				registroActividad.setCliente(empresa);
					
				registroActividad.setFase(fases);
					
				registroActividad.setEmpleado(empleado);
					
				registroActividad.setProyecto(proyecto);
					
				registroActividad.setRequerimiento(requerimiento);
				
				registroActividad.setArea(area);
				
				registroActividad.setFase(fases);
				
				registroActividad.setTarea(tarea);
					
				this.registroActividadService.save(registroActividad);// Ejecuta el servicio para guardar el arreglo

				return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa"); // Se retorna una respuesta exitosa
					
			}else {
					
			this.registroActividadService.save(registroActividad);

			return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
				
			}
		
	}
	
	/**
	 * Metodo Eliminar RegistroActividad
	 * @param registroActividadJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteRegistroActividad", method = RequestMethod.POST)
	public RestResponse deleteRegistroActividad(@RequestBody String registroActividadJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		RegistroActividad registroActividad = this.mapper.readValue(registroActividadJson, RegistroActividad.class);
		
		if(registroActividad.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.registroActividadService.deleteRegistroActividad(registroActividad.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar RegistroActividad
	 * @return
	 */
	@RequestMapping(value ="/getAllRegistroActividades", method = RequestMethod.GET)
	public List<RegistroActividad> getAllRegistroActividad(){
		return  this.registroActividadService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener RegistroActividads por ID.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/findByRegistroActividadId", method = RequestMethod.POST)
	public RegistroActividad findOne(@RequestBody String registroActividadId) throws Exception {

		this.mapper = new ObjectMapper();
			
		RegistroActividad registroActividad = this.mapper.readValue(registroActividadId, RegistroActividad.class);
	
		if(registroActividad.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.registroActividadService.findByRegistroActividadId(registroActividad.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.registroActividadService.findByRegistroActividadId(registroActividad.getId()) ;
		} 

	}
	
	/**
	 * Metodo Obtener RegistroActividades por empleados.
	 * @param registroJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAllRegistreToEmployee", method = RequestMethod.POST)
	public List<RegistroActividad> getAllRegistreToEmployee(@RequestBody String empleadoJson) throws Exception {

		this.mapper = new ObjectMapper();

		Empleado empleado = this.mapper.readValue(empleadoJson, Empleado.class);

		return this.registroActividadService.findRegistreToEmployee(empleado.getId());

	}
	
	/**
	 * Metodo Obtener RegistroActividades por rango de fecha.
	 * @param registroJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAllRegistreByDate", method = RequestMethod.POST)
	public List<RegistroActividad> getAllRegistreByDate(@RequestBody String registroJson) throws Exception {

		this.mapper = new ObjectMapper();

		RegistroActividad registro = this.mapper.readValue(registroJson, RegistroActividad.class);

		return this.registroActividadService.getAllRegistreByDate(registro.getId(), registro.getFechaTrabajo(),
				registro.getHoraInicio(), registro.getHoraFin());

	}
	
	/**
	 * Metodo Obtener RegistroActividades por empleado y fecha.
	 * @param registroJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getRegistreByEmployeeAndDate", method = RequestMethod.POST)
	public List<RegistroActividad> getRegistreByEmployeeAndDate(@RequestBody String registroActividadJson) throws Exception {

		this.mapper = new ObjectMapper();

		RegistroActividad registroActividad = this.mapper.readValue(registroActividadJson, RegistroActividad.class);

		return this.registroActividadService.findRegistreByEmployeeAndDate(registroActividad.getId(), registroActividad.getFechaTrabajo());

	}
	
	private boolean validate(RegistroActividad registroActividad) {		
		boolean isValid = true;	
		
		if (registroActividad.getDescripcion() == null ) {

			isValid = false;

		}
		
		return isValid;	
	}

}
