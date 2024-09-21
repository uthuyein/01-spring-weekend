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
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_tbl")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,length = 45)
	private String name;
	@Column(columnDefinition = "enum('SMALL','MEDIUM','LARGE','XL','XXL') default 'MEDIUM'")
	private Size size;
	private Double retailPrice;
	private Double wholeSalePrice;
	@ManyToOne
	private Category category;
	
	private Boolean isActive = true;
	
	public enum Size{
		SMALL,MEDIUM,LARGE,XL,XXL
	}
}
