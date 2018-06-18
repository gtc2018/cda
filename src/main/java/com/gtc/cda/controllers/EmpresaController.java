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
import com.gtc.cda.common.Archivo;
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.common.Generico;
import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.services.EmpresaService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins = "*")

@RestController
public class EmpresaController {

	@Autowired
	protected EmpresaService empresaService;

	protected ObjectMapper mapper;

	/**
	 * aaaaaaaa!Test Metodo crear o editar Empresas.
	 * 
	 * @param empresaJson
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/saveOrUpdateEmpresa", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String empresaJson)
			throws JsonParseException, JsonMappingException, IOException, ParseException {

		this.mapper = new ObjectMapper();

		Empresa empresa = this.mapper.readValue(empresaJson, Empresa.class);

		if (!this.validate(empresa)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		} else {
			// Servicio crear o editar empresa.
			String url = empresa.getUrlCarpeta() + "\\" + empresa.getNumeroDocumento() + "_" + empresa.getDescripcion();
			
			FormatoFecha fecha = new FormatoFecha();
			Date fechaActual = new Date();
			fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual);
			empresa.setUrlCarpeta(url);

			if (empresa.getId() != null) {
				empresa.setFechaModificacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual));

			} else {
				empresa.setFechaCreacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual));

			}
			
			//Imagen ---------------------------------------------------------------------------
			if(empresa.getId() != null) {
				
				if(empresa.getImagen() != null) {
					
					empresa.setImagenEmpresa(fecha.DIRECTORIO_IMAGENES + empresa.getImagenEmpresa());
					Archivo archivo = new Archivo();
					String foto = empresa.getImagenEmpresa();
					this.empresaService.save(empresa);
					
					if (foto != null) {
						String[] parts = foto.split("87");
						String part2 = parts[1];
						String[] nombreArchivo = part2.split("/");

						String nombreArchivo2 = nombreArchivo[1];
						String url2 = "\\\\25.72.193.72\\Compartida\\CDA_DIR\\" + nombreArchivo2;

						archivo.decodeBase64(empresa.getImagen(), url2);
					}	
				}
			}else {
				
				if (empresa.getImagen() != null) {
					
					empresa.setImagenEmpresa(fecha.DIRECTORIO_IMAGENES + empresa.getImagenEmpresa());
				}else {
					empresa.setImagenEmpresa(fecha.DIRECTORIO_IMAGENES+"logo.png");
				}
				
				if (empresa.getImagen() != null) {
					Archivo archivo = new Archivo();
					String foto = empresa.getImagenEmpresa();

					if (foto != null) {
						String[] parts = foto.split("87");
						String part2 = parts[1];
						String[] nombreArchivo = part2.split("/");

						String nombreArchivo2 = nombreArchivo[1];
						String url2 = "\\\\25.72.193.72\\Compartida\\CDA_DIR\\" + nombreArchivo2;

						archivo.decodeBase64(empresa.getImagen(), url2);

					}
				}
				
			}

			// Llamado al metodo para crear carpeta Empresa.
			Generico generico = new Generico();
			generico.createFolder(url);
			generico.createFolder(url + "\\Empleados\\Fotos");
			this.empresaService.save(empresa);
			return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		}
	}

	/**
	 * Metodo consultar empresas.
	 * 
	 * @param empresa
	 * @return
	 */
	@RequestMapping(value = "/getAllEmpresas", method = RequestMethod.GET)
	public List<Empresa> getAllEmpresas() {
		return this.empresaService.findAll();

	}

	@RequestMapping(value = "/getEmpresaById", method = RequestMethod.POST)
	public Empresa getEmpresaById(@RequestBody String empresaidJson) throws Exception {

		this.mapper = new ObjectMapper();

		Empresa empresa = this.mapper.readValue(empresaidJson, Empresa.class);

		return this.empresaService.findByEmpresaId(empresa.getId());

	}

	/**
	 * Metodo eliminar Empresas.
	 * 
	 * @param empresa
	 * @return
	 */
	@RequestMapping(value = "/deleteEmpresa", method = RequestMethod.POST)
	public void deleteEmpresa(@RequestBody String empresaJson) throws Exception {
		this.mapper = new ObjectMapper();

		Empresa empresa = this.mapper.readValue(empresaJson, Empresa.class);

		if (empresa.getId() == null) {
			throw new Exception("El ID no puede ser nulo.");
		}
		this.empresaService.deleteEmpresa(empresa.getId());

	}
	
	/**
	 * Metodo que obtiene los empresas por numero de documento
	 * 	 */
	@RequestMapping(value = "/getEnterpriseForRegistre", method = RequestMethod.POST)
	public List<Empresa> getEnterpriseForRegistre(@RequestBody String empresaJson) throws Exception {

		this.mapper = new ObjectMapper();
		
		Empresa empresa = this.mapper.readValue(empresaJson, Empresa.class);
				
		return this.empresaService.findEnterpriseForRegistre(empresa.getNumeroDocumento());
 

	}

	/**
	 * Metodo validar campos empresa.
	 * 
	 * @param empresa
	 * @return
	 */
	private boolean validate(Empresa empresa) {
		boolean isValid = true;

		if (StringUtils.trimToNull(empresa.getDescripcion()) == null) {
			isValid = false;
		}
		if (StringUtils.trimToNull(empresa.getTipoDocumento()) == null) {
			isValid = false;
		}

		if (StringUtils.trimToNull(empresa.getNumeroDocumento()) == null) {
			isValid = false;
		}

		if (StringUtils.trimToNull(empresa.getEmail()) == null) {
			isValid = false;
		}

		return isValid;
	}

}
