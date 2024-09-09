package com.jdc.mkt.test;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Address;

public class JpqlTest extends CommonFactory{

	@Test
	@Order(1)
	void testQueryVsTypedQuery() {
		var em = emf.createEntityManager();
		//query
		var query  = em.createQuery("select a from Address a");
		@SuppressWarnings("unchecked")
		var addresses = (List<Address>)query.getResultList();
		System.out.println(addresses);
		
		//Typedquery
		var query1  = em.createQuery("select a from Address a",Address.class);
		var addresses1 = query1.getResultList();
		System.out.println(addresses1);
		
	}
	
	@Test
	@Order(2)
	void testStaticVsDynamic() {
		//dynamic query
		var em = emf.createEntityManager();
		var dynamicQuery = em.createQuery("select a from Address a where a.state = 'mandalay'",Address.class);
		System.out.println(dynamicQuery.getResultList());
		
		//static query
		var staticQuery = em.createNamedQuery("address.selectAllAddress",Address.class);
		System.out.println(staticQuery.getResultList());
	}
}
