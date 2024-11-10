package com.jdc.mkt.test.specification;

import java.util.Iterator;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.dto.StateDto;
import com.jdc.mkt.services.ESpecificationExecutorService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ASpecificationExecutorTest {

	@Autowired
	private ESpecificationExecutorService service;
	
	@Test
	@Order(1)
	void countByRegionNameLikeTest() {
		System.out.println("\n================ Order 1 ================== ");
		var count = service.countByRegionNameLike("n");
		System.out.println("State Count : "+count);
	}
	
	@Test
	@Order(2)
	void findOneByRegionNameLikeTest() {
		System.out.println("\n================ Order 2 ================== ");		
		var state = service.findOneByRegionNameLike("East");
		System.out.println("State name : "+state.get().getName());
	}
	@Test
	@Order(3)
	void findAllRegionNameLikeTest() {
		System.out.println("\n================ Order 3 ================== ");		
		var list = service.findAllByRegionNameLike("n");
		System.out.println("State list : "+list);
	}
	
	@Test
	@Order(4)
	void findByRegionNameLikeTest() {
		System.out.println("\n================ Order 4 ================== ");		
		var listDto = service.findByRegionNameLike("n");
		for(StateDto dto :listDto)
			System.out.println(dto.getName()+"\t"+dto.getCapital()+"\t"+dto.getRegion());
	}
}
