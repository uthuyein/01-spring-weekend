package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sales implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private SalesPk id;	
	@ManyToOne
	@MapsId(value = "accountId")
	private Cashier account;
	private Boolean isActive = true;
	private double taxPercent;
	private Double subTotal;
	private Double total;
	
}
