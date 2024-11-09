package com.jdc.mkt.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.mkt.entity.Region;

public interface RegionRepository extends JpaRepositoryImplementation<Region, Integer>{

	long deleteByName(String name);
}
