package com.jdc.mkt.query.dynamic;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.query.TestConfig;
import com.jdc.mkt.services.ProductService;

public class DynamicSearchTest extends TestConfig{
	
	@Autowired
	ProductService service;

	@ParameterizedTest
	@Order(1)
	@CsvSource({
		"HUGO,,0,0",
		"Levis,T-Shirt,0,0",
		"Adidas,T-Shirt,30000,0",
		"Adidas,T-Shirt,30000,28000"})
	void productTest(String product,String category,int dt,int ws) {
		var list = service.searchWithBaseRepo(product, category, dt, ws);
		System.out.println(list.size());
	}
}
