package com.jdc.mkt.query.projection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.dto.SelectProductNameAndCustomerNameInfDto;
import com.jdc.mkt.query.TestConfig;
import com.jdc.mkt.repo.project.SalesRepo;

public class SaleWithProjectTest extends TestConfig{

	@Autowired
	SalesRepo repo;
	
	@Test
	void selectPNameAndCName() {
		var list = repo.selectPNameAndCName();
		for(SelectProductNameAndCustomerNameInfDto dto :list) {
			System.out.println(dto.getName()+"\t\t"+dto.getUsername());
		}
	}
}
