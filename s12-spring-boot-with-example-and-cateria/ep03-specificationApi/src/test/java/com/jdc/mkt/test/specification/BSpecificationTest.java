package com.jdc.mkt.test.specification;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.FSpecificationServiceFromState;
import com.jdc.mkt.services.GSpecificationServiceFromRegion;

@SpringBootTest
public class BSpecificationTest {

	@Autowired
	FSpecificationServiceFromState stateService;
	@Autowired
	GSpecificationServiceFromRegion regionService;
	
	@Test
	//@Disabled
	void findByRegionNameAndStateNameLike() {
		var list = regionService.findByNameAndStateNameLike("Central", "m");
		list.forEach(s -> System.out.println("State name :"+s.getName()));
	}
	
	
	@Test
	@Disabled
	void findByRegionName() {
		var list = stateService.findbyRegionName("Central");
		list.forEach(s -> System.out.println("State name :"+s.getName()));
	}
	
	@Test
	@Disabled
	void findByRegionNameNot() {
		var list = stateService.findbyRegionNameNot("Central");
		list.forEach(s -> System.out.println("State name :"+s.getName()));
	}
	
	@Test
	@Disabled
	void findByRegionNameAndCapitalNameLike() {
		var list = stateService.findByRegionNameAndCapitalNameLike("Central", "m");
		list.forEach(s -> System.out.println("State name :"+s.getName()));
	}
	
	@Test
	@Disabled
	void findByRegionNameOrCapitalNameLike() {
		var list = stateService.findByRegionNameOrCapitalNameLike("Central", "m");
		list.forEach(s -> System.out.println("State name :"+s.getName()));
	}
}
