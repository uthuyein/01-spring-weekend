package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	//same as named query name by using parameter index
	List<Product> findProductByNam(String name);
	
	@Query(name = "Product.findProductByDetail")
	List<Product> findProductByPrice(@Param("frm") int frm,@Param("to") int to);
}
