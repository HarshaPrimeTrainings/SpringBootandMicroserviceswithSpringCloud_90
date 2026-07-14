package com.training.multidatabaseservice.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

	@Primary
	@ConfigurationProperties(prefix = "spring.mysql.datasource")
	@Bean("mysql")
	public DataSource mySqlDataSouece() {
		return DataSourceBuilder.create().build();
	}
	
	
	@ConfigurationProperties(prefix = "spring.pgdb.datasource")
	@Bean("pgdb")
	public DataSource pgDbDataSouece() {
		return DataSourceBuilder.create().build();
	}
	
}
