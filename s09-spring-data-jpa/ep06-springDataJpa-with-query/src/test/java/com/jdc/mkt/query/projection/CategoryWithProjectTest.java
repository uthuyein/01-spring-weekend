package com.jdc.mkt.query.projection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.dto.classes.SelectCategoryDtoClass;
import com.jdc.mkt.dto.inter.SelectCategoryDto;
import com.jdc.mkt.query.TestConfig;
import com.jdc.mkt.repo.project.CategoryRepoProj;

public class CategoryWithProjectTest extends TestConfig{

	@Autowired
	CategoryRepoProj repo;
	
	@Test
	@Disabled
	@Order(1)
	void testWithInterfaceBaseProject() {
		var list = repo.selectByIsActiveWithInterface();
		list.forEach(c -> System.out.printf("Id :%d\tName :%s\n",c.getId(),c.getName()));
	}
	
	@Test
	@Disabled
	@Order(2)
	void testWithRecordBaseProject() {
		var list = repo.selectByIsActiveWithRecord();
		list.forEach(c -> System.out.printf("Id :%d\tName :%s\n",c.getId(),c.getName()));
	}
	
	@Test
	@Order(3)
	void testWithDynamicProject() {
		var cat = repo.findOneById(1,SelectCategoryDto.class);
		System.out.println(cat.getName());
	}
	
}
