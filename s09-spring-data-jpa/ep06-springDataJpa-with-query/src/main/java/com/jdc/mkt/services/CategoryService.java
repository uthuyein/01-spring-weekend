package com.jdc.mkt.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.repo.CategoryRepo;

import io.micrometer.common.util.StringUtils;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo repo;
	
	public List<Category> search(int id,String name) {
		StringBuffer sb = new StringBuffer("select c from Category c where 1 = 1");
		Map<String, Object> params = new HashMap<String, Object>();
		if(0 > id) {
			sb.append(" and c.id = :id");
			params.put("id", id);
		}
		
		if(StringUtils.isNotBlank(name)) {
			sb.append(" and c.name = :name");
			params.put("name", name);
		}
		
		return repo.query(sb.toString(), params);
	}
}
