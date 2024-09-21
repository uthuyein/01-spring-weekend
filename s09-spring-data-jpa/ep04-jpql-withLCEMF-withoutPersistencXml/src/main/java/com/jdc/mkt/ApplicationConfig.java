package com.jdc.mkt;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@PropertySource("classpath:/jpa.properties")
@ComponentScan(basePackages = "com.jdc.mkt.services")
@EnableTransactionManagement
public class ApplicationConfig {
	
	@Bean
	DataSource dataSource(
			@Value("${db.url}")String url,
			@Value("${db.user}")String user,
			@Value("${db.pass}")String pass) throws SQLException {
		var config = new BoneCPConfig();
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(pass);
		return new BoneCPDataSource(config);
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(ds);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("com.jdc.mkt.entity");
		emf.setJpaPropertyMap(jpaProperties());
		return emf;
	}

	private Map<String, ?> jpaProperties() {
		var map =  new HashMap<String, String>();
		map.put("hibernate.hbm2ddl.auto", "create");
		map.put("hibernate.show_sql", "true");
		map.put("hibernate.format_sql", "true");
		return map;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
