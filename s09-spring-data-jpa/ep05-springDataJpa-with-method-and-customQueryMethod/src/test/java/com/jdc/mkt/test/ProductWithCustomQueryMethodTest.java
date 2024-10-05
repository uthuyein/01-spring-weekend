package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.repo.ProductRepoWithCustomQueryMethod;

public class ProductWithCustomQueryMethodTest extends TestConfig{

	@Autowired
	ProductRepoWithCustomQueryMethod repo;
	
	@Order(1)
	@ParameterizedTest
	@CsvSource("Adidas,1")
	void testFindByProductName(String name,int res) {
		var list = repo.searchByName(name);
		assertEquals(res, list.size()); 
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource("T-shirt,5")
	void testCountByCategoryName(String name,int res) {
		var count = repo.countByCategoryName(name);
		assertEquals(res, count); 
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource("T-shirt,3")
	void testFindFirstByCategoryName(String name,int res) {
		var stream = repo.findFirst3ByCategoryName(name);
		assertEquals(res, stream.size());
	}
	
	@Order(4)
	@ParameterizedTest
	@CsvSource("50000,4")
	void getDistinctByProductName(int wsPrice,int res) {
		var list = repo.getDistinctByWholeSalePrice(wsPrice);
		assertEquals(res, list.size());
	}
	
	@Order(5)
	@ParameterizedTest
	@CsvSource("Wallet,10")
	@Transactional
	void deleteByCategoryName(String cat,int res) {
//		repo.deleteByCategoryName(cat);
//		assertEquals(res, repo.findAll().size());
	}
}
