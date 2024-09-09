package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "voucher_tbl")
public class Voucher implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private VoucherPk id;
	@ManyToOne
	private Customer customer;
	private Double total;
//	@ManyToMany
//	private List<Product> products;
}
