package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

public class ManageStateTest extends CommonFactoryTest{

	//@Test
	void manageStateFromTransient() {
		var em = emf.createEntityManager();	
		var product = new Product("Watermelon",2000.0,com.jdc.mkt.entity.Product.Size.MEDIUM);
		var cat = new Category();
		cat.setId(1);
		product.setCategory(cat);
		em.getTransaction().begin();
		em.persist(product);
		product.setPrice(2500.0);
		assertTrue(em.contains(product));
		em.getTransaction().commit();
		
	}
	
	//@Test
	void managedStateFromFind() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var prod1 = em.find(Product.class, 1);
		assertNotNull(prod1);
		assertTrue(em.contains(prod1));	
		prod1.setName("test");
		em.getTransaction().commit();
	}
	
	@Test
	void managedStateFromDetach() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var prod1 = em.find(Product.class, 1);
		em.detach(prod1);
		assertFalse(em.contains(prod1));
		var prod2 = em.merge(prod1);
		
		assertFalse(em.contains(prod1));
		assertTrue(em.contains(prod2));
		
		prod2.setName("prod2");
		em.getTransaction().commit();
	}
}
