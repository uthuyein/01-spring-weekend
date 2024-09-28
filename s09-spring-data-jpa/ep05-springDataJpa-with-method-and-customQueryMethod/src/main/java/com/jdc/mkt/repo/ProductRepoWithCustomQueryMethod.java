package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Product;

public interface ProductRepoWithCustomQueryMethod extends JpaRepository<Product, Integer>{

	List<Product> searchByName(String name);
	
	long countByCategoryName(String name);
	
	List<Product> findFirst3ByCategoryName(String name);
	
	List<Product> getDistinctByWholeSalePrice(int wsPrice);
	
	void deleteByCategoryName(String name);
}
