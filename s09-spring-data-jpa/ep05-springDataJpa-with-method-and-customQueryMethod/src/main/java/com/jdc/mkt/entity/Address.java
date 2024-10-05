package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "address_tbl ")
@SecondaryTable(name = "contact_tbl")
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String city;
	private String township;
	private String street;
	
	@Column(table = "contact_tbl")
	private String primaryContact;
	
	@Column(table = "contact_tbl")	
	private String secondaryContact;
	
	@Column(table = "contact_tbl")
	private String email;

}
