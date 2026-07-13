package com.training.multidatabaseservice.mysql;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "com.training.multidatabaseservice.mysql", 
	entityManagerFactoryRef = "mysqlentitymanager", 
	transactionManagerRef = "mysqltransaction")
public class MySQLConfig {
	
	@Primary
	@Bean("mysqlentitymanager")
	public LocalContainerEntityManagerFactoryBean mySQlEntityManager(EntityManagerFactoryBuilder emb,@Qualifier("mysql") DataSource ds) {
		return emb.dataSource(ds).packages("com.training.multidatabaseservice.mysql").persistenceUnit("mysql").build();
	}
	
	@Primary
	@Bean("mysqltransaction")
	public PlatformTransactionManager mySqlTransaction(@Qualifier("mysqlentitymanager") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
