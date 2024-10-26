package com.jdc.mkt.repo.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.mkt.dto.SelectProductNameAndCustomerNameInfDto;
import com.jdc.mkt.entity.Sales;

public interface SalesRepoProj extends JpaRepository<Sales, Integer>{

	@Query("""
			select p.name name,c.username username from SaleHistory sh
			join sh.product p
			join sh.sales.customer c order by c.username desc
			""")
	List<SelectProductNameAndCustomerNameInfDto> selectPNameAndCName();
}
