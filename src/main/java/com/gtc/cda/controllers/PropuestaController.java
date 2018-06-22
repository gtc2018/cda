package com.gtc.cda.controllers;

import java.awt.Desktop;
import java.io.File;
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
import com.gtc.cda.common.Archivo;
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.models.Cotizacion;
import com.gtc.cda.models.Propuesta;
//import com.google.gson.JsonObject;
import com.gtc.cda.services.PropuestaService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class PropuestaController {
	
	@Autowired
	protected PropuestaService propuestaService;
	
	protected ObjectMapper mapper;
	
	/**
	 * 
	 * @param PropuestaJson
	 * @return 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException 
	 */
	// Guardar o Editar
	@RequestMapping(value ="/saveOrUpdatePropuesta", method = RequestMethod.POST)
	public RestResponse saveOrUpdatePropuesta(@RequestBody String propuestaJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		
		this.mapper = new ObjectMapper();
		
		Propuesta propuesta = this.mapper.readValue(propuestaJson, Propuesta.class);
		
		if (!this.validate(propuesta)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}	
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(propuesta.getId() ==null ) {
			propuesta.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
			propuesta.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
			propuesta.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		if(propuesta.getCotizacionId() != null) {
		
			Cotizacion cotizacion = new Cotizacion();
			
			cotizacion.setId(new Long(propuesta.getCotizacionId()));
			
			propuesta.setCotizacion(cotizacion);
		}
		
		if(propuesta.getDocBits() != null) {
			propuesta.setArchivo(fecha.DIRECTORIO_IMAGENES + propuesta.getArchivo());
			
				Archivo archivo = new Archivo();

				String nameDoc = propuesta.getArchivo();

				if (nameDoc != null	) {
					
					String[] parts = nameDoc.split("87");
					String part2 = parts[1];
					String[] nombreArchivo = part2.split("/");

					String nombreArchivo2 = nombreArchivo[1]; 
					String url = "\\\\25.72.193.72\\Compartida\\CDA_DIR\\" + nombreArchivo2;

					archivo.decodeBase64(propuesta.getDocBits(), url);

				}

			}
		
		this.propuestaService.save(propuesta);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar Propuesta
	 * @param propuestaJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deletePropuesta", method = RequestMethod.POST)
	public RestResponse deletePropuesta(@RequestBody String propuestaJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Propuesta propuesta = this.mapper.readValue(propuestaJson, Propuesta.class);
		
		if(propuesta.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.propuestaService.deletePropuesta(propuesta.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar propuestas
	 * @return
	 */
	@RequestMapping(value ="/getAllPropuesta", method = RequestMethod.GET)
	public List<Propuesta> getAllPropuesta(){
		return  this.propuestaService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener Propuesta por ID.
	 * @param propuestaJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getFindByPropuestaId", method = RequestMethod.POST)
	public Propuesta findByPropuestaId(@RequestBody String propuestaId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Propuesta propuesta = this.mapper.readValue(propuestaId, Propuesta.class);
	
		if(propuesta.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.propuestaService.findByPropuestaId(propuesta.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.propuestaService.findByPropuestaId(propuesta.getId()) ;
		} 

	}
	
	/**
	 * Metodo Obtener Propuestas por Cotizacion.
	 * @param propuestaJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDocumentByQuotation", method = RequestMethod.POST)
	public List<Propuesta> getDocumentByQuotation(@RequestBody String propuestaId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Propuesta propuesta = this.mapper.readValue(propuestaId, Propuesta.class);
	
		if(propuesta.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.propuestaService.getDocumentByQuotation(propuesta.getId()) == null) {
			throw new Exception("No existen registros");
		}
		else {
			 			
			return this.propuestaService.getDocumentByQuotation(propuesta.getId()) ;
		} 

	}
	
	/**
	 * Metodo para abrir archivos.
	 * @param propuestaJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getOpenDocument", method = RequestMethod.POST)
	public RestResponse getOpenDocument(@RequestBody String propuestaId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Propuesta propuesta = this.mapper.readValue(propuestaId, Propuesta.class);

        	            
		abrirarchivo("C:\\Users\\Anggelo\\Desktop\\GTCProject\\cda\\src\\archivos\\images.jpg");
		
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");

	}
	
	public void abrirarchivo(String archivo){

	     try {

	            File objetofile = new File (archivo);
	           System.out.println(objetofile);
	           Desktop.getDesktop().browse(objetofile.toURI());

	     }catch (IOException ex) {

	            System.out.println(ex);

	     }

	}
	
//	private void btnAbrirarchivoActionPerformed(java.awt.event.ActionEvent evt) {                                                
//
//	    abrirarchivo("C:\\Users\\Anggelo\\Documents\\images.jpg");
//
//	}
	
	// Validaciones
	private boolean validate(Propuesta propuesta) {		
		boolean isValid = true;			
		

		return isValid;	
	}

}
