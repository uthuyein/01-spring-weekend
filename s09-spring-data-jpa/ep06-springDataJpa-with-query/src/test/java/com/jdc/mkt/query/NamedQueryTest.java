package com.jdc.mkt.query;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.repo.ProductRepo;

public class NamedQueryTest  extends TestConfig{

	@Autowired
	ProductRepo repo;
	
	@Order(2)
	@ParameterizedTest
	@CsvSource("20000,60000")
	void nameQueryTest(int frm,int to) {
		var list = repo.findProductByPrice(frm, to);
		System.out.println(list);
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource("Levis")
	void nameQueryTest(String name) {
		var list = repo.findProductByNam(name);
		System.out.println(list);
	}
	
	
}
