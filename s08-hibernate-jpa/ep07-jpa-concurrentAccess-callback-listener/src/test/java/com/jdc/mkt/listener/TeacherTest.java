package com.jdc.mkt.listener;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.CommonFactory;
import com.jdc.mkt.entity.Teacher;

public class TeacherTest extends CommonFactory{

	@Test
	@Order(1)
	void create() {
		var em = emf.createEntityManager();
		var member = new Teacher();
		member.setLoginId("teacher1");
		member.setName("Daw Nu Nu Kyi");
		member.setPassword("123");
		member.setEmail("nnk@gmail.com");
		em.getTransaction().begin();
		em.persist(member);
		em.getTransaction().commit();
	}
	@Test
	@Order(2)
	void update() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();		
		var member = em.find(Teacher.class, 1);
		member.setLoginId("nnkyi");
		em.getTransaction().commit();
	}
}
