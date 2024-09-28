package com.jdc.mkt.entity;

import java.io.Serializable;

import com.jdc.mkt.entity.Product.Size;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "sale_history_tbl")
public class SaleHistory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SaleHistoryPk id;
	@ManyToOne
	@MapsId("productId")
	private Product product;
	@Enumerated
	private Size size;
	@ManyToOne
	@MapsId("salesId")
	private Sales sales;
	private int qtys;
	@Transient
	private double total;

}