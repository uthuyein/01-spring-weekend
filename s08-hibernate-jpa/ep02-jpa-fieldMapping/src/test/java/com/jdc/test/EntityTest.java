package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EntityTest {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("fieldMapping");
	}
	
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen())
			emf.close();
	}
	
	@Test
	void test() {
		
	}
}
