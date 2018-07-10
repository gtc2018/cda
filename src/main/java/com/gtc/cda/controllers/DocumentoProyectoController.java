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
import com.gtc.cda.models.DocumentoProyecto;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.services.DocumentoProyectoService;
//import com.google.gson.JsonObject;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class DocumentoProyectoController {
	
	@Autowired
	protected DocumentoProyectoService documentoProyectoService;
	
	protected ObjectMapper mapper;
	
	/**
	 * 
	 * @param DocumentoProyectoJson
	 * @return 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException 
	 */
	// Guardar o Editar
	@RequestMapping(value ="/saveOrUpdateDocumentoProyecto", method = RequestMethod.POST)
	public RestResponse saveOrUpdateDocumentoProyecto(@RequestBody String documentoProyectoJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		
		this.mapper = new ObjectMapper();
		
		DocumentoProyecto documentoProyecto = this.mapper.readValue(documentoProyectoJson, DocumentoProyecto.class);
		
		if (!this.validate(documentoProyecto)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}	
		
		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();
		fecha.fecha("yyyy-MM-dd HH:mm:ss", fech);		
		//seteo la fecha de creacion al campo fechaCreacion.
		if(documentoProyecto.getId() ==null ) {
			documentoProyecto.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
			documentoProyecto.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
		}
		else {
		//Seteo la fecha de modificacion al campo fechaModificacion.
			documentoProyecto.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
		}
		
		if(documentoProyecto.getProyectoId() != null) {
		
			Proyecto proyecto = new Proyecto();
			
			proyecto.setId(new Long(documentoProyecto.getProyectoId()));
			
			documentoProyecto.setProyecto(proyecto);
		}
		
		if(documentoProyecto.getDocBits() != null) {
			documentoProyecto.setArchivo(fecha.DIRECTORIO_IMAGENES + documentoProyecto.getArchivo());
			
				Archivo archivo = new Archivo();

				String nameDoc = documentoProyecto.getArchivo();

				if (nameDoc != null	) {
					
					String[] parts = nameDoc.split("87");
					String part2 = parts[1];
					String[] nombreArchivo = part2.split("/");

					String nombreArchivo2 = nombreArchivo[1]; 
					String url = "\\\\25.72.193.72\\Compartida\\CDA_DIR\\" + nombreArchivo2;

					archivo.decodeBase64(documentoProyecto.getDocBits(), url);

				}

			}
		
		this.documentoProyectoService.save(documentoProyecto);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar documentoProyecto
	 * @param documentoProyectoJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteDocumentoProyecto", method = RequestMethod.POST)
	public RestResponse deleteDocumentoProyecto(@RequestBody String documentoProyectoJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		DocumentoProyecto documentoProyecto = this.mapper.readValue(documentoProyectoJson, DocumentoProyecto.class);
		
		if(documentoProyecto.getId() == null){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"El campo id no puede ser nulo");
		}		
		
		this.documentoProyectoService.deleteDocumentoProyecto(documentoProyecto.getId());	
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	/**
	 * Metodo consultar documentoProyectos
	 * @return
	 */
	@RequestMapping(value ="/getAllDocumentoProyecto", method = RequestMethod.GET)
	public List<DocumentoProyecto> getAllDocumentoProyecto(){
		return  this.documentoProyectoService.findAll();
		
	}	
	
	/**
	 * Metodo Obtener DocumentoProyecto por ID.
	 * @param DocumentoProyectoJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDocumentoProyectoId", method = RequestMethod.POST)
	public DocumentoProyecto getDocumentoProyectoId(@RequestBody String documentoProyectoId) throws Exception {

		this.mapper = new ObjectMapper();
			
		DocumentoProyecto documentoProyecto = this.mapper.readValue(documentoProyectoId, DocumentoProyecto.class);
	
		if(documentoProyecto.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.documentoProyectoService.getDocumentoProyectoId(documentoProyecto.getId()) == null) {
			throw new Exception("No existen registros con este ID");
		}
		else {
			 			
			return this.documentoProyectoService.getDocumentoProyectoId(documentoProyecto.getId()) ;
		} 

	}
	
	/**
	 * Metodo Obtener DocumentoProyectos por Proyecto.
	 * @param DocumentoProyectoJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDocumentByProject", method = RequestMethod.POST)
	public List<DocumentoProyecto> getDocumentByProject(@RequestBody String documentoProyectoId) throws Exception {

		this.mapper = new ObjectMapper();
			
		DocumentoProyecto documentoProyecto = this.mapper.readValue(documentoProyectoId, DocumentoProyecto.class);
	
		if(documentoProyecto.getId() == null){
			
			throw new Exception("El ID no puede ser nulo.");
		}
		
		// Se valida la existencia del registro
		
		if (this.documentoProyectoService.getDocumentByProject(documentoProyecto.getId()) == null) {
			throw new Exception("No existen registros");
		}
		else {
			 			
			return this.documentoProyectoService.getDocumentByProject(documentoProyecto.getId()) ;
		} 

	}
	
//	/**
//	 * Metodo para abrir archivos.
//	 * @param documentoProyectoJson
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/getOpenDocument", method = RequestMethod.POST)
//	public RestResponse getOpenDocument(@RequestBody String propuestaId) throws Exception {
//
//		this.mapper = new ObjectMapper();
//			
//		Propuesta propuesta = this.mapper.readValue(propuestaId, Propuesta.class);
//
//        	            
//		abrirarchivo("C:\\Users\\Anggelo\\Desktop\\GTCProject\\cda\\src\\archivos\\images.jpg");
//		
//		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
//
//	}
//	
//	public void abrirarchivo(String archivo){
//
//	     try {
//
//	            File objetofile = new File (archivo);
//	           System.out.println(objetofile);
//	           Desktop.getDesktop().browse(objetofile.toURI());
//
//	     }catch (IOException ex) {
//
//	            System.out.println(ex);
//
//	     }
//
//	}
	
//	private void btnAbrirarchivoActionPerformed(java.awt.event.ActionEvent evt) {                                                
//
//	    abrirarchivo("C:\\Users\\Anggelo\\Documents\\images.jpg");
//
//	}
	
	// Validaciones
	private boolean validate(DocumentoProyecto dpcumentoProyecto) {		
		boolean isValid = true;			
		

		return isValid;	
	}

}
