package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class SaleHistoryPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "sales_id")
	private Integer salesId;
}
