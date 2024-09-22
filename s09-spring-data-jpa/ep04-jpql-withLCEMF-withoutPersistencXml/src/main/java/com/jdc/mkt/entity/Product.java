package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.List;

import com.jdc.mkt.listener.EnableTimeListener;
import com.jdc.mkt.listener.Times;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Product implements EnableTimeListener{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,length = 45)
	private String name;
	private Integer detailPrice;
	private Integer wholeSalePrice;
	private Times times;
	
	@ElementCollection
	@Column(name = "size")	
	@CollectionTable(name = "sizes_tbl"
	,joinColumns = @JoinColumn(name = "product_id"))
	private List<Size> sizes;
	
	@ManyToOne
	private Category category;
	
	private Boolean isActive = true;
	
	public enum Size{
		SMALL,MEDIUM,LARGE,XL,XXL
	}
}
