package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
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
import com.gtc.cda.models.Permiso;
import com.gtc.cda.models.Proyecto;
import com.gtc.cda.models.Requerimiento;
import com.gtc.cda.services.RequerimientoService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins = "*")

@RestController

public class RequerimientoController {
	
	@Autowired
	protected RequerimientoService requerimientoService;

	protected ObjectMapper mapper;
	
	@RequestMapping(value = "/saveOrUpdateRequerimiento", method = RequestMethod.POST)
	public RestResponse saveOrUpdateRequerimiento(@RequestBody String requerimientoJson)
			throws JsonParseException, JsonMappingException, IOException, ParseException {

		this.mapper = new ObjectMapper();

		Requerimiento requerimiento = this.mapper.readValue(requerimientoJson, Requerimiento.class);

		Proyecto proyecto = new Proyecto();

		proyecto.setId(new Long(requerimiento.getProyectoId()));

		requerimiento.setProyecto(proyecto);
		

		if (!this.validate(requerimiento)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}


		// Generacion fecha creacion
		FormatoFecha fecha = new FormatoFecha();
		Date fechaActual = new Date();
		// seteo la fecha de creacion al campo fechaCreacion.

		if (requerimiento.getId() != null) {
			requerimiento.setFechaModificacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual));

		} else {
			requerimiento.setFechaCreacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual));
			requerimiento.setEstado(1);

		}

		this.requerimientoService.save(requerimiento);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");

	}
	
	/**
	 * Metodo consultar todos los requerimientos
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAllRequerimientos", method = RequestMethod.GET)
	public List<Requerimiento> getAllRequerimiento() {
		return this.requerimientoService.findAll();

	}
	
	@RequestMapping(value = "/deleteRequerimiento", method = RequestMethod.POST)
	public void deleteRequerimiento(@RequestBody String requerimientoJson) throws Exception {
		this.mapper = new ObjectMapper();

		Requerimiento requerimiento = this.mapper.readValue(requerimientoJson, Requerimiento.class);

		if (requerimiento.getId() == null) {
			throw new Exception("El ID no puede ser nulo.");
		}

		this.requerimientoService.deleteRequerimiento(requerimiento.getId());

	}
	
	private boolean validate(Requerimiento requerimiento) {

		boolean isValid = true;

		if (StringUtils.trimToNull(requerimiento.getProyectoId()) == null) {

			isValid = false;

		}

		if (StringUtils.trimToNull(requerimiento.getClienteId()) == null) {

			isValid = false;

		}

		return isValid;

	}


}
