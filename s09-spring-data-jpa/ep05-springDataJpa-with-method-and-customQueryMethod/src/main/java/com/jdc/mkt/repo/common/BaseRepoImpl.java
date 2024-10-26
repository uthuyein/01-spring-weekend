package com.jdc.mkt.repo.common;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;

public class BaseRepoImpl<T,ID> extends SimpleJpaRepository<T, ID> implements BaseRepo<T, ID>{

	private EntityManager em;
	
	public BaseRepoImpl(Class<T> classes, EntityManager em) {
		super(classes,em);
		this.em = em;
	}

	@Override
	public List<T> query(String jpql, Map<String, Object> params) {
		var query = em.createQuery(jpql,getDomainClass());
		for(var entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

}
