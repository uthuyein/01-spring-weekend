package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Patient;
import com.jdc.mkt.entity.Patient.Gender;

public class GetResultTest extends CommonFactory{
	
	@Order(3)
	@ParameterizedTest
	@CsvSource({"Aung Aung,MALE,aung@gmail.com,094534534","Sandar,FEMALE,sandar@gmail.com,094534343"})
	void testResultStreamWithParamName(String name,String gender,String email,String resultPhone) {
		var em = emf.createEntityManager();
		var query = em.createQuery("select p from Patient p where p.name = :name and p.gender = :gender and p.contact.email = :email ",Patient.class);
		query.setParameter("name", name);
		query.setParameter("gender", Gender.valueOf(gender));
		query.setParameter("email", email);
		
		var stream = query.getResultStream();
		
		assertEquals(resultPhone, stream.findFirst().get().getContact().getPhone());
		
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource({"MALE,2","FEMALE,1"})
	void testResultListWithParamName(String gender,int result) {
		var em = emf.createEntityManager();
		var query = em.createQuery("select p from Patient p where p.gender = :gender ",Patient.class);
		query.setParameter("gender", Gender.valueOf(gender));	
		
		var list = query.getResultList();
		
		assertNotNull(list);
		assertEquals(result, list.size());
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource(delimiter = ':',value = {
		"sandar:094534343:1990-10-12:FEMALE",
		"Aung Aung:094534534:1988-02-11:MALE"		
			})
	void testSingleResultWithParamIndex(String name,String phone,String resultDate,String resultGender) {
		var em = emf.createEntityManager();
		var query = em.createQuery("select p from Patient p where p.name = ?1 and p.contact.phone = ?2",Patient.class);
		query.setParameter(1, name);
		query.setParameter(2, phone);
		
		var patient = query.getSingleResult();
		
		assertNotNull(patient);
		assertAll(() -> {
			assertEquals(LocalDate.parse(resultDate), patient.getDob());
			assertEquals(Gender.valueOf(resultGender), patient.getGender());
		});
	}	
}
