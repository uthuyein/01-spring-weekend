package com.jdc.mkt.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.SaleHistory;
import com.jdc.mkt.entity.SaleHistoryPk;

public interface SalesHistoryRepo extends JpaRepository<SaleHistory, SaleHistoryPk>{
	
	@Query("""
			select p from SaleHistory sh 
			join sh.product p
			where sh.sales.saleDate = :date
			""")
	List<Product> selectProductBySaleDateWithJpql(@Param("date") LocalDate date);
	
	@Query(
			value = """
			select * from product_tbl p 
			join sale_history_tbl sh on sh.product_id = p.id
			join sales_tbl s on sh.sales_id = s.id
			where s.saleDate = :date
			""",
			nativeQuery = true)
	List<Product> selectProductBySaleDateWithSql(@Param("date") LocalDate date);
	
	@Query("""
			select count(p.id) from SaleHistory sh
			join sh.product p where p.name = :name
			""")
	long selectCountByProduct(@Param("name")String name);

	@Query("""
			select p from SaleHistory sh
			join sh.product p
			join sh.sales.customer c
			where c.username = :name 
			""")
	List<Product> selectProductByCustomerName(@Param("name") String name);
	
	
}
