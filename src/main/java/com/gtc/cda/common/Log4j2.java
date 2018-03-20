

package com.gtc.cda.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4j2 {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	String log(){
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warning message");
		logger.error("Error message");
		
		return "Ok";
	}
			
	
	

}

