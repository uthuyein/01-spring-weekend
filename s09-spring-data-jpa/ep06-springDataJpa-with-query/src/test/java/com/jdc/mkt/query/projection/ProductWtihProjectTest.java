package com.jdc.mkt.query.projection;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.query.TestConfig;
import com.jdc.mkt.repo.project.ProductReopProj;

public class ProductWtihProjectTest extends TestConfig{

	@Autowired
	ProductReopProj repo;
	
	@Test
	@Order(1)
	void selectProductWithCategoryTest() {
		var list = repo.selectProductWithCategory();
		list.forEach(dto -> System.out.println(
				"Product id :%d\tName :%s\tCategory id :%d\tName :%s\n"
				.formatted(dto.getProductId(),
						dto.getProductName(),
						dto.getCategory().getId(),
						dto.getCategory().getName())));
	}
	@Test
	@Order(2)
	void selectProductIdNamePriceTest() {
		var list = repo.selectProductIdNamePrice();
		list.forEach(dto -> System.out.printf(
				"Product id :%d\tName :%s\tPrice :%d\n",
						dto.id(),
						dto.product(),
						dto.detailPrice()
						));
	}
}
