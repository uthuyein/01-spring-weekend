package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GetUpdateTest extends CommonFactory {

	@ParameterizedTest
	@CsvSource("1,Yangon,Latha,122block b22 a1,1")
	void updateResultTest(int id,String state,String township,String address,int result) {
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
}
