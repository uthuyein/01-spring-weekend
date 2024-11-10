package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.BRegionServiceWithCriteria;
import com.jdc.mkt.services.AStateServiceWithCriteria;

@SpringBootTest
public class CriteriaTest {

	@Autowired
	AStateServiceWithCriteria service;
	@Autowired
	BRegionServiceWithCriteria regionService;
	
	@Test
	@Disabled
	void selectStateByNameLikeTest() {
		var list = service.selectStateByNameLike("k");
		System.out.println(list);
	}
	
	@Test
	@Disabled
	void selectStateByRegionNameLikeTest() {
		var list = service.selectStateByRegionNameLike("s");
		System.out.println(list);
	}
	
	@Test
	void selectRegionByStateNameLikeTest() {
		var list = regionService.selectRegionByStateNameLike("k");
		System.out.println(list);
	}
	
}
