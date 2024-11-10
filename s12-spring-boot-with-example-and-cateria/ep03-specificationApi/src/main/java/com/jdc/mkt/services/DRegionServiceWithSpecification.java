package com.jdc.mkt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Region;
import com.jdc.mkt.entity.Region_;
import com.jdc.mkt.entity.State;
import com.jdc.mkt.entity.State_;
import com.jdc.mkt.repository.RegionRepository;
import com.jdc.mkt.repository.StateRepository;

@Service
public class DRegionServiceWithSpecification {

	@Autowired
	RegionRepository repo;
	@Autowired
	StateRepository stateRepo;
	
	
	@Transactional
	public long deleteRegionByStateNameLike(String name) {
		//deleteStateByRegionName(name);
		
		Specification<Region> spec = (root, query, cb) -> 
			cb.equal(root.get(Region_.name), name);
		
		return repo.delete(spec);
		//return repo.deleteByName(name);
	}
	
	
	@Transactional
	public long deleteStateByRegionName(String name) {
		return stateRepo.deleteStateByRegionName(name);
	}



	/*
	 * select r from Region r where r.id in 
	 * (select s.region.id from State s join s.region where lower(s.name) like lower(:name))
	 */
	public List<Region> selectRegionByStateNameLike(String name){
		Specification<Region> spec = (root, query, cb) -> {
			var subQuery = query.subquery(Integer.class);
			var subRoot = subQuery.from(State.class);	
			
			var join = subRoot.join(State_.region);
			subQuery.select(join.get(Region_.id));
			subQuery.where(cb.like(cb.lower(subRoot.get(State_.name)), name.toLowerCase().concat("%")));
			
			return root.get(Region_.id).in(subQuery);
		};
		return repo.findAll(spec);
	}
}
