package com.gtc.cda.controllers;

import java.io.IOException;
import java.util.List;

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
import com.gtc.cda.models.Item;
import com.gtc.cda.services.ItemService;
import com.gtc.cda.util.RestResponse;

@RestController
public class ItemController {
	
	@Autowired
	protected ItemService itemService;
	
	protected ObjectMapper mapper;
	
	/**
	 * 
	 * @param itemJson
	 * @return 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value ="/saveOrUpdateItem", method = RequestMethod.POST)
	public RestResponse saveOrUpdateItem(@RequestBody String itemJson) throws JsonParseException, JsonMappingException, IOException{
		
		this.mapper = new ObjectMapper();
		
		Item item = this.mapper.readValue(itemJson, Item.class);
		
		if (!this.validate(item)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		this.itemService.save(item);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	/**
	 * Metodo Eliminar Item
	 * @param itemJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteItem", method = RequestMethod.POST)
	public void deleteItem(@RequestBody String itemJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Item item = this.mapper.readValue(itemJson, Item.class);
		
		if(item.getId() == null){
			throw new Exception("El ID no puede ser nulo.");
		}
		
		this.itemService.deleteItem(item.getId());
		
	}
	
	/**
	 * Metodo consultar Items
	 * @return
	 */
	@RequestMapping(value ="/getAllItem", method = RequestMethod.GET)
	public List<Item> getAllItem(){
		return  this.itemService.findAll();
		
	}
	
	
	private boolean validate(Item item) {
		
		boolean isValid = true;
		
		if (StringUtils.trimToNull(item.getDescripcion()) == null ) {

			isValid = false;

		}
		
		if (StringUtils.trimToNull(item.getIcono()) == null ) {

			isValid = false;

		}
		
		return isValid;
		
	}

}
