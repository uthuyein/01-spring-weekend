package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product.Size;

import jakarta.persistence.PersistenceException;

public class StateChangeTest extends CommonFactoryTest {
	
	@Test
	void removeTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		var p = em.find(Product.class, 1);
		assertTrue(em.contains(p));
		
		em.detach(p);
		assertFalse(em.contains(p));
		
		assertThrows(IllegalArgumentException.class, () -> em.remove(p));
				
		em.getTransaction().commit();
	}
	
	//@Test
	void mergeTest() {
		var em = emf.createEntityManager();
		var p = getProduct();
		em.getTransaction().begin();
		
		var p1 = em.merge(p);
		assertTrue(em.contains(p1));
		
		em.detach(p1);
		assertFalse(em.contains(p1));
		
		var p2 = em.merge(p1);
		assertTrue(em.contains(p2));
		
		em.remove(p2);
		assertFalse(em.contains(p2));
		
		assertThrows(IllegalArgumentException.class, () -> em.merge(p2));
		
		em.getTransaction().commit();
	}

	//@Test
	void persistTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var p = getProduct();
		
		em.persist(p);
		assertTrue(em.contains(p));
		
		em.remove(p);
		assertFalse(em.contains(p));
		
		em.persist(p);
		assertTrue(em.contains(p));
		
		em.detach(p);
		assertFalse(em.contains(p));
		
		assertThrows(PersistenceException.class, () -> em.persist(p));
		em.getTransaction().commit();
	}
	
	private Product getProduct() {
		var p = new Product("Gar Gar snacks",2000.0,Size.SMALL);
		var c = new Category();
		c.setName("Snack");	
		c.addProduct(p);
		return p; 
	}
}
