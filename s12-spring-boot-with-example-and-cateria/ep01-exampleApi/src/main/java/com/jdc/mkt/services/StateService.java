package com.jdc.mkt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.NullHandler;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Region;
import com.jdc.mkt.entity.State;
import com.jdc.mkt.repo.StateRepo;

@Service
public class StateService {

	@Autowired
	StateRepo stateRepo;
	
	public List<State> searchWithNullHandler(String name,String region){
		var probe = new State(null,name,null,new Region(null,region,null));
		
		return stateRepo.findAll(Example.of(
				probe,
				ExampleMatcher
				.matching()
				/*
				 * Null Handler
				 */
				//.withNullHandler(NullHandler.IGNORE)
				//.withIgnoreNullValues()
				//.withIncludeNullValues()
				));
	}
	
	public List<State> searchWithIgnoreCase(String name,String region){
		var probe = new State(null,name,null,new Region(null,region,null));
		
		return stateRepo.findAll(Example.of(
				probe,
				ExampleMatcher
				.matching()
				//.withIgnoreCase()
				//.withIgnoreCase(false)
				//.withIgnoreCase("name")
				));
	}
	
	public List<State> searchWithStringMatcher(String name,String region){
		var probe = new State(null,name,null,new Region(null,region,null));
		
		return stateRepo.findAll(Example.of(
				probe,
				ExampleMatcher
				.matching()
				.withStringMatcher(StringMatcher.STARTING)
				));
	}
}
