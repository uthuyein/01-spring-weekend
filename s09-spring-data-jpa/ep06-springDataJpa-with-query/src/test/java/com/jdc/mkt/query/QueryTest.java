package com.jdc.mkt.query;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.repo.ProductRepo;

public class QueryTest  extends TestConfig{

	@Autowired
	ProductRepo repo;

	@Order(5)
	@Test
	void nativeQueryTest() {
		var list = repo.selectAllProductByCat("Levis");
		System.out.println(list);
	}
	
	@Order(4)
	@Test
	void namedNativeQueryTest() {
		var list = repo.selectAllProduct();
		System.out.println(list);
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource("T-Shirt")
	void queryTest(String cat) {
		var list = repo.selectProductByCategory(cat);
		System.out.println(list);
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource("20000,60000")
	void nameQueryTestWithNameParam(int frm,int to) {
		var list = repo.findProductByPrice(frm, to);
		System.out.println(list);
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource("Levis")
	void nameQueryTestWithIndexParam(String name) {
		var list = repo.findProductByNam(name);
		System.out.println(list);
	}
	
	
}
