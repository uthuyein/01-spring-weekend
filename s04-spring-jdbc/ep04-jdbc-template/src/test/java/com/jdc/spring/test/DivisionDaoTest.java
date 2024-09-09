package com.jdc.spring.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.model.DivisionDao;
import com.jdc.spring.model.dto.DivisionForm;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
public class DivisionDaoTest {

	@Autowired
	private DivisionDao dao;
	
	@Order(1)
	@ParameterizedTest
	@CsvFileSource(resources = "/test_create.txt",delimiter = ':')
	void test_create(String name,String capital,String region,int expectedId) {
		
		//Prepare input
		var form = new DivisionForm(name, capital, region);
		
		//Excute method
		var result = dao.create(form);
		
		//check result
		assertEquals(expectedId,result);		
	}
	
	@Order(2)
	@Test
	void test_count() {
		assertEquals(15, dao.countAll());
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvFileSource(resources = "/test_create.txt",delimiter = ':')
	void test_find_by_id(String name,String capital,String region,int expectedId) {	
		var result = dao.findById(expectedId);		
		assertAll(()->{
			assertNotNull(result);
			assertEquals(name, result.name());
			assertEquals(capital, result.capital());
			assertEquals(region, result.region());
		});
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"Mandalay Region,1"
	})
	void test_find_by_name(String name,int expectedSize) {	
		var result = dao.findByName(name);	
		assertEquals(expectedSize, result.size());
		
	}
	
	@Order(4)
	@ParameterizedTest
	@CsvSource({
		"Pathein,1"
	})
	void test_find_by_capital(String capital,int expectedSize) {		
		var result = dao.findByCapital(capital);	
		assertEquals(expectedSize, result.size());
		
	}
	
	@Order(4)
	@ParameterizedTest
	@CsvSource({
		"North,4",
		"South,5",
		"East,3",
		"West,3"
	})
	void test_find_by_region(String region,int expectedSize) {		
		var result = dao.findByRegion(region);	
		assertEquals(expectedSize, result.size());
		
	}
	
	@Order(5)
	@ParameterizedTest
	@CsvFileSource(resources = "/test_create.txt",delimiter = ':')
	void test_update(String name,String capital,String region,int expectedId) {
		var form = new DivisionForm(name.toUpperCase(), capital.toUpperCase(), region.toUpperCase());
	
		assertTrue(dao.update(expectedId, form));
		
		var result = dao.findById(expectedId);
	
		assertNotNull(result);
		assertEquals(form.name(), result.name());
		assertEquals(form.capital(), result.capital());
		assertEquals(form.region(), result.region());
	}
	
	@Order(6)
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15})
	void test_delete(int id) {
		assertTrue(dao.delete(id));
		var result = dao.findById(id);
		assertNull(result);
	}
}
