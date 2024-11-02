package com.jdc.mkt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.State;
import com.jdc.mkt.repo.StateRepo;

@Service
public class StateService {

	@Autowired
	private StateRepo stateRepo;
	
	//query method
	public List<State> findByStateNameLikeWithQueryMethod(String name){
		return stateRepo.findByNameLikeOrderByCapital(name);
	}
	
	//jpql query
	public List<State> findByStateNameLikeWithJpQl(String name){
		return stateRepo.findByStateNameLike(name);
	}
	
	//query method with sort
	public List<State> findByStateNameLikeWithSort(String name,Sort sort){
		return stateRepo.findByNameLike(name,sort);
	}
	
	//query method with Pagnation and query method
	public Page<State> findByRegionNameLikeWithPagnation(String name,Pageable page){
		return stateRepo.findByRegionNameLike(name, page);
	}
	
	//query method with Pagnation and jpql
	public Page<State> findByRegionNameLikeWithPagnationAndJpql(String name,Pageable page){
		return stateRepo.findByStateLike(name, page);
	}
}
