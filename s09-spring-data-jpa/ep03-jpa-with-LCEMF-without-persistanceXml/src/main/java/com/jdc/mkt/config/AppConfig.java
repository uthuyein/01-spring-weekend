package com.jdc.mkt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "com.jdc.mkt.services")
@PropertySource("classpath:/props/jpa.properties")
@EnableTransactionManagement
public class AppConfig {
	
	@Value("${db.url}")
	private String URL;
	@Value("${db.user}")
	private String USER;	
	@Value("${db.pass}")
	private String PASSWORD;
	
	@Bean
	DataSource dataSource() {
		var ds = new BasicDataSource();			
		ds.setUrl(URL);
		ds.setUsername(USER);
		ds.setPassword(PASSWORD);
		return ds;
	}
		
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.jdc.mkt.entity");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	
		bean.setJpaProperties(jpaProperties());
		return bean;
	}

	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		
		return new JpaTransactionManager(emf);
	}
	
	private Properties jpaProperties() {
		var prop = new Properties();
		prop.setProperty("jakarta.persistence.schema-generation.database.action", "drop-and-create");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.format_sql", "true");
		return prop;
	}
}
