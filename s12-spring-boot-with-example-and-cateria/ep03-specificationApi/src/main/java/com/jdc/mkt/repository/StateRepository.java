package com.jdc.mkt.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.mkt.entity.State;

public interface StateRepository extends JpaRepositoryImplementation<State, Integer>{

	long deleteStateByRegionName(String name);

}
