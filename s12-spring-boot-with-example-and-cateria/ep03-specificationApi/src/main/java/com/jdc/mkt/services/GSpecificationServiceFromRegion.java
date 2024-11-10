package com.jdc.mkt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Region;
import com.jdc.mkt.entity.Region_;
import com.jdc.mkt.entity.State;
import com.jdc.mkt.entity.State_;
import com.jdc.mkt.repository.RegionRepository;

import jakarta.persistence.criteria.Join;

@Service
public class GSpecificationServiceFromRegion {

	@Autowired
	private RegionRepository repo;
	
	public List<Region> findByNameAndStateNameLike(String region,String state){
		Specification<Region> regionname = (root,query,cb) -> 
		cb.equal(root.get(Region_.name), region);
		
		Specification<Region> statenamelike = (root,query,cb) -> {
		var subQuery = query.subquery(Integer.class);
		var subRoot = subQuery.from(State.class);
		Join<State, Region> joinRegion =  subRoot.join(State_.region);
	
		subQuery.select(joinRegion.get(Region_.id));
		subQuery.where(cb.like(cb.lower(subRoot.get(State_.name)), state.toLowerCase().concat("%")));
		return root.get(Region_.id).in(subQuery);
		};
		return repo.findAll(Specification.where(regionname)
				//.and(statenamelike));
				.or(statenamelike));
	}
}
