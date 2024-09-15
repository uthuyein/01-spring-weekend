package com.jdc.mkt.jpa_test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;

import jakarta.persistence.Persistence;

public class JpaTest {

	@Test
	 void create() {
		var emf = Persistence.createEntityManagerFactory("jpa-with-LEMF");
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var cat = new Category("Fruits");
		em.persist(cat);
		em.getTransaction().commit();
		
	}
}
