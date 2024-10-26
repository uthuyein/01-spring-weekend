package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.repo.common.BaseRepo;

public interface ProductRepo extends BaseRepo<Product, Integer>{

	//same as named query name by using parameter index
	List<Product> findProductByNam(String name);
	
	//different named with query name by using name parameter
	@Query(name = "Product.findProductByDetail")
	List<Product> findProductByPrice(@Param("frm") int frm,@Param("to") int to);
	
	@Query("select p from Product p where p.category.name = :cat ")
	List<Product> selectProductByCategory(@Param("cat") String category);
	
	//used native query
	@Query(nativeQuery = true)
	List<Product> selectAllProduct();
	@Query( nativeQuery = true,value = """
			select * from product_tbl p where p.name = :name
			""")
	List<Product> selectAllProductByCat(@Param("name") String name);
	
	
}
