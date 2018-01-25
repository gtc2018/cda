/*

package com.gtc.cda.datasource;

import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("")
public class DataSourceConexion {
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String url;
	
	
	public void setUsername(String username) {this.username=username;}
	
	public void setPassword(String password) {this.password=password;}
	
	public void setUrl(String url) {this.url=url;}
	
	@Bean
	DataSource dataSource() throws SQLException {
		
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setImplicitCachingEnable(true);
		dataSource.setFastConnectionFailoverEnable(true);
		
		return dataSource;
	}
	

}
*/