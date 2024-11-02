package com.jdc.mkt.test;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.jdc.mkt.entity.Region;
import com.jdc.mkt.services.StateService;

@SpringBootTest
public class SortingTest {

	@Autowired
	private StateService service;
	
	@Test
	@Disabled
	void testWithQueryMethod() {
		var list = service.findByStateNameLikeWithQueryMethod("m".concat("%"));
		list.forEach(s -> System.out.printf("Name :%10s\tCapital :%3s\n",s.getName(),s.getCapital()));
	}
	
	@Test
	@Disabled
	void testWithJpQlQuery() {
		var list = service.findByStateNameLikeWithJpQl("m".concat("%"));
		list.forEach(s -> System.out.printf("Name :%10s\tCapital :%3s\n",s.getName(),s.getCapital()));
	}
	
	@Test
	//@Disabled
	void testWithQueryMethodAndSort() {
		var list1 = service.findByStateNameLikeWithSort("m".concat("%"),Sort.by("name").descending());
		list1.forEach(s -> System.out.printf("Name :%10s\tCapital :%3s\n",s.getName(),s.getCapital()));
		
		var list2 = service.findByStateNameLikeWithSort("m".concat("%"),Sort.by(Direction.DESC, "name"));
		list2.forEach(s -> System.out.printf("Name :%10s\tCapital :%3s\n",s.getName(),s.getCapital()));
		
		var list3 = service.findByStateNameLikeWithSort("m".concat("%"),Sort.by(Order.asc("name")));
		list3.forEach(s -> System.out.printf("Name :%10s\tCapital :%3s\n",s.getName(),s.getCapital()));
		
		var list4 = service.findByStateNameLikeWithSort("m".concat("%"),Sort.by(List.of(Order.asc("name"),Order.desc("capital"))));
		list4.forEach(s -> System.out.printf("Name :%10s\tCapital :%3s\n",s.getName(),s.getCapital()));
		
		var list5 = service.findByStateNameLikeWithSort("m".concat("%"),Sort.sort(Region.class).descending());
		list5.forEach(s -> System.out.printf("Name :%10s\tCapital :%3s\n",s.getName(),s.getCapital()));
	}
}
