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
import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.services.EmpleadoService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins = "*")
@RestController
public class EmpleadoController {

	@Autowired
	protected EmpleadoService empleadoService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/saveOrUpdateEmpleado", method = RequestMethod.POST)
	public RestResponse saveOrUpdateEmpleado(@RequestBody String empleadoJson)
			throws JsonParseException, JsonMappingException, IOException, ParseException {

		this.mapper = new ObjectMapper();

		Empleado empleado = this.mapper.readValue(empleadoJson, Empleado.class);

		if (!this.validate(empleado)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}

		// Generacion fecha creacion
		FormatoFecha fecha = new FormatoFecha();
		Date fechaActual = new Date();
		// seteo la fecha de creacon al campo fechaCreacion.
		if(empleado.getId() == null) {
			empleado.setFechaCreacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual));
			}else {
				empleado.setFechaModificacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual));
			}
		

		this.empleadoService.save(empleado);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");

	}

	@RequestMapping(value = "/empleado/create", method = RequestMethod.POST)
	public RestResponse createUser(@RequestBody Empleado empleado) throws ParseException, IOException {
		
		if (!this.validate(empleado)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");

		}

		FormatoFecha fecha = new FormatoFecha();
		Date fech = new Date();

		empleado.setFechaCreacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fech));
		if(empleado.getImagen() != null) {
		empleado.setFoto(fecha.DIRECTORIO_IMAGENES + empleado.getFoto());
		}else {
			empleado.setFoto(fecha.DIRECTORIO_IMAGENES + "logo.png");
		}
		this.empleadoService.save(empleado);

		if (empleado.getImagen() != null) {
			Archivo archivo = new Archivo();

			String foto = empleado.getFoto();

			if (foto != null  && foto != null
					
					
					
					
					) {
				String[] parts = foto.split("87");
				String part2 = parts[1];
				String[] nombreArchivo = part2.split("/");

				String nombreArchivo2 = nombreArchivo[1]; 
				String url = "\\\\25.72.193.72\\Compartida\\CDA_DIR\\" + nombreArchivo2;

				archivo.decodeBase64(empleado.getImagen(), url);

			}

		}

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}

	/**
	 * Metodo consultar todos los empleados.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAllEmpleados", method = RequestMethod.GET)
	public List<Empleado> getAllEmpleados() {
		return this.empleadoService.findAll();

	}

	@RequestMapping(value = "/getEmpleadoById", method = RequestMethod.POST)
	public Empleado getEmpleadoById(@RequestBody String rolId) throws Exception {

		this.mapper = new ObjectMapper();

		Empleado empleado = this.mapper.readValue(rolId, Empleado.class);

		return this.empleadoService.findByEmpleadoId(empleado.getId());

	}

	@RequestMapping(value = "/getAllEmployeesToEnterprise", method = RequestMethod.POST)
	public List<Empleado> getAllEmployeesToEnterprise(@RequestBody String empresaJson) throws Exception {

		this.mapper = new ObjectMapper();

		Empresa empresa = this.mapper.readValue(empresaJson, Empresa.class);

		return this.empleadoService.findEmployeesToEnterprise(empresa.getId());

	}

	/**
	 * Metodo Eliminar Empleados.
	 * 
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteEmpleado", method = RequestMethod.POST)
	public void deleteEmpleado(@RequestBody String usuarioJson) throws Exception {
		this.mapper = new ObjectMapper();

		Empleado empleado = this.mapper.readValue(usuarioJson, Empleado.class);

		if (empleado.getId() == null) {
			throw new Exception("El ID no puede ser nulo.");
		}

		this.empleadoService.deleteEmpleado(empleado.getId());

	}

	private boolean validate(Empleado empleado) {

		boolean isValid = true;

		if (StringUtils.trimToNull(empleado.getNombres()) == null) {

			isValid = false;

		}

		if (StringUtils.trimToNull(empleado.getApellidos()) == null) {

			isValid = false;

		}

		if (StringUtils.trimToNull(empleado.getEmail()) == null) {

			isValid = false;

		}

		if (empleado.getCargoId() == null) {

			isValid = false;

		}

		return isValid;

	}

}
