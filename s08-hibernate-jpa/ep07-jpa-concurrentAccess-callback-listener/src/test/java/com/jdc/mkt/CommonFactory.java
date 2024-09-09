package com.jdc.mkt;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestMethodOrder(OrderAnnotation.class)
public class CommonFactory {

	public static EntityManagerFactory emf;
	
	@BeforeAll
	 static void createEmf() {
		emf = Persistence.createEntityManagerFactory("ep07");
	}
	
	@AfterAll
	 static  void closeEmf() {
		if(null != emf && emf.isOpen())
			emf.close();
	}
}
