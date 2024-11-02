package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.StateService;

@SpringBootTest
public class StateExampleTest {

	@Autowired
	StateService service;
	
	@Test
	@Disabled
	void testWithNullHandler() {
		var list = service.searchWithNullHandler("Magway Region", "Central");
		list.forEach(s -> System.out.println("Name  :"+s.getName()));
	}
	
	@Test
	@Disabled
	void testWithIgnoreCase() {
		var list = service.searchWithIgnoreCase("magway region", "Central");
		list.forEach(s -> System.out.println("Name  :"+s.getName()));
	}
	
	@Test
	void testWithStringMatcher() {
		var list = service.searchWithStringMatcher("region", "Central");
		list.forEach(s -> System.out.println("Name  :"+s.getName()));
	}
}
