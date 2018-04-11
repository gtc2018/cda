package com.gtc.cda.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class MainRestController {
	
	@GetMapping(value="/")
	public String hello(){
		
		return "Bienvenido...";
		
	}

}
