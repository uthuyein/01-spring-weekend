package com.jdc.mkt.entity;

import com.jdc.mkt.entity.enumeration.AccountType;
import com.jdc.mkt.entity.enumeration.MemberType;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_tbl")
public class Customer extends Account{

	private static final long serialVersionUID = 1L;
	@Enumerated
	private MemberType member;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Address address;
	
	public Customer() {
		setAccount(AccountType.CUSTOMER);
	}

	
}
