package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.StateService;
import com.jdc.mkt.services.StateWithProjectionService;

@SpringBootTest
public class StateExampleTest {

	@Autowired
	StateService service;
	@Autowired
	StateWithProjectionService stateProjService;
	
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
	@Disabled
	void testWithStringMatcher() {
		var list = service.searchWithStringMatcher("region", "Central");
		list.forEach(s -> System.out.println("Name  :"+s.getName()));
	}
	
	@Test
	@Disabled
	void testWithPrpertiesMatcher() {
		var list = service.searchWithPropteriesMatcher("n", "Central");
		list.forEach(s -> System.out.println("Name  :"+s.getName()));
	}
	
	@Test
	void testWithProjectMatcher() {
		var list = stateProjService.selectWithProjection("n", "Central");
		list.forEach(s -> System.out.printf("State  :%s\t%s\t%s\n",s.getName(),s.getCapital(),s.getRegion().getName()));
	}
}
