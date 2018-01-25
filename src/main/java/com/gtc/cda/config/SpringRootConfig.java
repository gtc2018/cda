/*
package com.gtc.cda.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan(basePackages = {"com.gtc.cda"})
public class SpringRootConfig {
	
	@Bean
	public BasicDataSource getDataSource(){
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/cda");
		ds.setUsername("root");
		ds.setPassword("");
		
		ds.setMaxActive(2);
		ds.setInitialSize(1);
		ds.setTestOnBorrow(true);
		ds.setValidationQuery("SELECT 1");
		ds.setDefaultAutoCommit(true);
		
		
		return ds;
	}
	

}

*/
