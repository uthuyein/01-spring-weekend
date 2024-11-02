package com.jdc.mkt.query.projection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.dto.inter.SelectProductNameAndCustomerNameInfDto;
import com.jdc.mkt.query.TestConfig;
import com.jdc.mkt.repo.project.SalesRepoProj;

public class SaleWithProjectTest extends TestConfig{

	@Autowired
	SalesRepoProj repo;
	
	@Test
	@Disabled
	@Order(1)
	void selectPNameAndCNameTest() {
		var list = repo.selectPNameAndCName();
		for(SelectProductNameAndCustomerNameInfDto dto :list) {
			System.out.println(dto.getName()+"\t\t"+dto.getUsername());
		}
	}
	@Test
	@Disabled
	@Order(2)
	void selectPNameCNameDtPriceQtyTest() {
		var list = repo.selectPNameCNameDtPriceQty();
		list.forEach(dto -> System.out.println(
				"Sale Date :%s\tCategory :%s\tProduct :%s\tPrice :%d\tQtys :%d\n"
				.formatted(
						dto.getDate(),
						dto.getCategory(),
						dto.getProduct(),
						dto.getPrice(),
						dto.getQtys())));
	}
	
	@Test
	@Order(3)
	void selectProductQtyTotalTest() {
		var list = repo.selectProductQtyTotal();
//		list.forEach(dto -> System.out.println(
//				"Product :%.5s\tPrice :%d\tQtys :%d\tTotal Price :%d\n"
//				.formatted(
//						dto.getProduct(),
//						dto.getPrice(),
//						dto.getTotalQtys(),
//						dto.getTotalPrice()
//						)));
		
		//with default method
		//list.forEach(dto -> dto.data());
		
		//with spring El expression
		list.forEach(dto -> System.out.println( dto.getValue()));
	}
}
