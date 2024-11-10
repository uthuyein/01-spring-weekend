package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.DRegionServiceWithSpecification;

@SpringBootTest
public class RegionWithSpecificationTest {

	@Autowired
	DRegionServiceWithSpecification service;
	
	@Test
	@Disabled
	void selectRegionByStateNameLikeTest() {
		var list = service.selectRegionByStateNameLike("k");
		System.out.println(list);
	}
	@Test
	void deleteRegionByStateNameLikeTest() {
		var res = service.deleteRegionByStateNameLike("South");
		System.out.println(res);
	}
}
