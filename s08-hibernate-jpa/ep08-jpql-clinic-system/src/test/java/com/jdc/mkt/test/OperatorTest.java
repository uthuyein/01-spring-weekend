package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Patient;
import com.jdc.mkt.entity.dto.PatientDto;
import com.jdc.mkt.entity.dto.PatientWithBetweenOpe;

public class OperatorTest extends CommonFactory{

	@ParameterizedTest
	@Order(1)
	@ValueSource(ints = 7)
	void selectCountTest(int res) {
		em.getTransaction().begin();
		var query = em.createQuery("select count(p) from Patient p ",Long.class);
		var result = query.getSingleResult();
		
		assertEquals(res, result);
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@Order(2)
	@CsvSource("Aya Thida")
	void selectWithNestestTest(String name) {
		em.getTransaction().begin();
		var query = em.createQuery("""
				select p from Patient p where p.dob =
				(select max(p.dob) from Patient p) 
				""",Patient.class);
		var patient = query.getSingleResult();
		assertEquals(name, patient.getName());
		
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@Order(3)
	@ValueSource(ints = 7)
	void selectOneFieldTest(int res) {
		em.getTransaction().begin();
		var query = em.createQuery("select contact.email from Patient ",String.class);
		var list = query.getResultList();
		
		assertEquals(res, list.size());
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@Order(4)
	@ValueSource(ints = 7)
	void selectNewOpeTest(int res) {
		em.getTransaction().begin();
		var query = em.createQuery("""
				select new com.jdc.mkt.entity.dto.PatientDto
				(name,dob,gender) from Patient
				""",PatientDto.class);
		var list = query.getResultList();
		
		assertEquals(res, list.size());
		assertEquals("Sandar", list.get(1).getName());
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@Order(5)
	@CsvSource("1999-01-01,2005-12-31,2")
	void selectBetweenTest(LocalDate from,LocalDate to,int res) {
		em.getTransaction().begin();
		var query = em.createQuery("""
				select new com.jdc.mkt.entity.dto.PatientWithBetweenOpe
				(name,dob,gender,contact.phone) from Patient
				where dob between :from and :to order by dob
				""",PatientWithBetweenOpe.class);
		query.setParameter("from",from);
		query.setParameter("to", to);		
		var list = query.getResultList();
		
		assertEquals(res, list.size());
		em.getTransaction().commit();
	}
}
