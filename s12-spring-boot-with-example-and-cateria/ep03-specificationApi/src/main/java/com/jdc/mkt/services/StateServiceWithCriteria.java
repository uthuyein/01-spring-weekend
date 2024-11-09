package com.jdc.mkt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Region_;
import com.jdc.mkt.entity.State;
import com.jdc.mkt.entity.State_;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class StateServiceWithCriteria {

	@PersistenceContext
	EntityManager em;
	
	//select s from State s where lower(s.region.name) like lower(:name)
	public List<State> selectStateByRegionNameLike(String name){
		var cb = em.getCriteriaBuilder();
		var regionQuery = cb.createQuery(State.class);
		var root = regionQuery.from(State.class);
		regionQuery.select(root);
		
		var query = regionQuery.where(
				cb.like(
				root.get(State_.region)
				.get(Region_.name),name.toLowerCase().concat("%")));
		return em.createQuery(query).getResultList();
	}
	
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
		query.where(cb.like(cb.lower(root.get(State_.name)), name.toLowerCase().concat("%")));
		
		TypedQuery<State> tpQuery =  em.createQuery(query);
		
		return tpQuery.getResultList();
	}
}
