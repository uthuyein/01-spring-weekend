package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.RegionService;

@SpringBootTest
public class RegionExampleTest {

	@Autowired
	private RegionService regionService;
	
	@Test
	void findWithRegionTest() {
		var list = regionService.findByRegionName("Central");
		var name = list.stream().findFirst().get().getName();
		System.out.println("Name :"+name);
	}
}
