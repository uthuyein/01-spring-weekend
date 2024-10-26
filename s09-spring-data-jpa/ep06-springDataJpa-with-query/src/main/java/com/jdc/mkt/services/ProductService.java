package com.jdc.mkt.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.repo.ProductRepo;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ProductService {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ProductRepo repo;
	
	Map<String, Object> params = new HashMap<String, Object>();
	
	
	public List<Product> searchWithBaseRepo(String name,String category,Integer dtPrice,Integer wsPrice){
		return repo.query(getQuery(name, category, dtPrice, wsPrice), params);
	}
	
	public List<Product> search(String name,String category,Integer dtPrice,Integer wsPrice) {
		
		var query = em.createQuery(getQuery(name, category, dtPrice, wsPrice), Product.class);
		
		for(var entry:params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}
	
	private String getQuery(String name,String category,Integer dtPrice,Integer wsPrice) {
		StringBuffer sb = new StringBuffer("select p from Product p where 1 = 1");
		
		if(StringUtils.isNotBlank(name)) {
			sb.append(" and p.name = :product");
			params.put("product", name);
		}
		if(StringUtils.isNotBlank(category)) {
			sb.append(" and p.category.name = :category");
			params.put("category", category);
		}
		if(0 >dtPrice) {
			sb.append(" and p.detailPrice = :dt");
			params.put("dt", dtPrice);
		}
		if(0 > wsPrice) {
			sb.append(" and p.wholeSalePrice = :ws");
			params.put("ws", dtPrice);
		}
		return sb.toString();
	}
}
