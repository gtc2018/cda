package com.gtc.cda.controller;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.interfaces.EmpresaService;
import com.gtc.cda.modelo.Empresa;
import com.gtc.cda.util.RestResponse;

@RestController
public class EmpresaController {

	@Autowired
	protected EmpresaService empresaService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String empresaJson)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();

		Empresa empresa = this.mapper.readValue(empresaJson, Empresa.class);

		if (!this.validate(empresa)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}

		this.empresaService.save(empresa);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");

	}

	private boolean validate(Empresa empresa) {
		boolean isValid = true;

		if (StringUtils.trimToNull(empresa.getEmpresaId()) == null ) {

			isValid = false;

		}
		
		if (StringUtils.trimToNull(empresa.getDescripcion()) == null ) {

			isValid = false;

		}
		
		if (StringUtils.trimToNull(empresa.getNit()) == null ) {

			isValid = false;

		}
		
		if (StringUtils.trimToNull(empresa.getEmail()) == null ) {

			isValid = false;

		}

		return isValid;
	}

}
