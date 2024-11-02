package com.jdc.mkt.query.projection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.dto.classes.SelectCategoryDtoRecord;
import com.jdc.mkt.dto.inter.SelectCategoryDto;
import com.jdc.mkt.query.TestConfig;
import com.jdc.mkt.repo.project.CategoryRepoProj;

public class CategoryWithProjectTest extends TestConfig {

	@Autowired
	CategoryRepoProj repo;

	@Test
	@Disabled
	@Order(1)
	void testWithInterfaceBaseProject() {
		var list = repo.selectByIsActiveWithInterface();
		list.forEach(c -> System.out.printf("Id :%d\tName :%s\n", c.getId(), c.getName()));
	}

	@Test
	@Disabled
	@Order(2)
	void testWithRecordBaseProject() {
		var list = repo.selectByIsActiveWithRecord();
		list.forEach(c -> System.out.printf("Id :%d\tName :%s\n", c.getId(), c.getName()));
	}

	@Test
	// @Disabled
	@Order(3)
	void testWithDynamicProject() {
		// inerface
		var inter = repo.findOneById(1, SelectCategoryDto.class);
		System.out.println(inter.getName());

		// record
		var rec = repo.findOneById(1, SelectCategoryDtoRecord.class);
		System.out.println(rec.name());

		// can't use class type
//		var cl = repo.findOneById(1, SelectCategoryDtoClass.class);
//		System.out.println(cl.getName());
	}

}
