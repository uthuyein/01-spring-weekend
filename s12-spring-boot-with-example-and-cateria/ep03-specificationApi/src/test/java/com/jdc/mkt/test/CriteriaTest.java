package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.StateService;

@SpringBootTest
public class CriteriaTest {

	@Autowired
	StateService service;
	
	@Test
	void test() {
		var list = service.selectStateByNameLike("k");
		System.out.println(list);
	}
}
