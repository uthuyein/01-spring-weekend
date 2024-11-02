package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.jdc.mkt.services.StateService;

@SpringBootTest
public class PagnationTest {

	@Autowired
	StateService service;
	
	@Test
	@Disabled
	void testWithPagnationWithQueryMethod() {
	//	PageRequest req = PageRequest.of(0, 3);
		PageRequest req = PageRequest.of(0, 3, Sort.by("name"));
		var page = service.findByRegionNameLikeWithPagnation("North".concat("%"),req); 
		
		System.out.println("Num of element :"+page.getNumberOfElements());
		System.out.println("Total element :"+page.getTotalElements());
		System.out.println("Number :"+page.getNumber());
		System.out.println("Total pages :"+page.getTotalPages());
		
		for(var state :page.toList()) {
			System.out.println("Name :"+state.getName());
		}
	}
	
	@Test
	void testWithPagnationWithJpql() {
		var page = service.findByRegionNameLikeWithPagnationAndJpql("M".concat("%"),
				//PageRequest.of(0, 3)
				PageRequest.of(0, 2, Direction.DESC, "name")
				);
		System.out.println("Num of element :"+page.getNumberOfElements());
		System.out.println("Total element :"+page.getTotalElements());
		System.out.println("Number :"+page.getNumber());
		System.out.println("Total pages :"+page.getTotalPages());
		
		for(var state :page.toList()) {
			System.out.println("Name :"+state.getName());
		}
	}
}
