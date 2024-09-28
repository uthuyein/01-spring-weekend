package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.services.ProductService;

public class ProductTest implements FactoryTestConfig{

	@Autowired
	ProductService service;
	
	@Test
	@Disabled
	void selectProductById() {
		service.selectProduct(1);
	}
	
	@ParameterizedTest
	@CsvSource("thida aye,5")
	void selectProductByCashierName(String name,int res) {
		var list = service.selectProductByCanshierName(name);
		assertEquals(res, list.size());
		
	}
	
	@ParameterizedTest
	@Disabled
	@CsvSource("40000,60000,5")
	void selectProductByDetailPrice(Integer frmPrice,Integer toPrice,int res) {
		var list = service.selectProductByDetailPrice(frmPrice,toPrice);
		assertEquals(res, list.size());
		list.stream().forEach(p -> System.out.println(p.category()+"\t"+p.product()+"\t"+p.dtPrice()));
	}
	
	@ParameterizedTest
	@Disabled
	@CsvSource({"T-Shirt,5","Trouser,5","Wallet,0"})
	void selectProductByCategoryName(String name,int size) {
		List<Product> products =  service.selectProductByCategoryName(name);
		assertEquals(size, products.size());
		
		var pList = service.selectProductByCategoryNameWithLeftJoin(name);
		System.out.println("Size :"+pList.size());
	}
}
