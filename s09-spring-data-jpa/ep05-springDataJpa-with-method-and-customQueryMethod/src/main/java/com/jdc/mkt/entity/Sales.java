package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="sales_tbl")
public class Sales implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cashier cashier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;
	
	private Boolean isActive = true;
	private double tax;
	private Double subTotal;
	private Double total;
	private LocalDate saleDate ;
	private LocalTime saleTime;
	
	@OneToMany(mappedBy = "sales")
	private List<SaleHistory> saleHistoryList;
}
