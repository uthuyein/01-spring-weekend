package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product.Size;

import jakarta.persistence.EntityNotFoundException;

public class FindAndGetReferenceTest extends CommonFactoryTest {

	// @Test
	void insertTest() {
		var product = new Product("Durian", 50000.0,Size.MEDIUM);
		var cat = new Category();
		cat.setId(1);
		product.setCategory(cat);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
	}
	
	//@Test
	void notFoundEntityWithFindAndGetReference() {
		var em = emf.createEntityManager();
		var prod1 =  em.find(Product.class, 6);
		assertNull(prod1);
		var prod2 = em.getReference(Product.class, 6);
		assertNotNull(prod2);
		assertThrows(EntityNotFoundException.class,() -> prod2.setName("ss"));
		
	}

	@Test
	void findAndGetReferenceTest() {
		var em = emf.createEntityManager();
		System.out.println("-------------------     Using find method ! ----------");
		var product = em.find(Product.class, 1);
		assertNotNull(product);
		em.close();
		assertEquals("Orange", product.getName());	
		
		
		System.out.println("----------------    Using getReference method ! -------------");
		var em1 = emf.createEntityManager();
		var product1 = em1.getReference(Product.class, 1);
		assertNotNull(product1);
		em1.close();
		assertThrows(LazyInitializationException.class, () -> product1.getName());
		
	}
}
