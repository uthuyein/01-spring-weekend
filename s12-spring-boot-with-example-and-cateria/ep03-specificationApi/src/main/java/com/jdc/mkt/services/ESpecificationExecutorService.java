package com.jdc.mkt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.StateDto;
import com.jdc.mkt.entity.Region_;
import com.jdc.mkt.entity.State;
import com.jdc.mkt.entity.State_;
import com.jdc.mkt.repository.StateRepository;

@Service
public class ESpecificationExecutorService {

	@Autowired
	private StateRepository repo;
	
	public long countByRegionNameLike(String name) {
		return repo.count(byRegionNameLike(name));
	}
	
	public Optional<State> findOneByRegionNameLike(String name) {
		return repo.findOne(byRegionNameLike(name));
	}
	
	public List<State> findAllByRegionNameLike(String name){
		return repo.findAll(byRegionNameLike(name),Sort.by(Direction.DESC, "name"));
	}
	
	public List<StateDto>findByRegionNameLike(String name){
		return repo.findBy(byRegionNameLike(name), 
				query -> query
				//.project("name","capital","region")
				.as(StateDto.class)
				.all());
	}
	
	private Specification<State> byRegionNameLike(String name){
		return (root,query,cb) -> 
			cb.like(cb.lower(root.get(State_.region).get(Region_.name)),
			name.toLowerCase().concat("%"));
		
	}
}
