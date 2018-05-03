package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.models.Fase;
import com.gtc.cda.services.FaseService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins = "*")
@RestController
public class FaseController {

	@Autowired
	protected FaseService faseService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/fase/create", method = RequestMethod.POST)
	public RestResponse faseCreate(@RequestBody String faseJson) throws ParseException, IOException {

		this.mapper = new ObjectMapper();

		Fase fase = this.mapper.readValue(faseJson, Fase.class);

		if (!this.validate(fase)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");

		}

		FormatoFecha fecha = new FormatoFecha();
		Date fechaActual = new Date();

		if (fase.getId() == null) {
			fase.setFechaCreacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual));
		} else {
			fase.setFechaModificacion(fecha.fecha(fecha.FORMATO_YYYY_MM_DD, fechaActual));
		}

		this.faseService.save(fase);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/fases/getAll", method = RequestMethod.GET)
	public List<Fase> getAllFases() {
		return this.faseService.findAll();

	}

	@RequestMapping(value = "/fase/delete", method = RequestMethod.POST)
	public RestResponse deleteFase(@RequestBody String faseJson) throws ParseException, IOException {
		this.mapper = new ObjectMapper();

		Fase fase = this.mapper.readValue(faseJson, Fase.class);

		if (!this.existe(fase)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "El Id no existe o no es valido.");
		}
		this.faseService.deleteFase(fase.getId());
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}

	/**
	 * 
	 * @param fase
	 * @return
	 */

	private boolean existe(Fase fase) {

		List<Fase> faseResponse = new ArrayList<>();

		if (fase.getId() != null) {

			faseResponse = this.faseService.existe(fase.getId());

			if (faseResponse.size() > 0) {
				return true;

			}
		}

		return false;

	}

	/**
	 * 
	 * @param fase
	 * @return
	 */
	private boolean validate(Fase fase) {

		boolean isValid = true;

		if (StringUtils.trimToNull(fase.getDescripcion()) == null) {

			isValid = false;

		}

		return isValid;

	}

}
