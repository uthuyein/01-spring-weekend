package com.jdc.mkt.repo.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.mkt.dto.classes.ProductIdNamePriceRecord;
import com.jdc.mkt.dto.inter.ProductIdNamePriceDto;
import com.jdc.mkt.dto.inter.SelectProductWithCategoryDto;
import com.jdc.mkt.entity.Product;

public interface ProductReopProj extends JpaRepository<Product, Integer>{

	@Query("""
			select p.id productId,p.name productName,p.category category
			from Product p
			""")
	List<SelectProductWithCategoryDto> selectProductWithCategory();
	
	@Query(name = "Product.productIdNamePrice",nativeQuery = true)
	List<ProductIdNamePriceRecord> selectProductIdNamePrice();
}
