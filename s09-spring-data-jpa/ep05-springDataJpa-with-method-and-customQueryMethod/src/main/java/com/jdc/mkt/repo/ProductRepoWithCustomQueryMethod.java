package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Product;

public interface ProductRepoWithCustomQueryMethod extends JpaRepository<Product, Integer>{

	List<Product> searchByName(String name);
	
	long countByCategoryName(String name);
	void deleteByCategoryName(String name);
	
	//Logical Base
	List<Product> findFirst3ByCategoryName(String name);
	List<Product> getDistinctByWholeSalePrice(int wsPrice);
	List<Product> findByNameAndDetailPrice(String name, int dtPrice);
	List<Product> findByNameOrDetailPrice(String name, int dtPrice);

	Boolean existsByName(String name);	
	
	//String Base
	List<Product> findByNameLike(String name);
	List<Product> findByNameStartingWith(String name);
	List<Product> findByNameEndingWith(String string);
	List<Product> findByNameContaining(String string);

	//Number Base

	List<Product> getByDetailPriceGreaterThanEqual(int i);
	List<Product> getByDetailPriceLessThanEqual(int i);

	List<Product> getByDetailPriceIsLessThan(int i);

	
	
	
	//boolean findByIsActive(Boolean active);

	
}
