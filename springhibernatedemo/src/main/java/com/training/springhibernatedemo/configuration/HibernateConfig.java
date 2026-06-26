package com.training.springhibernatedemo.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

	@Bean
	public SessionFactory initSession() {
		//Registry
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//metadata
		Metadata metadata = new MetadataSources(sr).getMetadataBuilder().build();
		//session
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		return sf;
	}
}
