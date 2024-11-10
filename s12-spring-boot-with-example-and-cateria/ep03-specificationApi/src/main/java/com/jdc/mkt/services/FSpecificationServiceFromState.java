package com.jdc.mkt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Region_;
import com.jdc.mkt.entity.State;
import com.jdc.mkt.entity.State_;
import com.jdc.mkt.repository.StateRepository;

@Service
public class FSpecificationServiceFromState {

	@Autowired
	private StateRepository repo;
	
	public List<State> findbyRegionName(String name){
		return repo.findAll(
				Specification.where(
						(root,query,cb)-> 
						cb.equal(root.get(State_.region).get(Region_.name), name)));
	}
	
	public List<State> findbyRegionNameNot(String name){
		return repo.findAll(
				Specification.not(
						(root,query,cb)-> 
						cb.equal(root.get(State_.region).get(Region_.name), name)));
	}
	
	public List<State> findByRegionNameAndCapitalNameLike(String region,String capital){
		Specification<State> regionName = (root,query,cb) -> 
		cb.equal(root.get(State_.region).get(Region_.name), region);
		
		Specification<State> capitalNameLike = (root,query,cb)->
		cb.like(cb.lower(root.get(State_.capital)),capital.toLowerCase().concat("%"));
		
		return repo.findAll(Specification.allOf(regionName,capitalNameLike));
	}
	
	public List<State> findByRegionNameOrCapitalNameLike(String region,String capital){
		Specification<State> regionName = (root,query,cb) -> 
		cb.equal(root.get(State_.region).get(Region_.name), region);
		
		Specification<State> capitalNameLike = (root,query,cb)->
		cb.like(cb.lower(root.get(State_.capital)),capital.toLowerCase().concat("%"));
		
		return repo.findAll(Specification.anyOf(regionName,capitalNameLike));
	}
}
