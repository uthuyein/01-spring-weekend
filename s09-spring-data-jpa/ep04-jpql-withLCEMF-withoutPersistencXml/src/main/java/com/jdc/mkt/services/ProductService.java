package com.jdc.mkt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.dto.ProductDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ProductService {

	@PersistenceContext
	EntityManager em;
	
	public Product selectProduct(int id) {
		return em.find(Product.class, id);
	}
	
	public List<Product> selectProductByCategoryName(String name) {
		var jpql = "select p from Product p where p.category.name = :name";
		var query = em.createQuery(jpql,Product.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	public List<Product> selectProductByCategoryNameWithLeftJoin(String name) {
		var jpql = "select p from Product p left join p.category c where c.name = :name";
		var query = em.createQuery(jpql,Product.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	public List<ProductDto> selectProductByDetailPrice(Integer frmPrice,Integer toPrice){
		var jpql = """
				select new com.jdc.mkt.entity.dto.ProductDto(p.category.name ,p.name ,p.detailPrice ) 
				from Product p where p.detailPrice between :frmPrice and :toPrice
				""";
		var query = em.createQuery(jpql,ProductDto.class);
		query.setParameter("frmPrice", frmPrice);
		query.setParameter("toPrice", toPrice);
		return query.getResultList();
	}

}
