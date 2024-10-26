package com.jdc.mkt.dto.inter;

import java.time.LocalDate;

public interface selectPNameCNameDtPriceQtyDto {

	LocalDate getDate();
	String getProduct();
	String getCategory();
	int getPrice();
	int getQtys();
}
