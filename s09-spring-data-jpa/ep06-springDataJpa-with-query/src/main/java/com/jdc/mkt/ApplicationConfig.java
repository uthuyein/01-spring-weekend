package com.jdc.mkt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jdc.mkt.repo.common.BaseRepoImpl;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.jdc.mkt.repo",
		repositoryBaseClass = BaseRepoImpl.class)
@ComponentScan(basePackages = "com.jdc.mkt.services")
@PropertySource({"classpath:/connection.properties"})
public class ApplicationConfig {

	@Bean
	DataSource dataSource(
			@Value("${db.url}")String url,
			@Value("${db.user}")String user,
			@Value("${db.pass}")String pass) throws SQLException {
		var config = new BasicDataSource();
		config.setUrl(url);
		config.setUsername(user);
		config.setPassword(pass);
		return config;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) throws IOException {
		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(ds);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("com.jdc.mkt.entity");
		emf.setJpaProperties(jpaProperties());
		return emf;
	}

	private Properties jpaProperties() throws IOException {
		var prop = new Properties();
		prop.load(getClass().getResourceAsStream("/jpa.properties"));
		return prop;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	
	
}
