package com.jdc.mkt.repo.project;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.mkt.dto.classes.SelectCategoryDtoClass;
import com.jdc.mkt.dto.inter.SelectCategoryDto;
import com.jdc.mkt.entity.Category;

public interface CategoryRepoProj extends JpaRepository<Category, Integer>{

	@Query("""
			select c.id number,c.name name from Category c where c.isActive is null
			""")
	List<SelectCategoryDto> selectByIsActiveWithInterface();
	
	@Query("""
			select new com.jdc.mkt.dto.classes.SelectCategoryDtoClass(c.id number,c.name name) from Category c where c.isActive is null
			""")
	List<SelectCategoryDtoClass> selectByIsActiveWithRecord();

	
	//dynamic projection with
	<T> T findOneById(int id,Class<T> classes);
}
