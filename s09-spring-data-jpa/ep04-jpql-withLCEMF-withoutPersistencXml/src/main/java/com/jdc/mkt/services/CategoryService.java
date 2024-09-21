package com.jdc.mkt.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CategoryService {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void create(Category c) {
		em.persist(c);
	}

	public Category selectCategoryById(int id) {
		return em.find(Category.class, id);
	}

	public Category selectCategoryByProductName(String name) {
		String jpql = """
				select c from Category c join c.products p where lower(p.name) = lower(:name)
				""";
		var query = em.createQuery(jpql,Category.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
}
