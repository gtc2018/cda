package com.gtc.cda.test;



import javax.activation.DataSource;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gtc.cda.config.SpringRootConfig;

public class TestDataSource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		DataSource ds = ctx.getBean(DataSource.class);
		//JdbcTemplate jt = new JdbcTemplate(ds);

	}

}
