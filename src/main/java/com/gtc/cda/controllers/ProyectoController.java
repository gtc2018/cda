package com.gtc.cda.controllers;

import java.io.IOException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.gtc.cda.common.Archivo;
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.common.Generico;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.models.PorcentajePorFase;
import com.gtc.cda.models.Fase;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.services.EmpresaService;
import com.gtc.cda.services.ProyectoService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins = "*")

@RestController
public class ProyectoController {

	@Autowired
	protected ProyectoService proyectoService;

	@Autowired
	protected EmpresaService empresaService;

	protected ObjectMapper mapper;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	


	@RequestMapping(value = "/getAllProyectos", method = RequestMethod.GET)
	public List<Proyecto> getAllProyectos() {
		return this.proyectoService.findAll();

	}

	@RequestMapping(value = "/saveOrUpdateProyecto", method = RequestMethod.POST)
	public RestResponse saveOrUpdateProyecto(@RequestBody String proyectoJson)
			throws JsonParseException, JsonMappingException, IOException, ParseException {

		this.mapper = new ObjectMapper();

		Proyecto proyecto = this.mapper.readValue(proyectoJson, Proyecto.class);

		if (!this.validate(proyecto)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		} 
		
		//Generacion fecha creacion
				FormatoFecha fecha = new FormatoFecha();
				Date fech = new Date();
				//seteo la fecha de creacion al campo fechaCreacion.
				if(proyecto.getId() ==null ) {
					proyecto.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
					proyecto.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
				}
				else {
				//Seteo la fecha de modificacion al campo fechaModificacion.
					proyecto.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
				}
				
				//Valida la entrada de los datos por estructura
//				if (proyecto.getClienteId() != null) {
//				
//				    Empresa empresa = new Empresa();// Variable de empresa
//			        
//					empresa.setId(new Long(proyecto.getClienteId()));// Setea el id que viene del campo ClienteId a la variable empresa
//					
//					proyecto.setCliente(empresa);//Setea la empresa al cliente
//					
//					this.proyectoService.save(proyecto);// Ejecuta el servicio para guardar el arreglo
//
//					return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa"); // Se retorna una respuesta exitosa
					
//				}else {
				
				if(proyecto.getDocBits() != null) {
					proyecto.setDocumento(fecha.DIRECTORIO_IMAGENES + proyecto.getDocumento());
					
						Archivo archivo = new Archivo();

						String nameDoc = proyecto.getDocumento();

						if (nameDoc != null	) {
							
							String[] parts = nameDoc.split("87");
							String part2 = parts[1];
							String[] nombreArchivo = part2.split("/");

							String nombreArchivo2 = nombreArchivo[1]; 
							String url = "\\\\25.72.193.72\\Compartida\\CDA_DIR\\" + nombreArchivo2;

							archivo.decodeBase64(proyecto.getDocBits(), url);

						}

					}
					
				this.proyectoService.save(proyecto);
				
		        return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		        
		   

	}

	//
	@RequestMapping(value = "/deleteProyecto", method = RequestMethod.DELETE)
	public void deleteProyecto(@RequestBody String proyectoJson) throws Exception {
		this.mapper = new ObjectMapper();

		Proyecto proyecto = this.mapper.readValue(proyectoJson, Proyecto.class);

		if (proyecto.getId() == null) {
			throw new Exception("El ID no puede ser nulo.");
		} else {

			this.proyectoService.deleteProyecto(proyecto.getId());
		}

	}

	private boolean validate(Proyecto proyecto) {

		boolean isValid = true;

		if (StringUtils.trimToNull(proyecto.getNombre()) == null) {

			isValid = false;

		}

		return isValid;

	}
	
	
	@RequestMapping(value = "/getProyectoByCliente", method = RequestMethod.POST)
	public List<Proyecto> getProyectoPorEmpresa(@RequestBody String empresaJson) throws Exception {

		this.mapper = new ObjectMapper();
		
		Empresa empresa = this.mapper.readValue(empresaJson, Empresa.class);
		
		
		if(empresa.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.proyectoService.findByCliente(empresa.getId()) == null) {
			
			throw new Exception("No existen registros con este ID");
		}
		else {		
			return this.proyectoService.findByCliente(empresa.getId());
		} 

	}

}