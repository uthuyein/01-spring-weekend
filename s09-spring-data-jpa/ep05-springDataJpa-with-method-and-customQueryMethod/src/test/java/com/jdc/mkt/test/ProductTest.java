package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.enumeration.Size;
import com.jdc.mkt.repo.ProductRepo;

public class ProductTest extends TestConfig{

	@Autowired
	private ProductRepo repo;
	
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"Test,30000,28000,1,13"
	})
	void saveTest(String name,int dtPrice,int wsPrice,int catId,int res) {
		var p = new Product();
		p.setName(name);
		p.setDetailPrice(dtPrice);
		p.setWholeSalePrice(wsPrice);
		p.setCategory(new Category(catId));
		var product =  repo.save(p);
		assertEquals(res, product.getId());
	}
	@Test
	@Order(2)
	void saveAllTest() {
		List<Product> list = List.of(
				new Product("O2",5000,4500,List.of(Size.SMALL,Size.MEDIUM),new Category(1)),
				new Product("Myanmar",5000,4500,List.of(Size.SMALL,Size.MEDIUM,Size.LARGE),new Category(1)));
		var resList = repo.saveAll(list);
		assertEquals(2, resList.size());
	}
	
	@Order(3)
	@ParameterizedTest
	@ValueSource(ints = 15)
	void findAllTest(int result) {
		assertEquals(result, repo.findAll().size());
	}
	
	@Test
	@Order(4)
	void deleteAllTest() {
		List<Product> list = List.of(
				new Product(13),
				new Product(14));
		 repo.deleteAll(list);
		assertEquals(13, repo.findAll().size());
		
//		List<Integer> ids = List.of(10,11);
//		repo.deleteAllById(ids);
//		assertEquals(10, repo.findAll().size());
		
	}
}
