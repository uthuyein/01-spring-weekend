package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.services.CategoryService;

public class CategoryTest implements FactoryTestConfig {

	@Autowired
	CategoryService service;
	
	@Test
	@Disabled
	void selectCatgoryById() {
		service.selectCategoryById(1);
	}
	@ParameterizedTest
	@CsvSource(value = "Hugo,1")
	void selectCategoryByProductName(String name,int res) {
		Category cat = service.selectCategoryByProductName(name);
		assertNotNull(cat);
		assertEquals("Trouser", cat.getName());
	}
}
