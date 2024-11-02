package com.jdc.mkt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Region;
import com.jdc.mkt.repo.RegionRepo;

@Service
public class RegionService {

	@Autowired
	private RegionRepo regionRepo;
	
	public List<Region> findByRegionName(String name){
		var probe = new Region();
		probe.setName(name);
		return regionRepo.findAll(Example.of(probe));
	}
}
