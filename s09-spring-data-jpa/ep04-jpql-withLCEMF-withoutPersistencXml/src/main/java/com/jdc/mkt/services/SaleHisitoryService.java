package com.jdc.mkt.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.dto.SaleHistoryByDynamicSearchDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class SaleHisitoryService {

	@PersistenceContext
	EntityManager em;
	
	public List<SaleHistoryByDynamicSearchDto> search(String category,String product,LocalDate frmDate,LocalDate toDate){
		Map<String, Object> map = new HashMap<String, Object>();
		var sb = new StringBuilder("""
				select new com.jdc.mkt.entity.dto.SaleHistoryByDynamicSearchDto(c.name ,p.name ,sh.qtys,(sh.qtys*p.detailPrice) total)from 
				SaleHistory sh
				join sh.product p
				join sh.product.category c
				join sh.sales s where 1=1
				""");
		if(null != product) {
			sb.append(" and p.name = :product");
			map.put("product", product);
		}
		if(null != category) {
			sb.append(" and c.name = :category");
			map.put("category", category);
		}
		if(null != frmDate && null != toDate) {
			sb.append(" and s.saleDate between :frmD and :toD");
			map.put("frmD", frmDate);
			map.put("toD", toDate);
		}
			
		var query = em.createQuery(sb.toString(),SaleHistoryByDynamicSearchDto.class);		
		
		for(Map.Entry<String,Object> entry :map.entrySet()) {
			query.setParameter(entry.getKey(),entry.getValue());
		}
		return query.getResultList();
	}
}
