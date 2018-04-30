package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
//import java.util.ArrayList;
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
import com.gtc.cda.models.Menu;
import com.gtc.cda.models.Permiso;
import com.gtc.cda.services.PermisoService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins = "*")

@RestController
public class PermisoController {

	@Autowired
	protected PermisoService permisoService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/saveOrUpdatePermiso", method = RequestMethod.POST)
	public RestResponse saveOrUpdatePermiso(@RequestBody String permisoJson)
			throws JsonParseException, JsonMappingException, IOException, ParseException {

		this.mapper = new ObjectMapper();

		Permiso permiso = this.mapper.readValue(permisoJson, Permiso.class);

		Menu menu = new Menu();

		// Rol rol = new Rol();

		menu.setId(new Long(permiso.getMenu_id()));

		// rol.setId(new Long(permiso.getRol_id()));

		permiso.setMenu(menu);
		// permiso.setRol(rol);

		if (!this.validate(permiso)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}

		/*
		 * if (this.existe(permiso)) { return new
		 * RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
		 * "El permiso asociado al Rol y Pantalla selecionada ya existe."); }
		 */

		// Generacion fecha creacion
		FormatoFecha fecha = new FormatoFecha();
		Date fechaActual = new Date();
		// seteo la fecha de creacion al campo fechaCreacion.

		if (permiso.getId() != null) {
			permiso.setFechaModificacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual));

		} else {
			permiso.setFechaCreacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual));
			permiso.setEstado(1);

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
	public List<Permiso> getMenuSession(@RequestBody String rolId) throws Exception {

		this.mapper = new ObjectMapper();

		Permiso permiso = this.mapper.readValue(rolId, Permiso.class);

		// Rol rol = new Rol();
		// rol.setId(new Long(permiso.getRol_id()));
		// permiso.setRol(rol);

		return this.permisoService.findByRolId(permiso.getRolId());

	}

	/**
	 * Metodo para validar si el permiso ya existe, recibe dos parametros RolId y
	 * MenuId, retorna verdadero is existe y falso si no.
	 * 
	 * @param permiso
	 * @return true / false
	 */

	/*
	 * private boolean existe(Permiso permiso) {
	 * 
	 * List<Permiso> permisosResponse = new ArrayList<>();
	 * 
	 * permisosResponse = this.permisoService.existe(permiso.getRolId(),
	 * permiso.getMenu_id());
	 * 
	 * if (permisosResponse.size() > 0) { return true;
	 * 
	 * }
	 * 
	 * return false;
	 * 
	 * }
	 */

	private boolean validate(Permiso permiso) {

		boolean isValid = true;

		if (StringUtils.trimToNull(permiso.getRolId()) == null) {

			isValid = false;

		}

		if (StringUtils.trimToNull(permiso.getMenu_id()) == null) {

			isValid = false;

		}

		return isValid;

	}

}
