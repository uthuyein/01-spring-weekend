package com.jdc.mkt.entity;

import java.util.List;

import com.jdc.mkt.entity.enumeration.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cashier_tbl")
public class Cashier extends Account{

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "cashier")
	private List<Sales> sales;
	
	public Cashier() {
		setAccount(AccountType.CASHIER); 
	}
}
