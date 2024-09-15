package com.jdc.mkt.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "com.jdc.mkt.services")
@EnableTransactionManagement
public class AppConfig {
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return emf;
	}
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
