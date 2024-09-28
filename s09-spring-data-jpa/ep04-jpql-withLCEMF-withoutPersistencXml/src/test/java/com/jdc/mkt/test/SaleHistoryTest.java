package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.services.SaleHisitoryService;


public class SaleHistoryTest implements FactoryTestConfig{

	@Autowired
	SaleHisitoryService service;
	
	@ParameterizedTest
	@CsvSource({
		",,,,9",
		"T-Shirt,,,,6",
		",Adidas,,,2",
		"T-Shirt,Adidas,,,2",
		",,2022-10-20,2022-10-23,7"
	})
	public void searchTest(String category,String product,String frmDate,String toDate,int result) {
		var list = service.search(category, product,
				getDate(frmDate),getDate(toDate));
		list.forEach(p -> System.out.println(p.product()+"\t"));
		System.out.println();
		assertEquals(result, list.size());
	}
	
	private LocalDate getDate(String date) {
		return null != date ?Date.valueOf(date).toLocalDate() : null;
	}
}
