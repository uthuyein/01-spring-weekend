package com.jdc.mkt.repo.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.mkt.dto.inter.SelectProductNameAndCustomerNameInfDto;
import com.jdc.mkt.dto.inter.SelectProductQtyTotalDto;
import com.jdc.mkt.dto.inter.selectPNameCNameDtPriceQtyDto;
import com.jdc.mkt.entity.Sales;

public interface SalesRepoProj extends JpaRepository<Sales, Integer>{

	@Query("""
			select p.name name,c.username username from SaleHistory sh
			join sh.product p
			join sh.sales.customer c order by c.username desc
			""")
	List<SelectProductNameAndCustomerNameInfDto> selectPNameAndCName();
	
	@Query("""
			select s.saleDate date, p.name product,c.name category,p.detailPrice price,sh.qtys qtys from Sales s
			join s.saleHistoryList sh
			join sh.product p
			join p.category c
			""")
	List<selectPNameCNameDtPriceQtyDto> selectPNameCNameDtPriceQty();
	
	@Query("""
			select p.name product,p.detailPrice price,sum(sh.qtys) totalQtys , (sum(sh.qtys)*p.detailPrice) totalPrice from SaleHistory sh
			join sh.product p group by product,price order by product
			""")
	List<SelectProductQtyTotalDto> selectProductQtyTotal();
}
