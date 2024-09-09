package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "customer_tbl")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NonNull
	@Column(nullable = false,length = 45)
	private String name;
	@NonNull
	@Column(columnDefinition = "varchar(20) not null check(email like '%@%')")
	private String email;
	@NonNull
	@Column(nullable = false,length = 12)
	private String phone;
	//use mappedBy parameter that table don't want to create foreign key.
	@OneToOne(mappedBy = "customer")
	private Address address;
}
