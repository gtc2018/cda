package com.gtc.cda.controllers;

import java.io.IOException;
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
import com.gtc.cda.models.Permiso;
import com.gtc.cda.services.PermisoService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")

@RestController
public class PermisoController {

	@Autowired
	protected PermisoService permisoService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/saveOrUpdatePermiso", method = RequestMethod.POST)
	public RestResponse saveOrUpdatePermiso(@RequestBody String permisoJson)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();

		Permiso permiso = this.mapper.readValue(permisoJson, Permiso.class);

		if (!this.validate(permiso)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}

		this.permisoService.save(permiso);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}

	/**
	 * Metodo consultar todos los permisos
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAllPermisos", method = RequestMethod.GET)
	public List<Permiso> getAllPermisos() {
		return this.permisoService.findAll();

	}

	@RequestMapping(value = "/deletePermiso", method = RequestMethod.POST)
	public void deletePermiso(@RequestBody String permisoJson) throws Exception {
		this.mapper = new ObjectMapper();

		Permiso permiso = this.mapper.readValue(permisoJson, Permiso.class);

		if (permiso.getId() == null) {
			throw new Exception("El ID no puede ser nulo.");
		}

		this.permisoService.deletePermiso(permiso.getId());

	}
	
	
	@RequestMapping(value = "/getMenuSession", method = RequestMethod.POST)
	public List<Permiso>  getMenuSession(@RequestBody String rolId) throws Exception {

		this.mapper = new ObjectMapper();
			
		Permiso permiso = this.mapper.readValue(rolId, Permiso.class);
		
		return this.permisoService.findByRolId(permiso.getRolId());

	}
	

	private boolean validate(Permiso permiso) {

		boolean isValid = true;

		if (StringUtils.trimToNull(permiso.getRolId()) == null) {

			isValid = false;

		}

		return isValid;

	}

}
