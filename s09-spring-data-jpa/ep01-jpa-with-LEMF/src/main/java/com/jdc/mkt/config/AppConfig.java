package com.jdc.mkt.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "com.jdc.mkt.services")
@EnableTransactionManagement
public class AppConfig {
	
	@Bean
	LocalEntityManagerFactoryBean enManagerFactory() {
		var emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return emf;
	}
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
