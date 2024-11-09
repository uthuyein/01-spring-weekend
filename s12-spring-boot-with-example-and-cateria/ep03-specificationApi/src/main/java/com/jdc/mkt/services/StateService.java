package com.jdc.mkt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.State;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class StateService {

	@PersistenceContext
	EntityManager em;
	
	// select s from State s where lower(s.name) like lower(:name)
	public List<State> selectStateByNameLike(String name){
		//create criteria builder
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		//create query obj
		CriteriaQuery<State> query = cb.createQuery(State.class);
		
		// from State s
		Root<State> root = query.from(State.class);
		
		//select s
		query.select(root);
		
		//where lower(s.name) like lower(:name)
		query.where(cb.like(cb.lower(root.get("name")), name.toLowerCase().concat("%")));
		
		TypedQuery<State> tpQuery =  em.createQuery(query);
		
		return tpQuery.getResultList();
	}
}
