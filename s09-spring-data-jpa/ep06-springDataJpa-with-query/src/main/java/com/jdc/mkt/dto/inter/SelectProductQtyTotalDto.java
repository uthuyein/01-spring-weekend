package com.jdc.mkt.dto.inter;

import org.springframework.beans.factory.annotation.Value;

public interface SelectProductQtyTotalDto {

	String getProduct();
	int getPrice();
	long getTotalQtys();
	long getTotalPrice();
	
	@Value("#{target.product +'  '+target.price+'  '+target.totalQtys+'  '+target.totalPrice }")
	String getValue();
	
	default String data() {
		return "Product :%.5s\tPrice :%d\tQtys :%d\tTotal Price :%d\n"
				.formatted(
						getProduct(),
						getPrice(),
						getTotalQtys(),
						getTotalPrice()
						);
	}
}
