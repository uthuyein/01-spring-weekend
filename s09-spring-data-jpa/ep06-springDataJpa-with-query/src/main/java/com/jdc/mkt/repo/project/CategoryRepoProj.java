package com.jdc.mkt.repo.project;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.mkt.dto.SelectCategoryDto;
import com.jdc.mkt.entity.Category;

public interface CategoryRepoProj extends JpaRepository<Category, Integer>{

	@Query("""
			select c.id id,c.name name from Category c where c.isActive is null
			""")
	List<SelectCategoryDto> selectByIsActive();
}
