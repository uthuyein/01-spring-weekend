package com.jdc.spring.pos.model.repo.impl;

import java.util.List;
import java.util.Locale.Category;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jdc.spring.pos.model.input.CategoryForm;
import com.jdc.spring.pos.model.output.CategoryDto;
import com.jdc.spring.pos.model.repo.CategoryRepo;

@Repository
@SuppressWarnings("unused")
public class CategoryRepoImpl implements CategoryRepo {

	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate template;
	private RowMapper<Category> rowMapper;

	public CategoryRepoImpl(DataSource datasource) {
		template = new NamedParameterJdbcTemplate(datasource);
		rowMapper = new DataClassRowMapper<>(Category.class);
		insert = new SimpleJdbcInsert(datasource).withTableName("category_tbl").usingGeneratedKeyColumns("id");

	}

	@Override
	public int create(CategoryForm form) {
		return 0;
	}

	@Override
	public CategoryDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> search(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
