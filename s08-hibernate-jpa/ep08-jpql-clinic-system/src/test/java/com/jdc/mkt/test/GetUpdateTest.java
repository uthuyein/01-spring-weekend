package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GetUpdateTest extends CommonFactory {

	@ParameterizedTest
	@Order(1)
	@CsvSource(delimiter = ':', value = "1:Yangon:insein:no-22 b-2,thayayyon street:1")
	void updateResultTestWithDynamicQuery(int id,String state,String township,String address,int result) {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var query = em.createQuery("update Address a set a.state = :state , a.township = :township , a.address = :address where a.id = :id");
		
		query.setParameter("state", state);
		query.setParameter("township", township);
		query.setParameter("address", address);
		query.setParameter("id", id);
		
		var res = query.executeUpdate();
		assertEquals(result, res);
		em.getTransaction().commit();		
	}
	
	@ParameterizedTest
	@Order(2)
	@CsvSource(delimiter = ':',value = "Genearalist:099923342:09454353343:3:1")
	void updateResultTestWithStaticQuery(String special,String before,String after,int specialRes,int phoneRes) {
		var em = emf.createEntityManager( );
		em.getTransaction().begin();
		var querySpecial = em.createNamedQuery("doctor.updateSpecialization");
		querySpecial.setParameter("special", special);
		var res = querySpecial.executeUpdate();
		assertEquals(specialRes, res);

		var queryPhone = em.createNamedQuery("doctor.updateDepartment");
		queryPhone.setParameter("before", before);
		queryPhone.setParameter("after", after);
		var res1 = queryPhone.executeUpdate();
		assertEquals(phoneRes, res1);
		em.getTransaction().commit();
	}
}
