package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.ApplicationConfig;
import com.jdc.mkt.entity.Category;
import com.jdc.mkt.services.CategoryService;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class CategoryTest {

	@Autowired
	CategoryService service;
	
	@Test
	void testCreate() {
		var cat = new Category("Fruits");
		service.create(cat);
	}
}
