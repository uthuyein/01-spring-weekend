package com.jdc.mkt.entity;

import com.jdc.mkt.entity.enumeration.AccountType;
import com.jdc.mkt.listener.EnableTimeListener;
import com.jdc.mkt.listener.TimeListener;
import com.jdc.mkt.listener.Times;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(TimeListener.class)
public class Account implements EnableTimeListener{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	private String loginId;
	private String password;
	private AccountType account;
	private Times times;
	
	
}
