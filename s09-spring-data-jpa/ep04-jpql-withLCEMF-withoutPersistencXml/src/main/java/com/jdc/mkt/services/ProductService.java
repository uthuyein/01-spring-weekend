package com.jdc.mkt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.dto.ProductByCashierDto;
import com.jdc.mkt.entity.dto.ProductByDetailPriceDto;

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
	
	public List<ProductByDetailPriceDto> selectProductByDetailPrice(Integer frmPrice,Integer toPrice){
		var jpql = """
				select new com.jdc.mkt.entity.dto.ProductByDetailPriceDto(p.category.name ,p.name ,p.detailPrice ) 
				from Product p where p.detailPrice between :frmPrice and :toPrice
				""";
		var query = em.createQuery(jpql,ProductByDetailPriceDto.class);
		query.setParameter("frmPrice", frmPrice);
		query.setParameter("toPrice", toPrice);
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unused")
	public List<ProductByCashierDto> selectProductByCanshierName(String name){
		
		var jpqlStartFromCashier = """
				select distinct new com.jdc.mkt.entity.dto.ProductByCashierDto
				(sh.product.name,sh.product.detailPrice) from Cashier c
				join c.sales s
				join s.saleHistoryList sh
				where c.username = :cashier
				""";
		var jpqlWithJoin = """
				select distinct new com.jdc.mkt.entity.dto.ProductByCashierDto
				(p.name,p.detailPrice) from SaleHistory sh
				join sh.product p
				join sh.sales.account c
				where c.username = :cashier
				""";
		
		var jpqlWithoutJoin = """
				select distinct new com.jdc.mkt.entity.dto.ProductByCashierDto
				(sh.product.name,sh.product.detailPrice) from SaleHistory sh
				where sh.sales.account.username = :cashier
				""";
		
		
		var query = em.createQuery(jpqlStartFromCashier,ProductByCashierDto.class);
		query.setParameter("cashier", name);
		return query.getResultList();
	}

}
