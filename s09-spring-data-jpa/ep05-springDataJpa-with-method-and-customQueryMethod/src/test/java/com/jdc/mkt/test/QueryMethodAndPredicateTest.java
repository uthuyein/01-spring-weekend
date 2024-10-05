package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Sales;
import com.jdc.mkt.repo.ProductRepoWithCustomQueryMethod;
import com.jdc.mkt.repo.SaleRepoWithCustomQueryMethod;

public class QueryMethodAndPredicateTest extends TestConfig{

	@Autowired
	ProductRepoWithCustomQueryMethod productRepo;
	
	@Autowired
	SaleRepoWithCustomQueryMethod saleRepo;
	
	@Order(5)
	@ParameterizedTest
	@CsvSource("thida,2022-10-22")
	void allTest(String cashier,String date) {
		List<Sales> list1 = saleRepo.findByCashierUsernameLikeAndSaleDateAfter(cashier.concat("%"),Date.valueOf(date).toLocalDate());
		assertEquals(4, list1.size());
	}
	
	@Order(4)
	@ParameterizedTest
	@CsvSource("2022-10-22")
	void dateTimeBaseTest(String date) {
		List<Sales> list1 = saleRepo.findBySaleDateAfter(Date.valueOf(date).toLocalDate());
		assertEquals(6, list1.size());
		
		List<Sales> list2 = saleRepo.findBySaleDateIsBefore(Date.valueOf(date).toLocalDate());
		assertEquals(3, list2.size());
		
//		List<Sales> list3 = saleRepo.findBySaleDateIsWithin(Date.valueOf(date).toLocalDate(),Date.valueOf("2022-10-25").toLocalDate());
//		assertEquals(4, list3.size());
	}
	
	@Test
	@Order(3)
	void numericBaseTest() {
		List<Product> products1 = productRepo.getByDetailPriceGreaterThanEqual(65000);
		assertEquals(3, products1.size());
		
		List<Product> products2 = productRepo.getByDetailPriceLessThanEqual(30000);
		assertEquals(2, products2.size());
		
		List<Product> products3= productRepo.getByDetailPriceIsLessThan(40000);
		assertEquals(4, products3.size());
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource("Lev")
	void stringBaseTest(String name) {
		List<Product> products1 = productRepo.findByNameLike(name.concat("%"));
		assertEquals(4, products1.size());
		
		List<Product> products2 = productRepo.findByNameStartingWith(name);
		assertEquals(4, products2.size());
		
		List<Product> products3 = productRepo.findByNameEndingWith("s");
		assertEquals(7, products3.size());
		
		List<Product> products4 = productRepo.findByNameContaining("i");
		assertEquals(7, products4.size());
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource("Levis,55000")
	void logicalTest(String name,int dtPrice) {
		var andProducts = productRepo.findByNameAndDetailPrice(name, dtPrice);
		assertEquals(1, andProducts.size());
		
		List<Product> orProducts = productRepo.findByNameOrDetailPrice(name, dtPrice);
		assertEquals(6, orProducts.size());
		
		boolean existProducts = productRepo.existsByName(name);
		assertTrue(existProducts);

	}
	
	
}
