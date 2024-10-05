package com.jdc.mkt.query;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.repo.SalesHistoryRepo;

public class SaleHistoryTest extends TestConfig{

	@Autowired
	SalesHistoryRepo repo;
	
	@Order(4)
	@ParameterizedTest
	@CsvSource({"Su Su,3","thida aye,4"})
	void selectProductByCustomerName(String name,int res) {
		var list = repo.selectProductByCustomerName(name);
		assertEquals(res, list.size());
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource("Levis")
	void selectCountByProductName(String name) {
		var count = repo.selectCountByProduct(name);
		assertEquals(5, count);
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource("2022-10-25")
	void selectProductBySaleDateWithSql(String date) {
		var list = repo.selectProductBySaleDateWithSql(Date.valueOf(date).toLocalDate());
		assertEquals(5, list.size());
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource("2022-10-25")
	void selectProductBySaleDate(String date) {
		var list = repo.selectProductBySaleDateWithJpql(Date.valueOf(date).toLocalDate());
		assertEquals(5, list.size());
	}
}
