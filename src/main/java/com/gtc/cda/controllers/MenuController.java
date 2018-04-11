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
import com.gtc.cda.models.Menu;
import com.gtc.cda.services.MenuService;
import com.gtc.cda.util.RestResponse;

@CrossOrigin(origins="*")
@RestController
public class MenuController {
	
	@Autowired
	protected MenuService menuService;
	
	protected ObjectMapper mapper;
	
	
	/**
	 * Método crear o Actualizar Menu.
	 * @param menuJson
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	
	@RequestMapping(value ="/saveOrUpdateMenu", method = RequestMethod.POST)
	public RestResponse saveOrUpdateMenu(@RequestBody String menuJson) throws JsonParseException, JsonMappingException, IOException{
		
		this.mapper = new ObjectMapper();
		
		Menu menu = this.mapper.readValue(menuJson, Menu.class);
		
		if (!this.validate(menu)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		this.menuService.save(menu);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
		
	}
	
	
	/**
	 * Método consultar todos los menu.
	 * @return
	 */
	@RequestMapping(value ="/getAllMenus", method = RequestMethod.GET)
	public List<Menu> getAllMenus(){
		return  this.menuService.findAll();
		
	}
	
	
	/**
	 * Método eliminar menu.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteMenu", method = RequestMethod.POST)
	public void deleteMenu(@RequestBody String menuJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Menu menu = this.mapper.readValue(menuJson, Menu.class);
		
		if(menu.getId() == null){
			throw new Exception("El ID no puede ser nulo.");
		}
		
		this.menuService.deleteMenu(menu.getId());
		
	}
	
	
	
	
	private boolean validate(Menu menu) {
		
		boolean isValid = true;
		
		if (StringUtils.trimToNull(menu.getDescripcion()) == null ) {

			isValid = false;

		}
		
		return isValid;
		
	}

}
