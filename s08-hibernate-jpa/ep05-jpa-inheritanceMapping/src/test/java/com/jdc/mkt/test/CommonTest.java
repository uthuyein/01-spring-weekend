package com.jdc.mkt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Teacher;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CommonTest {

private static EntityManagerFactory emf;
	

	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("inheritanceMapping");
	}
	
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen())
			emf.close();
	}
	
	@Test
	void test() {
		Teacher stu = new Teacher();
		stu.setName("andrew");
		stu.setLoginId("andrew");
		stu.setPassword("123");
		stu.setTeaching("java");
		stu.setAge("34");
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(stu);
		em.getTransaction().commit();
	}
}
