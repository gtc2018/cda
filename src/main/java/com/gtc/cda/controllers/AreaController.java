package com.gtc.cda.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
import com.gtc.cda.models.Area;
//import com.gtc.cda.models.Empresa;
import com.gtc.cda.services.AreaService;
import com.gtc.cda.util.RestResponse;

@RestController
public class AreaController {
	
	@Autowired
	protected AreaService areaService;
	
	protected ObjectMapper mapper;
	
	/**
	 * 
	 * @param cargoJson
	 * @return 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value ="/saveOrUpdateArea", method = RequestMethod.POST)
	public RestResponse saveOrUpdateArea(@RequestBody String areaJson) throws JsonParseException, JsonMappingException, IOException{
		
		this.mapper = new ObjectMapper();
		
		Area area = this.mapper.readValue(areaJson, Area.class);
		
//		JsonParser jsonParser = new JsonParser();		
//		JsonObject objectFromString = jsonParser.parse(areaJson).getAsJsonObject();
//		JsonObject cliente = jsonParser.parse(objectFromString.get("cliente").toString()).getAsJsonObject();
//		String clienteG = cliente.get("id").toString();
//		String descripcion = objectFromString.get("descripcion").toString();		
//		Empresa clienteTMP = new Empresa();
//		clienteTMP.setId(new Long(clienteG.substring(1, clienteG.length()-1)));		
//		Area area = new Area(); 
//		area.setCliente(clienteTMP);
//		area.setDescripcion(descripcion.substring(1, descripcion.length()-1));
//		
		if (!this.validate(area)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		this.areaService.save(area);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar Area
	 * @param areaJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteArea", method = RequestMethod.POST)
	public void deleteArea(@RequestBody String areaJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Area area = this.mapper.readValue(areaJson, Area.class);
		
		if(area.getId() == null){
			throw new Exception("El ID no puede ser nulo.");
		}		
		this.areaService.deleteArea(area.getId());		
	}
	
	/**
	 * Metodo consultar Cargo
	 * @return
	 */
	@RequestMapping(value ="/getAllAreas", method = RequestMethod.GET)
	public List<Area> getAllArea(){
		return  this.areaService.findAll();
		
	}	
	
	private boolean validate(Area cargo) {		
		boolean isValid = true;				
		return isValid;	
	}

}
