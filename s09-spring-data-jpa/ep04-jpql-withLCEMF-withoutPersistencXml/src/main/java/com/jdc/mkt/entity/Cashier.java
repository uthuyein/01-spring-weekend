package com.jdc.mkt.entity;

import jakarta.persistence.Entity;

@Entity
public class Cashier extends Account{

	private static final long serialVersionUID = 1L;

	public Cashier() {
		setAccount(AccountType.CASHIER); 
	}
}
