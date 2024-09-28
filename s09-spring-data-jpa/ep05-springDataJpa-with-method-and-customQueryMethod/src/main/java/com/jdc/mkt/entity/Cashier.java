package com.jdc.mkt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cashier_tbl")
public class Cashier extends Account{

	private static final long serialVersionUID = 1L;

	public Cashier() {
		setAccount(AccountType.CASHIER); 
	}
}
