package com.gtc.cda.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
	
	@GetMapping(value="/")
	public String hello(){
		
		return "Bienvenido...";
		
	}

}
