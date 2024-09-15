package com.jdc.mkt.services;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CategoryService {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void create(Category category) {
		em.persist(category);
		
	}
}
