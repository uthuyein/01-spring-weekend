package com.jdc.mkt.query.projection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.query.TestConfig;
import com.jdc.mkt.repo.project.CategoryRepoProj;

public class CategoryWithProjectTest extends TestConfig{

	@Autowired
	CategoryRepoProj repo;
	
	@Test
	void testWithInterfaceBaseProject() {
		var list = repo.selectByIsActive();
		list.forEach(c -> System.out.printf("Id :%d\tName :%s\n",c.getId(),c.getName()));
	}
	
	
}
