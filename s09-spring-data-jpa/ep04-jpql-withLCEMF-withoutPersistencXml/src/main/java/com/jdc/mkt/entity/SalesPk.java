package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class SalesPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LocalDate saleDate ;
	private LocalTime saleTime;
	@Column(name="account_id")
	private Integer accountId;
}
