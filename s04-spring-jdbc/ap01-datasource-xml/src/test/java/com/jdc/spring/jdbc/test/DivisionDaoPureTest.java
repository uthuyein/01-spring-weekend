package com.jdc.spring.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.jdbc.impl.DivisionDaoPure;
import com.jdc.spring.jdbc.impl.DivisionDaoTemplate;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class DivisionDaoPureTest {

	@SuppressWarnings("unused")
	@Autowired
	private DivisionDaoPure dao;
	@Autowired
	private DivisionDaoTemplate template;
	
	@Test
	void test_find_all() {
		var result = template.findAll();
		assertNotNull(result);
		assertEquals(15, result.size());
	}
}
