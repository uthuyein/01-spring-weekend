package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "voucher_detail_tbl")
@Getter
@Setter
public class VoucherDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer qty;
	@ManyToOne(optional = false)
	private Voucher voucher;
	@ManyToOne(optional = false)
	private Product product;
	
}
