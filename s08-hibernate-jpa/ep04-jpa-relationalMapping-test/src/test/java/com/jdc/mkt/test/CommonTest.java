package com.jdc.mkt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CommonTest {

	private static EntityManagerFactory emf;
	

	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("testMapping");
	}
	
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen())
			emf.close();
	}
	
	@Test
	void test() {}
}
