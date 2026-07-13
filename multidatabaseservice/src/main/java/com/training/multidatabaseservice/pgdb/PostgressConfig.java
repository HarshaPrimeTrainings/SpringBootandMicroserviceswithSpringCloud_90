package com.training.multidatabaseservice.pgdb;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "com.training.multidatabaseservice.pgdb", 
	entityManagerFactoryRef = "pgdbentitymanager", 
	transactionManagerRef = "pgdbtransaction")
public class PostgressConfig {

	@Bean("pgdbentitymanager")
	public LocalContainerEntityManagerFactoryBean pgDBEntityManager(EntityManagerFactoryBuilder emb,@Qualifier("pgdb") DataSource ds) {
		return emb.dataSource(ds).packages("com.training.multidatabaseservice.pgdb").persistenceUnit("pgdb").build();
	}
	
	@Bean("pgdbtransaction")
	public PlatformTransactionManager pgDbTransaction(@Qualifier("pgdbentitymanager") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
