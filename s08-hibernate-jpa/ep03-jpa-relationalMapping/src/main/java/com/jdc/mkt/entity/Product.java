package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "product_tbl")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private Double price;
	@Column(columnDefinition = "enum('SMALL','MEDIUM','LARGE') not null default 'SMALL' ")
	private Size size;
	//single filed must be used the end of one relation
	//single field should be many-to-one or one-to-one
	@ManyToOne
	//@JoinTable(name = "product_category_tbl")
	private Category category;
//	@ManyToMany(mappedBy = "products")
//	private List<Voucher> vouchers;
	
	public enum Size{
		SMALL,MEDIUM,LARGE
	}
}
