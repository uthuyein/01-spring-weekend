package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.CStateServiceSpecification;

@SpringBootTest
public class StateWithSpecificationTest {

	@Autowired
	CStateServiceSpecification service;
	
	@Test
	@Disabled
	void selectStateByRegionNameLike() {
		var list = service.selectStateByRegionNameLike("s");
		System.out.println(list);
	}
	@Test
	@Disabled
	void selectStateByRegionName() {
		var list = service.selectStateByRegionNameWithJoin("North West");
		System.out.println(list);
	}
	
	@Test
	@Disabled
	void deleteByStateName() {
		var res = service.deleteByStateName("Ayeyarwady Region");
		System.out.println(res);
	}
}
