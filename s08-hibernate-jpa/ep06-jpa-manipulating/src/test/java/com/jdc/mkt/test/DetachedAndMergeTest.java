package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;

public class DetachedAndMergeTest extends CommonFactoryTest{

	@Test
	void detachTest() {
		var em = emf.createEntityManager();
		
		var prod1 = em.find(Product.class, 1);
		assertTrue(em.contains(prod1));
		
		//to be detached
		em.detach(prod1);
		assertFalse(em.contains(prod1));
		
		//to be managed
		var prod2 = em.merge(prod1);
		assertTrue(em.contains(prod2));
		//to be detached
		em.clear();
		assertFalse(em.contains(prod2));
	}
}
