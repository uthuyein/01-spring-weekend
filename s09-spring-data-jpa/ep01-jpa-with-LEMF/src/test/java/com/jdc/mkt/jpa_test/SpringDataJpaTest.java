package com.jdc.mkt.jpa_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.services.CategoryService;

//@SpringJUnitConfig(classes = AppConfig.class)
@SpringJUnitConfig(locations = "classpath:/application.xml")
public class SpringDataJpaTest {

	@Autowired
	CategoryService service;
	
	@Test
	void createTest() {
		var cat = new Category("Drinks");
		service.create(cat);
	}
}
