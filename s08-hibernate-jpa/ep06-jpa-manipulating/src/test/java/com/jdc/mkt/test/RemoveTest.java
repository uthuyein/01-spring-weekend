package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

public class RemoveTest extends CommonFactoryTest {

	//@Test
	void removeProductTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var p1 = em.find(Product.class, 1);
		em.remove(p1);
		em.getTransaction().commit();
	}
	@Test
	void removeCategoryTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();	
		var cat = em.find(Category.class, 1);
		
		System.out.println("Before :"+cat.getProducts());
		cat.getProducts().remove(0);
		System.out.println("After :"+cat.getProducts());
		em.getTransaction().commit();
	}
	
}
