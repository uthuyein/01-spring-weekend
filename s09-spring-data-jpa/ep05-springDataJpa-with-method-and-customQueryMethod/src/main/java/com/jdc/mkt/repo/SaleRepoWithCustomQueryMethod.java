package com.jdc.mkt.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Sales;

public interface SaleRepoWithCustomQueryMethod extends JpaRepository<Sales, Integer> {

	List<Sales> findBySaleDateAfter(LocalDate localDate);

	List<Sales> findBySaleDateIsBefore(LocalDate localDate);

	List<Sales> findByCashierUsernameLikeAndSaleDateAfter(String concat, LocalDate localDate);

	
//	List<Sales> findBySaleDateIsWithin(LocalDate frm,LocalDate to);

}
